package ma.sqli.peps.BF.test

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._


// mvn clean test-compile gatling:test
class BfSimulation extends Simulation {

  val protocol = karateProtocol(
    "/buyingFrame" -> Nil
  )

  val create = scenario("create").exec(karateFeature("classpath:ma/sqli/peps/BF/test/HappyBFtest.feature@name=save"))

  setUp(
    //create.inject(rampUsers(10) during (5 seconds)).protocols(protocol),
    create.inject(atOnceUsers(1)).protocols(protocol)
  )

}
