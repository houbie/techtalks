'use strict';

describe('The main view', function () {
  var page;

  beforeEach(function () {
    browser.get('http://localhost:3000/index.html');
    page = require('./main.po');
  });

  it('should include jumbotron with correct data', function() {
    expect(page.h1El.getText()).toBe('\'Allo, \'Allo!');
    expect(page.imgEl.getAttribute('src')).toMatch(/assets\/images\/yeoman.png$/);
    expect(page.imgEl.getAttribute('alt')).toBe('I\'m Yeoman');
      });

  it('list more than 5 awesome things', function () {
    expect(page.thumbnailEls.count()).toBeGreaterThan(5);
  });

  it('test binding page', function () {
    page.menuBinding.click();
    browser.sleep(2000);
    expect(page.input1.getAttribute('value')).toBe('');

    page.input0.sendKeys('abc');
    browser.sleep(2000);
    expect(page.input1.getAttribute('value')).toBe('abc');
  });

});
