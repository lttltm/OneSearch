'use strict';
/*global angular */

angular.module('OneSearchApp').
controller('HomeController', 
    function ($scope,$location, $http, queryService) {
	
		$scope.submit = function(){
			queryService.set($scope.query);
			$location.path('/result');
		}
		
	
	  function recommend(response,query) {
		  $http.get("/api/recommend?query="+query)
		  .success(function(data){
			  response($.map(data, function(item) {
					return {
						value : item
					}
				}));
		  });
		  return [];
	  }
    $scope.myOption = {
            options: {
                html: true,
                focusOpen: true,
                onlySelect: true,
                source: function (request, response) {
                    var data = recommend(response,request.term);
//                    data = $scope.myOption.methods.filter(data, request.term);

//                    if (!data.length) {
//                        data.push({
//                            label: 'not found',
//                            value: ''
//                        });
//                    }
//                    // add "Add Language" button to autocomplete menu bottom
//                    data.push({
//                        label: $compile('<a class="ui-menu-add" ng-click="add()">Add Language</a>')($scope),
//                        value: null
//                    });
//                    response(data);
                }
            },
            methods: {}
        };
    });