ThisBuild / organization := "io.skintracker"
ThisBuild / scalaVersion := "3.3.1"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(SbtTwirl)
  .enablePlugins(NativeImagePlugin)
  .settings(
    name := "activej-scala",
    libraryDependencies ++= Seq(
      "io.activej" % "activej-launchers-http" % "6.0-beta2",
      "org.postgresql" % "postgresql" % "42.7.1",
      "ch.qos.logback" % "logback-classic" % "1.4.14",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
    ),
    Compile / mainClass := Some("io.skintracker.MultiThreaded"),
    nativeImageJvm := "graalvm-java21",
    nativeImageVersion := "21.0.1"
  )
