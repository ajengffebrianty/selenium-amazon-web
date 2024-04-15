# Automation Testing Selenium for Amazon Web Store

## Introduction

This repository contains my attempt to automate testing procedures for purchasing a TV product on Amazon's web store. The test script utilizes Selenium, a popular automation tool for web browsers, to simulate user interactions and verify functionalities.

## Test Flow

1. **Launch:** Use Selenium based tools to launch the application.
2. **Navigate:** Open the browser and navigate to the site.
3. **Select Department:** Navigate to the left sidebar, select for products by department “electronics” and then “television & video”.
4. **Refine Search:** Select the “televisions” then select “32 inches & under” from the left side refinery.
5. **Sort Items:** From appearing search results, navigate to the sorting dropdown and sort the items by price descending.
6. **Product Selection:** Click on the product link for the first product in search result and go to the product page.
7. **Add to List:** Click on ‘add to list’.
8. **Sign In Verification:** Verify if the Sign In page is showing up (since users haven’t logged in yet).
9. **Invalid Sign In Attempt:** Enter some random username and submit. Assert the error appearance then get the text from that error.
10. **Close Application:** Finally, close the application and end the test.

