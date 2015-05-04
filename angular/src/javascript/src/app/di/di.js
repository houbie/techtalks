'use strict';

var app = angular.module('spa');

app.service('greetingService', function () {
  this.greeting = 'Hi ixor!';
  this.logGreeting = function () {
    console.log(this.greeting);
  };
});


app.controller('DiCtrl', function ($scope, greetingService) {
  $scope.greeting = greetingService.greeting;
  greetingService.logGreeting();
});
