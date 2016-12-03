package hmrc

import hmrc.model.{Apple, Basket, Orange}
import hmrc.service.Checkout
import org.scalatest.{FeatureSpec, GivenWhenThen}
/**
  * Created by sam.elamin on 03/12/2016.
  */
class DealSpec extends FeatureSpec with GivenWhenThen {
  feature("Shopping basket deal checkout") {
    scenario("2 for 1 apples") {
      Given("a basket with 2 apples")
      val basket = new Basket(List(Apple(), Apple()))

      When("calculating the price")
      val totalPrice = Checkout.calculatePriceAfterDiscount(basket)

      Then("the total price is £1.20")
      assert(totalPrice == 0.6)
    }
    scenario("3 for 2 oranges") {
      Given("a basket with three oranges")
      val basket = new Basket(List(Orange(), Orange(), Orange()))

      When("calculating the price")
      val totalPrice = Checkout.calculatePriceAfterDiscount(basket)

      Then("the total price is £0.50")
      assert(totalPrice == 0.5)
    }
    scenario("Basket with 3 oranges and 2 apples") {
      Given("a basket with 3 oranges and 2 apples")
      val basket = new Basket(List(Orange(), Orange(), Orange(), Apple(), Apple()))

      When("calculating the price")
      val totalPrice = Checkout.calculatePriceAfterDiscount(basket)

      Then("the total price is £1.10")
      assert(totalPrice == 1.1)
    }
    scenario("Basket with 7 oranges and 5 apples") {
      Given("a basket with 7 oranges and 5 apples")
      val basket = new Basket(List(
        Orange(),
        Orange(),
        Orange(),
        Orange(),
        Orange(),
        Orange(),
        Orange(),
        Apple(),
        Apple(),
        Apple(),
        Apple(),
        Apple()))

      When("calculating the price")
      val totalPrice = Checkout.calculatePriceAfterDiscount(basket)

      Then("the total price is £3.05")
      assert(totalPrice == 3.05)
    }
  }
}
