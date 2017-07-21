package org.hablapps.fpinscala.intro.implicits
package code

import org.scalatest.{FunSpec, Matchers}

/**
 * The first usage of implicits is the implicit argument passing,
 * this allows us to not expecify certain arguments of a function
 * and let the compile infer what values to use.
 */
class ImplicitArguments extends FunSpec with Matchers {

  // // 1. Let's start with a normal function
  // def post(data: Array[Byte], uri: String, port: Int): String =
  //   s"Posting to $uri on port $port"

  // it("Testing post") {
  //   post(Array.empty, "hablapps.org", 8080) shouldBe "Posting to hablapps.org on port 8080"
  // }

  // 2. We can mark the arguments we want as `implicit`, these
  // arguments must be in a separate argument group, and also
  // this group must be the last one.
  def post(data: Array[Byte])(implicit uri: String, port: Int): String =
    s"Posting to $uri on port $port"

  it("Testing post") {
    // 3. We can still use this method as we would normally
    post(Array.empty)("hablapps.org", 8080) shouldBe "Posting to hablapps.org on port 8080"

    // 4. But also, in this case, we can mark some values as `implicit`
    // so that the compiler uses them automatically.
    implicit val URI: String = "192.168.0.1"
    implicit val PORT: Int = 8080
    post(Array.empty) shouldBe "Posting to 192.168.0.1 on port 8080"

    // 5. We can also pass only a few of the arguments implicitly, we should
    // use the method `implicitly` to achieve it.
    post(Array.empty)(implicitly, 9000) shouldBe "Posting to 192.168.0.1 on port 9000"
  }
}

/**
 * The other kind of implicits is implicit conversions, compiler
 * will transform our values from its current type to another type
 * automatically. Let's see some case scenarios where this pattern
 * may fit.
 */
class ImplicitConversions extends FunSpec with Matchers {
  import scala.language.implicitConversions

  // // 6. We start from a completely normal function that
  // // transforms a Double to an Int
  // def doubleToInt(i: Double): Int = i.toInt

  // it("Testing doubleToInt") {
  //   doubleToInt(243.53) shouldBe 243
  // }

  // 7. We can tell the compiler to use this conversion
  // implicitly by using the `implicit` modifier
  implicit def doubleToInt(i: Double): Int = i.toInt
  val myNumber: Int = 243.53

  it("Testing doubleToInt") {
    (243.53: Int) shouldBe 243
  }

  // This use case, however, is dangerous, as it may hide bugs
  // in our code. In general, it's discouraged to use this kind
  // of implicit conversion.

  // // 8. A most suitable use case for this technique is the enrichment
  // // of the functionality of a value of some type, for instance, let's
  // // extend the functionality of integer values, in order to
  // // perform factorials and powers. The most common pattern is to
  // // create a wrapper and add that functionality. This is very related
  // // to the Adapter Pattern
  // class RichInt(i: Int) {
  //   def factorial: Int =
  //     if (i > 1)
  //       i * new RichInt(i-1).factorial
  //     else
  //       i
  //   def squared: Int = math.pow(i, 2).toInt
  //   def exp(e: Int): Int = math.pow(i, e).toInt
  // }

  // it("Testing RichInt") {
  //   new RichInt(5).factorial shouldBe 120
  // }

  // // 9. However, implicit conversions allow us to get rid of the
  // // manual instantiation of the wrapper, and use the extended
  // // methods right away.
  // implicit def intToRichInt(i: Int) = new RichInt(i)

  // it("Testing RichInt") {
  //   new RichInt(5).factorial shouldBe 120
  //   5.factorial shouldBe 120
  // }

  // 10. This pattern is so common that there is another kind of
  // implicits, these are called `implicit classes`, whose use case
  // is precisely that, extend the functionality of values of a type.
  implicit class RichInt(i: Int) {
    def factorial: Int =
      if (i > 1)
        i * new RichInt(i-1).factorial
      else
        i
    def squared: Int = math.pow(i, 2).toInt
    def exp(e: Int): Int = math.pow(i, e).toInt
  }

  it("Testing RichInt") {
    new RichInt(5).factorial shouldBe 120
    5.factorial shouldBe 120
  }

}
