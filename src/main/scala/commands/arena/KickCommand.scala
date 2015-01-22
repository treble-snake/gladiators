package commands.arena

import app.App
import app.state.ArenaState
import commands.Command

object KickCommand extends Command {
  override val ALIAS: String = "kick"

  override def execute(args: String): String = {
    args split " " lift 1 map {name =>
      App.fighters get name foreach App.state.asInstanceOf[ArenaState].removeFighter
      ""
    } getOrElse "Недостаточно параметров"
  }

  override def description: String = "[name] - убирает бойца, где [name] - его имя"
}
