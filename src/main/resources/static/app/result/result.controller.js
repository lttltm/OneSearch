'use strict';

angular.module('OneSearchApp')
    .controller('ResultController', function ($scope, $http,queryService) {
    	
    	 $scope.$on( 'result.update', function( event ) {
    		 $scope.results = queryService.results;
    	     $scope.$apply();//注意，原文这里少了这一行
    	 });
    	$scope.results = queryService.results;
    	
    	
    });