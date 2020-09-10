var examContent = '';
var examClassification = '';
var examSubject = '';
var timeStartExamDate = '';
var examStartHours = '';
var examStartMinutes = '';
var timeEndExamDate = '';
var examEndHours = '';
var examEndMinutes = '';
var examDuration = '';
var examMaxNumber = '';
var examRange = '';
var examAfterOnline = '';

function submitExam() {
	var questionBasicModel = new Object();
	var listQuestionDetailsModel = new Array();
	var questionDetailsModel;
	var valid = true;
	
	//********* Get data input from screen *********
	examContent = $('#examContent').val();
	examClassification = $('#examClassification').val();
	examSubject = $('#examSubject').val();
	
	// Start - End date
	timeStartExamDate = $('#timeStartExamDate').val();
	examStartHours = $('#examStartHours').val();
	examStartMinutes = $('#examStartMinutes').val();
	
	timeEndExamDate = $('#timeEndExamDate').val();
	examEndHours = $('#examEndHours').val();
	examEndMinutes = $('#examEndMinutes').val();
	
	examDuration = $('#examDuration').val();
	examMaxNumber = $('#examMaxNumber').val();
	examRange = $('input[name="examRange"]:checked').val();
	examAfterOnline = $('input[name="examAfterOnline"]:checked').val();
	
	//********* Check validate for data input from screen *********
	if (!isValidExam()) {
		return;
	}
	
	//********* Set exam info ***********
	questionBasicModel.examContent = examContent;
	questionBasicModel.examClassification = examClassification;
	questionBasicModel.examSubject = examSubject;
	
	questionBasicModel.timeStartExam = formatExamDate(timeStartExamDate, examStartHours, examStartMinutes);
	questionBasicModel.timeEndExam = formatExamDate(timeEndExamDate, examEndHours, examEndMinutes);
	
	questionBasicModel.examDuration = examDuration;
	questionBasicModel.examMaxNumber = examMaxNumber;
	questionBasicModel.examRange = examRange;
	questionBasicModel.examAfterOnline = examAfterOnline;
	
	//********* Set question list *********
	$('.question').each(function(idx, value) {
		questionDetailsModel = new Object();
		questionDetailsModel.questionNo = $(value).attr('indexQuestionChange');
		var indexQuestion = $(value).attr('indexQuestion');
		questionDetailsModel.questionClassification = $('#questionClassificationId' + indexQuestion).val();
		questionDetailsModel.questionCoefficientPoint = $('#questionCoefficientPointId' + indexQuestion).val();

		if (!questionDetailsModel.questionCoefficientPoint) {
			alert('questionDetailsModel.questionCoefficientPoint');
			valid = false;
			return false;
		}
		
		if (!handleQuestion(questionDetailsModel, indexQuestion, value)) {
			valid = false;
			return false;
		}
		
		listQuestionDetailsModel.push(questionDetailsModel);
	});
	
	questionBasicModel.listQuestionDetailsModel = listQuestionDetailsModel;
	
	console.log(JSON.stringify(questionBasicModel));
	
	if (!valid) {
		return;
	} else {
		
		$('#TW001Form :input').prop("disabled", true);
		$('img').hide();
	
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: baseUrl + 'api/tw001/createNewExam',
			data: JSON.stringify(questionBasicModel),
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				TW001Form.submit();
			},
			error: function (e) {
				$('#TW001Form :input').prop("disabled", false);
				$('img').show();
			}
		});
	}
}

function handleQuestion(questionDetailsModel, indexQuestion, element) {
	var questionClassification = questionDetailsModel.questionClassification;
	var questionNo = questionDetailsModel.questionNo;
	var listAnserModel = new Array();
	var answerModel;
	var valid = true;
	
	// Set info details of question
	
	//One answer correct
	if (questionClassification == QUESTION_ONE_CORRECT) {
		
		var questionContent = $('#questionOneCorrectContentId' + indexQuestion).val();

		if (!questionContent) {
			alert(warningInputMsg.replace('xxx', questionNo));
			setItemError('questionOneCorrectContentId' + indexQuestion);
			return false;
		} else {
			clearItemError('questionOneCorrectContentId' + indexQuestion);
		}
		questionDetailsModel.questionContent = questionContent;
		
		$('.answerOneCorrectContentClass' + indexQuestion).each(function(idx, value) {
			if (!$(value).val()) {
				alert(warningInputMsg.replace('xxx', questionNo));
				valid = false;
				setItemError($(value).attr('id'));
				return false;
			} else {
				answerModel = new Object();
				answerModel.answerCd1 = listChar[idx];
				answerModel.answerName1 = $(value).val();
				listAnserModel.push(answerModel);
				clearItemError($(value).attr('id'));
			}
		});
		
		if (!valid) {
			return false;
		}
		
		questionDetailsModel.listAnserModel = listAnserModel;
		
		var answerCorrect = $('input[name="answerOneCorrectName' + indexQuestion + '"]:checked').val();
		
		if (!answerCorrect) {
			alert(warningSelectAnswerMsg.replace('xxx', questionNo));
			setItemError('oneCorrectAnswerAId' + indexQuestion);
			return false;
		} else {
			clearItemError('oneCorrectAnswerAId' + indexQuestion);
		}
		questionDetailsModel.answerCorrect = answerCorrect;
		
	// Many answer correct
	} else if (questionClassification == QUESTION_MANY_CORRECT) {
		var questionContent = $('#questionManyCorrectContentId' + indexQuestion).val();
		
		if (!questionContent) {
			alert(warningInputMsg.replace('xxx', questionNo));
			setItemError('questionManyCorrectContentId' + indexQuestion);
			return false;
		} else {
			clearItemError('questionManyCorrectContentId' + indexQuestion);
		}
		questionDetailsModel.questionContent = questionContent;
		
		$('.answerManyCorrectContentClass' + indexQuestion).each(function(idx, value) {
			if (!$(value).val()) {
				alert(warningInputMsg.replace('xxx', questionNo));
				valid = false;
				setItemError($(value).attr('id'));
				return false;
			} else {
				answerModel = new Object();
				answerModel.answerCd1 = listChar[idx];
				answerModel.answerName1 = $(value).val();
				listAnserModel.push(answerModel);
				clearItemError($(value).attr('id'));
			}
		});
		
		if (!valid) {
			return false;
		}
		
		questionDetailsModel.listAnserModel = listAnserModel;
			
		var isSelectAnswer = $('input[name="answerManyCorrectName' + indexQuestion + '"]:checked').length;
		if (!isSelectAnswer) {
			alert(warningSelectAnswerMsg.replace('xxx', questionNo));
			setItemError('answerManyCorrectAId' + indexQuestion);
			return false;
		} else {
			clearItemError('answerManyCorrectAId' + indexQuestion);
		}
		
		var answerCorrect = '';
		$.each($('input[name="answerManyCorrectName' + indexQuestion + '"]:checked'), function(idx, value) {
			answerCorrect += $(value).val() + ',';
		});
		
		questionDetailsModel.answerCorrect = answerCorrect.substring(0, answerCorrect.length - 1);
		
	// True - False
	} else if (questionClassification == QUESTION_TRUE_FALSE) {
		var questionContent = $('#questionTrueFalseContentId' + indexQuestion).val();
		var answerCorrect = $('input[name="answerTrueFalseName' + indexQuestion + '"]:checked').val();
		
		if (!questionContent) {
			alert(warningInputMsg.replace('xxx', questionNo));
			setItemError('questionTrueFalseContentId' + indexQuestion);
			return false;
		} else {
			clearItemError('questionTrueFalseContentId' + indexQuestion);
		}
		
		if (!answerCorrect) {
			alert(warningSelectAnswerMsg.replace('xxx', questionNo));
			setItemError('answerTrueId' + indexQuestion);
			return false;
		} else {
			clearItemError('answerTrueId' + indexQuestion);
		}
		
		questionDetailsModel.questionContent = questionContent;
		questionDetailsModel.answerCorrect = answerCorrect;
		
		answerModel = new Object();
		answerModel.answerCd1 = '0';
		answerModel.answerName1 = 'True';
		listAnserModel.push(answerModel);
		
		answerModel = new Object();
		answerModel.answerCd1 = '1';
		answerModel.answerName1 = 'False';
		listAnserModel.push(answerModel);
		
		questionDetailsModel.listAnserModel = listAnserModel;
		
	// Connect-line
	} else if (questionClassification == QUESTION_CONNECT_LINE) {
		var questionContent = $('#questionConnectLineContentId' + indexQuestion).val();
		
		if (!questionContent) {
			alert(warningInputMsg.replace('xxx', questionNo));
			setItemError('questionConnectLineContentId' + indexQuestion);
			return false;
		} else {
			clearItemError('questionConnectLineContentId' + indexQuestion);
		}
		
		questionDetailsModel.questionContent = questionContent;
		
		var $listAnswer = $(element).find('.answerQuestionConnectLineClass');
		var lengthAnswer = $listAnswer.length;
		var answer;
		var answerCorrect = '';
		var indexAnswer = '';
		
		$.each($listAnswer, function(idx, value) {
			indexAnswer = $(value).attr('indexAnswer');
			var answerCharCd = $('#answerCharId' + indexQuestion + '-' + indexAnswer).text();
			var answerNumberCd = $('#answerNumberId' + indexQuestion + '-' + indexAnswer).text();
			var answerChar = $('#answerCharContentId' + indexQuestion + '-' + indexAnswer).val();
			var answerNumber = $('#answerNumberContentId' + indexQuestion + '-' + indexAnswer).val();
			var answerSelect = $('#connectLineQuestionId' + indexQuestion + '-' + indexAnswer).val();
			
			if (!answerChar) {
				alert(warningInputMsg.replace('xxx', questionNo));
				valid = false;
				setItemError('answerCharContentId' + indexQuestion + '-' + indexAnswer);
				return false;
			} else {
				clearItemError('answerCharContentId' + indexQuestion + '-' + indexAnswer);
			}
			
			if (!answerNumber) {
				alert(warningInputMsg.replace('xxx', questionNo));
				valid = false;
				setItemError('answerNumberContentId' + indexQuestion + '-' + indexAnswer);
				return false;
			} else {
				clearItemError('answerNumberContentId' + indexQuestion + '-' + indexAnswer);
			}
			
			if (!answerSelect) {
				alert(warningSelectAnswerMsg.replace('xxx', questionNo));
				valid = false;
				setItemError('connectLineQuestionId' + indexQuestion + '-' + indexAnswer);
				return false;
			} else {
				clearItemError('connectLineQuestionId' + indexQuestion + '-' + indexAnswer);
			}
			
			answerModel = new Object();
			answerModel.answerCd1 = answerCharCd;
			answerModel.answerName1 = answerChar;
			answerModel.answerCd2 = answerNumberCd;
			answerModel.answerName2 = answerNumber;
			answerCorrect += answerSelect + ',';
			listAnserModel.push(answerModel);
		});
		
		if (!valid) {
			return false;
		}
		
		questionDetailsModel.listAnserModel = listAnserModel;
		questionDetailsModel.answerCorrect = answerCorrect.substring(0, answerCorrect.length - 1);
	}
	
	return true;
}

function isValidExam() {

	if (!isRequired(itemExamContent, 'examContent', examContent)) {
		return false;
	} else {
		clearItemError('examContent');
	}
	
	if (!checkNumber(itemExamDuration, 'examDuration', examDuration, 3, true, false)) {
		return;
	} else {
		clearItemError('examDuration');
	}
	
	if (!checkNumber(itemExamMaxNumber, 'examMaxNumber', examMaxNumber, 3, false, false)) {
		return;
	} else {
		clearItemError('examMaxNumber');
	}
	
	if (!checkDateTime(itemStartDateExam, 'timeStartExamDate', timeStartExamDate, 'dd/mm/yyyy', true)) {
		return false;
	} else {
		clearItemError('timeStartExamDate');
	}
	
	if (!checkDateTime(itemEndDateExam, 'timeEndExamDate', timeEndExamDate, 'dd/mm/yyyy', false)) {
		return false;
	} else {
		clearItemError('timeEndExamDate');
	}
	
	if (timeEndExamDate) {
		
		var startDate = formatExamDate(timeStartExamDate, examStartHours, examStartMinutes);
		var endDate = formatExamDate(timeEndExamDate, examEndHours, examEndMinutes);
		
		if (!checkFromTo(itemStartDateExam, 'timeStartExamDate', startDate, itemEndDateExam, 'timeEndExamDate', endDate)) {
			return false;
		} else {
			clearItemError('timeStartExamDate');
		}
	}
	
	return true;
}

/**
 * format: dd/mm/yyyy hh:mm
 * @param date
 * @returns
 */
function formatExamDate(date, hours, minutes) {
	
	if (!date || date.length != 10) {
		return '';
	}
	
	var d = date.split('/');
	var day = d[0];
	var month = d[1];
	var year = d[2];

	if (month.length < 2) 
		month = '0' + month;
	if (day.length < 2) 
		day = '0' + day;

	return [day, month, year].join('/') + ' ' + hours + ':' + minutes;
}