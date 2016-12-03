package hmrc.model

/**
  * Created by sam.elamin on 03/12/2016.
  */
class Basket(val fruits: List[Fruit]) {
  def calculateTotalPrice(): BigDecimal = {
    fruits.view.map(_.price).sum
  }

  def calculatePriceWithDealsApplied(): BigDecimal = {
    ApplyOrangesDeal(ApplyApplesDeal(this)).fruits.view.map(_.price).sum
  }

  def ApplyApplesDeal(basket: Basket): Basket = {
    val numberOfApples = basket.fruits.count(_ == Apple())
    val offer = (numberOfApples / 2) + (numberOfApples % 2)
    val updatedFruits = basket.fruits.filterNot(item => item == Apple()) ++ List.fill(offer)(Apple())
    new Basket(updatedFruits)
  }

  def ApplyOrangesDeal(basket: Basket): Basket = {
    val numberOfOranges = basket.fruits.count(_ == Orange())
    val offer = ((numberOfOranges / 3) * 2) + (numberOfOranges % 3)
    val updatedFruits = basket.fruits.filterNot(item => item == Orange()) ++ List.fill(offer)(Orange())
    new Basket(updatedFruits)
  }
}
