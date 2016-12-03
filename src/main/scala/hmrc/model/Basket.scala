package hmrc.model

/**
  * Created by sam.elamin on 03/12/2016.
  */
class Basket(fruits: List[Fruit]) {
  def calculateTotalPrice(): BigDecimal = {
    fruits.view.map(_.price).sum
  }
}
