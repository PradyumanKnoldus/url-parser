package com.knoldus

import scala.util.Try

class URLParser(protocol: String, domain: String, path: String)

object URLParser {

  // Define an apply method to create a new instance of URLParser
  def apply(protocol: String, domain: String, path: String): URLParser =
    new URLParser(protocol, domain, path)

  // Define an unapply method to extract the protocol, domain, and path from a given URL string
  def unapply(url: String): Option[(String, String, String)] = {

    // Try to split the URL string into its component parts
    Try {
      val parts = url.split("://")

      // If there are exactly two parts, extract the protocol, domain, and path
      if (parts.length == 2) {
        val protocol = parts(0)
        val domainAndPath = parts(1).split("/", 2)
        val domain = domainAndPath(0)
        val path = if (domainAndPath.length > 1) "/" + domainAndPath(1) else ""
        Some(protocol, domain, path)
      } else {
        None
      }
    }.getOrElse(None) // Return None if an exception is thrown
  }
}
