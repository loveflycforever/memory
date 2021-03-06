
function tableView(json) {
//创建table
    var table =
        document.createElement("table");
    //创建thead，并追加到table中
    var thead =
        document.createElement("thead");
    table.appendChild(thead);
    //创建tr,并追加到thead
    var tr =
        document.createElement("tr");
    thead.appendChild(tr);
    //json数组中第1个人的每个属性
    for (var key in json[0]) {
//创建th
        var th =
            document.createElement("th");
//设置th的内容为key
        th.innerHTML = key;
//将th追加到tr中
        tr.appendChild(th);
    }
    //创建tbody元素
    var tbody =
        document.createElement("tbody");
    //将tbody追加到table中
    table.appendChild(tbody);
    //遍历json中所有员工
    for (var i = 0; i < json.length; i++) {
//创建tr
        var tr =
            document.createElement("tr");
//遍历当前员工的每个属性
        for (var key in json[i]) {
//创建td
            var td =
                document.createElement("td");
//设置td的内容为当前员工的当前属性值
            td.innerHTML = json[i][key];
//将td追加到tr
            tr.appendChild(td);
        }//(遍历结束)
//将tr追加到tbody中
        tbody.appendChild(tr);
    }
    //将table添加到id为data的div下
    document.getElementById("data")
        .appendChild(table);
}
