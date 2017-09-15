package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  To start right with IntelliJ:
 * https://spring.io/guides/gs/intellij-idea/
 *
 *  The @SpringBootApplication tells Springboot that:
 *      - This is a the source class of bean definition for the application
 *      - Tell spring boot to start adding beans based on the classpath settings
 *      - Spring Boot adds it automatically when it sees spring-webmvc on the classpath, flags the application as a web application
 */
@SpringBootApplication
public class Application {

    /**
     * You package everything in a single, executable JAR file, driven by a good old Java main() method.
     * Along the way, you use Spring’s support for embedding the Tomcat servlet container as the HTTP runtime,
     * instead of deploying to an external instance.
     * The main() method uses Spring Boot’s SpringApplication.run() method to launch an application
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}

