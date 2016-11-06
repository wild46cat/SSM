/**
 * Created by wuxueyou on 16/10/1.
 */

//angularjs post Request
function baseRequest($httpProvider) {
    // Use x-www-form-urlencoded Content-Type
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

    /**
     * The workhorse; converts an object to x-www-form-urlencoded serialization.
     * @param {Object} obj
     * @return {String}
     */
    var param = function (obj) {
        var query = '', name, value, fullSubName, subName, subValue, innerObj, i;

        for (name in obj) {
            value = obj[name];

            if (value instanceof Array) {
                for (i = 0; i < value.length; ++i) {
                    subValue = value[i];
                    fullSubName = name + '[' + i + ']';
                    innerObj = {};
                    innerObj[fullSubName] = subValue;
                    query += param(innerObj) + '&';
                }
            }
            else if (value instanceof Object) {
                for (subName in value) {
                    subValue = value[subName];
                    fullSubName = name + '[' + subName + ']';
                    innerObj = {};
                    innerObj[fullSubName] = subValue;
                    query += param(innerObj) + '&';
                }
            }
            else if (value !== undefined && value !== null)
                query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
        }

        return query.length ? query.substr(0, query.length - 1) : query;
    };
    // Override $http service's default transformRequest
    $httpProvider.defaults.transformRequest = [function (data) {
        return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
    }];
}

//baseurl
function getRoot() {
    var hostname = location.hostname;
    var pathname = location.pathname;
    var contextPath = pathname.split("/")[1];
    var port = location.port;
    var protocol = location.protocol;
    return protocol + "//" + hostname + ":" + port + "/" + contextPath;
}
var BASE_URL = getRoot();

//getRequestParam
function getRequestParam(param) {
    var requestString = location.search;
    var reg = new RegExp("(?:\\?|&)" + param + "=(.*?)(?:&|$)");
    if (reg.test(requestString)) {
        return decodeURIComponent(RegExp.$1);
    } else {
        return '';
    }
}

//MSG
var MSG_ERROR = '网络连接超时!';
var MSG_LOGINSUCCESS = '登录成功!';
var MSG_LOGINERROR = '用户名或密码错误!';

