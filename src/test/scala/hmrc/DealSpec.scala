package hmrc

import hmrc.model.{Apple, Basket}
import hmrc.service.Checkout
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * Created by sam.elamin on 03/12/2016.
  */
class DealSpec extends FeatureSpec with GivenWhenThen {
  feature("Shopping basket deal checkout") {
    scenario("Basket with multiple apples and no oranges") {
      Given("a basket with three apples")
      val basket = new Basket(List(Apple(), Apple(), Apple()))

      When("calculating the price")
      val totalPrice = Checkout.calculatePriceAfterDiscount(basket)

      Then("the total price is £1.20")
      assert(totalPrice == 1.20)
    }
  }
}
