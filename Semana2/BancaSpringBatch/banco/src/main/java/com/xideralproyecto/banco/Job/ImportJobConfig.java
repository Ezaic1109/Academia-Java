package com.xideralproyecto.banco.Job;

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

@Configuration
@EnableBatchProcessing
public class ImportJobConfig {

    @Bean
public JpaPagingItemReader<ClienteEntity> reader(EntityManagerFactory emf) {
    JpaPagingItemReader<ClienteEntity> reader = new JpaPagingItemReader<>();
    reader.setName("clienteEntityReader"); // <- Nombre requerido
    reader.setEntityManagerFactory(emf);
    reader.setQueryString("SELECT c FROM ClienteEntity c"); // <- Usa el nombre correcto de la clase
    reader.setPageSize(10);
    return reader;
}

    @Bean
    public ClienteItemProcessor processor() {
        return new ClienteItemProcessor();
    }

    @Bean
    public RepositoryItemWriter<ClienteMongo> writer(ClienteMongoRepository mongoRepository) {
        RepositoryItemWriter<ClienteMongo> writer = new RepositoryItemWriter<>();
        writer.setRepository(mongoRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      JpaPagingItemReader<ClienteEntity> reader,
                      ClienteItemProcessor processor,
                      RepositoryItemWriter<ClienteMongo> writer) {
        return new StepBuilder("step1", jobRepository)
                .<ClienteEntity, ClienteMongo>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    // **Importante: Nombre de bean "clienteJob" para que coincida con el controlador**
    @Bean(name = "clienteJob")
    public Job importJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("importClientesJob", jobRepository)
                .start(step1)
                .build();
    }
}