
function fire_ajax_submit() {



    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "GET",
        url: "http://localhost:8091/imitation",
        cache: false,
        dataType: 'json',
        timeout: 600000,
        success: function ( data, textStatus, jqXHR) {
            alert(JSON.stringify(data));

            $("#btn-search").prop("disabled", false);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus+' '+jqXHR.getAllResponseHeaders());
            $("#btn-search").prop("disabled", false);

        }
    });

}