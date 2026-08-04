package com.tca.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerComponent implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunnerComponent running....");

        System.out.println("Command-Line arguments...");
        for(String arg : args){
            System.out.println("\t" + arg);
        }

    }

}
