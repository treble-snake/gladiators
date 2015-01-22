package model.fighters

import model.attributes.Attribute

abstract class GladiatorBase extends Fighter {

  protected val attributes: Map[String, Attribute] = null

  override var name: String = "anonymous"

  var maxHitPoints: Int = 0
  var currentHitPoints: Int = 0

  override def set(attr: String, value: Int) =
    Option(value) filter(_ >= 0) foreach {v => attributes get attr foreach(_.value = v) }

  override def get(attr: String): Option[Int] = attributes get attr map (_.value)

  override def toString: String = s"$name\n" + (attributes map
    {it => s"${it._2.desc.name} (${it._2.desc.code}): ${it._2.value}\n"} reduce(_ + _))

  override def shortDesc: String = s"$name (" + (
    attributes map {it => s"${it._2.desc.code}: ${it._2.value}"} mkString ", ") + ")"


  override def condition: (Int, Int) = (currentHitPoints, maxHitPoints)

  override def isDead: Boolean = currentHitPoints <= 0

  override def equals(obj: scala.Any): Boolean =
    obj.isInstanceOf[Fighter] && obj.asInstanceOf[Fighter].name == name

  override def hashCode(): Int = name.hashCode()
}