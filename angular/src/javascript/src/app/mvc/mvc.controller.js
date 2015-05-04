'use strict';

var app = angular.module('spa');
app.controller('MvcCtrl', function () {
  this.counter = 0;

  this.increment = function () {
    this.counter += 1;
  };
});

app.controller('MvcCtrlClassic', function ($scope) {
  $scope.counter = 0;

  $scope.increment = function () {
    $scope.counter += 1;
  };
});
