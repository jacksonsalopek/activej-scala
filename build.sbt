ThisBuild / organization := "io.skintracker"
ThisBuild / scalaVersion := "3.3.1"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "activej-scala",
    libraryDependencies ++= Seq(
      "io.activej" % "activej-launchers-http" % "6.0-beta2"
    )
  )
  .enablePlugins(SbtTwirl)
