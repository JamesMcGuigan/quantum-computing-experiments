import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.jamesmcguigan",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "number-factorization-classical",
    libraryDependencies += scalaTest % Test,
)

//val projectMainClass = "com.jamesmcguigan.factorization.Main"
mainClass in (Compile, run) := Some("com.jamesmcguigan.factorization.Main")
