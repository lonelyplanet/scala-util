package com.lonelyplanet.util

import org.scalatest.{FlatSpec, Matchers}
import OptionConversions._

class OptionConversionsSpec extends FlatSpec with Matchers {
  it should "wrap in Option" in {
    wrapOption(10, condition = true) shouldBe Some(10)
    wrapOption(10, condition = false) shouldBe None
  }

  it should "wrap String in Option" in {
    stringToOption("abc") shouldBe Some("abc")
    stringToOption("") shouldBe None
    stringToOption("     ") shouldBe None
  }

  it should "map Seq to Option" in {
    seqToOption(List("abc")) shouldBe Some(List("abc"))
    seqToOption(List.empty) shouldBe None
  }
}
