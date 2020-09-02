function KeyUp() {
    var a = $('#NewStaffPwd1').val();
    //alert(a);
    var b = $('#NewStaffPwd2').val();
    //alert(b);
    if (a == b) {
        $('#btnSave').removeAttr('disabled');
    }
    else {
        $('#btnSave').attr('disabled', 'disabled');
    }
}