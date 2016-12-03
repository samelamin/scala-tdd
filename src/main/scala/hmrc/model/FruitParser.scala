package hmrc.model

/**
  * Created by sam.elamin on 03/12/2016.
  */
object FruitParser {
  def parseFruits(input: String): List[Fruit] = {
    if (input == null) {
      Nil
    }
    else {
      val cleanedList = input.split(",").toList.map(_.trim)
      val fruits = cleanedList.collect {
        case "Apple" => Apple()
        case "Orange" => Orange()
      }
      fruits
    }
  }
}
