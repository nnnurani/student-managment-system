package com.nurani.sms;

import com.nurani.sms.entity.Student;
import com.nurani.sms.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
//    @Bean
//    CommandLineRunner commandLineRunner (StudentRepository repository){
//        return args -> {
//            Student nurani = new Student(
//                    "Nurani",
//                    "Ulukhanova",
//                    "ulukhanova01.gmail.com"
//            );
//            Student aysun = new Student(
//                    "Aysun",
//                    "Ulukhanova",
//                    "u.aysun.gmail.com"
//            );
//
//            repository.saveAll(
//                    List.of(nurani,aysun)
//            );
//        };
//
//    }
}

