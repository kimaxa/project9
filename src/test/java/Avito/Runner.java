package Avito;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/src/main/java/Features",  // путь до пакета с feature файлами
        glue = "Avito", //Путь до пакета с шагами
        tags = "@Feature" //Тег, по которому будет запущен сценарий
)
public class Runner {
    @Test
    public static void run(String[] args) {

    }
}
