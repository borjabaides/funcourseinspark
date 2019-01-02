package org.hablapps.fpinscala.intro.scalatestlib

import org.scalatest.{FunSpec, Matchers}

class Exercises extends FunSpec with Matchers {

  // PART I
  //
  // Take a look at Option's API and test the following methods
  // - http://www.scala-lang.org/api/current/scala/Option.html
  //
  // > testOnly org.hablapps.fpinscala.intro.scalatestlib.Exercises

  describe("Testing Option[A]") {
    describe("contains") {
      it("should return true if it's a Some and the value matches") {
      Some("something") contains "something" shouldBe true
      }
      it("should return false if it's a Some but the value doesn't match") {
      Some("something") contains "anything"  shouldBe false
      }
      it("should return false if it's a None") {
      None contains "anything" shouldBe false
      }
 
    }
    describe("getOrElse") {
      it("should return the content if it's a Some") {
        Some("something") getOrElse("something") shouldBe "something"
      }
      it("should return the alternative if it's a None") {
        None getOrElse("something") shouldBe "something"
      }
      it("shouldn't compile if the alternative doesn't type check") {
        "x*2" shouldNot compile      }
    }
    describe("orElse") {
      it("should return itself if it's a Some") {
        //Some("something") orElse Some("something")  shouldBe "something"
      }
      it("should return the alternative if it's a None") {
        //  None orElse Some("else")  shouldBe "else"
                }
      it("shouldn't compile if the alternative doesn't type check") {
        "x*2" shouldNot compile
              }
    }
  }
}
