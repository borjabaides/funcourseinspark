package org.hablapps.fpinscala.intro.implicits

import org.scalatest.{FunSpec, Matchers}

class Exercises extends FunSpec with Matchers {

  // 1. Using implicit arguments
  //
  // Define a case class Car, with one member `_speed` that handles
  // the speed internally in km/h. This class will offer support to
  // work with other measure units.
  //
  // These are the measures we are going to give support to
  sealed abstract class MeasureUnit
  case object KilometersPerHour extends MeasureUnit
  case object MetersPerSecond extends MeasureUnit
  case object MilesPerHour extends MeasureUnit
  case object Knots extends MeasureUnit

  case class Car(_speed: Double) {

    // PART I
    //
    // Implement a private method `toKPH` that gets a quantity and
    // an implicit measure, and does the conversion to km/h.
    //
    // 1 km/h => 1        km/h :P
    // 1 m/s  => 3.6      km/h
    // 1 mph  => 1.609344 km/h
    // 1 knot => 1.852    km/h
    private def toKPH(q: Double)(implicit U: MeasureUnit): Double = {
       U match {
         case KilometersPerHour => q
         case MetersPerSecond => q * 3.6
         case MilesPerHour => q * 1.609344 
         case Knots => q * 1.852
       }
    }

    // PART II
    //
    // Implement the opposite, a private method `fromKPH` that gets a
    // quantity and an implicit measure, and does the conversion from km/h
    // to the implicit measure
    private def fromKPH(q: Double)(implicit U: MeasureUnit): Double = 
    {  U match {
         case KilometersPerHour => q
         case MetersPerSecond => q / 3.6
         case MilesPerHour => q / 1.609344 
         case Knots => q / 1.852
       }
    }
    // PART III
    //
    // Implement a method `speedUp` that given an increment and
    // an implicit measure, increments the car's speed accordingly
    def speedUp(inc: Double)(implicit U: MeasureUnit): Car = this.copy(_speed = _speed + toKPH(inc))
    //si solo hay un argumento se puede poner esto o copiar con todos los demas 
      //new Car(this._speed + toKPH(inc))

    // PART IV
    //
    // Implement a method `speed` that returns the current speed
    // (_speed) converting to the implicit measure received as argument
    def speed(implicit U: MeasureUnit): Double =  fromKPH(this._speed)
    
  }

  // Tests are ignored, once you've finished the correspondent PARTs,
  // you can start changing `ignore` to `it` to activate them.
  //
  // You can run the test from sbt console:
  // > testOnly org.hablapps.fpinscala.intro.implicits.Exercises
  val car100 = Car(100)
  describe("Testing speedUp & speed") {
    describe("Using Km/h as default") {
      implicit val defaultMeasurementUnits = KilometersPerHour

      it("should speed up w/o changing measures") {
        car100.speedUp(10)._speed shouldBe 110
        car100.speedUp(10).speed shouldBe 110
      }

      it("should increment 3.6 times when using m/s explicitly") {
        car100.speedUp(10)(MetersPerSecond).speed shouldBe 136
      }
    }

    describe("Using m/s as default") {
      implicit val defaultMeasurementUnits = MetersPerSecond

      it("should speed up changing measures") {
        car100.speedUp(10)._speed shouldBe 136
        car100.speedUp(10).speed shouldBe (136 / 3.6)
      }

      it("should decrement 3.6 times when using km/h explicitly") {
        car100.speedUp(10)(KilometersPerHour)._speed shouldBe 110
        car100.speedUp(10)(KilometersPerHour).speed shouldBe (110 / 3.6)
      }
    }
  }

  // 2. Using implicit classes
  //
  // PART V
  //
  // Imagine we don't have access to the Car class and we need
  // to extend its functionality with a method `stop` that will
  // set the speed to 0.
  //
  // Create an implicit class to achieve it

  // ??
  implicit class stopC (C :Car) { 
   //al haber un solo campo podria ser... def stop : Car = new Car(0)
   // por si tuviera mas de un campo:
    def stop : Car = C.copy(_speed=0)
  }  
  //si solo hay un argumento se puede poner esto o copiar con todos los demas 
  describe("The stop method") {
    it("should set the speed to 0") {
      // Uncomment next line once the implicit class is created
      car100.stop._speed shouldBe 0
    }
  }

}
