import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"pretty","html:target/html"},
        features = {"src/test/features"},
        glue={"Steps"},
        tags={"@validate"}
)

public class Runner {

}
