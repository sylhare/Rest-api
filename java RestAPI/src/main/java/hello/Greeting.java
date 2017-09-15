package hello;

/**
 *  Build running the application
 *  mvnw spring-boot:run
 *
 *  or creating a JAR
 *  mvnw clean package
 *
 *  Test the service at
 *  http://localhost:8080/greeting
 *
 *  GET
 *  {"id":1,"content":"Hello, World!"}
 *
 *  and at
 *  http://localhost:8080/greeting?name=User
 *
 *  GET
 *  {"id":1,"content":"Hello, User!"}
 *
 */
public class Greeting {

    private final long id; // The id field is a unique identifier for the greeting
    private final String content; // content is the textual representation of the greeting.

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}