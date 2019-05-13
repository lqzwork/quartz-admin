/**
 * 默认分页工具参数
 * dep:pagination
 */
var defPagOpts = {
		selector : '#Pagination' ,
        refreshDo : ".overflow-hidden",
		prev_text :'« 上一页',
		next_text : "下一页 »",
		num_edge_entries: 2,
		num_display_entries: 6
};

var selector;
/**
 * 分页器
 */
function DefPagination(pageOptions) {
    var emp = {};
    $.extend(emp, defPagOpts, pageOptions);
    this.opts = emp;
    var pag = this;
    selector = pag.opts.selector;
 
    $(pag.opts.selector).pagination(pag.opts.totalRecord, {
		callback : PageCallback, //PageCallback() 为翻页调用次函数。
		prev_text : pag.opts.prev_text,
		next_text : pag.opts.next_text,
		items_per_page : pag.opts.pageSize,
		num_edge_entries : pag.opts.num_edge_entries, //两侧首尾分页条目数
		num_display_entries : pag.opts.num_display_entries, //连续分页主体部分分页条目数
		current_page : pag.opts.pageNo - 1
	//当前页索引
	});
	//翻页调用   
	function PageCallback(index, jq) {
		InitTable(index + 1);
	}
	//请求数据   
	function InitTable(pageNo) {
		$.ajax({
			type : "POST",
			dataType : "text",
			url : pag.opts.searchUrl, //提交到一般处理程序请求数据   
			data : "pageNo=" + (pageNo), //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
			success : function(data) {
				$(pag.opts.refreshDo).html("")
				$(pag.opts.refreshDo).html(data);
			}
		});
	}
}