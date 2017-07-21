name := "funcourseinscala"

// scalaOrganization := "org.typelevel"

scalaBinaryVersion := "2.12"

scalaVersion := "2.12.0"

organization := "org.hablapps"

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

unmanagedSourceDirectories in Test ++= Seq(
  baseDirectory.value / "module1-typeclasses"
)

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % "0.9.0",
  "org.typelevel" %% "discipline" % "0.7.1",
  "org.scalaz" %% "scalaz-core" % "7.2.7",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.7",
  "org.scalatest" %% "scalatest" % "3.0.0",
  "com.chuusai" %% "shapeless" % "2.3.2"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Ypartial-unification",
  // "-Xprint:typer",
  // "-Xlog-implicit-conversions",
  "-language:postfixOps",
  "-language:higherKinds")

