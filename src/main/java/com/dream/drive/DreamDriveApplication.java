package com.dream.drive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

@SpringBootApplication
public class DreamDriveApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DreamDriveApplication.class, args);
	}


}
