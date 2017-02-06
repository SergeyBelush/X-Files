$(document).ready(function () {

    $("#uploadFileButton").click(readFile);

    showAllListFiles();

});


function readFile() {

    fileName = $('#uploadImage').val();

    reader = new FileReader();

    reader.onload = function() {
        content =  reader.result;
        console.log(content);

        $.ajax({
            url: "uploadFile",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                name: fileName,
                file: content
            }),
            success: addFileInTable
        });
    };

    file = document.getElementById('uploadImage').files[0];
    reader.readAsBinaryString(file);

}


function addFileInTable(data) {
    console.log(data);
    var $table = $('#glossary-table');
    $table.append($('<tbody/>')
                .append($('<tr/>')
                    .append($('<td/>', {
                            style: "width: 200px",
                            text: data.fileName
                        })
                    ).append("<td style='width: 200px' id='down'><a href='javascript:download22(\"" + data.id + "\")'>Download</a></td>")
    ))
}


function download22(id) {

    console.log(id);

    var x=new XMLHttpRequest();
    x.open("GET", "/download?id="+id, true);
    x.responseType = 'application/json';
    x.onload=function(e){download(x.response, "testjson.json"); }
    x.send();

}

function saveFile(data){
    /*console.log("am in");*/
    download(data, "application/json", "testjson.json");
}


function showAllListFiles() {

    $.ajax({
        url: 'listFiles',
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            var $table = $('#glossary-table');
            $.each(data, function (i, val) {
                $table.append($('<tbody/>')
                    .append($('<tr/>')
                        .append($('<td/>', {
                                style: "width: 200px",
                                text: val.name
                            }
                            )
                        ).append("<td style='width: 200px'><a href='javascript:download22(\"" + val.ida + "\")'>Download</a></td>")
                    )
                )
            });
        }
    });
}