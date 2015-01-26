package commands

trait Command {
  val ALIAS: String
  def isExit = false
  def alwaysAvailable = false
  def execute(args: String*): String
  val description: String
}









