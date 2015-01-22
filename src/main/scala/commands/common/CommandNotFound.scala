package commands.common

import commands.Command

object CommandNotFound extends Command {
  override val ALIAS: String = "NoCommand"
  override def execute(args: String) = "Command not found"
  override def description: String = "no description"
}
