package ma.sqli.peps.BF.test;


import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class TestRunner {


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "dev");
    }


    @Karate.Test
    Karate HappyBFtest() {
        return Karate.run("HappyBFtest").relativeTo(getClass());
    }



    @Karate.Test
    Karate SadBFtest() {
        return Karate.run("SadBFtest").relativeTo(getClass());
    }

}
