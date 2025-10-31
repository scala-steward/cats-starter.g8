addSbtPlugin("org.foundweekends.giter8" %% "sbt-giter8" % "0.18.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.3.1")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.6")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.14.4")

addSbtPlugin("com.github.sbt"   % "sbt-jacoco"  % "3.5.0")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")

libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value
