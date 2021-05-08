package spark

import org.apache.spark.sql.SparkSession

trait SharedSparkSession {
  val spark: SparkSession = SparkSession
    .builder()
    .master("local[4]")
    .appName("Test")
    .getOrCreate()
}
