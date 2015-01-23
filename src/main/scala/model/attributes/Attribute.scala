package model.attributes

case class Attribute(desc: AttributeDescription, var value: Int) {
  def apply(value: Int) = this.value = value
}
