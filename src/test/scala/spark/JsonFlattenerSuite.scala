package spark

import org.scalatest.funsuite.AnyFunSuite
import org.apache.spark.sql.functions._

class JsonFlattenerSuite extends AnyFunSuite
  with SharedSparkSession
  with TestUtils {

  test("json flattener1") {

    import spark.implicits._

    val originalDF = Seq((1, """{"code":"200","name":null,"data":{"batchNo":"2202104020642108611","id":"123456"},"msg":"成功","timestamp":"1617369230495","is_valid":true,"array":[1,2,3]}"""))
      .toDF("id", "json")

    originalDF.show(false)

    val incompleteDF = originalDF
      .withColumn("json", flattenJsonUDF('json))

    val schema = schema_of_json(lit(incompleteDF.select('json).as[String].first))

    val flattenedDF = incompleteDF
      .withColumn("json", explode_outer(from_json('json, schema)))
      .select(
        "id",
        "json.*"
      )

    flattenedDF.show(false)
  }

  test("json flattener2") {

    import spark.implicits._

    val originalDF = Seq((1, """{"code":"200","name":null,"data":{"batchNo":"2202104020642108611"}"""))
      .toDF("id", "json")

    originalDF.show(false)

    val incompleteDF = originalDF
      .withColumn("json", flattenJsonUDF('json))

    val schema = schema_of_json(lit(incompleteDF.select('json).as[String].first))

    val flattenedDF = incompleteDF
      .withColumn("json", explode_outer(from_json('json, schema)))
      .select(
        "id",
        "json.*"
      )

    flattenedDF.show(false)
  }
}
