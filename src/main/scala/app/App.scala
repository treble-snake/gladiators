package app

import app.state.{AppState, DefaultState}
import commands.Commands
import commands.common.HelpCommand
import model.fighters.{Fighter, Gladiator}

import scala.collection.mutable

object App {

  var state: AppState = new DefaultState
  val fighters: mutable.Map[String, Fighter] = mutable.Map()

  def fightersList: String = "Список бойцов:\n" +
    App.fighters.map{ f => s"- ${f._2.shortDesc}"}.mkString("\n")

  def main(args: Array[String]) {
    def addSomeFighters() {
      var tmp: Fighter = new Gladiator
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
    }

    def processLine(line: String) {
      try {
        val words = line.split(" ")
        println(Commands.get(words(0)).execute(words.drop(1): _*))
      } catch {
        case e: Throwable =>
          println(s"${e.getMessage}\nНажмите Enter")
          Console.in.readLine
      }
      println(state.toString)
    }

    Configuration.init()
    addSomeFighters()
    println(HelpCommand.execute)
    Iterator.continually(Console.in.readLine)
      .takeWhile(!Commands.get(_).isExit)
      .foreach(processLine)
  }
}
