package ma.sqli.peps.BF.test

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class BfSimulation extends Simulation {

  val protocol = karateProtocol(
    "/buyingFrame/id/{id}" -> Nil,
    "/buyingFrame/" -> pauseFor("get" -> 15, "delete" -> 25)
  )

  protocol.runner.karateEnv("dev")

  val create = scenario("create").exec(karateFeature("classpath:BF/test/HappyBFtest.feature@name=save"))
  val delete = scenario("delete").exec(karateFeature("classpath:BF/test/HappyBFtest.feature@name=delete"))

  setUp(
    create.inject(rampUsers(10) during (5 seconds)).protocols(protocol),
    delete.inject(rampUsers(5) during (5 seconds)).protocols(protocol)
  )

}
