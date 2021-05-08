package json

object JsonFlattener {
  def flattenJson(json: Json): Json = {

    def flattenObject(obj: Object): List[Object] = {
      var objects: List[Object] = List(Object())

      obj.pairs.foreach {
        case Pair(k, v: Array) =>
          val values = v.values
          val objLen = objects.length
          val valuesLen = values.length
          val size = (objLen * valuesLen) - 1
          val cartesianProd = for (i <- 0 to size) yield (objects(i % objLen), values(i % valuesLen))
          objects = cartesianProd.toList.map(i => Object(i._1.pairs :+ Pair(k, i._2))).flatMap(flattenObject)
        case Pair(k, v: Object) =>
          val innerObjects = flattenObject(v)
          val objLen = objects.length
          val innerObjLen = innerObjects.length
          val size = (objLen * innerObjLen) - 1
          val cartesianProd = for (i <- 0 to size) yield (objects(i % objLen), innerObjects(i % innerObjLen))
          objects = cartesianProd.toList.map(i => Object(i._1.pairs ++ i._2.pairs.map(p => {
            Pair("\"" + k.replace("\"", "") + "~" + p.key.replace("\"", "") + "\"", p.value)
          })))

        case Pair(k, v) => objects = objects.map(obj => obj.addPair(Pair(k, v)))
      }

      objects
    }

    def flattenValue(v: Value): List[Value] = {
      v match {
        case o: Object => flattenObject(o)
        case _ => List(v)
      }
    }

    Json(Array(flattenValue(json.value)))
  }
}
