'use strict';

angular.module('spa', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngResource', 'ui.router', 'ui.bootstrap'])
  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'app/main/main.html',
        controller: 'MainCtrl'
      })
      .state('binding', {
        url: '/binding',
        templateUrl: 'app/binding/binding.html',
        controller: 'BindingCtrl'
      });

    $urlRouterProvider.otherwise('/');
  })
;
