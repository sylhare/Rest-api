import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * More help on
 * http://websystique.com/java/json/jackson-json-annotations-example/
 */
public class JsonJacksonAnnotationsDemo {

    public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(new File(".\\src\\main\\resources\\inputfile.json"), Car.class);

        mapper.writeValue(new File(".\\src\\main\\resources\\outputfile.json"), car);
        System.out.println(car);

    }
}
