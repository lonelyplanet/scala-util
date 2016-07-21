package com.lonelyplanet.util

import scala.collection.immutable.Seq

object OptionConversions {
  def wrapOption[T](obj: T, condition: => Boolean): Option[T] = if (condition) Some(obj) else None

  def seqToOption[T](list: Seq[T]): Option[Seq[T]] = wrapOption(list, list.nonEmpty)

  def stringToOption(str: String): Option[String] = wrapOption(str, !trimmedStringIsEmpty(str))

  private def trimmedStringIsEmpty(str: String) = str.trim.isEmpty
}
