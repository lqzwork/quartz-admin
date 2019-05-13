$(function	()	{
	//修改页面上其他控件颜色
	$('.widget-color-list li').click(function()	{
		$legend = $('legend');		
		$btn = $('.btn.btn-sm.btn-success');		
		$selectedColor = $(this).data('color');
		checkSkin($legend,$selectedColor);
		checkSkin($btn,$selectedColor);
//		$legend.removeClass('widget-light-grey');
//		$legend.removeClass('widget-dark');
//		$legend.removeClass('widget-dark-blue');
//		$legend.removeClass('widget-blue');
//		$legend.removeClass('widget-green');
//		$legend.removeClass('widget-yellow');
//		$legend.removeClass('widget-orange');
//		$legend.removeClass('widget-red');
//		$legend.removeClass('widget-purple');
//
//		if($selectedColor != 'reset')
//			$legend.addClass($selectedColor);
//		
//		return false;
	});
});

function checkSkin(el, color){
	el.removeClass('widget-light-grey');
	el.removeClass('widget-dark');
	el.removeClass('widget-dark-blue');
	el.removeClass('widget-blue');
	el.removeClass('widget-green');
	el.removeClass('widget-yellow');
	el.removeClass('widget-orange');
	el.removeClass('widget-red');
	el.removeClass('widget-purple');
	if(color != 'reset')
		el.addClass(color);
	return false;
}