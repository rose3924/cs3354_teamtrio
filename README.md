The project was written in Java 21
Things needed to run project Eclipse and Node.js
Only certain IP addresses can access the AWS database, so to run it I need your IP address

To Run the Project:
- Open Eclipse
- Open a new workspace with project in it
- Click File > Import > Maven > Existing Maven Projects
- Hit Next then find the Project in your files then click finish
- Then open Command prompt and cd into the Project directory
- Then type npm install bulma into the command prompt (this is to install bulma)
- Click Run > Run Configuration… > double click Maven Build (this should make a new configuration)
- In Base Directory blank press Workspace and click the root directory of the project and click Ok
- Then in the Goals blank type spring-boot:run
- Then press Run
- Check which port the Project is running by looking in the Console Output and finding toward the button saying something similar to “Tomcat started on port 8080 (http)” 
- This should tell your the port it is running on, the default is 8080, make sure the port in the link is correct
- Paste the link below in a browser
- http://localhost:8080/index
 
Hospital Keys:
Texas Health Presbyterian Hospital : THRPH-A-2551-747
Allen Medical City Mckinney : MCH-DAL-4671-8476
Medical City Dallas : MCH-MCK-4671-847
