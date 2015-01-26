package commands.common

import app.App
import commands.{Command, Commands}


object HelpCommand extends Command {
  override val ALIAS = "help"

  override def alwaysAvailable = true

  def execute:String = execute("");

  override def execute(args: String*): String = {
    (App.state.commands ++
      Commands.all.filter(_._2.alwaysAvailable).map(_._2))
        .map(c => c.ALIAS + " " + c.description + "\n") reduce (_ + _)
  }

  override val description = "- отобразить помощь"
}
