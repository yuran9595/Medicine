package org.clinicNew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.clinicNew", "org.core"})
public class ClinicNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicNewApplication.class, args);
    }

}
