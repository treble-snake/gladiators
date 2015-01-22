package commands.arena

import app.App
import app.state.ArenaState
import commands.Command

object PickCommand extends Command {
  override val ALIAS: String = "pick"

  override def execute(args: String): String = {
    args split " " lift 1 map {name =>
      App.fighters get name foreach App.state.asInstanceOf[ArenaState].addFighter
      ""
    } getOrElse "Недостаточно параметров"
  }

  override def description: String = "[name] - выбирает бойца, где [name] - его имя"
}
