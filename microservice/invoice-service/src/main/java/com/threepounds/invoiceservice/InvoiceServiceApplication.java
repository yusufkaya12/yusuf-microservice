package com.threepounds.invoiceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.threepounds")
public class InvoiceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvoiceServiceApplication.class, args);
    }
}