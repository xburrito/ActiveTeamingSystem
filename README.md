# Active Teaming System

**Csc 32200 - Software Engineering Final Project**

Team Q Participants:

- Gabriel Espinoza (**RECEIVE ALL BONUS POINTS**)
- Albert Chang
- Orion Cadri
- Ide

-----

1. [Phase 1 - Team Spec Report](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/documentation/Team%20Q%20-%20Phase%20II.pdf) {Pages: 1 - 17}

2. [Phase 2 - Design Report](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/documentation/Team%20Q%20-%20Phase%20II.pdf) {Pages: 18 - EOF}

3. [Phase 3 - Demo] {Complete}

4. [Phase 4 - Debugging] {Complete}

5. [Phase 5 - Final Report] {Complete}

------
### Prepare and Run:
1. Clone this git and go to directory:

``
$ git clone https://github.com/ZGabriell/ActiveTeamingSystem && cd ActiveTeamingSystem
``

2. Compile and run

3. At the login window, click register underneath to create an account. **{If you already have one, skip to part 7}**

4. Fill out registration form. Make sure reference is valid and properly paired with their status and hit register now.

5. NOTE: in order to register, the email used to register with must be a referral email. To virtually create a referral email, go to: ./src/Database/Referral.txt and append on the next line the desired **[Referrer's username (Found in User.csv), Referrer's rank, Your desired registration e-mail]**

6. Once registration form has been successfully processed, a pop-up notifies you that the SU will review your application and either approve or reject it. **If approved, your application will be appended to the User.csv database and you will be able to log in as a OU or VIP depending on initial given reputation score.**

(**To approve of application, go and login to - User: adminOU@gmail.com / Password: root, enter messages, and click approve application. Applicant should now be able to login with registered credentials.**)

7. At the home screen, OU and VIP should be able to view other user profiles, messages, the groups they are actively participating in, projects, meeting poll pages as well as the settings option to change their username and/or password. At the home screen, users should be able to interact with other users through messaging, sending collaboration requests as well as compliment to raise the receiving party's reputation score. 

8. Clicking the logOut button on the left column will prompt a sign up pop-up. Upon confirming, you will be redirected to the browse page where you can view the top profiles as well as the top teams. Top left corner **Go Back** will redirect you to the login page. 

-----

### Software Usage

Based on the user's status, they will have access to a variety of activities available on the software.
Some activities are:

- **Browse** - View the top profiles as well as top projects. There is an option on the right side to expand for more results.
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.24.50%20PM.png?raw=true)
- **Register** - Provides a form asking basic information: Name, Email, D.O.B. and referral. Make sure registering email has been referred first before creating an account with that email.
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.23.23%20PM.png?raw=true)
- **log in** - To gain login access, upon registering, have the SU approve of the application in order to be able to log in. The SU should receive a message to stamp an approval on the applicant's request.
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.23.11%20PM.png?raw=true)
- **Home Menu** - You should be able to send a message, send a collaboration request, as well as compliment over the highlighted user of choice. 
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.27.22%20PM.png?raw=true)
- **Messages** - You should be able to view messages in your inbox. 
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.27.30%20PM.png?raw=true)
- **Groups** - You can highlight a group and schedule a meeting (Currently lacks functionality)
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.27.44%20PM.png?raw=true)
- **Projects** - Will be properly displayed. (Lacks functionality to keep specific ones private)
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.24.30%20PM.png?raw=true)
- **Create poll** - If meeting polls are present, you can accept or reject time suggested. 
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.24.35%20PM.png?raw=true)
- **Vote** - (Currently lacks functionality)
- **Increase reputation** - (Currently lacks functionality)
![picture](https://github.com/ZGabriell/ActiveTeamingSystem/blob/master/screenshots/Screen%20Shot%202020-05-13%20at%2011.27.22%20PM.png?raw=true)
