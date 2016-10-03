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
            url:BASE_URL + '/file/upload',
            securityuri:false,
            fileElementId:'file',
            dataType:'json',
            success:function(data,status){
                if(data != null){
                    if(data.resCode == 1){
                        alert('上传成功!');
                        $('#resPath').text(data.resFilePath);
                        $('#fileimg').empty();
                        $('#fileimg').append('<img src="data:image/png;base64,'+ data.resFile + '" style="width: 200px;height: 200px;border: solid #cccccc 1px;"/>');
                        //$('#fileimg').attr("src","data:image/png;base64," + data.resFile);
                    }else{
                        alert('上传失败!');
                        $('#resPath').text(' ');
                        $('#fileimg').empty();
                        $('#fileimg').append('<img src="data:image/png;base64,'+ 'error' + '" style="width: 200px;height: 200px;border: solid #cccccc 1px;"/>');
                        //$('#fileimg').attr("src","data:image/png;base64,--");
                    }
                }
            },
            error: function (data, status) {
                alert('error');
            }
        })
    });
});
