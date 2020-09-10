//Code functions
function initialTable() {

	// Define Columns
	var columns = [
			{
				data : 'contentQuestion',
				'render' : function(data, type, row, meta) {
					if (row.contentQuestion.length > 50) {
						return '<span title="' + row.contentQuestion + '">'
								+ row.contentQuestion.substring(0, 50)
								+ '...</span>';
					}
					return row.contentQuestion;
				}
			},
			{
				data : 'typeQuestion',
				'className' : 'align-middle',
				'width':'8%'
			},
			{
				data : 'timeStartExam',
				'className' : 'text-center align-middle',
				'width':'14%'
			},
			{
				data : 'timeEndExam',
				'className' : 'text-center align-middle',
				'width':'14%'
			},
			{
				data : 'timeOverExam',
				'className' : 'text-center align-middle',
				'width':'5%'
			},
			{
				data : 'countExam',
				'className' : 'text-center align-middle',
				'width':'5%'
			},
			{
				data : 'highestScore',
				'className' : 'text-center align-middle',
				'width':'5%'
			},
			{
				data:'buttonAction',
				'width':'18%',
				'className' : 'text-center align-middle'
				//,'render' : function(data, type, row, meta) {
//
//					return renderButton(row.id, row.typeQuestion);
//				}
			}
			];

	// DataTables
	var table = $('#tbl_datatables').DataTable({
		'paging' : true,
		"pagingType" : "full_numbers",
		'scrollCollapse' : false,
		'deferLoading': 0,
		'searching' : false,
		'processing' : true,
		'serverSide' : true,
		'info':false,
		'columnDefs' : [{
			'targets' : [0],
			'searchable' : false,
			'orderable': false
		},{
			'targets' : [6],
			'searchable' : false,
			'orderable': false
		}
		,{
			'targets' : [4],
			'searchable' : false,
			'orderable': false
		}
		,{
			'targets' : [5],
			'searchable' : false,
			'orderable': false
		}
		,{
			'targets' : [7],
			'searchable' : false,
			'orderable': false
		}],
		"order": [[ 2, "ASC" ]],
		'ajax' : {
			
			'url' : baseUrl + 'api/tw009/search',
			"contentType": "application/json",
			"type": "GET",
			'data' : function(d) {

				// set search keyword to parameter
				d.subjectType = $('#subjectType').val();
				d.questionType = $('#questionType').val();
				d.questionBasicId = $('#questionBasicId').val();

				// set order to parameter
				var order = $('#tbl_datatables').DataTable().order();
				var columnIndex = order[0][0];
				d.orderColumn = columns[columnIndex].data;
				d.orderDirection = order[0][1];
			},
			complete : function(response) {

				// check exist of responseJSON
				if (!response.responseJSON){

					// return
					return;
				}
				checkDataTable('tbl_datatables', response.responseJSON.recordsTotal);
			},
			error : function(xhr) {
				alert('Có lỗi không xác định xảy ra');
			}
		},
		'sAjaxDataProp' : 'data',
		'columns' : columns,
		'language' : getLanguageForDataTable()
	});
	checkDataTable('tbl_datatables', 0);
}

function handleEvent(){
	$('#btn_search').click(function(){
		$('#tbl_datatables').DataTable().ajax.reload();
	});
}
function executeSubmit(bt) {
	if (bt.value == 1){
		
		tw002.action.value = bt.value;
		tw002.screenSource.value = 'tw007';
		tw002.id.value = bt.getAttribute('questionid');
		tw002.typeQuestion.value = bt.getAttribute('typeQuestion');
		tw002.submit();
	}
}

function renderButton(id, typeQuestion) {
	return '<button type = "button" class="btn btn-secondary mr-1" onclick = "executeSubmit(this)" value="1" questionId="'+id+'" typeQuestion="'+typeQuestion+'">Vào thi</button>'
			+ '<button type = "button" class="btn btn-secondary mr-1" onclick = "executeSubmit(this)" value="2" questionId="'+id+'" typeQuestion="'+typeQuestion+'">Chi tiết</button>'
			+ '<button type = "button" class="btn btn-secondary mr-1 mt-1" onclick = "executeSubmit(this)" value="3" questionId="'+id+'" typeQuestion="'+typeQuestion+'">Chỉnh sửa</button>'
			+ '<button type = "button" class="btn btn-secondary mr-1 mt-1" onclick = "executeSubmit(this)" value="4" questionId="'+id+'" typeQuestion="'+typeQuestion+'">Xóa</button>';
}
$(document).ready(function() {
	initialTable();
	handleEvent();
});