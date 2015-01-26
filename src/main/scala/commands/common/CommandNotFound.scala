package commands.common

import commands.Command

object CommandNotFound extends Command {
  override val ALIAS = "NoCommand"
  override def execute(args: String*) = "Command not found"
  override val description = "no description"
}
