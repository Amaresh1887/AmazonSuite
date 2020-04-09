$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Search.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Search Product"
    }
  ],
  "line": 4,
  "name": "Search Scenario",
  "description": "",
  "id": "search-scenario",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@loginTest"
    }
  ]
});
formatter.before({
  "duration": 20784097900,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Scroll to the product",
  "description": "",
  "id": "search-scenario;scroll-to-the-product",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@MidProduct"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "User already login to Amazon app",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "enter \"65 inch TV\" Product name in Search Box",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "click on Search in Search page",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "user scroll to the mid of the product",
  "keyword": "Then "
});
formatter.match({
  "location": "Search.user_already_login_to_Amazon_app()"
});
formatter.result({
  "duration": 32925153700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "65 inch TV",
      "offset": 7
    }
  ],
  "location": "Search.enter_Product_name_in_Search_Box(String)"
});
formatter.result({
  "duration": 27712198200,
  "status": "passed"
});
formatter.match({
  "location": "Search.click_on_Search_in_Search_page()"
});
formatter.result({
  "duration": 164666200,
  "status": "passed"
});
formatter.match({
  "location": "Search.user_scroll_to_the_mid_of_the_product()"
});
formatter.result({
  "duration": 22273093600,
  "status": "passed"
});
});