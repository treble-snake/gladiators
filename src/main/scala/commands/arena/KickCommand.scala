package commands.arena

import app.App
import app.state.ArenaState
import commands.Command

object KickCommand extends Command {
  override val ALIAS = "kick"

  override def execute(args: String*): String = {
    args lift 0 map {name =>
      App.fighters get name foreach App.state.asInstanceOf[ArenaState].removeFighter
      ""
    } getOrElse "Недостаточно параметров"
  }

  override val description = "[name] - убирает бойца, где [name] - его имя"
}
