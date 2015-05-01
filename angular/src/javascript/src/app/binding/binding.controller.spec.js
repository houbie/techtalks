'use strict';

describe('controllers', function(){
  var scope;

  beforeEach(module('spa'));

  beforeEach(inject(function($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should define more than 5 awesome things', inject(function($controller) {
    expect(scope.foo).toBeUndefined();

    $controller('BindingCtrl', {
      $scope: scope
    });

    expect(scope.foo).toBe('bar');
  }));
});
