package com.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.company.util.FileUpload;

@SpringBootApplication
@MapperScan("com.company.dao")
@ServletComponentScan
public class ImApplication implements CommandLineRunner {
	@Autowired
	private FileUpload fileUpload;

	public static void main(String[] args) {
		SpringApplication.run(ImApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(fileUpload.getPath());
	}

}
