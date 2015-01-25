package app.state

import app.Configuration
import commands.Command
import commands.common.CancelCommand
import commands.creating.{SaveCommand, SetCommand}
import model.attributes.{Attribute, AttributeDescription}

import scala.collection.mutable

class CreationState(attributesList: List[AttributeDescription[Any]]) extends AppState {
  override def commands: Set[Command] = Set(SetCommand, SaveCommand, CancelCommand)

  private val attributes: mutable.Map[String, Attribute[Any]] = mutable.Map(
    attributesList.map({item => (item.name, Attribute(item, item.Default))}): _*
  )
  private var experiencePoints = Configuration.baseExperience

  override def toString: String =
    s"Боец:\n$attributes\nОсталось свободных очков: $experiencePoints"

  def set(attr: String, value: String) {
    attributes get attr foreach { item =>
      val cost = item.cost(value on_: item)
      if(cost <= experiencePoints) {
        attributes put (attr, Attribute(item.desc, value))
        experiencePoints -= cost
      }
    }
//    attr match {
//      case "name" => fighter.name = value.toString
//      case _ =>
//        val newValue = value.toString.toInt
//        fighter.get(attr).foreach { currentValue =>
//          val cost: Int = newValue - currentValue
//          if (cost <= experiencePoints) {
//            fighter(attr) = newValue
//            experiencePoints -= cost
//          }
//        }
//    }
  }

  def save() = {
    if(experiencePoints != 0)
      throw new Exception("Надо потратить все очки опыта. Все!")

//    if(App.fighters get fighter.name isDefined)
//      throw new Exception("Боец с таким именем уже есть")

//    App.fighters += (fighter.name -> fighter)
  }
}
