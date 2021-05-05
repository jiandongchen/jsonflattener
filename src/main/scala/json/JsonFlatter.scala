package json

object JsonFlatter {
  def flatJson(json: Json): Json = {
    def flatObject(obj: Object): List[Object] = {
      var objects: List[Object] = List(Object())

      obj.pairs.foreach {
        case Pair(k, v: Array) =>
          val values = v.values
          val objLen = objects.length
          val valuesLen = values.length
          val size = (objLen * valuesLen) - 1
          val cartesianProd = for (i <- 0 to size) yield (objects(i % objLen), values(i % valuesLen))
          objects = cartesianProd.toList.map(i => Object(i._1.pairs :+ Pair(k, i._2)))
        case Pair(k, v: Object) =>
          val innerObjects = flatObject(v)
          val objLen = objects.length
          val innerObjLen = innerObjects.length
          val size = (objLen * innerObjLen) - 1
          val cartesianProd = for (i <- 0 to size) yield (objects(i % objLen), innerObjects(i % innerObjLen))
          objects = cartesianProd.toList.map(i => Object(i._1.pairs ++ i._2.pairs.map(p => {
            Pair("\"" + k.replace("\"", "") + "_" + p.key.replace("\"", "") + "\"", p.value)
          })))

        case Pair(k, v) => objects = objects.map(obj => obj.addPair(Pair(k, v)))
      }

      objects
    }

    def flatValue(v: Value): List[Value] = {
      v match {
        case o: Object => flatObject(o)
        case _ => List(v)
      }
    }

    Json(Array(flatValue(json.value)))
  }
}
