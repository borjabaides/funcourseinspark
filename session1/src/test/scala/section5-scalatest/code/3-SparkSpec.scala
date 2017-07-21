package org.hablapps.fpinscala.intro.scalatestlib
package code

import org.scalatest.{FunSpec, BeforeAndAfterAll, Matchers}
import org.apache.spark.{SparkConf, SparkContext}

class SparkSpec extends FunSpec with Matchers with BeforeAndAfterAll {

  @transient private var _sc: SparkContext = _
  def sc: SparkContext = _sc

  val conf = new SparkConf().setMaster("local[*]").setAppName("test")

  override def beforeAll() {
    _sc = new SparkContext(conf)
    super.beforeAll()
  }

  override def afterAll() {
    sc.stop()
    System.clearProperty("spark.driver.port")
    _sc = null
    super.afterAll()
  }

  describe("A RDD[Int]") {
    it("should calculate the sum correctly if it's not empty") {
      sc.parallelize(1 :: 2 :: 3 :: 4 :: Nil).sum shouldBe 10
    }

    it("should calculate the sum correctly if it's empty") {
      sc.parallelize(List.empty[Int]).sum shouldBe 0
    }
  }
}
