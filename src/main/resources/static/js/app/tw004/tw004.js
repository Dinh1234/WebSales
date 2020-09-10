function executeSubmit(bt) {

	TW004Form.typeQuestion.value = bt.value;
	TW004Form.submit();
}

$(document).ready(function() {
	initialTable();
	handleEvent();
});