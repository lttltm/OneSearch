'use strict';

angular.module('OneSearchApp')
    .factory('AuthServerProvider', function loginService($http, localStorageService, $window, $timeout, $q) {
        return {
            login: function(credentials) {
                var data = 'j_username=' + encodeURIComponent(credentials.username) +
                    '&j_password=' + encodeURIComponent(credentials.password) +
                    '&remember-me=' + credentials.rememberMe + '&submit=Login';
                return $http.post('api/authentication', data, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                }).success(function (response) {
                    return response;
                });
            },
            logout: function() {
                // logout from the server
                $http.post('api/logout').success(function (response) {
                    localStorageService.clearAll();
                    // to get a new csrf token call the api
                    $http.get('api/account');
                    return response;
                });
            },
            getToken: function () {
                var token = localStorageService.get('token');
                return token;
            },
            hasValidToken: function () {
                var token = this.getToken();
                return !!token;
            },

            //add for get token   yzd
            getAccessToken:function(){
                var defer = $q.defer();
                console.log("Start get Meta*******************************");
                $http.get('api/accesstoken')
                    .success(function (response) {
                        console.log("Here: Success!===============================");
                        //console.log(response);
                        defer.resolve(response);
                        //return response;
                    });

                console.log(defer.promise);
                return defer.promise;

                //$http({
                //        url:'api/accesstoken',
                //        method:"POST"
                //        //headers: {
                //        //    'Content-Type': 'application/x-www-form-urlencoded',
                //        //    //'Authorization': 'Basic cmVzdGNsaWVudDpjbGllbnRTZWNlcnQ=',
                //        //    'Accept': 'application/json'
                //        //},
                //        //data: postData
                //    }).success(function (response) {
                //    console.log("Here: ===============================");
                //    console.log(response);
                //            return response;
                //        });

            },

            setCredentials:function(){
                //var username = ;
                //var password = ;
                //var authdata = Base64.encode(username + ':' + password);

                //$rootScope.globals = {
                //    currentUser: {
                //        username: username,
                //        authdata: authdata
                //    }
                //};


                //$http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
                $http.defaults.headers.common['Authorization'] = 'Basic ' +'cmVzdGNsaWVudDpjbGllbnRTZWNlcnQ=';
                //$cookieStore.put('globals', $rootScope.globals);

            },

            ajaxcall:function(a)
            {
                var request = new XMLHttpRequest();
                var params = "username=user&password=password&grant_type=password";
                //var url = 'http://localhost:9080/oauth/token';
                var url = 'http://localhost:9080/client';
                request.open('GET', url, true);
                //request.open('POST', url, true);
                request.withCredentials = true;

                //request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                //request.setRequestHeader("Authorization", "Basic cmVzdGNsaWVudDpjbGllbnRTZWNlcnQ=");
                //request.setRequestHeader("Accept", "application/json");
                //request.send(params);
                request.send();

                request.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status ==200) {
                        //print(request.getResponseHeader("Content-Type"));
                        console.log(request.responseText);
                        a(request.responseText);
                        //txt = request.responseText;
                        //return request.responseText;
                    }
                }

            }
        };
    });
