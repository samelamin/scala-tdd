package hmrc.service

import hmrc.model.Basket
/**
  * Created by sam.elamin on 03/12/2016.
  */
object Checkout {
  def calculatePrice(basket: Basket): BigDecimal = {
    basket.calculateTotalPrice()
  }
}