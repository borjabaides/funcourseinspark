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
      }
      it("should return false if it's a Some but the value doesn't match") {
      }
      it("should return false if it's a None") {
      }
    }
    describe("getOrElse") {
      it("should return the content if it's a Some") {
      }
      it("should return the alternative if it's a None") {
      }
      it("shouldn't compile if the alternative doesn't type check") {
      }
    }
    describe("orElse") {
      it("should return itself if it's a Some") {
      }
      it("should return the alternative if it's a None") {
      }
      it("shouldn't compile if the alternative doesn't type check") {
      }
    }
  }
}
