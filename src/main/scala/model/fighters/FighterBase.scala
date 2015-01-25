package model.fighters

import model.attributes.Attribute

abstract class FighterBase extends Fighter {

  protected val attributes: Map[String, Attribute[Any]] = Map()

  override var name: String = "anonymous"

  var maxHitPoints: Int = 0
  var currentHitPoints: Int = 0

  override def set(attr: String, value: Int) = {}
//    Option(value) filter(_ >= -12) foreach {v => attributes get attr foreach(_(v))}

  override def get[T](attr: String): Option[T] = {None}
//    attributes get attr map (_.value)

  override def toString: String = s"$name\n" + (attributes map
    {it => s"${it._2.desc.name} (${it._2.desc.code}): ${it._2.value}\n"} reduce(_ + _))

  override def shortDesc: String = s"$name (" + (
    attributes map {it => s"${it._2.desc.code}: ${it._2.value}"} mkString ", ") + ")"

  override def apply(attr: String) = get(attr).get

  override def update(attr: String, value: Int) = set(attr, value)

  override def condition: (Int, Int) = (currentHitPoints, maxHitPoints)

  override def isDead: Boolean = currentHitPoints <= 0

  override def equals(obj: scala.Any): Boolean =
    obj.isInstanceOf[Fighter] && obj.asInstanceOf[Fighter].name == name

  override def hashCode(): Int = name.hashCode()
}
