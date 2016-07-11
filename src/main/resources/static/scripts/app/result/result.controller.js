'use strict';

angular.module('OneSearchApp')
    .controller('ResultController', function ($scope, $http,queryService) {
    	
    	function loadData(page,size){
    		 console.log(queryService.get());
    		$http.get("api/query?query="+queryService.get()+"&page="+page+"&size="+size)
        	.success(function(data){
        		$scope.results = data.content;
        		console.log(data);
        		$scope.pageCount = data.totalPages;
        	});
    	}
    	
    	
    	$scope.onPageChange = function() {
    		      // ajax request to load data
    		      console.log($scope.currentPage);
    		      loadData($scope.currentPage,10)
    	};

    	loadData(1,10);	
    	

    });