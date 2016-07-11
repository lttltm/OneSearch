'use strict';

angular.module('OneSearchApp')
    .controller('LoginController' , function ($location, $scope, $timeout,Auth) {
        $scope.user = {};
        $scope.errors = {};

        $scope.rememberMe = true;
        $timeout(function (){angular.element('[ng-model="username"]').focus();});
        $scope.login = function (event) {
            event.preventDefault();
            Auth.login({
                username: $scope.username,
                password: $scope.password,
                rememberMe: $scope.rememberMe
            }).then(function () {
                $scope.authenticationError = false;
                $location.path('/');
            }).catch(function () {
                $scope.authenticationError = true;
            });
        };
    });
