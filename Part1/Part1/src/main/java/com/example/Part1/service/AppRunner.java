package com.example.Part1.service;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
public void run(ApplicationArguments args) throws Exception {
System.out.println("Hello Application Runner");
System.out.println(Arrays.asList(args.getSourceArgs()));
System.out.println(args.getNonOptionArgs());
System.out.println(args.getOptionNames());
System.out.println(args.getOptionValues("db"));
System.out.println(args.containsOption("bye"));
System.out.println("End of Application Runner");
}
}