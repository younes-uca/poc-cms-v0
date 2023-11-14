package ma.sqli.peps.app;


import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class TestRunner {


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "dev");
    }

    @Karate.Test
    Karate AppStatusTest() {
        return Karate.run("AppStatusTest").relativeTo(getClass());
    }


}
