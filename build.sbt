// Project name (artifact name in Maven)
name := "fruitshop"

// orgnization name (e.g., the package name of the project)
organization := "com.fruitshop.billing"

version := "1.0"

// project description
description := "FruitShopBilling"

scalaVersion := "2.11.8"

parallelExecution in Test := false

scalacOptions := Seq("-deprecation", "-unchecked", "-optimize", "-feature")

// library dependencies. (orginization name) % (project name) % (version)
libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "16.0",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "junit" % "junit" % "4.12"
  )

resolvers ++= Seq(
  "Local Maven" at Path.userHome.asFile.toURI.toURL + ".m2/repository",
  "Local Ivy Repository" at Path.userHome.asFile.toURI.toURL + ".ivy2/local",
  "maven2-repository.dev.java.net" at "http://download.java.net/maven/2",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  )

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case x => MergeStrategy.first
}
