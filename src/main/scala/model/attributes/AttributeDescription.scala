package model.attributes

abstract class AttributeDescription[T] {
  val name = "Название"
  val code = "Код"
  val desc = "Описание"
  val Default: T
}

abstract class IntAttrDesc extends AttributeDescription[Int] {
  override val Default = 0
}

abstract class StringAttrDesc extends AttributeDescription[String] {
  override val Default = "не указано"
}

object DexterityDescription extends IntAttrDesc {
  override val name: String = "Ловкость"
  override val code: String = "dex"
  override val desc: String = "Влияет на шанс попадания/уворота"
}

object EnduranceDescription extends IntAttrDesc {
  override val name: String = "Выносливость"
  override val code: String = "end"
  override val desc: String = "Влияет на количество очков жизней"
}

object StrengthDescription extends IntAttrDesc {
  override val name: String = "Сила"
  override val code: String = "str"
  override val desc: String = "Влияет на наносимые повреждения"
}

object NameDescription extends StringAttrDesc {
  override val name: String = "Имя"
  override val code: String = "name"
  override val desc: String = "Собсно имя"
}