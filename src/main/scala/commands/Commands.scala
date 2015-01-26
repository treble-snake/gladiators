package commands

import app.App
import commands.arena.{ArenaCommand, FightCommand, KickCommand, PickCommand}
import commands.common.{CancelCommand, CommandNotFound, ExitCommand, HelpCommand}
import commands.creating.{CreateCommand, SaveCommand, SetCommand}

object Commands {
  val all = Map(
    CreateCommand.ALIAS -> CreateCommand,
    ArenaCommand.ALIAS -> ArenaCommand,
    CancelCommand.ALIAS -> CancelCommand,
    SetCommand.ALIAS -> SetCommand,
    SaveCommand.ALIAS -> SaveCommand,
    PickCommand.ALIAS -> PickCommand,
    KickCommand.ALIAS -> KickCommand,
    FightCommand.ALIAS -> FightCommand,
    ExitCommand.ALIAS -> ExitCommand,
    HelpCommand.ALIAS -> HelpCommand
  )

  def get(alias: String): Command = all get alias filter {
      c => c.alwaysAvailable || App.state.commands.contains(c)} getOrElse CommandNotFound
}
