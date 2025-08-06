// Paquete donde se encuentra esta clase
package com.xideralproyecto.banco.Job;

// Importaciones necesarias de Spring Batch y otras dependencias
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Entity.ClienteMongo;
import com.xideralproyecto.banco.Processor.ClienteItemProcessor;
import com.xideralproyecto.banco.Repository.ClienteMongoRepository;

import jakarta.persistence.EntityManagerFactory;

// Clase de configuración que define un Job de Spring Batch
@Configuration
@EnableBatchProcessing // Habilita el soporte para procesamiento por lotes en Spring
public class ImportJobConfig {

    // Bean que define el lector de datos desde una base de datos relacional usando JPA
    @Bean
    public JpaPagingItemReader<ClienteEntity> reader(EntityManagerFactory emf) {
        // Se crea una instancia del lector JPA
        JpaPagingItemReader<ClienteEntity> reader = new JpaPagingItemReader<>();

        // Se le asigna un nombre al reader (requerido para evitar errores)
        reader.setName("clienteEntityReader");

        // Se pasa el EntityManagerFactory para que JPA pueda gestionar las entidades
        reader.setEntityManagerFactory(emf);

        // Consulta JPQL para leer todos los clientes desde la tabla correspondiente
        reader.setQueryString("SELECT c FROM ClienteEntity c");

        // Se establece el tamaño de página (cuántos registros leer por lote)
        reader.setPageSize(10);

        // Se retorna el lector configurado
        return reader;
    }

    // Bean que define el procesador para convertir ClienteEntity en ClienteMongo
    @Bean
    public ClienteItemProcessor processor() {
        // Retorna una instancia del procesador que implementa ItemProcessor
        return new ClienteItemProcessor();
    }

    // Bean que define el escritor para guardar datos en MongoDB usando un repositorio Spring Data
    @Bean
    public RepositoryItemWriter<ClienteMongo> writer(ClienteMongoRepository mongoRepository) {
        // Se crea un escritor que utiliza un repositorio de MongoDB
        RepositoryItemWriter<ClienteMongo> writer = new RepositoryItemWriter<>();

        // Se le indica cuál repositorio utilizar
        writer.setRepository(mongoRepository);

        // Se indica qué método del repositorio se utilizará (en este caso, "save")
        writer.setMethodName("save");

        // Se retorna el escritor configurado
        return writer;
    }

    // Bean que define el paso del Job (lectura -> procesamiento -> escritura)
    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      JpaPagingItemReader<ClienteEntity> reader,
                      ClienteItemProcessor processor,
                      RepositoryItemWriter<ClienteMongo> writer) {

        // Se construye el paso llamado "step1", usando el jobRepository
        return new StepBuilder("step1", jobRepository)
                // Se define el tipo de chunk: lee ClienteEntity, convierte a ClienteMongo, y escribe
                .<ClienteEntity, ClienteMongo>chunk(10, transactionManager)
                // Se asigna el lector definido previamente
                .reader(reader)
                // Se asigna el procesador que convierte los datos
                .processor(processor)
                // Se asigna el escritor que guarda en MongoDB
                .writer(writer)
                // Se construye y retorna el paso
                .build();
    }

    // Bean que define el Job completo, compuesto por uno o más pasos
    @Bean(name = "clienteJob") // Este nombre debe coincidir con el que se invoque desde el controlador
    public Job importJob(JobRepository jobRepository, Step step1) {
        // Se construye el Job llamado "importClientesJob" que empieza con el paso1
        return new JobBuilder("importClientesJob", jobRepository)
                .start(step1) // Inicia con el único paso definido
                .build(); // Se construye y retorna el Job
    }
}
