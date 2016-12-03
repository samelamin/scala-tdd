package hmrc.service

import hmrc.model.Basket
/**
  * Created by sam.elamin on 03/12/2016.
  */
object Checkout {
  def calculatePriceAfterDiscount(basket: Basket) : BigDecimal = {
    0.6
  }

  def calculatePriceBeforeDiscounts(basket: Basket): BigDecimal = {
    basket.calculateTotalPrice()
  }
}