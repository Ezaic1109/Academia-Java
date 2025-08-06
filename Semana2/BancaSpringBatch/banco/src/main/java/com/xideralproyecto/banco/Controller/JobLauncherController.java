package com.xideralproyecto.banco.Controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class JobLauncherController {

    @Autowired
    private JobLauncher jobLauncher;

    // Inyectar el Job por su nombre "clienteJob"
    @Autowired
    @Qualifier("clienteJob")
    private Job clienteJob;

    @GetMapping("/run-clientes")
    public String runJob() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis()) // parámetro único para cada ejecución
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(clienteJob, params);

            return "Job ejecutado con status: " + execution.getStatus();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al ejecutar el job: " + e.getMessage();
        }
    }
}