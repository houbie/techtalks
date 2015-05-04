/**
 * This file uses the Page Object pattern to define the main page for tests
 * https://docs.google.com/presentation/d/1B6manhG0zEXkC-H-tPo2vwU06JhL8w9-XCF9oehXzAQ
 */

'use strict';

var MainPage = function() {
  this.jumbEl = element(by.css('.jumbotron'));
  this.h1El = this.jumbEl.element(by.css('h1'));
  this.imgEl = this.jumbEl.element(by.css('img'));
  this.thumbnailEls = element(by.css('body')).all(by.repeater('awesomeThing in awesomeThings'));


  this.menuBinding = element(by.linkText('Binding'));
  this.input0 = element.all(by.css('input')).get(0);
  this.input1 = element.all(by.css('input')).get(1);
};

module.exports = new MainPage();
