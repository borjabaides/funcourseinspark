package org.hablapps.fpinscala.intro.oo
package code

import org.scalatest.{FunSpec, Matchers}

object BikeSpec extends BikeSpec

class BikeSpec extends FunSpec with Matchers {

  // // 1. Creation of a MUTABLE bike, with cadence, gear and speed as members.
  // // Fields are defined using the constructor's arguments
  // class Bike(_cadence: Int, _speed: Int, _gear: Int) {
  //   var cadence: Int = _cadence
  //   var speed: Int = _speed
  //   var gear: Int = _gear
  // }

  // describe("Testing MUTABLE class Bike") {
  //   val b = new Bike(1, 2, 3)

  //   it("should create objects with the given arguments") {
  //     b.cadence shouldBe 1
  //     b.speed shouldBe 2
  //     b.gear shouldBe 3
  //   }

  //   it("should be able to modify those members") {
  //     b.cadence = 100
  //     b.cadence shouldBe 100
  //   }
  // }

  // // 2. IMMUTABLE version of previous bike. We us `val` (value) instead
  // // of `var` (variable). Scala encourages immutability, hence the use of
  // // `var`s is discouraged in most of the cases. As a result of this change,
  // // we don't have setters anymore.
  // class Bike(_cadence: Int, _speed: Int, _gear: Int) {
  //   val cadence: Int = _cadence
  //   val speed: Int = _speed
  //   val gear: Int = _gear
  // }

  // describe("Testing IMMUTABLE class Bike") {
  //   val b = new Bike(1, 2, 3)

  //   it("should create objects with the given arguments") {
  //     b.cadence shouldBe 1
  //     b.speed shouldBe 2
  //     b.gear shouldBe 3
  //   }

  //   it("should not compile if we try to change a member") {
  //     "b.cadence = 100" shouldNot compile
  //   }
  // }

  // // 3. Constructor arguments and member fields can be unified. We just need
  // // to add wether we want them to be treated as `val` or `var`.
  // class Bike(val cadence: Int, val speed: Int, val gear: Int)

  // // 4. To add a method we use the reserved world `def`. Let's add a method
  // // to our bike, `slowDown`, that will decrease de speed given a decrement.
  // class Bike(val cadence: Int, val speed: Int, val gear: Int) {
  //   def slowDown(dec: Int): Bike =
  //     new Bike(cadence, speed-dec, gear)
  // }

  // describe("Testing IMMUTABLE class Bike") {
  //   val b = new Bike(1, 2, 3)

  //   it("should create objects with the given arguments") {
  //     b.cadence shouldBe 1
  //     b.speed shouldBe 2
  //     b.gear shouldBe 3
  //   }

  //   it("should not compile if we try to change a member") {
  //     "b.cadence = 100" shouldNot compile
  //   }

  //   it("should return a new bike with less speed when we slowDown") {
  //     val b2 = b.slowDown(2)
  //     b2 shouldBe a [Bike]
  //     b2.cadence shouldBe 1
  //     b2.speed shouldBe 0
  //     b2.gear shouldBe 3
  //   }
  // }

  // // 5. We can create new constructors through `def this`:
  // class Bike(val cadence: Int, val speed: Int, val gear: Int) {
  //   def this(cadence: Int, speed: Int) =
  //     this(cadence, speed, 100)

  //   def slowDown(dec: Int): Bike =
  //     new Bike(cadence, speed-dec, gear)
  // }

  // describe("Testing IMMUTABLE class Bike") {
  //   val b = new Bike(1, 2, 3)

  //   it("should create objects with the given arguments") {
  //     b.cadence shouldBe 1
  //     b.speed shouldBe 2
  //     b.gear shouldBe 3
  //   }

  //   it("should not compile if we try to change a member") {
  //     "b.cadence = 100" shouldNot compile
  //   }

  //   it("should return a new bike with less speed when we slowDown") {
  //     val b2 = b.slowDown(2)
  //     b2 shouldBe a [Bike]
  //     b2.cadence shouldBe 1
  //     b2.speed shouldBe 0
  //     b2.gear shouldBe 3
  //   }

  //   it("should create a Bike without passing the gear argument") {
  //     val b3 = new Bike(1, 2)
  //     b3.cadence shouldBe 1
  //     b3.speed shouldBe 2
  //     b3.gear shouldBe 100
  //   }
  // }

  // 6. It's possible to have classes with only one instance, which are known
  // as Singleton Objects. This allows us to get rid of class members used in
  // Java. Let's create a `BikeFactory` with initial values and a method to
  // create new bikes (`create`)
  object BikeFactory {
    val defaultSpeed: Int = 25

    def create(cadence: Int): Bike =
      new Bike(cadence, defaultSpeed, 200)
  }

  describe("Testing BikeFactory singleton object") {
    it("should have a static member defaultSpeed") {
      BikeFactory.defaultSpeed shouldBe 25
    }

    it("should create a Bike given its cadence") {
      val b = BikeFactory.create(1)
      b.cadence shouldBe 1
      b.speed shouldBe 25
      b.gear shouldBe 200
    }
  }

  // // 7. Companion Objects are singleton objects (or simply objects) that go
  // // with a data type, for instance, the bike class
  // object Bike {
  //   def create(cadence: Int): Bike =
  //     new Bike(cadence, 100, 200)
  // }

  // describe("Testing Bike companion object") {
  //   it("should create a Bike given its cadence") {
  //     val b = Bike.create(1)
  //     b.cadence shouldBe 1
  //     b.speed shouldBe 100
  //     b.gear shouldBe 200
  //   }
  // }

  // 8. We can use single inheritance very easily. We'll define a mountain
  // bike that inherits from our bike, adding a new value member `seatHeight`.
  class MountainBike(
    val seatHeight: Int,
    cadence: Int,
    speed: Int,
    gear: Int) extends Bike(cadence, speed, gear)

  describe("Testing class MountainBike") {
    val mb = new MountainBike(50, 1, 2, 3)

    it("should create objects with the given arguments") {
      mb.seatHeight shouldBe 50
      mb.cadence shouldBe 1
      mb.speed shouldBe 2
      mb.gear shouldBe 3
    }

    it("should not compile if we try to change a member") {
      "mb.cadence = 100" shouldNot compile
    }

    it("should return a new bike with less speed when we slowDown") {
      val b2 = mb.slowDown(2)
      b2 shouldBe a [Bike] // Immutability + Inheritance = Oops!
      b2.cadence shouldBe 1
      b2.speed shouldBe 0
      b2.gear shouldBe 3
    }

  }

  // 9. If a class has any non-concrete member, it must be abstract. We'll define
  // a roadBike that doesn't implement `seatHeight`.
  abstract class RoadBike(
      cadence: Int,
      speed: Int,
      gear: Int) extends Bike(cadence, speed, gear) {
    val seatHeight: Int
  }

  describe("Testing abstract class RoadBike") {
    val mb = new RoadBike(1, 2, 3) {
      val seatHeight = 50
    }

    it("should not compile when we don't concrete seatHeight member") {
      "new RoadBike(1, 2, 3)" shouldNot compile
    }

    it("should create objects when we concrete seatHeight member") {
      mb.seatHeight shouldBe 50
      mb.cadence shouldBe 1
      mb.speed shouldBe 2
      mb.gear shouldBe 3
    }

    // it should behave like Bike spec

  }

  // 10. Traits are, roughly speaking, partially implemented interfaces, and allow
  // us to use Multiple Inheritance. For instance, we'll define an engine with a
  // fixed `engineDisplacement` and an abstract `rpm`.
  trait Engine {
    val engineDisplacement: Int
    val rpm: Int = 5000
  }

  describe("Testing trait Engine") {
    val eng = new Engine {
      val engineDisplacement = 50
    }

    it("should not compile when we don't concrete seatHeight member") {
      "new Engine(1, 2, 3) {}" shouldNot compile
    }

    it("should create objects when we concrete seatHeight member") {
      eng.engineDisplacement shouldBe 50
      eng.rpm shouldBe 5000
    }

    it("should override rpm member") {
      val eng2 = new Engine {
        val engineDisplacement = 50
        override val rpm = 7000
      }
      eng2.engineDisplacement shouldBe 50
      eng2.rpm shouldBe 7000
    }

  }

  // 11. This way we can define a `MotorBike`, inheriting from `Bike` and `Engine`.
  class MotorBike(
    cadence: Int,
    speed: Int,
    gear: Int,
    override val engineDisplacement: Int) extends Bike(cadence, speed, gear) with Engine

  describe("Testing class MotorBike") {

    val mb = new MotorBike(1, 2, 3, 50)

    it("should create MotorBike objects") {
      mb.cadence shouldBe 1
      mb.speed shouldBe 2
      mb.gear shouldBe 3
      mb.engineDisplacement shouldBe 50
      mb.rpm shouldBe 5000
    }

    // It should behave like Bike (slowDown)

    // It should behave like Engine

  }

  // 12. Case classes
  case class Bike(cadence: Int, speed: Int, gear: Int) {
    def slowDown(dec: Int): Bike =
      this.copy(speed = speed-dec)
  }

  describe("Testing case class Bike") {
    val b = Bike(1, 2, 3)

    it("should create objects with the given arguments") {
      b.cadence shouldBe 1
      b.speed shouldBe 2
      b.gear shouldBe 3
    }

    it("should not compile if we try to change a member") {
      "b.cadence = 100" shouldNot compile
    }

    it("should return a new bike with less speed when we slowDown") {
      val b2 = b.slowDown(2)
      b2 shouldBe a [Bike]
      b2.cadence shouldBe 1
      b2.speed shouldBe 0
      b2.gear shouldBe 3
    }

    it("should create copies of itself changing members") {
      val b2 = b.copy(cadence = 100)
      b2.cadence shouldBe 100
      b2.speed shouldBe b.speed
      b2.gear shouldBe b.gear

      val b3 = b.copy(speed = 200, gear = 300)
      b3.cadence shouldBe b.cadence
      b3.speed shouldBe 200
      b3.gear shouldBe 300
    }

    it("should extract the members") {
      val Bike(c, s, g) = b
      c shouldBe 1
      s shouldBe 2
      g shouldBe 3
    }

  }

  // 13. Method invocations
  describe("Testing different method invocations") {

    it("should work for slowDown") {
      val bike = Bike(1, 25, 3)

      bike.slowDown(10).speed shouldBe 15
      (bike slowDown 10).speed shouldBe 15
      // (bike slowDown {
      //   val read = readLine
      //   read.toInt + 5
      // }).speed shouldBe 15
    }

    it("should work the opposite for :-ending methods") {
      val l = List(1, 2, 3)

      l.::(0) shouldBe List(0, 1, 2, 3)
      0 :: l shouldBe List(0, 1, 2, 3)
    }
  }

  // 14. The `apply` method
  object Bike {
    def apply(cadence: Int): Bike =
      new Bike(cadence, 100, 200)
  }

  describe("The apply method") {
    it("can be explicitly called") {
      Bike.apply(1) shouldBe Bike(1, 100, 200)
    }

    it("can be implicitly called") {
      Bike(1) shouldBe Bike(1, 100, 200)
    }
  }

}
