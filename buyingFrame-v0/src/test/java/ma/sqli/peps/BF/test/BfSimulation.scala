package ma.sqli.peps.BF.test

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._


// mvn clean test-compile gatling:test TODO: check junit5 in pom
class BfSimulation extends Simulation {

  val protocol = karateProtocol(
    "/buyingFrame" -> Nil
  )

  val health = scenario("health").exec(karateFeature("classpath:../java/ma/sqli/peps/app/AppStatusTest.feature"))

  setUp(
    health.inject(rampUsers(10) during (5 seconds)),
    //create.inject(atOnceUsers(1)).protocols(protocol)
  )

}
