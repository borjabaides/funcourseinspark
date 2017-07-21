name := "module1-scalaintro"

scalaVersion := "2.11.11"

organization := "org.hablapps"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.1"
    exclude("org.glassfish.hk2", "hk2-utils")
    exclude("org.glassfish.hk2", "hk2-locator")
    exclude("javax.validation", "validation-api"),
  "org.scalatest" %% "scalatest" % "3.0.1", // % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "com.holdenkarau" %% "spark-testing-base" % "2.1.1_0.7.0" % "test"
)

initialCommands in console := "import org.hablapps.fpinscala.intro._"
