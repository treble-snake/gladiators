package commands.arena

import app.App
import app.state.ArenaState
import commands.Command

object PickCommand extends Command {
  override val ALIAS = "pick"

  override def execute(args: String*): String = {
    args lift 0 map {name =>
      App.fighters get name foreach App.state.asInstanceOf[ArenaState].addFighter
      ""
    } getOrElse "Недостаточно параметров"
  }

  override val description = "[name] - выбирает бойца, где [name] - его имя"
}
