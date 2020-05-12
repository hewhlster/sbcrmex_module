function servcieStatusFormatter(status) {
    //服务状态 0:新建(待分配) 1：以分配(待处理) 2:以处理(待回访) 3:处理完成（待归档） 4:以归档	ret = "";
    switch (status) {
        case "0":
            ret = "<font color=red>待分配</font> ";
            break;
        case "1":
            ret = "待处理";
            break;
        case "2":
            ret = "待回访";
            break;
        case "3":
            ret = "待归档";
            break;
        case "4":
            ret = "<font color=green>以归档</font>";
            break;
        default:
            ret = "未知状态";
            break;
    }
    return ret;
}

function servcieTypeFormatter(type) {
    // 服务状态 0:咨询 1：建议 2:投诉
    ret = "";
    switch (type) {
        case "0":
            ret = "咨询";
            break;
        case "1":
            ret = "建议";
            break;
        case "2":
            ret = "待投诉";
            break;
        default:
            ret = "其它服务";
            break;
    }
    return ret;
}