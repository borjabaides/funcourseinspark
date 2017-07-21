package org.hablapps.fpinscala.intro.generics
package templates

import org.scalatest.{FunSpec, Matchers}

class Generics extends FunSpec with Matchers {

  // 1. Imagine we want to have a lazy wrapper over `Int`s
  class IntWrapper(_value: => Int) {
    lazy val value = _value
  }

  describe("IntWrapper") {
    it("should contain an integer") {
      new IntWrapper(3).value shouldBe 3
    }
  }

  // 2. As you can imagine, this is not very reusable, because
  // it is not useful if now we want to lazily wrap a `Boolean`
  // value. We would have to create another BooleanWrapper class.
  //
  // If we don't really mind what is inside our wrapper we can
  // generalize it for any type `A`

  // 3. Methods can also be generic, let's extend our wrapper to
  // be able to modify the content value given a function from `A`
  // to any other type `B`
}
