package json;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Address;
import model.Employee;

/**
 * For our example for JSON to POJO/Java object conversion,
 * we will take a complex example with nested object and arrays.
 * We will use arrays, list and Map in java objects for conversion.
 * Our complex json is stored in a file employee.txt with below structure:
 * https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
 */
public class JacksonObjectMapperDemo {

    public static void demo() throws IOException {

        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\employee.json"));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        Employee emp = objectMapper.readValue(jsonData, Employee.class);

        System.out.println("model.Employee Object\n" + emp);

        //convert Object to json string
        Employee emp1 = createEmployee();
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //writing to console, can write to any output stream such as file
        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, emp1);
        System.out.println("model.Employee JSON is\n" + stringEmp);
    }

    public static Employee createEmployee() {

        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("David");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[]{123456, 987654});
        emp.setRole("Manager");

        Address add = new Address();
        add.setId(50);
        add.setCity("Bangalore");
        add.setStreet("BTM 1st Stage");
        add.setZipcode(560100);
        emp.setAddress(add);

        List<String> cities = new ArrayList<String>();
        cities.add("Los Angeles");
        cities.add("New York");
        emp.setCities(cities);

        Map<String, String> props = new HashMap<String, String>();
        props.put("salary", "1000 Rs");
        props.put("age", "28 years");
        emp.setProperties(props);

        return emp;
    }

}