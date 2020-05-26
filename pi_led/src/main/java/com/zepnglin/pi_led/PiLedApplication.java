package com.zepnglin.pi_led;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.zepnglin.pi_led.nio.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PiLedApplication {
	public static void main(String[] args) {
		SpringApplication.run(PiLedApplication.class, args);
	}

}
