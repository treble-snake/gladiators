package commands.arena

import app.App
import app.state.DuelState
import commands.Command
import commands.common.HelpCommand

object ArenaCommand extends Command {
  override val ALIAS = "arena"

  override def execute(args: String): String = {
    App.state = new DuelState
    "Вы в режиме арены. Доступные команды: \n" + HelpCommand.execute
  }

  override def description: String = "- для входа в режим боя"
}
