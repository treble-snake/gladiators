package app.state

import app.{App, Configuration}
import commands.Command
import commands.common.CancelCommand
import commands.creating.{SaveCommand, SetCommand}
import model.fighters.Fighter

class CreationState(private val fighter: Fighter) extends AppState {
  override def commands: Set[Command] = Set(SetCommand, SaveCommand, CancelCommand)

  private var experiencePoints = Configuration.baseExperience

  override def toString: String =
    s"Боец:\n${fighter.toString}\nОсталось свободных очков: $experiencePoints"

  def set(attr: String, value: Any) = {
    attr match {
      case "name" => fighter.name = value.toString
      case _ =>
        val newValue: Int = value.toString.toInt
        fighter get attr foreach {currentValue =>
          if(newValue - currentValue <= experiencePoints)
          {
            fighter(attr) = newValue
            experiencePoints -= newValue - currentValue
          }
        }
    }
  }

  def save() = {
    if(experiencePoints != 0)
      throw new Exception("Надо потратить все очки опыта. Все!")

    if(App.fighters get fighter.name isDefined)
      throw new Exception("Боец с таким именем уже есть")

    App.fighters += (fighter.name -> fighter)
  }
}
