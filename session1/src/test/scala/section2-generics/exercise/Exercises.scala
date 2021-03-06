package org.hablapps.fpinscala.intro.generics

import org.scalatest.{FunSpec, Matchers}

class Exercises extends FunSpec with Matchers {

  case class Bike(gear: Int, cadence: Int, speed: Int)

  val bikes: List[Bike] = List(
    Bike(1,  0,  5),
    Bike(2, 10,  8),
    Bike(4, 25, 30),
    Bike(6,  1, 45))

  // Check `List` API to see the methods we'll be using during the next
  // exercises:
  //
  // http://www.scala-lang.org/api/current/#scala.collection.immutable.List

  // PART I
  //
  // Filter all bikes that have an odd gear.
  //
  // TIP: The module operator in Scala is `%`, e.g., `5 % 3 = 2`
  lazy val oddBikes: List[Bike] = bikes.filter( _.gear % 2 == 1) //_1

  describe("PART I") {
    it("should have only bikes with odd gear") {
      oddBikes shouldBe Bike(1, 0, 5) :: Nil
    }
  }

 // PART II
 //
 // Find the bike with the most `speed`. Use `reduce` method to get it.
 // def funcMax (a : Bike , b : Bike):Bike = if (a.speed > b.speed ) a else b
 // lazy val speediest: Bike = bikes.reduce((x,y) => funcMax(x, y))
 lazy val speediest: Bike = bikes.reduce((x,y) =>if (x.speed > y.speed ) x else y)
 
  describe("PART II") {
    it("should get the bike with the most speed") {
      speediest shouldBe Bike(6,  1, 45)
    }
  }

  // PART III
  //
  // Sum all bikes cadences. Use `foldLeft` method to get it.
  lazy val cadences: Int = bikes.foldLeft(0)((x,y) => x + y.cadence)

  describe("PART III") {
    it("should get the sum of all cadences") {
      cadences shouldBe 36
    }
  }
}
