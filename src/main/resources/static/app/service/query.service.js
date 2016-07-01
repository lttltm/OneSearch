angular.module('OneSearchApp')
    .service('queryService',['$http' ,'$rootScope' ,function($http,$rootScope,$q){
    	
    	this.word = '';
    	
    	this.set = function(data){
    		this.word = data;
    	}
    	
    	this.get = function(){
    		return this.word;
    	}
    	
    	return this;
    	
    	
    }]);