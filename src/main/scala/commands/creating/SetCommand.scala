package commands.creating

import app.App
import app.state.CreationState
import commands.Command

object SetCommand extends Command {
  override val ALIAS = "set"

  override def execute(args: String*): String = {
    if(args.size != 2)
      return "Неверное количество аргументов"

    App.state.asInstanceOf[CreationState].set(args(0), args(1))
    ""
  }

  override val description = "[attr] [value] - для установки параметров бойца; " +
    "\n\tвместо [attr] используйте:\n\t\t- name - для установки имени" +
    "\n\t\t- код атрибута (например, str) - для установки значения атрибута" +
    "\n\tвместо [value] укажите значение атрибута"
}
