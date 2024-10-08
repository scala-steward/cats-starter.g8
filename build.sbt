val CatsVersion              = "2.12.0"
val CatsEffectVersion        = "3.5.4"
val CatsEffectTestKitVersion = "3.5.4"
val CirceVersion             = "0.14.10"
val CirceFs2Version          = "0.14.1"
val CirceConfigVersion       = "0.10.1"
val Fs2Version               = "3.11.0"
val Http4sVersion            = "0.23.28"
val Log4CatsVersion          = "2.7.0"
val LogbackVersion           = "1.5.9"
val MunitVersion             = "1.0.2"
val MunitCatsEffectVersion   = "2.0.0"
val WeaverCatsVersion        = "0.8.4"

lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "scala-starter.g8",
    libraryDependencies ++= Seq(
      "org.typelevel"       %% "cats-core"           % CatsVersion,
      "org.typelevel"       %% "cats-effect"         % CatsEffectVersion,
      "co.fs2"              %% "fs2-core"            % Fs2Version,
      "co.fs2"              %% "fs2-io"              % Fs2Version,
      "io.circe"            %% "circe-core"          % CirceVersion,
      "io.circe"            %% "circe-generic"       % CirceVersion,
      "io.circe"            %% "circe-parser"        % CirceVersion,
      "io.circe"            %% "circe-literal"       % CirceVersion,
      "io.circe"            %% "circe-fs2"           % CirceFs2Version,
      "io.circe"            %% "circe-config"        % CirceConfigVersion,
      "org.http4s"          %% "http4s-ember-client" % Http4sVersion,
      "org.http4s"          %% "http4s-ember-server" % Http4sVersion,
      "org.http4s"          %% "http4s-dsl"          % Http4sVersion,
      "org.http4s"          %% "http4s-core"         % Http4sVersion,
      "org.http4s"          %% "http4s-client"       % Http4sVersion,
      "org.http4s"          %% "http4s-server"       % Http4sVersion,
      "org.http4s"          %% "http4s-circe"        % Http4sVersion,
      "org.typelevel"       %% "log4cats-slf4j"      % Log4CatsVersion,
      "ch.qos.logback"       % "logback-classic"     % LogbackVersion           % Runtime,
      "org.scalameta"       %% "munit"               % MunitVersion             % Test,
      "org.typelevel"       %% "munit-cats-effect"   % MunitCatsEffectVersion   % Test,
      "com.disneystreaming" %% "weaver-cats"         % WeaverCatsVersion        % Test,
      "org.typelevel"       %% "cats-effect-testkit" % CatsEffectTestKitVersion % Test
    ),
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List(
      "-Xms1024m",
      "-Xmx1024m",
      "-XX:ReservedCodeCacheSize=128m",
      "-Xss2m",
      "-Dfile.encoding=UTF-8"
    ),
    resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(
      Resolver.ivyStylePatterns
    )
  )
