package app.state

import app.App
import commands.Command
import commands.arena.{FightCommand, KickCommand, PickCommand}
import commands.common.CancelCommand
import model.fighters.Fighter

class ArenaState extends AppState {
  protected var fighters: Set[Fighter] = Set()

  override def commands: Set[Command] = Set(FightCommand, PickCommand, KickCommand, CancelCommand)

  override def toString: String =
    App.fightersList + "\nВыбраны бойцы: " + fighters.map(_.shortDesc).mkString(", ")

  def addFighter(fighter: Fighter) = {
    if(fighters.contains(fighter))
      throw new Exception("Боец уже выбран.")
    fighters += fighter
  }

  def removeFighter(fighter: Fighter) = {
    fighters -= fighter
  }

  def fightersState: String =
    fighters map {f => s"${f.name} ${f.condition._1}/${f.condition._2}"} mkString " | "

  def prepareFighters() = fighters foreach (_.prepare)

  /**
   * Моделирует битву
   * @return записи лога
   */
  def fight: List[String] = ???
}
