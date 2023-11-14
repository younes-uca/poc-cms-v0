package ma.sqli.peps;


import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class TestRunner {


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "localhost");
    }

    @Karate.Test
    Karate HappyOrderSave() {
        return Karate.run("test/HappyOrderTest").relativeTo(getClass());
    }


}
