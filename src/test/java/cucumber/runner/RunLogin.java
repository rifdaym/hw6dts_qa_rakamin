package cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    //features = "src/test/java/cucumber/features",
        features="src/test/resources",
        glue = "cucumber.stepDef",

        plugin = {
                /*report versi mentor*/
                "html:target/HTML_report.html",
                /* report versi asisten mentor */
                "pretty", "json:target/cucumber.json"},

        tags = "@Login or @Product or @Checkout"
        //tags = "@Login or @Product"
        //tags = "@Product or @Checkout"
)

public class RunLogin {
}
