$(function () {

    $('#checkAll').click(function () {

        if ($('#sites input').prop('checked') == true) {

            $('#sites input').prop('checked', false);
        } else {
            $('#sites input').prop('checked', true);
            $("#mywarning").hide();
        }
    });

    var $inputs = $('#translateBtn');

    $inputs.on('change paste input', function() {
        $inputs.not(this).attr('disabled', this.value == '' ? null : true);
    });

});

function myFunction() {

    if ($('.checkbox:checked').length ==0) {
        $("#mywarning").show();
    }else{
        document.getElementById("myForm").submit();
    }
}