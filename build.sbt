import Dependencies._
import com.typesafe.sbt.packager.docker._

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(DockerSpotifyClientPlugin)
enablePlugins(AshScriptPlugin)

// dockerCommands := dockerfile("root")
dockerBaseImage := "openjdk:8-jre-alpine"
dockerUpdateLatest := true

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "buildkite-trial",
    libraryDependencies ++= Seq(
        scalaTest % Test
    )
  )
