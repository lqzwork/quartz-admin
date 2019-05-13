<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String jsPath = request.getContextPath();
		String jsBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+jsPath+"/";
%>

<!--EasyUi引入-->
<script type="text/javascript" src="<%=jsPath%>/resources/plugin/easyui/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=jsPath%>/resources/plugin/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=jsPath%>/resources/plugin/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=jsPath%>/resources/plugin/easyui/easyui-utils.js" charset="utf-8"></script>
<!--Jquery  validate -->
<!--自定义组件拖拽-->
<script src="<%=jsPath%>/resources/js/jquery.dragsort-0.5.2.min.js"></script>

<script src="<%=jsPath%>/resources/js/jquery-form.js"></script>
<script src="<%=jsPath%>/resources/js/jquery.validate-1.14.0.min.js"></script>
<script src="<%=jsPath%>/resources/js/message/messages_zh.js"></script>
<!-- Bootstrap -->
<script src="<%=jsPath%>/resources/plugin/bootstrap/js/bootstrap.min.js"></script>
<!-- Switch-->
<script src="<%=jsPath%>/resources/plugin/bootstrap/js/bootstrap-switch.min.js"></script>

<!-- Slimscroll -->
<script src='<%=jsPath%>/resources/js/jquery.slimscroll.min.js'></script>
<!-- Morris -->
<script src='<%=jsPath%>/resources/js/rapheal.min.js'></script>	
<script src='<%=jsPath%>/resources/js/morris.min.js'></script>	
<!-- Sparkline -->
<script src='<%=jsPath%>/resources/js/sparkline.min.js'></script>
<!-- Skycons -->
<script src='<%=jsPath%>/resources/js/uncompressed/skycons.js'></script>
<!-- Popup Overlay -->
<script src='<%=jsPath%>/resources/js/jquery.popupoverlay.min.js'></script>
<!-- Easy Pie Chart -->
<script src='<%=jsPath%>/resources/js/jquery.easypiechart.min.js'></script>
<!-- Sortable -->
<script src='<%=jsPath%>/resources/js/uncompressed/jquery.sortable.js'></script>
<!-- Owl Carousel -->
<script src='<%=jsPath%>/resources/js/owl.carousel.min.js'></script>
<!-- Simplify -->
<script src="<%=jsPath%>/resources/js/simplify/simplify.js"></script>
<!-- jquery提示插件 -->
<script src="<%=jsPath%>/resources/js/jquery.tips.js"></script>
<!-- jquery cookie -->
<script src="<%=jsPath%>/resources/js/jquery.cookie.js"></script>
<!-- jquery cookie -->
<script src="<%=jsPath%>/resources/js/jquery.cookie.js"></script>
<!-- jquery dataTabe -->
<script src="<%=jsPath%>/resources/js/jquery.dataTables.js"></script>
<!-- ztree -->
<script src="<%=jsPath%>/resources/js/jquery.ztree.all.min.js"></script>
<!-- 扩展js-修改样式 -->
<script src="<%=jsPath%>/resources/js/expand.js"></script>
<!-- 扩展js-分页二次封装(暂不使用) -->
<script src="<%=jsPath%>/resources/js/jquery-util.js"></script>
<!-- json -->
<script src="<%=jsPath%>/resources/js/json2.js"></script>
<!-- datespicker-->
<script src="<%=jsPath%>/resources/plugin/bootstrap/js/bootstrap-datepicker.js"></script>
<script src="<%=jsPath%>/resources/plugin/bootstrap/js/bootstrap-datepicker.zh-CN.min.js"></script>
<script src="<%=jsPath%>/resources/plugin/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<!-- dataTable的二次封装 -->
<script src="<%=jsPath%>/jsp/common/constant.js"></script>

<!-- 城市-->
<script src="<%=jsPath%>/resources/js/city/city-picker.data.js"></script>
<script src="<%=jsPath%>/resources/js/city/city-picker.js"></script>

<!--富文本编辑-->
<script src="<%=jsPath%>/resources/plugin/wangEditor/js/wangEditor.js"></script>

<script type="text/javascript">
function popTip(obj,e){
    $("[data-toggle='tooltip']").tooltip({html : true });
}
function backone () {
    window.history.go(-1);
}
/**
 * 给时间框控件扩展一个清除的按钮
 */
$.fn.datebox.defaults.cleanText = '清空';
 
(function ($) {
  var buttons = $.extend([], $.fn.datebox.defaults.buttons);
  buttons.splice(1, 0, {
    text: function (target) {
      return $(target).datebox("options").cleanText
    },
    handler: function (target) {
      $(target).datebox("setValue", "");
      $(target).datebox("hidePanel");
    }
  });
  $.extend($.fn.datebox.defaults, {
    buttons: buttons
  });
 
})(jQuery)
</script>

