# jsonflatter

输入json

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

输出json

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

