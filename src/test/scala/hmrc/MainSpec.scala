package hmrc

import org.scalatest.{FeatureSpec, GivenWhenThen}
import org.scalatest.Matchers._
/**
  * Created by sam.elamin on 03/12/2016.
  */
class MainSpec extends FeatureSpec with GivenWhenThen {
  feature("Calculate the price of a basket given a list of fruits") {
    scenario("When passing an 'Apple, Apple, Orange, Apple' string") {
      val input = Array("Apple, Apple, Orange, Apple")
      val stream = new java.io.ByteArrayOutputStream()
      Console.withOut(stream)(Main.main(input))
      stream.toString should startWith("£2.05")
    }
  }
}
