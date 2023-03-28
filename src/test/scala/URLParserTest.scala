package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class URLParserTest extends AnyFlatSpec with Matchers {

  "URLParser" should "extract the protocol, domain, and path from a valid URL" in {
    val url = "https://www.knoldus.com/blogs/PradyumanKnoldus"
    val expected = Some("https", "www.knoldus.com", "/blogs/PradyumanKnoldus")
    val actual = url match {
      case URLParser(protocol, domain, path) => Some(protocol, domain, path)
      case _ => None
    }
    actual shouldEqual expected
  }

  it should "extract the protocol and domain from a URL without a path" in {
    val url = "https://www.knoldus.com"
    val expected = Some("https", "www.knoldus.com", "")
    val actual = url match {
      case URLParser(protocol, domain, path) => Some(protocol, domain, path)
      case _ => None
    }
    actual shouldEqual expected
  }


  it should "return None when given an invalid URL" in {
    val url = "not a valid URL"
    val expected = None
    val actual = url match {
      case URLParser(protocol, domain, path) => Some(protocol, domain, path)
      case _ => None
    }
    actual shouldEqual expected
  }
}
