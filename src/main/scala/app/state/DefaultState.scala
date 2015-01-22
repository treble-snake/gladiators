package app.state

import app.App
import commands.Command
import commands.arena.ArenaCommand
import commands.creating.CreateCommand

class DefaultState extends AppState {
  override def commands: Set[Command] = Set(CreateCommand, ArenaCommand)
  override def toString: String = "Вы в главном меню. " + App.fightersList
}
