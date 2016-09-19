package com.lonelyplanet.util.testing.scalatest.matchers

import org.scalatest.{FlatSpec, Matchers}

class URIMatchersSpec extends FlatSpec with Matchers with URIMatchers {
  "URIMatcher" should "match exactly the same URIs" in {
    val uri = "/hello/world"
    uri should matchIgnoreParameterOrdering(uri)
  }

  it should "match exactly the same URIs with query parameters" in {
    val uri = "/hello?what=world&when=now"
    uri should matchIgnoreParameterOrdering(uri)
  }

  it should "match exactly the same URIs with query parameters shuffled" in {
    val uri1 = "/hello?what=world&when=now"
    val uri2 = "/hello?when=now&what=world"
    uri1 should matchIgnoreParameterOrdering(uri2)
  }

  it should "not match different URIs" in {
    val uri1 = "/abc"
    val uri2 = "/hello"
    uri1 should not(matchIgnoreParameterOrdering(uri2))
  }

  it should "not the same URIs but with different query param values" in {
    val uri1 = "/hello?what=world"
    val uri2 = "/hello?what=scalatest"
    uri1 should not(matchIgnoreParameterOrdering(uri2))
  }
}
