package commands.creating

import app.state.{CreationState, DefaultState}
import app.App
import commands.Command

object SaveCommand extends Command {
  override val ALIAS: String = "save"

  override def execute(args: String): String = {
//    try {
      App.state.asInstanceOf[CreationState].save
      App.state = new DefaultState
      "Сохранение прошло успешно."
//    } catch {
//      case e: Throwable => e.getMessage
//    }
  }

  override def description: String = "- для сохранения бойца в список"
}
