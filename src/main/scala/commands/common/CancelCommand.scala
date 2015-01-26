package commands.common

import app.App
import app.state.DefaultState
import commands.Command

object CancelCommand extends Command {
  override val ALIAS = "cancel"
  override def execute(args: String*): String = { App.state = new DefaultState; "" }
  override val description = "- возврат в главное меню"
}
