# jsonflatter

## 背景

工作中遇到一个场景是需要对上游hive表存储的json字段进行解析展开后存入下游hive表，简单说就是将一个多维json对象进行一维展开，这边使用antlr4开发一个小模块方便封装为udf供spark调用。



## 效果

###### 输入json

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

###### 转化为解析树

![image](https://github.com/jiandongchen/jsonflatter/blob/main/image/parse-tree1.png)

###### 输出json

```json
[
    {
        "code":"200",
        "name":null,
        "data_batchNo":"2202104020642108611",
        "data_id":"123456",
        "msg":"成功",
        "timestamp":"1617369230495",
        "is_valid":true,
        "array":1
    },
    {
        "code":"200",
        "name":null,
        "data_batchNo":"2202104020642108611",
        "data_id":"123456",
        "msg":"成功",
        "timestamp":"1617369230495",
        "is_valid":true,
        "array":2
    },
    {
        "code":"200",
        "name":null,
        "data_batchNo":"2202104020642108611",
        "data_id":"123456",
        "msg":"成功",
        "timestamp":"1617369230495",
        "is_valid":true,
        "array":3
    }
]
```

