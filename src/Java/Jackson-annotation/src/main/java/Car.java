import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * POJO
 * http://websystique.com/java/json/jackson-json-annotations-example/
 *
 * @JsonProperty : This annotation can be used on a property or method which will be used for Serialization and Deserialization of JSON.
 * It takes an optional ‘name’ parameter which is useful in case the property name is different than ‘key’ name in json.
 *
 * @JsonIgnoreProperties : This Class level annotation can be used to prevent certain properties to be serialized & deserialized.
 * What it means is that they will not be mapped to JSON content.
 *
 * @JsonAnySetter, @JsonAnyGetter : These annotations works as a Catch-All and are applied on Getters/Setter working with a Map.
 * If there is any JSON value which is not mapped to a property in POJO, then that value can be caught by @JsonAnySetter, and stored (deserialized) into Map.
 * Similarly the values which are stored into Map can be serialized back to JSON using @JsonAnyGetter.
 *
 * @JsonSerialize : This annotation can be used to change[or customize] the default serialization (Java to JSON) process.
 *
 * Created by sylhare in 2017.
 */
@JsonIgnoreProperties({ "ignoreme1", "ignoreme2" }) //property ignore which won't be cached
public class Car {

    @JsonProperty
    private String name;

    @JsonProperty("carModel") //model in now linked to carModel property of the Json file
    private int model;

    @JsonProperty
    private String price;

    private String ignoreme1;

    private String ignoreme2;

    @JsonProperty
    private List<String> colors = new ArrayList<String>();

    @JsonProperty
    @JsonSerialize(using = CustomDateSerializer.class) // Allow to change the data serialized from the json into a custom class
    private Date promoDate;

    private Map<String, Object> otherProperties = new HashMap<String, Object>();

    @JsonAnyGetter  // Property stored but not defined in Car
    public Map<String, Object> any() {
        return otherProperties;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        otherProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", model=" + model + ", price=" + price
                + ", ignoreme1=" + ignoreme1 + ", ignoreme2=" + ignoreme2
                + ", colors=" + colors + ", promoDate=" + promoDate
                + ", otherProperties=" + otherProperties + "]";
    }

}

