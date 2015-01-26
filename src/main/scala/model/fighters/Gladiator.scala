package model.fighters

import app.Configuration
import model.attributes._

import scala.util.Random

object Gladiator {
  val attributes = List(StrengthDescription, DexterityDescription, EnduranceDescription)
  def makeAttributes = attributes.map(d => d.code -> Attribute(d, 0)).toMap
}

class Gladiator extends FighterBase {

  override protected val attributes = Gladiator.makeAttributes

  override def attack(target: Fighter): String = {
    val log:String = s"$name ударил по ${target.name}"
    val hitChange: Double = target.avoidAttack(
      Configuration.hitBaseChange + dexterity * Configuration.dexMultiplier)

    if(Random.nextInt(100) > hitChange)
      return log + " и промазал"

    log + s" и нанес ${target.receiveDamage(strength)} урона"
  }

  override def prepare() {
    maxHitPoints = (endurance * Configuration.hpMultiplier).toInt; currentHitPoints = maxHitPoints }

  override def avoidAttack(hitChange: Double): Double =
    hitChange - dexterity*Configuration.dexMultiplier

  override def receiveDamage(damage: Int): Int = {
    currentHitPoints -= damage
    damage
  }

  private def strength = get("str").get
  private def dexterity = get("dex").get
  private def endurance = get("end").get
}


