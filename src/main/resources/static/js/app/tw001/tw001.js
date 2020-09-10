
const QUESTION_ONE_CORRECT = 'LCH001';
const QUESTION_MANY_CORRECT = 'LCH002';
const QUESTION_TRUE_FALSE = 'LCH003';
const QUESTION_CONNECT_LINE = 'LCH004';
const QUESTION_INPUT_ANSWER = 'LCH005';
const QUESTION_TYPE_OFFLINE = 'ET1';
const QUESTION_TYPE_ONLINE = 'ET2';

var indexQuestionAdd = 1;
var listChar = new Array();

$(document).ready(function() {
	
	init();

	$('#examClassification').change(function() {
		changeExamClassification();
	});
}); 

function init() {
	
	generateHoursMinutes($('#examStartHours'), $('#examStartMinutes'));
	generateHoursMinutes($('#examEndHours'), $('#examEndMinutes'));
	changeExamClassification();
	
	$('input[name="examRange"][value="0"]').prop('checked', true);
	$('input[name="examAfterOnline"][value="0"]').prop('checked', true);
	
	changeQuestionClassification(null);
	outputQuestionNo();
	caculationQuestionNo();
	
	for (var i = 65; i <= 90; i++) {
		listChar.push(String.fromCharCode(i));
	}
	
}

function changeExamClassification() {
	// Online
	if ($('#examClassification').val() == QUESTION_TYPE_ONLINE) {
		$('#div-exam-after-online').show();
		
	// Offline
	} else {
		$('#div-exam-after-online').hide();
	}
}

function changeQuestionClassification(element) {
	
	var indexQuestion;
	
	if (!element) {
		indexQuestion = 1;
	} else {
		indexQuestion = $(element).attr('indexQuestion');
	}
	
	var questionClassification = $('#questionClassificationId' + indexQuestion).val();
	
	// Hide all question content, answer area
	$('#questionTrueFalseId' + indexQuestion).hide();
	$('#questionOneCorrectId' + indexQuestion).hide();
	$('#questionManyCorrectId' + indexQuestion).hide();
	$('#questionConnectLineId' + indexQuestion).hide();

	//One answer correct
	if (questionClassification == QUESTION_ONE_CORRECT) {
		$('#questionOneCorrectId' + indexQuestion).show();
		
	// Many answer correct
	} else if (questionClassification == QUESTION_MANY_CORRECT) {
		$('#questionManyCorrectId' + indexQuestion).show();
		
	// True - False
	} else if (questionClassification == QUESTION_TRUE_FALSE) {
		$('#questionTrueFalseId' + indexQuestion).show();

	// Connect-line
	} else if (questionClassification == QUESTION_CONNECT_LINE) {
		addAnswer(indexQuestion);
		$('#questionConnectLineId' + indexQuestion).show();
	}
}

/**
 * Generate data for drop-down Hours, Minutes (at start data exam, end date exam)
 * @param itemHoursId
 * @param itemMinutesId
 * @returns
 */
function generateHoursMinutes(itemHours, itemMinutes) {
	
	var optionHours = '<option value="00">00</option>';
	var optionMinutes = '<option value="00">00</option>';
	
	// Generation drop-down for hours
	for (var i = 1; i < 10; i++) {
		optionHours += '<option value="0' + i +'">0' + i + '</option>';
	}
	for (var i = 10; i < 24; i++) {
		optionHours += '<option value="' + i +'">' + i + '</option>';
	}
	
	// Generation drop-down for minutes
	for (var i = 1; i < 10; i++) {
		optionMinutes += '<option value="0' + i +'">0' + i + '</option>';
	}
	for (var i = 10; i < 60; i++) {
		optionMinutes += '<option value="' + i +'">' + i + '</option>';
	}
	
	itemHours.append(optionHours);
	itemMinutes.append(optionMinutes);
	
	itemHours.val('00');
	itemMinutes.val('00');
}

function outputQuestionNo() {
	
	$('.questionNoClass').each(function(idx, value) {
		$(value).text(questionNo + ' ' + Number(idx + 1));
		var indexNo = $(value).attr('indexQuestion');
		$('#question' + indexNo).attr('indexQuestionChange', Number(idx + 1))
	});
}

function addQuestion() {
	indexQuestionAdd++;
	
	var $questionClone = $(document).find('.question')[0];
	var indexQuestionClone = $($questionClone).attr('indexQuestion');
	
	var $question = $('#question' + indexQuestionClone).clone();
	
	$($question).attr('id', 'question' + indexQuestionAdd).attr('indexQuestion', indexQuestionAdd);
	
	var arrayChangeHaveIndex = [
		'questionNoId', 'deleteQuestion', 'clearQuestion', 
		'questionClassificationId', 'questionCoefficientPointId',
		'questionConnectLineAnswerId', 'addAnswer',
		'referQuestion'
	];
	
	var arrayChangeNoIndex = [
		// Question true/false
		'questionTrueFalseId', 'questionTrueFalseContentId', 
		'answerTrueId', 'answerFalseId', 
		
		// Question One Correct
		'questionOneCorrectId', 'questionOneCorrectContentId', 
		'oneCorrectAnswerAId', 'answerOneCorrectContentAId', 
		'oneCorrectAnswerBId', 'answerOneCorrectContentBId', 
		'oneCorrectAnswerCId', 'answerOneCorrectContentCId', 
		'oneCorrectAnswerDId', 'answerOneCorrectContentDId',
		
		// Question many correct
		'questionManyCorrectId', 'questionManyCorrectContentId', 
		'answerManyCorrectAId', 'answerManyCorrectContentAId', 
		'answerManyCorrectBId', 'answerManyCorrectContentBId', 
		'answerManyCorrectCId', 'answerManyCorrectContentCId',
		'answerManyCorrectDId', 'answerManyCorrectContentDId',
		
		'questionConnectLineId', 'questionConnectLineContentId'
	];
	
	var arrayChangeName = [
		'answerTrueFalseName',
		'answerOneCorrectName',
		'answerManyCorrectName'
	];
	
	var arrayChangeAnswerConnectLine = [
		'answerCharId', 'answerCharContentId',
		'connectLineQuestionId',
		'answerNumberId' ,'answerNumberContentId'
	];
	
	$.each(arrayChangeHaveIndex, function(idx, value) {
		
		$($question).find('#' + value + indexQuestionClone)
			.attr('id', value + indexQuestionAdd)
			.attr('indexQuestion', indexQuestionAdd);
	});
	
	$.each(arrayChangeNoIndex, function(idx, value) {
		$($question).find('#' + value + indexQuestionClone).attr('id', value + indexQuestionAdd);
	});
	
	$.each(arrayChangeName, function(idx, value) {
		$($question).find('input[name="' + value + indexQuestionClone + '"]').attr('name', value + indexQuestionAdd);
	});
	
	$.each(arrayChangeAnswerConnectLine, function(idx, value) {
		$($question).find('#' + value + indexQuestionClone + '-1').attr('id', value + indexQuestionAdd + '-1');
	});
	
	$($question).find('#answerQuestionConnectLineId' + indexQuestionClone + '-1')
		.attr('id', 'answerQuestionConnectLineId' + indexQuestionAdd + '-1')
		.attr('indexQuestion', indexQuestionAdd)
		.attr('indexAnswer', '1');
	
	$($question).find('#answerQuestionConnectLineImageId' + indexQuestionClone + '-1')
		.attr('id', 'answerQuestionConnectLineImageId' + indexQuestionAdd + '-1')
		.attr('indexQuestion', indexQuestionAdd)
		.attr('indexAnswer', '1');
	
	$($question).find('.answerOneCorrectContentClass' + indexQuestionClone)
		.removeClass('answerOneCorrectContentClass' + indexQuestionClone)
		.addClass('answerOneCorrectContentClass' + indexQuestionAdd);
	
	$($question).find('.answerManyCorrectContentClass' + indexQuestionClone)
		.removeClass('answerManyCorrectContentClass' + indexQuestionClone)
		.addClass('answerManyCorrectContentClass' + indexQuestionAdd);
	
	$.each($($question).find('.error'), function(idx, value) {
		$(value).removeClass('error');
	});
	
	$('#listQuestion').append($question);
	clearQuestion($question);
	clearAnsserConnectLine(indexQuestionAdd);
	
	$($question).find('#answerQuestionConnectLineId' + indexQuestionAdd + '-1')
		.attr('indexAnswer', '1');
	
	generateAnswerConnect(indexQuestionAdd);
	
	outputQuestionNo();
	caculationQuestionNo();
}

function caculationQuestionNo() {
	var totalQuestion = 0;
	var totalPoint = 0;
	
	$('.question').each(function(index, value) {
		totalQuestion++;
	});
	
	$('.questionCoefficientPoint').each(function(index, value) {
		totalPoint += Number($(value).val());
	});
	
	var summary = questionSummary.replace('xx', totalQuestion).replace('yy', totalPoint)
	$('#txt-questionSummary').text(summary);
}

function removeQuestion(element) {
	var indexQuestion = $(element).attr('indexQuestion');
	var questionNo = $('#question' + indexQuestion).attr('indexQuestionChange');
	
	if ($(document).find('.question').length == 1) {
		showPopupCommon('warning', deleteAllQuestionMsg, null);
		return;
	} else if (confirm(deleteQuestionMsg + ' ' + questionNo + '?')) {
		$('#question' + indexQuestion).remove();
		
		// Export summary at end page
		caculationQuestionNo();
		
		// Output question no
		outputQuestionNo();
	}
}

function clearQuestion(element) {
	
	var indexQuestion = $(element).attr('indexQuestion');
	
	$('#questionClassificationId' + indexQuestion).val(QUESTION_ONE_CORRECT);
	$('#questionCoefficientPointId' + indexQuestion).val('1');
	
	$('#questionTrueFalseContentId' + indexQuestion).val('');
	$('input[name="answerTrueFalseName' + indexQuestion + '"]').prop('checked', false);
	
	$('#questionOneCorrectContentId' + indexQuestion).val('');
	$('#answerOneCorrectContentAId' + indexQuestion).val('');
	$('#answerOneCorrectContentBId' + indexQuestion).val('');
	$('#answerOneCorrectContentCId' + indexQuestion).val('');
	$('#answerOneCorrectContentDId' + indexQuestion).val('');
	$('input[name="answerOneCorrectName' + indexQuestion + '"]').prop('checked', false);
	
	$('#questionManyCorrectContentId' + indexQuestion).val('');
	$('#answerManyCorrectContentAId' + indexQuestion).val('');
	$('#answerManyCorrectContentBId' + indexQuestion).val('');
	$('#answerManyCorrectContentCId' + indexQuestion).val('');
	$('#answerManyCorrectContentDId' + indexQuestion).val('');
	$('input[name="answerManyCorrectName' + indexQuestion + '"]').prop('checked', false);
	
	clearAnsserConnectLine(indexQuestion);
	$('#questionConnectLineContentId' + indexQuestion).val('');
	$('#answerCharContentId' + indexQuestion + '-1').val('');
	$('#connectLineQuestionId' + indexQuestion + '-1').val('1');
	$('#answerNumberContentId' + indexQuestion + '-1').val('');
	
	changeQuestionClassification($('#questionClassificationId' + indexQuestion));
	caculationQuestionNo();
}

function clearAnsserConnectLine(indexQuestion) {
	var $listAnswer = $('#questionConnectLineAnswerId' + indexQuestion).find('.answerQuestionConnectLineClass');
	
	if ($listAnswer.length > 1) {
		for (var i = 1; i < $listAnswer.length; i++) {
			$($listAnswer[i]).remove();
		}
	}
	$($listAnswer[0]).attr('id', 'answerQuestionConnectLineId' + indexQuestion + '-1');
	
	$('#answerCharContentId' + indexQuestion + '-1').val('');
	$('#answerNumberContentId' + indexQuestion + '-1').val('');
	$('#connectLineQuestionId' + indexQuestion + '-1').val('1');
}

function addAnswer(element) {
	var indexQuestion = '';
	
	if ($.type(element) == 'object') {
		indexQuestion = $(element).attr('indexQuestion');
	} else {
		indexQuestion = element;
	}
	
	var $listAnswer = $('#questionConnectLineAnswerId' + indexQuestion).find('.answerQuestionConnectLineClass');
	var lengthAnswer = $listAnswer.length;
	
	if ((lengthAnswer + 1) > 10) {
		alert(addAnswerConnectLineMsg);
		return;
	}
	var indexAnswerAdd = Number($($listAnswer[lengthAnswer - 1]).attr('indexAnswer')) + 1;
	var $listAnswerClone = $('#questionConnectLineAnswerId' + indexQuestion).find('.answerQuestionConnectLineClass');
	var $answerClone = $listAnswerClone[0];
	var $answer = $($answerClone).clone();
	var indexAnswer = $($answer).attr('indexAnswer');
	
	var numberAnswer = $listAnswerClone.length;
	
	var arrayChange = [
		'answerCharId', 'answerCharContentId',
		'connectLineQuestionId',
		'answerNumberId', 'answerNumberContentId'
	];
	
	$.each(arrayChange, function(idx, value) {
		$($answer).find('#' + value + indexQuestion + '-' + indexAnswer).attr('id', value + indexQuestion + '-' + indexAnswerAdd);
	});
	
	$($answer).find('#answerQuestionConnectLineImageId' + indexQuestion + '-' + indexAnswer)
		.attr('id', 'answerQuestionConnectLineImageId' + indexQuestion + '-' + indexAnswerAdd)
		.attr('indexQuestion', indexQuestion)
		.attr('indexAnswer', indexAnswerAdd);
	
	$($answer).attr('id', 'answerQuestionConnectLineId' + indexQuestion + '-' + indexAnswerAdd)
		.attr('indexQuestion', indexQuestion)
		.attr('indexAnswer', indexAnswerAdd);
	
	$.each($($answer).find('.error'), function(idx, value) {
		$(value).removeClass('error');
	});
	
	$('#questionConnectLineAnswerId' + indexQuestion).append($answer);
	clearAnser(indexQuestion, indexAnswerAdd);
	
	outputAnserInfo(indexQuestion);
	generateAnswerConnect(indexQuestion);
}

function clearAnser(indexQuestion, indexAnswer) {
	$('#answerCharContentId' + indexQuestion + '-' + indexAnswer).val('');
	$('#answerNumberContentId' + indexQuestion + '-' + indexAnswer).val('');
	$('#connectLineQuestionId' + indexQuestion + '-' + indexAnswer).val('1');
}

function outputAnserInfo(indexQuestion) {
	var $listQuestionChange = $('#questionConnectLineAnswerId' + indexQuestion).find('.answerQuestionConnectLineClass');
	
	$.each($listQuestionChange, function(idx, value) {
		var $answerChar = $(value).find('.answerCharClass')[0];
		var $answerConnect = $(value).find('.connectLineQuestion')[0];
		var $answerNumber = $(value).find('.answerNumberClass')[0];
		
		$($answerChar).text(listChar[idx]);
		$($answerConnect).val('1');
		$($answerNumber).text(idx + 1)
	});
}

function generateAnswerConnect(indexQuestion) {
	var $answer = $('#questionConnectLineAnswerId' + indexQuestion).find('.answerQuestionConnectLineClass');
	var lengthAnswer = $answer.length;
	var htmlOption = '';
	var indexAnswer = '';
	
	for (var i = 1; i <= lengthAnswer; i++) {
		htmlOption += '<option value="' + i + '">' + i + '</option>';
	}
	
	$.each($answer, function(idx, value) {
		indexAnswer = $(value).attr('indexAnswer');
		$('#connectLineQuestionId' + indexQuestion + '-' + indexAnswer).empty().append(htmlOption);
	});
	
	for (var i = 0; i < lengthAnswer; i++) {
		$('#connectLineQuestionId' + indexQuestion + '-' + indexAnswer).empty().append(htmlOption);
	}
}

function cancelExam() {
	TW001Form.submit();
}

function removeAnswerConnectLine(element) {
	var indexQuestion = $(element).attr('indexQuestion');
	var indexAnswer = $(element).attr('indexAnswer');
	var lengthAnswer = $('#questionConnectLineAnswerId' + indexQuestion).find('.answerQuestionConnectLineClass').length;
	
	if (lengthAnswer < 3) {
		alert(deleteAnswerConnectLineNumber);
		return;
	}
	
	$('#answerQuestionConnectLineId' + indexQuestion + '-' + indexAnswer).remove();
	
	outputAnserInfo(indexQuestion);
	generateAnswerConnect(indexQuestion);
}