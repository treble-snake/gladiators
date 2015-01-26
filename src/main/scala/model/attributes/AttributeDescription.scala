package model.attributes

trait AttributeDescription {
  val name: String
  val code: String
  val desc: String
}

object DexterityDescription extends AttributeDescription {
  override val name = "Ловкость"
  override val code = "dex"
  override val desc = "Влияет на шанс попадания/уворота"
}

object EnduranceDescription extends AttributeDescription {
  override val name = "Выносливость"
  override val code = "end"
  override val desc = "Влияет на количество очков жизней"
}

object StrengthDescription extends AttributeDescription {
  override val name = "Сила"
  override val code = "str"
  override val desc = "Влияет на наносимые повреждения"
}