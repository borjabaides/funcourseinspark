package org.hablapps.fpinscala.intro.oo

import org.scalatest.{FunSpec, Matchers}

class Exercises extends FunSpec with Matchers {

  // PART I
  //
  // Add a new non-implemented method to trait `Fruit`, that doesn't have
  // any argument and returns a Double. Take method `color` as a reference
  trait Fruit {
    def color: String
    ???
  }

  // PART II
  //
  // Next, we have the Companion Object for trait `Fruit` that we created
  // in PART I. Implement method `create`, that creates a `Fruit`, using
  // the argument `_color`, and setting the `price` to "3.0".
  //
  // TIP: Remember that a trait has no constructors, so you'll have to use
  // anonymous class syntax to create an instance. (`new Fruit {...}`)
  object Fruit {
    def create(_color: String): Fruit = ???
  }

  // PART III
  //
  // Make class `Banana` extend from trait `Fruit`, setting the method
  // `color` to "yellow" and receiving the `price` in the constructor.
  class Banana {
    def color: String = ???
  }

  // PART IV
  //
  // Create a fruit with any `color` using `Fruit.create` and a banana of
  // any `price` using Banana class' constructor.
  lazy val fruit: Fruit = ???
  lazy val banana: Banana = ???

  // Tests are ignored, once you've finished the correspondent PARTs,
  // you can start changing `ignore` to `it` to activate them.
  //
  // You can run the test from sbt console:
  // > testOnly org.hablapps.fpinscala.intro.oo.Exercises
  describe("The fruit") {
    it("should cost 3.0") {
      // Uncomment next line once the exercise is done
      // fruit.price shouldBe 3.0
    }
  }

  describe("The banana") {
    ignore("should be \"yellow\"") {
      banana.color shouldBe "yellow"
    }
  }

}
