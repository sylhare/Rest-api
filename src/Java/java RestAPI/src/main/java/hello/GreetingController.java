package hello;

//https://spring.io/guides/gs/rest-service/


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
 * @RestController: GreetingController is the controller of greeting
 * it  handles GET requests for /greeting by returning a new instance of the Greeting class
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     *
     * @RequestMapping(method=GET, "/greeting") to specify the HTTP operation to be mapped
     * @RequestMapping("/greeting") //ensures that all HTTP requests to /greeting are mapped to the greeting() method.
     * @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method
     * This query string parameter is explicitly marked as optional (required=true by default): if it is absent in the request, the defaultValue of "World" is used.
     * @param name
     * @return
     */
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}