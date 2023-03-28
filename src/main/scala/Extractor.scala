package com.knoldus

object Extractor extends App {

  val url = "https://www.knoldus.com/blogs/PradyumanKnoldus"

  // Use pattern matching to extract the protocol, domain, and path from the URL using the URLParser unapply method
  url match {
    case URLParser(protocol, domain, path) =>
      println(s"Protocol: $protocol")
      println(s"Domain: $domain")
      println(s"Path: $path")
    case _ =>
      println("Invalid URL format")
  }

}
