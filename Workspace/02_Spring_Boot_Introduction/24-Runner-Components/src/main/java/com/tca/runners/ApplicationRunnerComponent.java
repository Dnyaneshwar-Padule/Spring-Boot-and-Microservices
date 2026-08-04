package com.tca.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerComponent implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunnerComponent running......");

        System.out.println("Option-Arguments");
        for(String option : args.getOptionNames()){
            System.out.println("\t" + option + "=" + args.getOptionValues(option));
        }

        System.out.println("Non-Option-Arguments");
        for (String nonOption : args.getNonOptionArgs() ){
            System.out.println("\t" + nonOption);
        }

        System.out.println("Source Arguments");
        for(String arg : args.getSourceArgs()){
            System.out.println("\t" + arg);
        }
    }

}
