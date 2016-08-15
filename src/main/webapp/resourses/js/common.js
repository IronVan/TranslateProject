$(function () {

    $('#checkAll').click(function () {

        if ($('#sites input').prop('checked') == true) {

            $('#sites input').prop('checked', false);
        } else {
            $('#sites input').prop('checked', true);
            $("#mywarning").hide();
        }
    });




});

function myFunction() {

    if ($('.checkbox:checked').length == 0) {
        $("#mywarning").show();
    } else {
        document.getElementById("myForm").submit();
    }
}