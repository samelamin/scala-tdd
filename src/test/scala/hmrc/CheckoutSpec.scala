package hmrc

import hmrc.service.Checkout
import org.scalatest.{FeatureSpec, FlatSpec, GivenWhenThen}
import org.scalatest.Matchers._
import model.{Apple, Basket, Orange}
/**
  * Created by sam.elamin on 03/12/2016.
  */
class CheckoutSpec extends FeatureSpec with GivenWhenThen {
  feature("Shopping basket checkout") {
    scenario("Empty basket") {
      Given("An empty basket")
      val Basket = new Basket(List())

      When("Calculating the total price")
      val totalPrice = Checkout.calculatePriceBeforeDiscounts(Basket)

      Then("The total price should be 0")
      totalPrice should equal(0)
    }

    scenario("Basket with an apple") {
      Given("A basket with an apple")
      val Basket = new Basket(List(Apple()))

      When("Calculating the total price")
      val totalPrice = Checkout.calculatePriceBeforeDiscounts(Basket)

      Then("The total price should be 0.6")
      totalPrice should equal(0.6)
    }

    scenario("Basket with an orange") {
      Given("A basket with an orange")
      val Basket = new Basket(List(Orange()))

      When("Calculating the total price")
      val totalPrice = Checkout.calculatePriceBeforeDiscounts(Basket)

      Then("The total price should be 0.25")
      totalPrice should equal(0.25)
    }

    scenario("Basket with multiple apples and an orange") {
      Given("A basket with multiple apples and an orange")
      val Basket = new Basket(List(Apple(),Apple(),Apple(),Orange()))

      When("Calculating the total price")
      val totalPrice = Checkout.calculatePriceBeforeDiscounts(Basket)

      Then("The total price should be 2.05")
      totalPrice should equal(2.05)
    }


  }
}

