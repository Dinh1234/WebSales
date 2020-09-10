
var message = '';

function referQuestion(element) {
	
	$.ajax({
		type: 'GET',
		contentType: 'application/json',
		url: '/api/tw005/getDataInit',
		data: {},
		dataType: 'json',
//		cache: false,
		timeout: 600000,
		success: function (data) {
			console.log(data);
			initPopupRefer(data)
		},
		error: function (e) {
			message = 'Có một lỗi đã xảy ra!';
		}
	});
	
	$('#modal-referQuestion').modal('show');
}

function initPopupRefer(data) {
	$('#lbl_tw001_title').text(data.titleScreenRefer);
	var listSubjectType = data.listSubjectType;
	var listExamTitle = data.listExamTitle;
	var subjectHtml = '<option value="">' + allSubjectTypeTitle + '</option>';
	var examHtml = '<option value="">' + allExamTitle + '</option>';
	
	$.each(listSubjectType, function(idx, value) {
		subjectHtml += '<option value="' + value.id + '">' + value.name + '</option>';
	});
	
	$.each(listExamTitle, function(idx, value) {
		examHtml += '<option value="' + value[0] + '">' + value[1] + '</option>';
	});
	
//	$('#subjectType').empty().append(subjectHtml);
//	$('#examTitle').empty().append(examHtml);
}