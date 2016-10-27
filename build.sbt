import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

name := "scala-util"

organization := "com.lonelyplanet"

version := "0.2.0"

scalaVersion := "2.11.8"

resolvers += "Sonatype release repository" at "https://oss.sonatype.org/content/repositories/releases/"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val scalaTestVersion      = "3.0.0"
  val logbackClassicVersion = "1.1.6"

  Seq(
    "io.airbrake"          % "airbrake-java"                         % "2.2.8",
    "ch.qos.logback"       %  "logback-classic"                      % logbackClassicVersion % "provided",
    "net.logstash.logback" %  "logstash-logback-encoder"             % "4.7" % "provided",
    ("com.github.tkawachi" %  "exhash-logback"                       % "0.0.4").exclude("ch.qos.logback", "logback-classic"),
    "org.scalatest"        %% "scalatest"                            % scalaTestVersion % "provided",
    "com.netaporter"       %% "scala-uri"                            % "0.4.14"
  )
}

fork := true

SbtScalariform.scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(SpacesAroundMultiImports, false)
  .setPreference(CompactControlReadability, false)

bintrayOrganization := Some("lonelyplanet")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

val doNotPublishSettings = Seq(publish := {})

val publishSettings =
  if (version.toString.endsWith("-SNAPSHOT"))
    Seq(
      publishTo := Some("Artifactory Realm" at "http://oss.jfrog.org/artifactory/oss-snapshot-local"),
      bintrayReleaseOnPublish := false,
      credentials := List(Path.userHome / ".bintray" / ".artifactory").filter(_.exists).map(Credentials(_))
    )
  else
    Seq(
      organization := "com.lonelyplanet",
      pomExtra := <scm>
        <url>https://github.com/lonelyplanet/scala-util</url>
        <connection>https://github.com/lonelyplanet/scala-util</connection>
      </scm>
        <developers>
          <developer>
            <id>wlk</id>
            <name>Wojciech Langiewicz</name>
            <url>https://github.com/lonelyplanet/scala-util</url>
          </developer>
        </developers>,
      publishArtifact in Test := false,
      homepage := Some(url("https://github.com/lonelyplanet/scala-util")),
      publishMavenStyle := false,
      resolvers += Resolver.url("lonelyplanet ivy resolver", url("http://dl.bintray.com/lonelyplanet/maven"))(Resolver.ivyStylePatterns)
    )