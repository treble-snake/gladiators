package model.fighters

trait Fighter {

  /** Fighter's name */
  var name: String

  /**
   * Sets a fighter's attribute
   * @param attr attribute name
   * @param value attribute value
   * @return volume of used experience points (may be negative)
   */
  def set(attr: String, value: Int)

  /**
   * Returns value of the required attribute
   * @param attr attribute code
   * @return attribute value
   */
  def get(attr: String): Option[Int]

  def shortDesc: String

  def apply(attr: String)

  def update(attr: String, value: Int)

  /**
   * @param target
   * @return строка лога
   */
  def attack(target: Fighter): String

  def prepare

  def avoidAttack(hitChange: Double): Double

  def receiveDamage(damage: Int): Int

  def condition:(Int, Int)

  def isDead: Boolean
}
