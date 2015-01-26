package commands.creating

import app.App
import app.state.{CreationState, DefaultState}
import commands.Command

object SaveCommand extends Command {
  override val ALIAS = "save"

  override def execute(args: String*): String = {
//    try {
      App.state.asInstanceOf[CreationState].save
      App.state = new DefaultState
      "Сохранение прошло успешно."
//    } catch {
//      case e: Throwable => e.getMessage
//    }
  }

  override val description = "- для сохранения бойца в список"
}
