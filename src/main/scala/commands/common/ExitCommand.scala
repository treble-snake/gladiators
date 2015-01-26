package commands.common

import commands.Command

object ExitCommand extends Command {
  override val ALIAS = "exit"

  override def isExit = true
  override def alwaysAvailable = true
  override def execute(args: String*): String = ""
  override def description: String = "- выйти из программы"
}
