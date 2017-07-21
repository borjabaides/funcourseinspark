package org.hablapps.fpinscala.intro.scalatestlib
package code

import org.scalatest.{FunSpec, Matchers, Inside}

class ListMatchersSpec extends FunSpec with Matchers {

  describe("A List") {
    describe("when empty") {
      it("should have size 0") {
        List.empty[Int].size shouldBe 0
        List.empty[Int] should have size 0
        List.empty[Int] shouldBe empty
      }

      it("should produce NoSuchElementException when head is invoked") {
        a[NoSuchElementException] should be thrownBy {
          List.empty[Int].head
        }
      }
    }

    describe("when containing 1, 2, 3, 4, 5") {
      it("should contain a 3") {
        List(1, 2, 3, 4, 5) should contain (5)
      }
      it("should be sorted") {
        List(1, 2, 3, 4, 5) shouldBe sorted
      }
      describe("when adding a string") {
        it("should not compile") {
          """val xs: List[Int] = "hi" +: List(1, 2, 3, 4, 5)""" shouldNot compile
        }
      }
      describe("when adding an int") {
        it("should compile") {
          "0 +: List(1, 2, 3, 4, 5)" should compile
        }
      }
    }
  }

  describe("A 'hello world' string") {
    it("should start with 'hello'") {
      "hello world" should startWith ("hello")
    }
    it("should end with 'world'") {
      "hello world" should endWith ("world")
    }
    it("should contain 'lo wo'") {
      "hello world" should include ("lo wo")
    }
  }

  describe("A 10") {
    it("should be less than 20") {
      10 should be < 20
    }
    it("should be greater or equal than 10") {
      10 should be >= 10
    }
    it("should not be 11") {
      10 should not be 11
    }
    it("should be a java.lang.Integer") {
      10 shouldBe a [java.lang.Integer]
    }
  }

  describe("A Either[Int, String] = Left(4)") {
    import Inside._
    val l: Either[Int, String] = Left(4)

    it("should be Left(4)") {
      inside(l) {
        case Left(n) => n shouldBe 4
        case Right(_) => fail
      }
    }
    it("should be Left(_)") {
      l should matchPattern { case Left(n) => }
    }
  }

}
