'use strict';

angular.module('OneSearchApp')
    .controller('ResultController', function ($scope, $http,queryService) {
    	
    	$http.get("api/query?query="+queryService.get())
    	.success(function(data){
    		$scope.results = data.content;
    	});
    	
    	
    });