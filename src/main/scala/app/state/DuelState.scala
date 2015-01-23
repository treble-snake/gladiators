package app.state

import model.fighters.Fighter

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class DuelState extends ArenaState {

  override def addFighter(fighter: Fighter) = {
    if(fighters.size == 2)
      throw new Exception("Два бойца уже выбрано.")
    super.addFighter(fighter)
  }

  /**
   * Моделирует битву
   * @return записи лога
   */
  override def fight: List[String] = {
    if(fighters.size != 2)
      throw new Exception("Нужно выбрать двух бойцов.")

    var i = 0
    var pair = (fighters.head, fighters.last)
    val logBuffer = ListBuffer[String]()

    prepareFighters()
    do {
      logBuffer += s"Ход $i. $fightersState\n" + pair._1.attack(pair._2)
      pair = pair.swap
      i += 1
    } while(!pair._1.isDead && !pair._2.isDead && i < 100)

    logBuffer += s"\nКонец боя. $fightersState\nПобедитель: " +
      List(pair._1, pair._2).filter(!_.isDead).map(_.name).reduceOption(_+ ", " +_).getOrElse("ничья")

    logBuffer.result()
  }

}
