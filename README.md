# jsonflattener

## 背景

工作中遇到一个场景是需要对上游hive表存储的json字段进行解析展开后存入下游hive表，简单说就是将一个多维json对象进行一维展开，这边使用antlr4开发一个小模块方便封装为udf供spark调用。

展开后多级key之间的分割符为~

测试入口app.JsonApp

## Model Classes

![image](https://github.com/jiandongchen/jsonflatter/blob/main/image/model-classes.png)

## 效果

###### 输入json1

```json
{
    "code":"200",
    "name":null,
    "data":{
        "batchNo":"2202104020642108611",
        "id":"123456"
    },
    "msg":"成功",
    "timestamp":"1617369230495",
    "is_valid":true,
    "array":[
        1,
        2,
        3
    ]
}
```

###### 转化为解析树1

![image](https://github.com/jiandongchen/jsonflatter/blob/main/image/parse-tree1.png)

###### 输出json1

```json
[
	{
		"code": "200",
		"name": null,
		"data~batchNo": "2202104020642108611",
		"data~id": "123456",
		"msg": "成功",
		"timestamp": "1617369230495",
		"is_valid": true,
		"array": 1
	},
	{
		"code": "200",
		"name": null,
		"data~batchNo": "2202104020642108611",
		"data~id": "123456",
		"msg": "成功",
		"timestamp": "1617369230495",
		"is_valid": true,
		"array": 2
	},
	{
		"code": "200",
		"name": null,
		"data~batchNo": "2202104020642108611",
		"data~id": "123456",
		"msg": "成功",
		"timestamp": "1617369230495",
		"is_valid": true,
		"array": 3
	}
]
```

###### 输入json2

```json
{
	"code": "200",
	"data": {
		"batchNo": "2202104020642108611",
		"proposalResponses": [
			{
				"insuranceName": "杨梅",
				"liabilityResponses": [
					{
						"clinicResponses": [
							{
								"diagnosisResponses": [
									{
										"diseaseRiskLevel": "低",
										"diseaseRiskNote": "低风险"
									},
									{
										"diseaseRiskLevel": "中",
										"diseaseRiskNote": "中风险"
									}
								]
							},
							{
								"diagnosisResponses": [
									{
										"diseaseRiskLevel": "中",
										"diseaseRiskNote": "中风险"
									},
									{
										"diseaseRiskLevel": "中",
										"diseaseRiskNote": "中风险"
									}
								]
							}
						]
					}
				]
			}
		]
	},
	"msg": "成功",
	"timestamp": "1617369230495"
}
```

![image](https://github.com/jiandongchen/jsonflatter/blob/main/image/flatten-dataframe1.jpg)

###### 输出json2

```json
[
	{
		"code": "200",
		"data~batchNo": "2202104020642108611",
		"data~proposalResponses~insuranceName": "杨梅",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskLevel": "低",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskNote": "低风险",
		"msg": "成功",
		"timestamp": "1617369230495"
	},
	{
		"code": "200",
		"data~batchNo": "2202104020642108611",
		"data~proposalResponses~insuranceName": "杨梅",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskLevel": "中",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskNote": "中风险",
		"msg": "成功",
		"timestamp": "1617369230495"
	},
	{
		"code": "200",
		"data~batchNo": "2202104020642108611",
		"data~proposalResponses~insuranceName": "杨梅",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskLevel": "中",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskNote": "中风险",
		"msg": "成功",
		"timestamp": "1617369230495"
	},
	{
		"code": "200",
		"data~batchNo": "2202104020642108611",
		"data~proposalResponses~insuranceName": "杨梅",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskLevel": "中",
		"data~proposalResponses~liabilityResponses~clinicResponses~diagnosisResponses~diseaseRiskNote": "中风险",
		"msg": "成功",
		"timestamp": "1617369230495"
	}
]
```

