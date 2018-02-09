import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * Just for the sake of showing a handy and popular customization annotation, we created this class.
 * This is used on annotated Pojo ‘promoDate’ property.
 */
public class CustomDateSerializer extends JsonSerializer<Date>{

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        String formattedDate = dateFormat.format(date);
        generator.writeString(formattedDate);
    }

}
