#ElastiCode android DynamicObject example

This is an example of implementing our SDK for DynamicObject service  
The platform is android and the language is JAVA.  
This example also includes “share user info” implementation.

##Requirements:

- You need to integrate our SDK with premium integration
- In order to use the shared information, you need to run the project once with your key and click on “share info”.
- Now go to the dashboard, there you can see the 2 dynamicObjects that we created by running the app.
- The first dynamicObject type is “string”, the second is “array of strings” 
- Go to the first dynamicObject and add two more values, “value before share” and “value after share”
- For the first value (“before share”), add an “apply to all” audience
- For the second value (“after share”), add an audience as follows:
	- In the filters page, select “name” filter
	- configure it: if the “name” is in “david”
- Reorder the rules, place the “name” rule on top of the list.
- Go to the second dynamicObject and add two more arrays, “[value,before,share]” and “[value,after,share]”
- For the first array (“before,share”), add an “apply to all” audience
- For the second array (“after,share”), add an audience as follows:
	- In the filters page, select “name” filter
	- configure it: if the “name” is in “david”
- Reorder the rules, place the “name” rule on top of the list.


##How to use:

1) Put your API key  
2) Run the project    
3) Click on “value for1” and “valueFor2” and see the outputs  
4) Click on “visit1” and “visit2” for visiting the objects   
5) Click on “goalReached1” and “goalReached2”  
6) Click on “share info” button for sharing the information  
7) Repeat (3) and now you will get different results
