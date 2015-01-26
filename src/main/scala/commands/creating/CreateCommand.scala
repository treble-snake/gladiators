package commands.creating

import app.App
import app.state.CreationState
import commands.Command
import commands.common.HelpCommand
import model.fighters.Gladiator


object CreateCommand extends Command {
  override val ALIAS = "create"

  val types = Map(
    "usual" -> ("Обычный гладиатор", () => new Gladiator)
  )

  override def execute(args: String*): String = {
    args lift 0 map (
      types get _ map { item =>
        App.state = new CreationState(item._2())
        s"Вы в режиме создания гладиатора. Доступные команды:\n ${HelpCommand.execute}"
      } getOrElse "Ошибка, указан неверный тип гладиатора"
    ) getOrElse "Ошибка, не указан тип гладиатора"
  }

  override val description = "[type] - для входа в режим создания гладиатора" +
    "\n\t[type] - тип гладиатора; доступные типы:" + types.map(item =>
      s"\n\t\t - ${item._1}, ${item._2._1}").reduce(_ + _)
}
