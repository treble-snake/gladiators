package app.state

import commands._

trait AppState {
  def commands:Set[Command]
  override def toString: String = "Not implemented"
}
