'use strict';

angular.module('OneSearchApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


