package org.hablapps.fpinscala.intro.generics
package code

import org.scalatest.{FunSpec, Matchers}

class Generics extends FunSpec with Matchers {

  // // 1. Imagine we want to have a lazy wrapper over `Int`s
  // class IntWrapper(_value: => Int) {
  //   lazy val value = _value
  // }

  // describe("IntWrapper") {
  //   it("should contain an integer") {
  //     new IntWrapper(3).value shouldBe 3
  //   }
  // }

  // // 2. As you can imagine, this is not very reusable, because
  // // it is not useful if now we want to lazily wrap a `Boolean`
  // // value. We would have to create another BooleanWrapper class.
  // //
  // // If we don't really mind what is inside our wrapper we can
  // // generalize it for any type `A`
  // class Wrapper[A](_value: => A) {
  //   lazy val value = _value
  // }

  // describe("Wrapper") {
  //   it("should contain any A") {
  //     new Wrapper(3).value shouldBe 3
  //     new Wrapper("hola").value shouldBe "hola"
  //     new Wrapper(true).value shouldBe true
  //   }
  // }

  // 3. Methods can also be generic, let's extend our wrapper to
  // be able to modify the content value given a function from `A`
  // to any other type `B`
  class Wrapper[A](_value: => A) {
    lazy val value = _value

    def map[B](f: A => B): Wrapper[B] =
      new Wrapper[B](f(value))
  }

  describe("Wrapper") {
    it("should contain any A") {
      new Wrapper(3).value shouldBe 3
      new Wrapper("hola").value shouldBe "hola"
      new Wrapper(true).value shouldBe true
    }

    it("should change its content with the method `map`") {
      new Wrapper(3).map(_ > 0).value shouldBe true
      new Wrapper("hola").map(_.length).value shouldBe 4
      new Wrapper(true).map(identity).value shouldBe true
    }
  }
}
