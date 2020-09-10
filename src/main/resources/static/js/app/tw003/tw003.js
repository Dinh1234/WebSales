//Code functions
function initialTable() {
	// Define Columns
	var columns = [
			{
				data : 'idStudent',
				'className' : 'align-middle',
				'width':'15%'
			},
			{
				data : 'nameStudent',
				'className' : 'align-middle',
				'width':'25%'
			},
			{
				data : 'answerCorrect',
				'className' : 'align-middle  text-center',
				'width':'15%'
			},
			{
				data : 'score',
				'className' : 'align-middle  text-center',
				'width':'15%'
			},
			{
				data : 'timeExam',
				'className' : 'align-middle  text-center',
				'width':'15%'
			},
			{
				data : 'rank',
				'className' : 'align-middle'
			}];
	// DataTables
	var table = $('#tbl_datatables').DataTable({
		'paging' : false,
		"pagingType" : "full_numbers",
		'scrollCollapse' : false,
		'searching' : false,
		'processing' : false,
		'serverSide' : false,
		'info':false,
		'sort':false,
		'ajax' : {
			'url' : baseUrl + 'api/tw003/getHistoryExam',
			'contentType': 'application/json',
			'type': 'GET',
			'data': function(data) {
				data.subjectType = $('#subjectType').val();
				data.questionType = $('#questionType').val();
				data.orderBasicId = $('#orderBasicId').val();
				
			},
			complete : function(response) {
				// check exist of responseJSON
				if (!response.responseJSON){
					// return
					return;
				}
			},
			error : function(xhr) {
				alert('Có lỗi không xác định xảy ra!');
			}
		},
		'sAjaxDataProp' : 'data',
		'columns' : columns,
		'language' : getLanguageForDataTable()
	});
}

function counters(counter) {
	if(counter > 0){
		setTimeout(function () {
			counter--;
			$('.js-counter').text(counter + 's');
			counters(counter)
		}, 1000);
	} else {
		//counter = 10;
		$('#tbl_datatables').DataTable().ajax.reload(function() {
			counter = 10;
			counters(counter);
		});
	}
}

$(document).ready(function() {
	initialTable();
	counters(10);
});
