package org.hablapps.fpinscala.intro.scalatestlib
package templates

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.Checkers
import org.scalacheck.Arbitrary
import org.scalacheck.Prop.forAll
import com.holdenkarau.spark.testing.{RDDGenerator, SharedSparkContext}

class SparkTestingBaseSpec extends FunSpec with Matchers with Checkers with SharedSparkContext {

  describe("A RDD[Int]") {
    it("should calculate the sum correctly if it's not empty") {
      sc.parallelize(1 :: 2 :: 3 :: 4 :: Nil).sum shouldBe 10
    }

    it("should calculate the sum correctly if it's empty") {
      sc.parallelize(List.empty[Int]).sum shouldBe 0
    }
  }

  describe("The map function") {
    it("should not change number of elements of an arbitrary RDD[String]") {
      // check {
      //   forAll(???) { rdd =>
      //     rdd.map(_.length).count() == rdd.count()
      //   }
      // }
    }
  }
}
