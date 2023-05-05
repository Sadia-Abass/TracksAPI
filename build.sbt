ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "BBC-Sounds-TracksAPI"
  )

val Http4sVersion = "1.0.0-M30"
val CirceVersion = "0.14.5"
val ScalacticVersion = "3.2.15"
val Scalatest = "3.2.15"
val cirisVersion = "3.1.0"
val CirceGenericExtraVersion = "0.14.3"
libraryDependencies ++= Seq(
  "org.http4s"    %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"    %% "http4s-circe"        % Http4sVersion,
  "org.http4s"    %% "http4s-dsl"          % Http4sVersion,
  "io.circe"      %% "circe-core"          % CirceVersion,
  "io.circe"      %% "circe-generic"       % CirceVersion,
  "io.circe"      %% "circe-generic-extras" % CirceGenericExtraVersion,
  "org.scalactic" %% "scalactic"           % ScalacticVersion,
  "org.scalatest" %% "scalatest"           % Scalatest        % "test",
  "is.cir"        %% "ciris"               % cirisVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.11"
)

//addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.12")
