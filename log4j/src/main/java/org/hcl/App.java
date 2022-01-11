package org.hcl;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class App{
    static Logger log=Logger.getLogger(App.class.getName());
    public static void main( String[] args ){
        PropertyConfigurator.configure("C:\\Users\\mashh\\IdeaProjects\\log4j\\src\\main\\resources\\log4j.properties");
        log.debug("Sample debug message");
        log.info("Sample info message");
        log.warn("Sample warn message");
        log.error("Sample error message");
        log.fatal("Sample fatal message");
        System.out.println("Done");

    }
}