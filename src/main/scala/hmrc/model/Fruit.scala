package hmrc.model

/**
  * Created by sam.elamin on 03/12/2016.
  */
sealed abstract class Fruit(val price: BigDecimal)

case class Apple() extends Fruit(0.6)

case class Orange() extends Fruit(0.25)
