package hmrc

import hmrc.model.{Apple, FruitParser, Orange}
import org.scalatest.{FeatureSpec, GivenWhenThen}
import org.scalatest.Matchers._

/**
  * Created by sam.elamin on 03/12/2016.
  */
class FruitParserSpec extends FeatureSpec with GivenWhenThen {
  feature("Parsing strings to fruits") {

    scenario("When passing an 'apple' string") {
      FruitParser.parseFruits("Apple") should be(List(Apple()))
    }

    scenario("When passing an 'orange' string") {
      FruitParser.parseFruits("Orange") should be(List(Orange()))
    }

    scenario("When passing an 'apple' and 'orange' string") {
      FruitParser.parseFruits("Apple, Orange") should be(List(Apple(), Orange()))
    }
  }
}

