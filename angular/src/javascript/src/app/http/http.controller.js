'use strict';

var app = angular.module('spa');
app.controller('HttpCtrl', function ($scope, $http) {
  $scope.refresh = function () {
    $scope.weather = $http.get('http://api.openweathermap.org' +
    '/data/2.5/weather?zip=2800,be')
      .success(function (data) {
        $scope.weather = data.weather[0].description;
      });
  };
});
