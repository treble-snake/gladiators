package model.attributes

object Attribute {
  // TODO kinda shit
  def apply[T](desc: AttributeDescription[T], value: T): Attribute[T] = {
    value match  {
      case Some(x: Int) =>
        new IntAttribute(desc.asInstanceOf[AttributeDescription[Int]], x).asInstanceOf[Attribute[T]]
      case Some(x: String) =>
        new StringAttribute(desc.asInstanceOf[AttributeDescription[String]], x).asInstanceOf[Attribute[T]]
    }
  }
}

abstract class Attribute[T]() {
//  def apply(value: T) = this.value = value
  def desc: AttributeDescription[T]
  def value: T
  def cost(newValue: T): Int = 0
  def on_:(value: Any): T = value.asInstanceOf[T]
}

case class IntAttribute(desc: AttributeDescription[Int],
                          var value: Int = 0)
  extends Attribute[Int] {
  require(value >= 0, "Значение атрибута не может быть меньше нуля.")

  override def cost(newValue: Int) = newValue - value
}

case class StringAttribute(desc: AttributeDescription[String],
                         var value: String = "не указано")
  extends Attribute[String] {
  require(value.nonEmpty, "Значение атрибута не может быть пустым")
}
