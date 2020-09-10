function getLanguageForDataTable() {

	return {

		"decimal" : "",
		"emptyTable" : "Dữ liệu rỗng",
		"info" : "_START_〜_END_（Tổng_TOTAL_dòng）",
		"infoEmpty" : "",
		"infoFiltered" : "",
		"infoPostFix" : "",
		"thousands" : ",",
		"lengthMenu" : "Số lượng hiển thị: _MENU_",
		'loadingRecords' : 'Đang tải...',
		'processing' : 'Đang thực thi...',
		'search' : 'Tìm kiếm:',
		'zeroRecords' : 'Không tìm thấy dữ liệu',
		'paginate' : {
			'first' : 'Đầu trang',
			'last' : 'Cuối trang',
			'next' : 'Tới',
			'previous' : 'Lùi'
		},
		'aria' : {
			'sortAscending' : ': Sắp xếp tăng dần',
			'sortDescending' : ': Sắp xếp giảm dần'
		}
	}
}
function checkDataTable(tableId, recordsTotal) {

	var tableSelector = '#' + tableId;

	// Get datatable
	var $tableEmpty = $(tableSelector);
	
	$(tableSelector + '_wrapper thead th').attr('tabindex', '-1');

	// Fix position for table
	$('.dataTables_scrollBody table').css({'z-index': '0', 'position': 'relative'}); 

	if (recordsTotal) {

		// Show info/ length/ paging
		$(tableSelector + "_length").show();
		$(tableSelector + "_info").show();
		$(tableSelector + "_paginate").show();

		// Disable sorting
		$(tableSelector + "_wrapper").find('th.table-sorting-disabled')
				.toggleClass('table-sorting-disabled', false);
		$(tableSelector + "_wrapper").find('th.table-sorting-disabled')
				.toggleClass('sorting', true);
		
		// remove class top
		$(tableSelector + '_wrapper .top').removeClass('d-none');
		$(tableSelector + '_wrapper .top').show();

	} else {

		// Hide info/ length/ paging
		$(tableSelector + "_length").hide();
		$(tableSelector + "_info").hide();
		$(tableSelector + "_paginate").hide();

		// Disable sorting
		$(tableSelector + "_wrapper").find('th.sorting_asc').toggleClass(
				'table-sorting-disabled', true);
		$(tableSelector + "_wrapper").find('th.sorting_desc').toggleClass(
				'table-sorting-disabled', true);
		$(tableSelector + "_wrapper").find('th.sorting').toggleClass(
				'table-sorting-disabled', true);
		$(tableSelector + "_wrapper").find('th').removeClass('sorting_asc',
				true);
		$(tableSelector + "_wrapper").find('th').removeClass('sorting_desc',
				true);
		$(tableSelector + "_wrapper").find('th.sorting').toggleClass('sorting',
				false);
	}
}

/**
 * function show popup common using for popup warning, confirm, error
 * 
 * @param type
 * @param content
 * @returns show modal common
 */
function showPopupCommon(type, content, fcBtn) {
	
	// if type is warning
	if(type === "warning") {
		$('#title-popup-common').text(TITLE_WARNING);
		
		// show button OK
		$('#btn-common-ok').removeClass('d-none');
		
		// add function handle event onclick
		$('#btn-common-ok').attr('onClick', fcBtn + '()');
	} 
	
	// if type is confirm
	else if (type === "confirm") {
		$('#title-popup-common').text(TITLE_CONFIRM);
		
		// show button OK
		$('#btn-common-ok').removeClass('d-none');
		
		// add function handle event onclick
		$('#btn-common-ok').attr('onClick', fcBtn + '()');
	} 
	
	// if type is error
	else if (type === "error") {
		$('#title-popup-common').text(TITLE_ERROR);
		$('#btn-common-ok').addClass('d-none');
	}
	
	// show content popup
	$('#content-popup-common').text(content);
	
	// show popup common
	$('#modal-common').modal('show');
}