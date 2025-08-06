package com.xideralproyecto.banco.Controller; // Define el paquete al que pertenece esta clase

import org.springframework.batch.core.Job; // Representa un Job de Spring Batch, que contiene uno o más Steps
import org.springframework.batch.core.JobExecution; // Contiene información sobre la ejecución de un Job (status, start time, etc.)
import org.springframework.batch.core.JobParameters; // Representa los parámetros que se pasan al ejecutar un Job
import org.springframework.batch.core.JobParametersBuilder; // Utilidad para construir instancias de JobParameters
import org.springframework.batch.core.launch.JobLauncher; // Interfaz que permite lanzar (ejecutar) Jobs en Spring Batch
import org.springframework.beans.factory.annotation.Autowired; // Anotación que permite la inyección automática de dependencias
import org.springframework.beans.factory.annotation.Qualifier; // Permite especificar el nombre del bean que se desea inyectar
import org.springframework.web.bind.annotation.GetMapping; // Anotación para mapear solicitudes HTTP GET
import org.springframework.web.bind.annotation.RequestMapping; // Anotación para definir la ruta base del controlador
import org.springframework.web.bind.annotation.RestController; // Marca la clase como un controlador REST de Spring

@RestController // Declara que esta clase es un controlador REST (los métodos retornan directamente respuestas HTTP)
@RequestMapping("/batch") // Define el prefijo de la ruta para todos los endpoints dentro de esta clase
public class JobLauncherController {

    @Autowired // Inyecta automáticamente el bean JobLauncher en esta clase
    private JobLauncher jobLauncher; // Se encarga de ejecutar jobs de Spring Batch

    @Autowired // Inyecta automáticamente el Job llamado "clienteJob"
    @Qualifier("clienteJob") // Especifica que se inyecte el bean llamado exactamente "clienteJob"
    private Job clienteJob; // Job que será ejecutado, el cual debe estar configurado con ese nombre en la configuración de Spring

    @GetMapping("/run-clientes") // Mapea las solicitudes GET a /batch/run-clientes a este método
    public String runJob() {
        try {
            // Construye parámetros únicos para cada ejecución usando el tiempo actual (para evitar conflictos de ejecución repetida)
            JobParameters params = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis()) // Añade un parámetro único llamado "startAt"
                    .toJobParameters(); // Finaliza la construcción de los parámetros

            // Ejecuta el Job clienteJob con los parámetros construidos
            JobExecution execution = jobLauncher.run(clienteJob, params);

            // Retorna el estado final de la ejecución del job (por ejemplo: COMPLETED, FAILED, etc.)
            return "Job ejecutado con status: " + execution.getStatus();
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en la consola para depuración
            // Si ocurre algún error, se retorna el mensaje del error
            return "Error al ejecutar el job: " + e.getMessage();
        }
    }
}