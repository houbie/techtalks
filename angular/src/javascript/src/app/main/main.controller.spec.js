'use strict';

describe('controllers', function(){
  var scope;
  beforeEach(module('spa'));
  beforeEach(inject(function($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should have awesome things', inject(function($controller) {
    expect(scope.awesomeThings).toBeUndefined();
    $controller('MainCtrl', {
      $scope: scope
    });
    expect(angular.isArray(scope.awesomeThings)).toBeTruthy();
    expect(scope.awesomeThings.length > 5).toBeTruthy();
  }));
});
