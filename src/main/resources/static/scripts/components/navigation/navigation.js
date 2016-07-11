angular.module('OneSearchApp')
	.controller('navigation', function($scope, $location) {
		
		$scope.tab = function(viewLocation){
			return viewLocation === $location.path()
		}
		
});