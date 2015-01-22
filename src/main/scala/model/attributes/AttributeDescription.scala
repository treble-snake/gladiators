package model.attributes

abstract class AttributeDescription {
  val name = "Название"
  val code = "Код"
  val desc = "Описание"
}

object DexterityDescription extends AttributeDescription {
  override val name: String = "Ловкость"
  override val code: String = "dex"
  override val desc: String = "Влияет на шанс попадания/уворота"
}

object EnduranceDescription extends AttributeDescription {
  override val name: String = "Выносливость"
  override val code: String = "end"
  override val desc: String = "Влияет на количество очков жизней"
}

object StrengthDescription extends AttributeDescription {
  override val name: String = "Сила"
  override val code: String = "str"
  override val desc: String = "Влияет на наносимые повреждения"
}