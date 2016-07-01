'use strict';

var app = angular.module('OneSearchApp', ['ngRoute','ui.autocomplete'])


app.config(function($routeProvider){
	  console.log($routeProvider);
	  $routeProvider
      .when('/',{
    	  templateUrl : 'app/home/home.html',
			controller : 'HomeController'
      })
      .when('/result',{
    	  templateUrl : 'app/result/result.html',
			controller : 'ResultController'
      })
      .when('/printers',{template:'这是打印机页面'})
      .otherwise({redirectTo:'/'});
  });

