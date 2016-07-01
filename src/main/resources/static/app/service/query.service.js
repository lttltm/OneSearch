angular.module('OneSearchApp')
    .service('queryService',['$http' ,'$rootScope' ,function($http,$rootScope,$q){
    	
    	
    	this.results = [];
    	
    	this.query = function(query){
    		this.results = [{"id":"4","title":"测试4","content":"测试solr重新索引"},{"id":"3","title":"测试3","content":"正在测试solr上传3！"}]
    	}
    	
    	return this;
    	
    	
    }]);