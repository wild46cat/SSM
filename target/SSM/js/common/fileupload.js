/**
 * Created by wuxueyou on 16/10/1.
 */
var fileuploadapp = angular.module('fileupload', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

fileuploadapp.controller('fileuploadController', function ($scope) {
    $scope.test = "aabbcc";
    $('#resPath').text(' ');
    $('#ajaxUpload').click(function () {
        $.ajaxFileUpload({
            url: BASE_URL + '/file/upload',
            securityuri: false,
            fileElementId: 'file',
            dataType: 'json',
            timeout:30000,
            success: function (data, status) {
                if (data != null) {
                    if (data.resCode == 1) {
                        var path = BASE_URL + data.resFilePath;
                        $('#img').attr("src",path);
                        //alert('上传成功!');
                        //console.log(data);
                        $('#resPath').text(data.resFilePath);
                        //$('#fileimg').append('<img src="data:image/png;base64,'+ data.resFile + '" style="width: 200px;height: 200px;border: solid #cccccc 1px;"/>');
                    } else {
                        var errorPath = BASE_URL + '/img/404.jpg';
                        $('#img').attr("src",errorPath);
                        alert('上传失败!');
                        console.log(data);
                        $('#resPath').text(' ');
                        //$('#fileimg').append('<img src="data:image/png;base64,'+ 'error' + '" style="width: 200px;height: 200px;border: solid #cccccc 1px;"/>');
                    }
                }
            },
            error: function (data, status) {
                alert('error');
                //console.log(data);
            }
        });
    });
});
