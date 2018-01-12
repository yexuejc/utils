### thymeleaf 踩坑之路（一） 数字(number) 算法坑
-------------------------------
**涉及坑**
>1. 除法,整数和浮点数
>2. 三元运算(?:)
>3. 循环(list->each)遍历
>4. 拼接，字符串拼接，url拼接
>5. 用下标取list的元素
>6. 字符串截取


源代码：出处[/util-kotlin/src/main/resources/templates/upload.html](../../../../../util-kotlin/src/main/resources/templates/upload.html)<br/>
源代码相关 [util-kotlin](../../../../../util-kotlin/README.md)
```
<tr th:each="up,stat : ${list}">
    <td th:text="${up.version}">1.0</td>
    <td th:text="${up.code}">1</td>
    <td th:text="${up.type}">A</td>
    <td th:text="${up.minVersion}">1.0</td>
    <td th:text="${up.ismust}">Y</td>
    <td th:text="${up.crtTime}">-</td>
    <td th:text="${up.note}">更新说明</td>
    <td th:text="${list2[stat.index].fileSize}">-</td>
    <td th:text="${(up.fileSize/1024.0/1024.0)<1 ? #numbers.formatDecimal(up.fileSize/1024.0,0,2)+'KB' : #numbers.formatDecimal(up.fileSize/1024.0/1024.0,0,2)+'MB'}">-</td>
    <td th:text="${(up.fileUrl).substring((up.fileUrl).lastIndexOf('/')+1)}"></td>
    <td>
        <a th:href="|@{/file/download}?id=${up.id}|" target="_blank">下载</a>
    </td>
</tr>
```
1. 遍历后端传回list，`th:each="up,stat : ${list}"` `up` list的item；`stat` 状态变量,有 index,count,size,current,even,odd,first,last等属性<br/>
2. `${list2[stat.index].fileSize}` 使用下标`stat.index` 获取item `${list2[stat.index]}`,整句意思是获取集合list2下标为`stat.index` 元素的`fileSize`属性
3. ```th:text="${(up.fileSize/1024.0/1024.0)<1 ? #numbers.formatDecimal(up.fileSize/1024.0,0,2)+'KB' : #numbers.formatDecimal(up.fileSize/1024.0/1024.0,0,2)+'MB'}"```
最长的一句。先拆分解析`${(xxx)<1?aaa:bbb}`，这是一个三元运算，表达式`(xxx)`是否小于1，是执行`aaa`；否执行`bbb`。
4. `#numbers.formatDecimal(up.fileSize/1024.0,0,2)+'KB'` 这是一个大坑`up.fileSize/1024`这是整数运算，计算结果为整数型；`up.fileSize/1024.0` 这是浮点数运算，计算结果为浮点型。
`#numbers.formatDecimal(123.456,0,2)` 格式化数字123.456 保留小数点后2位。语法`#numbers.formatDecimal(numbwe,整数位,小数位)`。<br/>
注意：指定整数位不为0，表示位数不足用0补齐,例：`#numbers.formatDecimal(3.456,2,2)` 结果为`03.45`
5. `${(up.fileUrl).substring((up.fileUrl).lastIndexOf('/')+1)}` 截取`up.fileUrl`最后一个`/`之后的。例：`D:/localwork/app/v_1.0_a.apk`截取出来的是`v_1.0_a.apk`
