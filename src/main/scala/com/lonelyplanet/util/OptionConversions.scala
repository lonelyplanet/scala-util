package com.lonelyplanet.util

import scala.collection.immutable.Seq

object OptionConversions {
  def wrapOption[T](condition: => Boolean, obj: T): Option[T] = if (condition) Some(obj) else None

  def seqToOption[T](list: Seq[T]): Option[Seq[T]] = wrapOption(list.nonEmpty, list)

  def stringToOption(str: String): Option[String] = wrapOption(!trimmedStringIsEmpty(str), str)

  private def trimmedStringIsEmpty(str: String) = str.trim.isEmpty
}
