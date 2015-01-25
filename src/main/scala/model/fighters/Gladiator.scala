package model.fighters

import app.Configuration
import model.attributes._

import scala.util.Random

object Gladiator extends FighterUtil {
  val attributes: List[AttributeDescription[Any]] =
    List(NameDescription, StrengthDescription, DexterityDescription, EnduranceDescription).asInstanceOf[List[AttributeDescription[Any]]]
  def makeAttributes: Map[String, Attribute[Any]] = attributes.map(d => d.code -> Attribute(d, 0)).toMap
  .asInstanceOf[Map[String, Attribute[Any]]]
  def apply() = new Gladiator
}

class Gladiator extends FighterBase {

//  override protected val attributes = Gladiator.makeAttributes

  override def attack(target: Fighter): String = {
    val log:String = s"$name ударил по ${target.name}"
    val hitChange: Double = target.avoidAttack(
      Configuration.hitBaseChange + dexterity * Configuration.dexMultiplier)

    if(Random.nextInt(100) > hitChange)
      return log + " и промазал"

    log + s" и нанес ${target.receiveDamage(strength)} урона"
  }

  override def prepare: Unit = {
    maxHitPoints = (endurance * Configuration.hpMultiplier).toInt; currentHitPoints = maxHitPoints }

  override def avoidAttack(hitChange: Double): Double =
    hitChange - dexterity*Configuration.dexMultiplier

  override def receiveDamage(damage: Int): Int = {
    currentHitPoints -= damage
    damage
  }

  private def strength = 5//get("str").get
  private def dexterity = 5//get("dex").get
  private def endurance = 5//get("end").get
}


