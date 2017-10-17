name := "$name;format="Camel"$"

fork := true
javaOptions in test ++= Seq(
  "-Xms512M", "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.2.0"

libraryDependencies ++=
  Seq(
    "org.apache.hadoop" % "hadoop-azure" % "2.7.3",
    "ch.qos.logback" % "logback-classic" % "1.1.7",
    "com.rollbar" % "rollbar" % "0.5.3",
    "com.typesafe" % "config" % "1.2.1",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-streaming" % sparkVersion,

    "org.json4s" %% "json4s-native" % "3.5.3",
    "com.github.nscala-time" %% "nscala-time" % "2.16.0",

    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  )

mainClass in assembly := Some("$package$.Main")
assemblyJarName in assembly := "$name;format="camel"$.jar"

assemblyMergeStrategy in assembly := {
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case x if x.endsWith(".html") => MergeStrategy.first
  case PathList("com",   "google", _*) => MergeStrategy.last
  case PathList("com",   "esotericsoftware", _*) => MergeStrategy.last
  case PathList("io",    "netty", _*) => MergeStrategy.last
  case PathList("org",   "slf4j", _*) => MergeStrategy.last
  case PathList("org",   "apache", _*) => MergeStrategy.last
  case PathList("org",   "aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "ws", xs @ _*) => MergeStrategy.last
  case PathList("com",   "sun", "jersey", xs @ _*) => MergeStrategy.last
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("com",   "sun", xs @ _*) => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

