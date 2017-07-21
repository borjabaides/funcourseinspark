package org.hablapps.fpinscala.intro.scalatestlib
package templates

import org.scalatest.{FunSpec, Matchers, Inside}

class SetSpec extends FunSpec with Matchers {

  // 1.1 With the word "describe" we can group tests in a context
  describe("A Set") {

    // 1.2 We can nest describes at will
    describe("when empty") {

      // 1.3 with the word "it" we define single testing units
      it("should have size 0") {

        // 1.4 We can assert predicates right away
        assert(Set.empty.size == 0)
      }

      it("should produce NoSuchElementException when head is invoked") {

        // 1.5 We can capture exceptions with the method `assertThrows`
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }

  // 2. Matchers
  describe("A List") {
    describe("when empty") {
      // 2.1 (shouldBe, have size, empty)
      it("should have size 0") {
        // List.empty[Int] ???
      }

      // 2.2 (thrownBy)
      it("should produce NoSuchElementException when head is invoked") {
        // List.empty[Int].head
      }
    }

    describe("when containing 1, 2, 3, 4, 5") {
      // 2.3 (contain)
      it("should contain a 3") {
        // List(1, 2, 3, 4, 5)
      }
      // 2.4 (sorted)
      it("should be sorted") {
        // List(1, 2, 3, 4, 5)
      }
      describe("when adding a string") {
        // 2.5 (compile)
        it("should not compile") {
          // val xs: List[Int] = "hi" +: List(1, 2, 3, 4, 5)
        }
      }
      describe("when adding an int") {
        // 2.6 (compile)
        it("should compile") {
          // 0 +: List(1, 2, 3, 4, 5)
        }
      }
    }
  }

  describe("A 'hello world' string") {
    // 2.7 (startWith)
    it("should start with 'hello'") {
      // "hello world"
    }
    // 2.8 (endWith)
    it("should end with 'world'") {
      // "hello world"
    }
    // 2.9 (include)
    it("should contain 'lo wo'") {
      // "hello world"
    }
  }

  describe("A 10") {
    // 2.10 (<)
    it("should be less than 20") {
      // 10
    }
    // 2.11 (>=)
    it("should be greater or equal than 10") {
      // 10
    }
    // 2.12 (not be)
    it("should not be 11") {
      // 10
    }
    // 2.13 (a [])
    it("should be a java.lang.Integer") {
      // 10
    }
  }

  describe("A Either[Int, String] = Left(4)") {
    import Inside._
    val l: Either[Int, String] = Left(4)

    // 2.14 (inside)
    it("should be Left(4)") {
      // ???
    }
    // 2.15 (matchPattern)
    it("should be Left(_)") {
      // ???
    }
  }

}
