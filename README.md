# automation
Framework Highlights
----------------------
This is Page object model framework. It uses Java, TestNg,Maven,Extent Reports

Features includeded
--------------------
1. Page Object model
2. Log4j
3. Extent Reports
4. Read configuration from properites file
5. Utils ( Basic Read data from Excel, Http getResponse method to check response of broken links etc)
6. Proritization using TestNG
7. Easily add common methods
8. Added Listerners and easily update in the future
9. Maven ( easily add dependencies using maven in future)
10. Easily Run from command line with testng command line syntax
11. When test fail it will skip the remainging execution , we have achieved this using testNG annotations


Test Steps covered in this Demo repo:

1) Launch browser
2) Search for product TV ( I will make this step dynamic, we can pass any product in the arugument)
3) filter product with Screen size ( I will make this function also  dynamic, we can pass any scrren size to the locator)
4) Added First item to the cart which is having the facility to add cart
5) Verify the Items added to the Cart


Cons with my test Case (i have covered only happy flow)
------------------------------------------------------------------------
1. I have not validated that search returning any results or not. We can add a check point to validate the search results and procedeed only if we have search  results >0
2. After filtering I have not added to check point to validate the search results 
