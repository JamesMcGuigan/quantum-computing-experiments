name               := """number-factorization-classical"""
version            := "1.0.0-SNAPSHOT"
scalaVersion       := "2.12.7"
crossScalaVersions := Seq("2.12.7")
val projectMainClass = "com.jamesmcguigan.factorization.Main"

// resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"



//*******************************
// Maven settings
//*******************************

publishMavenStyle := true
organization := "com.jamesmcguigan"
description  := ""
homepage     := Some(url("https://github.com/JamesMcGuigan/quantum-computing-experiments"))
licenses     := Seq()
pomIncludeRepository := { _ => false }
