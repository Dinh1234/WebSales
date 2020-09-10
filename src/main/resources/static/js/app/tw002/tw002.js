//Code functions
function alertHello() {
	alert('Hello');
}

$(document).ready(function() {

	$('#myModalTW002').on('hidden.bs.modal', function() {
		// event xảy ra khi đóng popup
		window.location.href = "/tw003";
	})
});

/**
 * function show popup confirm submit test
 * 
 */
function confirmSubmitTest() {
	showPopupCommon("confirm", CONTENT_SUBMIT, "submitTest");
}

// create object question model FE
var questionModelFE = {};

// get data answer
var listAnswerModel = [];

function getAnswerModel() {
	
	questionModelFE.questionBasicId = $('#examCd').attr('value');;
	questionModelFE.userExam = $('#userId').attr('value');
	questionModelFE.timeWork = $('#timeStart').attr('value');
	questionModelFE.subjectID = $('#subjectId').attr('value');
	questionModelFE.typeQuestion = $('#typeQuestion').attr('value');

	$.each($('form input:radio, input:checkbox, :selected'), function(index, formField) {

		answerModel = {};

		if (formField.checked || formField.selected) {
			
			answerModel.questionDetailId = $(formField).attr('name');
			answerModel.answerCd1 = $(formField).val().trim();
			
			listAnswerModel.push(answerModel);
		}
		
		questionModelFE.listAnswer = listAnswerModel;
	});

	saveResultTest();
}

function saveResultTest() {

	// Get CSRF token
	var token = $('#hid_csrf_token').val();
	var header = $('#hid_csrf_header').val();

	// Call AJAX update of insert
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : baseUrl + 'api/tw002/saveAnswer',
		// beforeSend : function(xhr) {
		// xhr.setRequestHeader(header, token);
		// },
		data : JSON.stringify(questionModelFE),
		dataType : 'json',
		cache : false,
		timeout : 30000, // ms
		success : function(data) {
			if(data.status == 'OK') {
				//alert("success");
				executeSubmit(data);
				
				//window.location.href = "/tw003";
				
			} else {
				alert("not success");
			}
			

		},
		error : function(xhr) {
			alert("fail");

		}
	});
}

function executeSubmit(bt) {
	if (bt.status == 'OK'){
		
		tw003.action.value = bt.value;
		tw003.screenSource.value = 'tw002';
		tw003.orderBasicId.value = bt.questionBasicId;
		tw003.subjectType.value = bt.subjectType;
		tw003.questionType.value = bt.questionType;
		tw003.submit();
	}
}

/**
 * function show popup confirm submuit bài thi
 * 
 * @returns
 */
function submitTest() {
	$('#modal-common').modal('hide');

	getAnswerModel();

	/*
	 * setTimeout(function(){ $('#myModalTW002').modal('show'); }, 300);
	 */

}

referTW003 = function() {
	window.location.href = "/tw003";
}