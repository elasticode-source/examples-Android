#ElastiCode android AppTriggers with Events example

This is an example of implementing our SDK for AppTriggers service with Events  
The platform is android and the language is JAVA.

##Requirements:

- You need to integrate our SDK with premium integration
- In order to add the event and select it from the dashboard, you will have to run the app once with your key.
- When the app in on, click on the “send an event” button once so the system will catch the event.
- Now go to the dashboard and create two experiences for this example
- In the first experience, add this text “experience before event”
- In the second experience, add this text “experience after event”
- Add an appTrigger, name it “appTriggerAfterEvent”
- Attach the experiences you created to the appTrigger
- Add an “apply to all” audience for the first experience.
- For the second experience, add an “event” audience:
     - in the filters page, select “show app trigger” event
     - Configure the event: if the user visited “show app trigger” event at least 3 times in current session
- Reorder the rules, place the “event” rule on the top of the list

##How to use:

1) Put your API key  
2) Run the project    
3) click on the “show” button to see the appTrigger before the event  
4) Close the app trigger  
5) Send the event 3 times   
6) Click “show” again -> experience after event appears.