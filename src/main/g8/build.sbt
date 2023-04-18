val CatsVersion = "2.9.0"
val CatsEffectVersion = "3.4.9"
val CatsEffectTestKitVersion = "3.4.7"
val Log4CatsVersion = "2.5.0"
val MunitVersion = "0.7.29"
val MunitCatsEffectVersion = "1.0.7"
val LogbackVersion = "1.4.6"
val WeaverCatsVersion = "0.8.3"

ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "$scala_version$"
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

lazy val root = (project in file("."))
  .settings(
    name := "$name;format="norm"$",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.typelevel"              %% "cats-core"                 % CatsVersion,
      "org.typelevel"              %% "cats-effect"               % CatsEffectVersion,
      "org.typelevel"              %% "log4cats-slf4j"            % Log4CatsVersion,
      "ch.qos.logback"              % "logback-classic"           % LogbackVersion                 % Runtime,
      "org.scalameta"              %% "munit"                     % MunitVersion                   % Test,
      "com.disneystreaming"        %% "weaver-cats"               % WeaverCatsVersion              % Test,
      "org.typelevel"              %% "munit-cats-effect-3"       % MunitCatsEffectVersion         % Test,
      "org.typelevel"              %% "cats-effect-testkit"       % CatsEffectTestKitVersion       % Test
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    testFrameworks ++= List(
      new TestFramework("munit.Framework"),
      new TestFramework("weaver.framework.CatsEffect")
    ),
    assembly / assemblyJarName := "$name;format="camel"$.jar",
    assemblyMergeStrategy := {
      case PathList("META-INF", "MANIFEST.MF")  => MergeStrategy.discard
      case x if x.endsWith("module-info.class") => MergeStrategy.discard
      case x                                    => assemblyMergeStrategy.value(x)
    },
  )
