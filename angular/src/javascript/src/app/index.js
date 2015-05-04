'use strict';

angular.module('spa', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngResource', 'ui.router', 'ui.bootstrap', 'xeditable'])
  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'app/main/main.html',
        controller: 'MainCtrl'
      })
      .state('mvc', {
        url: '/mvc',
        templateUrl: 'app/mvc/mvc.html'
      })
      .state('binding', {
        url: '/binding',
        templateUrl: 'app/binding/binding.html'
      })
      .state('editable', {
        url: '/editable',
        templateUrl: 'app/editable/editable.html'
      })
      .state('watch', {
        url: '/watch',
        templateUrl: 'app/watch/watch.html',
        controller: 'WatchCtrl'
      })
      .state('di', {
        url: '/di',
        templateUrl: 'app/di/di.html',
        controller: 'DiCtrl'
      })
      .state('http', {
        url: '/http',
        templateUrl: 'app/http/http.html',
        controller: 'HttpCtrl'
      });

    $urlRouterProvider.otherwise('/');
  })
;
