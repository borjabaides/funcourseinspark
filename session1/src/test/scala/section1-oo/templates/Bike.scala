package org.hablapps.fpinscala.intro.oo
package templates

// 1. Creation of a MUTABLE bike, with cadence, gear and speed as members.
// Fields are defined using the constructor's arguments

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

// 2. IMMUTABLE version of previous bike. We us `val` (value) instead
// of `var` (variable). Scala encourages immutability, hence the use of
// `var`s is discouraged in most of the cases. As a result of this change,
// we don't have setters anymore.

// 3. Constructor arguments and member fields can be unified. We just need
// to add wether we want them to be treated as `val` or `var`.

// 4. To add a method we use the reserved world `def`. Let's add a method
// to our bike, `slowDown`, that will decrease de speed given a decrement.

// 5. We can create new constructors through `def this`:

// 6. It's possible to have classes with only one instance, which are known
// as Singleton Objects. This allows us to get rid of class members used in
// Java. Let's create a `BikeFactory` with initial values and a method to
// create new bikes (`create`)

// 7. Companion Objects are singleton objects (or simply objects) that go
// with a data type, for instance, the bike class

// 8. We can use single inheritance very easily. We'll define a mountain
// bike that inherits from our bike, adding a new value member `seatHeight`.

// 9. If a class has any non-concrete member, it must be abstract. We'll define
// a roadBike that doesn't implement `seatHeight`.

// 10. Traits are, roughly speaking, partially implemented interfaces, and allow
// us to use Multiple Inheritance. For instance, we'll define an engine with a
// fixed `engineDisplacement` and an abstract `rpm`.

// 11. This way we can define a `MotorBike`, inheriting from `Bike` and `Engine`.
