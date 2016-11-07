import NativePackagerHelper._

name := """a-star-lib"""

version := "0.1"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.12"
)

enablePlugins(JavaServerAppPackaging)

//mainClass in Compile := Some("astarlib.HelloSimple")
mainClass in Compile := Some("actorhello.Main")

mappings in Universal ++= {
  // optional example illustrating how to copy additional directory
  directory("scripts") ++
  // copy configuration files to config directory
  contentOf("src/main/resources").toMap.mapValues("config/" + _)
}

// add 'config' directory first in the classpath of the start script,
// an alternative is to set the config file locations via CLI parameters
// when starting the application
scriptClasspath := Seq("../config/") ++ scriptClasspath.value

licenses := Seq(("CC0", url("http://creativecommons.org/publicdomain/zero/1.0")))
