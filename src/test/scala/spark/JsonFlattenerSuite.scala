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

    val originalDF = Seq((1, """{"code":"200","costTime":135,"msg":"请求成功","reqNo":"e4e9818b-1645-4d15-a4a5-9b6d607d5b31","respData":{"bizType":"理赔","code":"200","reportResultList":[{"date":"2017-03-27 08:05:29","healthReportId":"2458192","institutionName":"美年大健康洛阳西工分院","reportResult":[{"itemKey":"itemA0101","itemScore":["0","0"],"itemVal":"163.0"},{"itemKey":"itemA0102","itemScore":["0","0"],"itemVal":"63.1"},{"itemKey":"itemB0203","itemScore":["0","0"],"itemVal":"5"},{"itemKey":"itemB0206","itemScore":["100","100"],"itemVal":"3"},{"itemKey":"itemA0701","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0202","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0205","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0602","itemScore":["0","0"],"itemVal":"1"},{"itemKey":"itemA0401","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0703","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0502","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemB1204","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemB0207","itemScore":["0","0"],"itemVal":"4"},{"itemKey":"itemB0612","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemB0613","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemB1209","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemB0204","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0601","itemScore":["0","0"],"itemVal":"1"},{"itemKey":"itemB0611","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0704","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemB1208","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemA0105","itemScore":["25","0"],"itemVal":"2"},{"itemKey":"itemA0104","itemScore":["25","0"],"itemVal":"4"},{"itemKey":"itemA0103","itemScore":["0","0"],"itemVal":"3"},{"itemKey":"itemA0501","itemScore":["0","0"],"itemVal":"2"},{"itemKey":"itemB0301","itemScore":["0","0"],"itemVal":"-99"},{"itemKey":"itemA0201","itemScore":["0","0"],"itemVal":"3"},{"itemKey":"itemA0303","itemScore":["0","0"],"itemVal":"1"},{"itemKey":"itemA0304","itemScore":["0","0"],"itemVal":"1"},{"itemKey":"itemA0302","itemScore":["0","0"],"itemVal":"1"},{"itemKey":"itemB0305","itemScore":["0","0"],"itemVal":"-99"},{"itemKey":"itemB1502","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemA1404","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemA1403","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1412","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1901","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1408","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1408","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1408","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1408","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1408","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1408","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1413","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1413","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemB1413","itemScore":["0","0"],"itemVal":"肝血管瘤"},{"itemKey":"itemB1406","itemScore":["0","0"],"itemVal":"结节"},{"itemKey":"itemB1406","itemScore":["0","0"],"itemVal":"未发现明显异常"},{"itemKey":"itemA1405","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemA1405","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemA1601","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemA1601","itemScore":["0","0"],"itemVal":""},{"itemKey":"itemA1701","itemScore":["0","0"],"itemVal":""}],"unknownItemList":["00:眼科检查（含裂隙灯）###虹膜###正常","00:尿液分析+镜检###酸碱度###6.5","00:血常规（五分类）###单核细胞绝对值###0.24","00:血常规（五分类）###中性粒细胞百分率###80.2 ↑","00:尿液分析+镜检###尿比重###1.015","00:尿液分析+镜检###尿结晶###未见","00:白带常规###白带白细胞###强阳性(3+)","00:血常规（五分类）###嗜碱性粒细胞值（BASO#）###0.00","00:眼科检查（含裂隙灯）###眼睑###正常","00:妇科检查###小结###阴道:分泌物中,黄色n子宫.:后位n宫颈:宫颈轻度糜烂样外观","00:内科检查###心音###未见异常","00:一般检查###小结###体重指数:23.70n血压:130/76mmHg","00:妇科检查###宫颈###宫颈轻度糜烂样外观","00:妇科检查###阴道###通畅, 分泌物中, 黄色","00:血常规（五分类）###嗜酸性粒细胞值（EOS#）###0.24","00:尿液分析+镜检###酮体###阴性","00:白带常规###霉菌###阴性","00:眼科检查（含裂隙灯）###巩膜###正常","00:血常规（五分类）###血小板压积###0.13","00:眼科检查（含裂隙灯）###矫正视力右###","00:妇科检查###外阴###未见异常","00:泌尿生殖系彩超（女）###小结###子宫:盆腔积液n右肾、左肾、膀胱、左附件、右附件未发现明显异常","00:血常规（五分类）###淋巴细胞绝对值###0.90 ↓","00:血常规（五分类）###单核细胞百分率###3.4","00:血常规（五分类）###红细胞体积分布宽度标准差###40.5","00:尿液分析+镜检###亚硝酸盐###阴性","00:白带常规###滴虫###阴性","00:血常规（五分类）###淋巴细胞百分率###13.0 ↓","00:内科检查###肝脏质地###未见异常","00:眼科检查（含裂隙灯）###眼球###正常","00:血常规（五分类）###平均血小板体积###9.9","00:血常规（五分类）###嗜碱性粒细胞比率（BASO%）###0.1","00:血常规（五分类）###红细胞分布宽度CV（RDW_CV）###10.8 ↓","00:内科检查###心脏杂音###未见异常","00:尿液分析+镜检###白细胞镜检###未见","00:尿液分析+镜检###尿液颜色###黄色","00:眼科检查（含裂隙灯）###晶体###正常","00:白带常规###白带上皮细胞###﹢","00:双乳腺红外检查###小结###详见纸质报告","00:血常规（五分类）###平均红细胞血红蛋白浓度###336","00:血常规（五分类）###平均红细胞血红蛋白量###30.9","00:血常规（五分类）###血小板分布宽度###16.7","00:内科检查###心率###72","00:内科检查###肝脏压痛###未见异常","00:尿液分析+镜检###尿白细胞###阴性","00:眼科检查（含裂隙灯）###裸眼视力左###0.7","00:眼科检查（含裂隙灯）###角膜###正常","00:白带常规###白带清洁度###Ⅲ","00:尿液分析+镜检###尿胆原###阴性","00:内科检查###心律###整齐","00:血脂四项###血清高密度脂蛋白###1.25","00:内科检查###其他###未见异常","00:眼科检查（含裂隙灯）###矫正视力左###","00:眼科检查（含裂隙灯）###其它###","00:内科检查###脾脏质地###未见异常","00:眼科检查（含裂隙灯）###结膜###正常","00:血脂四项###血清低密度脂蛋白###1.32","00:尿液分析+镜检###尿透明度###透明","00:内科检查###小结###内科检查未见异常","00:尿液分析+镜检###胆红素###阴性","00:眼科检查（含裂隙灯）###小结###裸眼视力右:0.3n裸眼视力左:0.7","00:眼科检查（含裂隙灯）###瞳孔###正常","00:血常规（五分类）###嗜酸性粒细胞比率（EOS%）###3.4","00:眼科检查（含裂隙灯）###色觉###正常","00:眼科检查（含裂隙灯）###裸眼视力右###0.3","00:尿液分析+镜检###维生素C###阴性","01:尿液分析+镜检###红细胞镜检###未见","02:尿液分析+镜检###尿液管型###未见","03:空腹腹部彩超###肝###肝脏大小、形态正常，包膜光整，肝实质回声不均匀，肝内可见大小约23×22mm稍强回声，nn 边缘清晰，肝内血管走行较清晰，门静脉内径正常。","03:妇科检查###右侧附件###右附件未见明显异常","03:胸部正位片DR###检查结果###胸部正位片DR未发现明显异常","03:空腹腹部彩超###胰###胰腺大小、形态正常，边缘规整，内部回声均匀，胰管未见扩张。","03:妇科检查###子宫.###后位","03:宫颈液基薄层（TCT）###小结###未见上皮内病变或恶性细胞","03:妇科检查###左侧附件###左附件未见明显异常","03:泌尿生殖系彩超（女）###左附件###左附件区未见明显异常回声。","03:泌尿生殖系彩超（女）###右肾###右肾大小、形态正常，包膜光滑，肾实质回声均匀，集合系统未见明显分离。","03:空腹腹部彩超###脾###脾脏大小、形态正常，包膜光整，回声均匀。","03:心电图###小结###窦性心律,正常心电图","03:泌尿生殖系彩超（女）###子宫###子宫大小、形态尚可，包膜光滑，肌层回声均匀，宫腔内未见明显异常回声。nn 于子宫后方可见深度约10mm的液性暗区。","03:泌尿生殖系彩超（女）###左肾###左肾大小、形态正常，包膜光滑，肾实质回声均匀，集合系统未见明显分离。","03:泌尿生殖系彩超（女）###膀胱###膀胱充盈良好，壁光滑，延续性好，其内透声性良好，未见明显占位性病变。","03:空腹腹部彩超###胆###胆囊大小、形态正常，囊壁光整，囊腔内透声好，胆总管无扩张。","03:胸部正位片DR###描述###胸廓发育对称，气管纵隔居中，肺门结构清晰，无增大，纵隔不宽，双肺野清晰，肺纹理走行自然，心影外形大小基本正常。肋膈角清晰。膈肌光滑。","03:泌尿生殖系彩超（女）###右附件###右附件区未见明显异常回声。","03:内科检查###病史###无"]}],"totalResult":{"accScore":"100","ciScore":"300","ddScore":"600","miScore":"700","niScore":"400","tlScore":"200","wlScore":"200"},"valid":true}}"""))
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

    flattenedDF.repartition(1).write.option("header","true").option("sep","#").csv("C:\\Users\\jiandong.chen\\Desktop\\jp")
  }
}
