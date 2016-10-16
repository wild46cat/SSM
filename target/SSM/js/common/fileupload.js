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
                        //ie8下,上传如果文件过大,渲染不出来
                        //$('#img').attr("src","data:image/jpg;base64," + data.resFile);
                        alert('上传成功!');
                        $('#resPath').text(data.resFilePath);
                    } else {
                        var errorPath = BASE_URL + '/img/404.jpg';
                        $('#img').attr("src",errorPath);
                        alert('上传失败!');
                        $('#resPath').text(' ');
                    }
                }
            },
            error: function (data, status) {
                alert('error');
            }
        });
    });
});
