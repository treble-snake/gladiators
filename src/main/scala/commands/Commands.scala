package commands

import app.App
import commands.arena.{FightCommand, KickCommand, PickCommand, ArenaCommand}
import commands.common.{CommandNotFound, HelpCommand, ExitCommand, CancelCommand}
import commands.creating.{SaveCommand, SetCommand, CreateCommand}

object Commands {
  private val _all = Map(
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

  def all = _all

  def get(alias: String): Command = _all get alias filter {
      c => c.alwaysAvailable || App.state.commands.contains(c)} getOrElse CommandNotFound
}
