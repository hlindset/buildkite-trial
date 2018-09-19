import Dependencies._
import com.typesafe.sbt.packager.docker._

def dockerfile(project: String) = Seq(
  Cmd("FROM", "cantara/alpine-openjdk8"),
  Cmd("MAINTAINER", "Håvard Lindset <lindset@gmail.com>"),
  Cmd("WORKDIR", "/opt/docker"),
  Cmd("ADD", "opt /opt"),
  ExecCmd("ENTRYPOINT", s"bin/$project"),
  ExecCmd("CMD", "")
)

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
