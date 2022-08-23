package filesParsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Auto;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonReader {
    ClassLoader classLoader = JsonReader.class.getClassLoader();

    @Test
    void jsonParser() throws Exception {
        InputStream is = classLoader.getResourceAsStream("auto.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Auto auto = objectMapper.readValue(is, Auto.class);
        assertThat(auto.firstName).isEqualTo("Sergey");
        assertThat(auto.age).isEqualTo(30);
        assertThat(auto.firstAuto).isEqualTo(false);
        assertThat(auto.model.name).contains("Ford");
        assertThat(auto.model.model).contains("Fiesta");


    }
}
