package commands.common

import app.App
import app.state.DefaultState
import commands.Command

object CancelCommand extends Command {
  override val ALIAS: String = "cancel"
  override def execute(args: String): String = { App.state = new DefaultState; "" }
  override def description: String = "- возврат в главное меню"
}
