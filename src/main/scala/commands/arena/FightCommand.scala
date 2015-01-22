package commands.arena

import app.App
import app.state.ArenaState
import commands.Command

object FightCommand extends Command {
  override val ALIAS: String = "fight"

  override def execute(args: String): String = {
    App.state.asInstanceOf[ArenaState].fight.mkString("\n") + "\n"

  }

  override def description: String = "- моделирует битву"
}
