import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper; // com.fasterxml.jackson.databind.ObjectMapper is the most important class in Jackson API that provides readValue() and writeValue() methods to transform JSON to Java Object and Java Object to JSON.
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import json.JacksonObjectMapperDemo;

public class Main {

    public static void main(String[] args) {

        try {

            /*
             * transform JSON to java object using Jackson JSON parser API.
             */
            JacksonObjectMapperDemo.demo();

            /*
             * Convert simple into Map instead of a java object
             */
            byte[] mapData;
            Map<String, String> myMap;
            //create ObjectMapper instance, can be reused
            ObjectMapper objectMapper = new ObjectMapper();

            //converting json to Map
            mapData = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\data.json"));

            myMap = objectMapper.readValue(mapData, HashMap.class);
            System.out.println("Map is: " + myMap);

            //another way
            myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String, String>>() {
            });
            System.out.println("Map using TypeReference: " + myMap);

            System.out.println("\n");

            /*
             * Sometimes we have json data and we are interested in only few of the keys values,
             * so in that case converting whole JSON to object is not a good idea.
             * Jackson JSON API provides option to read json data as tree like DOM Parser and we can read specific elements of JSON object through this.
             * Below code provides snippet to read specific entries from json file.
             */
            //read json file data to String
            byte[] jsonData = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\employee.json"));

            //read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode idNode = rootNode.path("id");
            System.out.println("id = " + idNode.asInt());

            JsonNode phoneNosNode = rootNode.path("phoneNumbers");
            Iterator<JsonNode> elements = phoneNosNode.elements();
            while (elements.hasNext()) {
                JsonNode phone = elements.next();
                System.out.println("Phone No = " + phone.asLong());
            }

            /*
             * Jackson JSON Java API provide useful methods to add, edit and remove keys from JSON data and then we can save it as new json file or write it to any stream.
             * Below code shows us how to do this easily.
             */
            //update JSON data
            ((ObjectNode) rootNode).put("permanent", false);
            //add new key value
            ((ObjectNode) rootNode).put("test", "test value");
            //remove existing key
            ((ObjectNode) rootNode).remove("id"); //does not remove the nested one
            ((ObjectNode) rootNode).remove("role");
            ((ObjectNode) rootNode).remove("properties");
            objectMapper.writeValue(new File(".\\src\\main\\resources\\updated_emp.json"), rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
