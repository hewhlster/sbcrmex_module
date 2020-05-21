$(function () {
    $.getJSON("user/user_menu", function (json) {
        $('.sidebar-menu').mtMenu({
            data: json.data, //后端以调整统一返回数据格式2020/5/16
            menuName: "name",
            menuId: "id",
            subMenus: "children",
            menuUrl: "menuUrl",
            menuIcon: "menuIcon"
        });
        var url = window.location.hash;
        //alert(url);
        if (url && url.length > 1) {
            mwtools.openMenu(url.substring(1));
        }
    });


    $("#user_center").click(function () {
        mwtools.loadContext("user/user_center_view");
    });
});

function sys_logout() {
    window.location.href = "/auth/logout";
}