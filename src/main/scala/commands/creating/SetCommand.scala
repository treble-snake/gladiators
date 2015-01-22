package commands.creating

import app.state.CreationState
import commands.Command
import app.App

object SetCommand extends Command {
  override val ALIAS: String = "set"

  override def execute(args: String): String = {
    val argsArray = args split " "
    if(argsArray.size != 3)
      return "Неверное количество аргументов"

    App.state.asInstanceOf[CreationState].set(argsArray(1), argsArray(2))
    ""
  }

  override def description: String = "[attr] [value] - для установки параметров бойца; " +
    "\n\tвместо [attr] используйте:\n\t\t- name - для установки имени" +
    "\n\t\t- код атрибута (например, str) - для установки значения атрибута" +
    "\n\tвместо [value] укажите значение атрибута"
}
