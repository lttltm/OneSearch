'use strict';

var app = angular.module('OneSearchApp', ['ngRoute','ui.autocomplete','ng-pagination','ngResource','LocalStorageModule'])


app.config(function($routeProvider,$httpProvider){
	 
	  //enable CSRF
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
    $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';
    
	  $routeProvider
      .when('/',{
    	  templateUrl : 'scripts/app/home/home.html',
			controller : 'HomeController'
      })
      .when('/result',{
    	  templateUrl : 'scripts/app/result/result.html',
			controller : 'ResultController'
      })
      .when('/login',{
    	  templateUrl : 'scripts/app/login/login.html',
			controller : 'LoginController'
      })
      .otherwise({redirectTo:'/'});
  });

