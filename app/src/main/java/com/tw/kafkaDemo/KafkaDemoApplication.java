package com.tw.kafkaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class KafkaDemoApplication {

	public static String version = null;
	public static void main(String[] args) {
		Date date = new Date();
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		version = sdf.format(date);
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

}

