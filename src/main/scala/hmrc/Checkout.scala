package hmrc

import model.Basket
/**
  * Created by sam.elamin on 03/12/2016.
  */
object Checkout {
  def calculatePrice(basket: Basket): BigDecimal = {
    if(basket.strings.contains("Apple"))
      {
        0.6
      }
    else
      {
        0
      }
  }
}