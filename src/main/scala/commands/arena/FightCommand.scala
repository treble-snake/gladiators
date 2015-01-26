package commands.arena

import app.App
import app.state.ArenaState
import commands.Command

object FightCommand extends Command {
  override val ALIAS = "fight"

  override def execute(args: String*): String = {
    App.state.asInstanceOf[ArenaState].fight.mkString("\n") + "\n"

  }

  override val description = "- моделирует битву"
}
