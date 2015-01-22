package app

import app.state.{AppState, DefaultState}
import commands.Commands
import commands.common.HelpCommand
import model.fighters.{Gladiator, Fighter}

object App {

  var state: AppState = new DefaultState
  var fighters: Map[String, Fighter] = Map()

  def fightersList: String = "Список бойцов:\n" +
    App.fighters.map { f => s"- ${f._2.shortDesc}"}.mkString("\n")

  def main(args: Array[String]) {
    Configuration.init
    println(HelpCommand.execute)

    var tmp:Fighter = new Gladiator
    tmp.name = "Patrick"
    tmp.set("str", 10)
    tmp.set("dex", 5)
    tmp.set("end", 5)
    fighters += (tmp.name -> tmp)

    tmp = new Gladiator
    tmp.name = "Allan"
    tmp.set("str", 5)
    tmp.set("dex", 5)
    tmp.set("end", 10)
    fighters += (tmp.name -> tmp)

    tmp = new Gladiator
    tmp.name = "Greg"
    tmp.set("str", 5)
    tmp.set("dex", 10)
    tmp.set("end", 5)
    fighters += (tmp.name -> tmp)

    Iterator.continually(Console.in.readLine)
      .takeWhile(!Commands.get(_).isExit)
      .foreach { line => try {
      println(Commands.get(line.split(" ")(0)).execute(line))
    } catch {
      case e: Throwable =>
        println(s"${e.getMessage}\nНажмите Enter")
        Console.in.readLine
    }
      println(state toString)
    }
  }
}
