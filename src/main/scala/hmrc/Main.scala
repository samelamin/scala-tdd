package hmrc

import hmrc.model.{Basket, FruitParser}
import hmrc.service.Checkout

/**
  * Created by sam.elamin on 03/12/2016.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val input = args(0)
    val items = FruitParser.parseFruits(input)
    val basket = new Basket(items)
    val basketPrice = Checkout.calculatePriceBeforeDiscounts(basket)
    println(s"£$basketPrice")
  }
}
