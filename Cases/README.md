#ElastiCode android Cases example

This is an example of implementing our SDK for Cases service  
The platform is android and the language is JAVA.  
This example also includes “share user info” implementation.

##Requirements:

- You need to integrate our SDK with premium integration
- In order to use the shared information, you need to run the project once with your key and click on “share info”.
- Now go to the dashboard, there you can see the 2 cases that we created by running the app.
- The first case type has 4 states, the second has 7 states
- Go to the first case and add an “apply to all” audience to any state
- Now select any other state and add an audience as follows:
	- In the filters page, select “name” filter
	- configure it: if the “name” is in “david”
- Reorder the rules, place the “name” rule on top of the list.
- Go to the first case and add an “apply to all” audience to any state
- Now select any other state and add an audience as follows:
	- In the filters page, select “name” filter
	- configure it: if the “name” is in “david”
- Reorder the rules, place the “name” rule on top of the list.


##How to use:

1) Put your API key  
2) Run the project    
3) Click on “state index 1” and “state index 2” and see the outputs  
4) Click on “visit1” and “visit2” for visiting the objects   
5) Click on “goalReached1” and “goalReached2”  
6) Click on “share info” button for sharing the information  
7) Repeat (3) and now you will get different result.