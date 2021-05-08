name := "jsonflattener"

version := "0.1"

scalaVersion := "2.12.10"

useCoursier := false

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.1.1"
  , "org.scalactic" %% "scalactic" % "3.2.7"
  , "org.scalatest" %% "scalatest" % "3.2.7" % "test"
)