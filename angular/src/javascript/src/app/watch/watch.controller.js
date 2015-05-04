'use strict';

var app = angular.module('spa');
app.controller('WatchCtrl', function ($scope) {
  $scope.phone = '+3212345644';

  $scope.$watch('phone.length', function (phoneLength) {
    console.log('phone length changed', phoneLength);
    if (phoneLength < 12) {
      $scope.phone += '0';
    }
  });
});
