import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.jamesmcguigan",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    mainClass in assembly := Some("com.jamesmcguigan.factorization.Main"),
    // assemblyJarName in assembly := "number-factorization-classical.jar",
    name := "number-factorization-classical",
    libraryDependencies += scalaTest % Test
  )

mainClass in (Compile, run) := Some("com.jamesmcguigan.factorization.Main")
