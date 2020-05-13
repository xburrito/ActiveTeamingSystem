package Model;

import java.io.*;
import java.util.*;

public class ActiveTeamingSystem {
    // ArrayList, holds all data from user database
    private List<User> userDB;
    // ArrayList, holds all data from group database
    private List<Group> groupDB;
    // ArrayList, holds top profiles
    private List<TopProfile> topProfilesList;
    // ArrayList, holds profiles for displayal
    private List<TopProfile> profileList;
    // ArrayList, holds projects for displayal
    private List<Project> projectDB;
    // Logged in User
    private User loggedUser;
    // group of Logged in user
    private Group loggedUserGroup;
    // BlackList List
    //private List<User> blackList;
    // Rejected Applications List
    //private List<User> rejectedList;
    // ArrayList, holds all data from group database
    private List<Referral> referralDB;

    // ArrayList, holds all data from group database
    private List<Poll> pollDB;

    // ArrayList, holds all data from group database
    private List<User> blackList;

    // External files paths
    String applicationDBFilePath ="src/Database/Application.txt";
    String groupDBFilePath = "src/Database/Groups.csv";
    String messagesDBFilePath ="src/Database/Messages.txt";
    String projectDBFilePath ="src/Database/Project.txt";
    String referralDBFilePath ="src/Database/Referral.txt";
    String userDBFilePath = "src/Database/User.csv";
    String pollDBFilePath = "src/Database/Poll.csv";
    String blacklistDBFilePath = "src/Database/Blacklist.csv";

    // default constructor
    public ActiveTeamingSystem(){
        // initialize userDB
        userDB = new ArrayList<User>();
        // initialize groupDB
        groupDB = new ArrayList<Group>();
        // initialize topProfilesList
        topProfilesList = new ArrayList<TopProfile>();
        // initialize profileList
        profileList = new ArrayList<TopProfile>();
        // initialize hashmap to hold the messages and notification of each user
        messagesDB = new HashMap<String, Deque<Message>>();
        // initialize hashmap to hold the applications of visitors
        applicationDB = new HashMap<String, Deque<Application>>();
        // initalize projectDB
        projectDB = new ArrayList<Project>();
        // initialize referralDB
        referralDB = new ArrayList<Referral>();
        // initialize pollDB
        pollDB = new ArrayList<Poll>();
        // initialize blacklist
        blackList = new ArrayList<User>();

    }

    public List<Project> getProjectDB() {
        return projectDB;
    }

    public List<Referral> getReferralDB() {
        return referralDB;
    }

    public List<Poll> getPollDB() {
        return pollDB;
    }

    public List<User> getBlackList() {
        return blackList;
    }

    public List<Project> getProjectList() {
        return projectDB;
    }

    public void setProjectList(List<Project> projectDB) {
        this.projectDB = projectDB;
    }

    // hashmap to hold the messages and notification of each user
    private HashMap<String, Deque<Message>> messagesDB;

    // hashmap to hold the applications of visitors
    private HashMap<String, Deque<Application>> applicationDB;

    public List<User> getUserDB() {
        return userDB;
    }

    public void setUserDB(List<User> userDB) {
        this.userDB = userDB;
    }

    public List<Group> getGroupDB() {
        return groupDB;
    }

    public void setGroupDB(List<Group> groupDB) {
        this.groupDB = groupDB;
    }

    public void setTopProfilesList(List<TopProfile> topProfilesList) {
        this.topProfilesList = topProfilesList;
    }

    public List<TopProfile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<TopProfile> profileList) {
        this.profileList = profileList;
    }

    public void setMessagesDB(HashMap<String, Deque<Message>> messagesDB) {
        this.messagesDB = messagesDB;
    }

    public HashMap<String, Deque<Application>> getApplicationDB() {
        return applicationDB;
    }

    public void setApplicationDB(HashMap<String, Deque<Application>> applicationDB) {
        this.applicationDB = applicationDB;
    }

    // get messagesDB
    public HashMap<String, Deque<Message>> getMessagesDB() {
        return messagesDB;
    }

    // find and get list of messages from passed user
    public List<Message> getMessagesList(String userID) {
        List<Message> messageList = new LinkedList<Message>();

        // iterate dictionary (HashMap) and deque for the userID
        if(messagesDB.containsKey(userID)) {
            // iterate message deque
            Iterator<Message> iterator = messagesDB.get(userID).iterator();
            while (iterator.hasNext()) {
                Message currentMessage = (Message) iterator.next();
                // add application into applicationList
                messageList.add(currentMessage);
            }
            // returns messageList
            return messageList;
        } // else no messages found
        System.out.println("no messages found for " + userID);
        return null;
    }

    // find and get deque of Application from passed applicant
    public List<Application> getApplicationList() {
        List<Application> applicationList = new LinkedList<Application>();

        // iterate dictionary (HashMap) and deque for the applicantID
        if(!applicationDB.isEmpty()) {
            Iterator it = applicationDB.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                // iterate application deque
                Iterator<Application> iterator = applicationDB.get(pair.getKey()).iterator();
                while (iterator.hasNext()) {
                    Application currentApplication = (Application) iterator.next();
                    // add application into applicationList
                    applicationList.add(currentApplication);
                }
            }

            // returns found deque of Application from specified applicant
            return applicationList;
        } // else no Applications found
        System.out.println("no Applications found");
        return null;
    }


//    // find and get messages from passed user
//    public double getMessagesList(int userID) {
//
//        // iterate dictionary (HashMap) and deque for the userID
//        if(messagesDB.containsKey(userID)) {
//            // iterate coin deque
//            Iterator<Message> iterator = messagesDB.get(message).iterator();
//            while (iterator.hasNext()) {
//                Message currentMessage = (Message) iterator.next();
//                if (currentMessage.getTradeId() == tradeId) {
//                    return currentMessage.getQunatity().doubleValue();
//                }
//            }
//        }
//        //System.out.println("no holdings found for " + coin);
//        return 0;
//    }


    // add user into userDB, (it adds users sorted from lowest to highest reputations score)
    public void addUser(String dayOfBirth, String dateJoined, int userID, String password, String email, String username, String lastName, String firstName, int repScore, String status) {
        // new repScore
        int newRepScore = repScore;
        //System.out.println(repScore);
        // if the userBD already has records
        if (!userDB.isEmpty()) {

            // loop through all elements
            for (int i = 0; i < userDB.size(); i++) {
                // if the element you are looking at is bigger than x, go to the next element
                if (userDB.get(i).getRepScore() > newRepScore)
                    continue;
                else
                    // otherwise, we have found the location to add x
                    userDB.add(i,new User(dayOfBirth, dateJoined, userID, password, email, username, lastName, firstName, repScore, status));
                    return;
            }
            // we looked through all of the elements, and they were all smaller than x, so we add ax to the end of the list
            userDB.add(new User(dayOfBirth, dateJoined, userID, password, email, username, lastName, firstName, repScore, status));
            return;
        }
        // simply add the new record
        userDB.add(new User(dayOfBirth, dateJoined, userID, password, email, username, lastName, firstName, repScore, status));
    }

    // add Group into groupDB, (it adds groups sorted from lowest to highest reputations score)
    //Group_ID,Group_Name,Group_Leader,Member_Count
    public void addGroupToDB(String groupID, String groupName, String groupLeader, List<User> groupMembersList) {
        // simply add the new record
        groupDB.add(new Group(groupID, groupName, groupLeader, groupMembersList));
    }

    // add Group into projectDB, (it adds groups sorted from lowest to highest reputations score)
    public void addProjectToDB(String projectName, String projectGroup, int projectScore) {
        // simply add the new record
        projectDB.add(new Project(projectName,projectGroup,projectScore));
    }

    // remove a user from the userDB
    public User removeUser(int userID) {
        User removed = null;

        for (int i=0; i<userDB.size();i++) {
            if (userDB.get(i).getUserID() == userID) {
                removed = userDB.remove(i);
            }
        }
        return removed;
    }

    // remove a group from the groupDB
    public Group removeGroup(String groupID) {
        Group removed = null;

        for (int i=0; i<groupDB.size();i++) {
            if (groupDB.get(i).getGroupID() == groupID) {
                removed = groupDB.remove(i);
            }
        }
        return removed;
    }


    // Reads file and loads the data into userDB
    // database columns: D.O.B.,Date Joined,User_ID,Password (Not Hashed Yet),Email,Username,Last_Name,First_Name,Rep_Score,Status
    public void loadFileToUserDB() throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(userDBFilePath));

            // skip first line (column names)
            //inputFile.nextLine();

            // while there is another line in the file
            while (inputFile.hasNextLine()) {
                // get line
                String currentLine = inputFile.nextLine();
                //System.out.println(currentLine + "CurrentLine: " + currentLine); // for debugging
                if (!currentLine.equals("")) {
                    // split line
                    String[] userRecords = currentLine.split(",");
                    //System.out.println(userRecords.length); // for debugging

                    // get all values
                    String dateOfBirth = userRecords[0];
                    String dateJoined = userRecords[1];
                    int userID = Integer.parseInt(userRecords[2]);
                    String password = userRecords[3];
                    String email = userRecords[4];
                    String username = userRecords[5];
                    String lastName = userRecords[6];
                    String firstName = userRecords[7];
                    int repScore = Integer.parseInt(userRecords[8]);
                    String status = userRecords[9];

                    // add into userDB
                    addUser(dateOfBirth, dateJoined, userID, password, email, username, lastName, firstName, repScore, status);
                }
            }
            // close scanner
            inputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // Reads file and loads the data into groupDB
    public void loadFileToGroupDB() throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(groupDBFilePath));

            // skip first line (column names)
            //inputFile.nextLine();

            // while there is another line in the file
            while (inputFile.hasNextLine()) {
                // get line
                String currentLine = inputFile.nextLine();
                //System.out.println(currentLine + "CurrentLine: " + currentLine); // for debugging
                if (!currentLine.equals("")) {
                    // split line
                    String[] groupRecords = currentLine.split(",");
                    //System.out.println(userRecords.length); // for debugging

                    // get all values
                    String groupID = groupRecords[0];
                    String groupName = groupRecords[1];
                    String groupLeader = groupRecords[2];
                    List<User> membersList = converToMembersList(groupRecords[3]);

                    // add into groupDB
                    addGroupToDB(groupID, groupName, groupLeader, membersList);
                }
            }
            // close scanner
            inputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // Reads file and loads the applications into applicationDB
    public void loadFileToApplicationDB() throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(applicationDBFilePath));

            // skip first line (column names)
            //inputFile.nextLine();

            // while there is another line in the file
            while (inputFile.hasNextLine()) {
                // get line
                String currentLine = inputFile.nextLine();
                //System.out.println(currentLine + "CurrentLine: " + currentLine); // for debugging
                if (!currentLine.equals("")) {
                    // split line
                    String[] applicationRecords = currentLine.split(",");
                    //System.out.println(userRecords.length); // for debugging

                    String submissionDate = applicationRecords[0];
                    String applicantName = applicationRecords[1];
                    String applicantEmail = applicationRecords[2];
                    String applicantDOB = applicationRecords[3];
                    String applicantUsername = applicationRecords[4];
                    String applicantPassword = applicationRecords[5];
                    String applicantReferrer = applicationRecords[6];
                    String applicantReferrerStatus = applicationRecords[7];

                    // add into applicationDB
                    addApplicationToDB(new Application(submissionDate, applicantName, applicantEmail, applicantDOB,applicantUsername, applicantPassword, applicantReferrer,applicantReferrerStatus));
                }
            }
            // close scanner
            inputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // Reads file and loads the message into messagesDB
    public void loadFileToMessageDB() throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(messagesDBFilePath));

            // skip first line (column names)
            //inputFile.nextLine();

            // while there is another line in the file
            while (inputFile.hasNextLine()) {
                // get line
                String currentLine = inputFile.nextLine();
                //System.out.println(currentLine + "CurrentLine: " + currentLine); // for debugging
                if (!currentLine.equals("")) {
                    // split line
                    String[] messageRecords = currentLine.split(",");
                    //System.out.println(userRecords.length); // for debugging

                    // get all values
                    String messageType = messageRecords[0];
                    String messageDate = messageRecords[1];
                    String senderUsername = messageRecords[2];
                    String receiverUsername = messageRecords[3];
                    String Note = messageRecords[4];

                    // add into messageDB
                    addMessageToDB(new Message(messageType, messageDate, senderUsername, receiverUsername,Note));
                }
            }
            // close scanner
            inputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }



    // saves new user into external file
    public void saveUserToFile(String dateOfBirth, String dateJoined, int userID, String password, String email, String username, String lastName, String firstName, int repScore, String status) throws IOException {

        try {
            String filePath = "src/Database/Groups.csv";
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(filePath, true));

            // double to string
            //String quantityStr = String.valueOf(quantity);
            //String tradeId = String.valueOf(id);

            // LATER CHECK IF WE CAN PASS INTS DIRECTLY INTO STRING WITHOUT CONVERTING IT TO STRING FIRST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // format word string
            String newUser = dateOfBirth + "," + dateJoined + "," +  userID + "," + password + "," + email + "," + username + "," + lastName + "," + firstName + "," + repScore + "," + status;
            // write word to file
            outputFile.newLine(); // select next line
            outputFile.write(newUser); // write word

            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // writes the complete userDB to the user database external file
    public void saveUserDBToFile() throws IOException {
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(userDBFilePath));

            for (int i =0; i< userDB.size(); i++) {
                // current user
                User currentUser = userDB.get(i);

                // get fields
                String dateOfBirth = currentUser.getDOB();
                String dateJoined = currentUser.getDateJoined();
                String userID = String.valueOf(currentUser.getUserID());
                String password = currentUser.getPassword();
                String email = currentUser.getEmail();
                String username = currentUser.getUserName();
                String lastName = currentUser.getLastName();
                String firstName = currentUser.getFirstName();
                String repScore = String.valueOf(currentUser.getRepScore());
                String status = currentUser.getStatus();

                // format user properties to string
                String userStr = dateOfBirth + "," + dateJoined + "," + userID + "," + password + "," + email + "," + username + "," + lastName + "," + firstName + "," + repScore + "," + status;

                // write the string
                outputFile.newLine(); // select next line
                outputFile.write(userStr); // write word
            }

            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // writes the complete groupDB to the groups database external file
    public void saveGroupDBToFile() throws IOException {
        // ok when we remove a group from our groupDB the user is also removed from the external group database
        // so I just have to make a copy of the database and overwrite the external file.
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(groupDBFilePath));

            for (int i =0; i< groupDB.size(); i++) {
                // current group
                Group currentGroup = groupDB.get(i);

                // get fields
                String groupID = String.valueOf(currentGroup.getGroupID());
                String groupName = currentGroup.getGroupName();
                String groupLeader = currentGroup.getGroupLeader();
                String groupMembersList = currentGroup.membersToString();

                // format group properties to string
                String groupStr = groupID + "," + groupName + "," + groupLeader + "," + groupMembersList;

                // write the string
                outputFile.newLine(); // select next line
                outputFile.write(groupStr); // write word
            }

            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // writes the complete messageDB to the message database external file
    public void saveMessageDBToFile() throws IOException {
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(messagesDBFilePath));

            // iterate dictionary (HashMap) and deque for the applicantID
            if(!messagesDB.isEmpty()) {
                Iterator it = messagesDB.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    // iterate message deque
                    Iterator<Message> iterator = messagesDB.get(pair.getKey()).iterator();
                    while (iterator.hasNext()) {

                        // currentMessage
                        Message currentMessage = (Message) iterator.next();

                        // get fields
                        String messageType = currentMessage.getMessageType();
                        String messageDate= currentMessage.getMessageDate();
                        String senderUsername= currentMessage.getSenderUsername();
                        String receiverUsername= currentMessage.getReceiverUsername();
                        String Note= currentMessage.getNote();

                        // format message properties to string
                        String groupStr = messageType + "," + messageDate + "," + senderUsername + "," + receiverUsername + "," + Note;

                        // write the string
                        outputFile.newLine(); // select next line
                        outputFile.write(groupStr); // write word
                    }
                }
            }
            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // writes the complete applicationDB to the application database external file
    public void saveApplicationDBToFile() throws IOException {
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(applicationDBFilePath));

            // iterate dictionary (HashMap) and deque for the applicantID
            if(!applicationDB.isEmpty()) {
                Iterator it = applicationDB.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    // iterate application deque
                    Iterator<Application> iterator = applicationDB.get(pair.getKey()).iterator();
                    while (iterator.hasNext()) {

                        // currentApplication
                        Application currentApplication = (Application) iterator.next();

                        // get fields
                        String submissionDate = currentApplication.getSubmissionDate();
                        String applicantName = currentApplication.getApplicantName();
                        String applicantEmail = currentApplication.getApplicantEmail();
                        String applicantDOB = currentApplication.getApplicantDOB();
                        String applicantUsername = currentApplication.getApplicantUsername();
                        String applicantPassword = currentApplication.getApplicantPassword();
                        String applicantReferrer = currentApplication.getApplicantReferrer();
                        String applicantReferrerStatus = currentApplication.getApplicantReferrerStatus();

                        // format application properties to string
                        String groupStr = submissionDate + "," + applicantName + "," + applicantEmail + "," + applicantDOB + "," + applicantUsername+ "," + applicantPassword + "," + applicantReferrer + "," + applicantReferrerStatus;

                        // write the string
                        outputFile.newLine(); // select next line
                        outputFile.write(groupStr); // write word
                    }
                }
            }
            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // writes the complete ReferralDB to the Referral database external file
    public void saveReferralDBToFile() throws IOException {
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(referralDBFilePath));

            for (int i =0; i< referralDB.size(); i++) {
                // current group
                Referral currentReferral = referralDB.get(i);

                // get fields
                String referrerUsername = currentReferral.getReferrerUsername();
                String referrerStatus = currentReferral.getReferrerStatus();
                String referrerInviteeEmail = currentReferral.getReferrerinviteeEmail();

                // format group properties to string
                String referralStr = referrerUsername + "," + referrerStatus + "," + referrerInviteeEmail;

                // write the string
                outputFile.newLine(); // select next line
                outputFile.write(referralStr); // write word
            }

            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }


    // adds all profiles to profile list, for home displayal
    public void addProfilesToList (){
        for (User user : userDB) {
            TopProfile profile = new TopProfile(user.getUserName(), user.getRepScore(), user.getStatus());
            System.out.println(user.getUserName());
            System.out.println(user.getRepScore());
            System.out.println(user.getStatus());
            profileList.add(profile);
        }
    }

    // get profiles
    public List<TopProfile> getProfiles() {
        return profileList;
    }



    // prints user DB
    public void printUserDB(){
        for (User user : userDB) {
            System.out.println(user.toString());
        }
    }

    // prints group DB
    public void printGroupDB(){
        for (Group group : groupDB) {
            System.out.println(group.toString());
        }
    }

    // SETTERS

    // sets loggedUser
    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    // sets the loggedUserGroup
    public void setLoggedUserGroup(Group loggedUserGroup) {
        this.loggedUserGroup = loggedUserGroup;
    }

    // GETTERS

    // gets the user who currently logged in the system
    public User getLoggedUser() {
        return loggedUser;
    }

    // gets the group of the user who currently logged in the system
    public Group getLoggedUserGroup() {
        return loggedUserGroup;
    }

    // gets User Database
    public List<User> getUserBD() {
        return userDB;
    }

    // gets Group Database
    public List<Group> getGroupBD() {
        return groupDB;
    }

    // get topProfilesList
    public List<TopProfile> getTopProfilesList() {
        return topProfilesList;
    }

    // adds 3 top profiles to topProfilesList
    public void addTopProfilesToList() {
        // size of topProfilesList
        int sizeList = topProfilesList.size();

        // if topProfilesList already contains records add next 3
        if (!topProfilesList.isEmpty()){
            // start searching after already stored elements
            for (int i = sizeList; i < sizeList+3; i++) {
                // first check if all items are already in the top list
                if (!(userDB.size() == topProfilesList.size())) {
                    User currentUser = userDB.get(i);
                    String username = currentUser.getUserName();
                    int repScore = currentUser.getRepScore();
                    String status = currentUser.getStatus();

                    // add current user into top list
                    topProfilesList.add(new TopProfile(username,repScore,status));
                }
            }
        } else {
            // simply add the first 3 profiles
            for (int i = 0; i < 3; i++) {
                User currentUser = userDB.get(i);
                String username = currentUser.getUserName();
                int repScore = currentUser.getRepScore();
                String status = currentUser.getStatus();
                topProfilesList.add(new TopProfile(username, repScore, status));
            }
        }
        //Collections.reverse(topProfilesList);
    }

    // Credential Authentication
    public boolean authenticateCredentials(String email, String password){
        // search userDB for user
        for (User user : userDB) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                // found user is now loggedUser
                loggedUser = user;
                return true;
                //System.out.println(loggedUser.toString());
            }
        }// user not found
        return false;
    }

    // stores messages into messages database

    // stores application into application database
    public void addApplicationToDB(Application newApplication) {

        // generate application Id from email and DOB
        String applicationID = newApplication.getApplicantEmail() + "-" + newApplication.getApplicantDOB();

        // check if applicant already has a previous application on the system "applicationDB"
        if(applicationDB.containsKey(applicationID)) {
            // add application into existing applicationDB deque
            applicationDB.get(applicationID).add(newApplication);
        } else { // store new application
            // create new application deque for new application
            Deque<Application> applicationDeque = new LinkedList<Application>();
            // add new applicationDB into deque
            applicationDeque.add(newApplication);
            // add (key/application) and (deque/value) to "Dictionary"
            applicationDB.put(applicationID, applicationDeque);
        }
    }

    // stores message into message database
    public void addMessageToDB(Message newMessage) {

        // applicationID = receiver username
        String messageId = newMessage.getReceiverUsername();

        // check if receiver already has a previous message on the system "applicationDB"
        if(messagesDB.containsKey(messageId)) {
            // add message into existing messageDB deque
            messagesDB.get(messageId).add(newMessage);
        } else { // store new message
            // create new message deque for the messageDB
            Deque<Message> messageDeque = new LinkedList<Message>();
            // add new message into deque
            messageDeque.add(newMessage);
            // add (key/message) and (deque/value) to "Dictionary"
            messagesDB.put(messageId, messageDeque);
        }
    }

    // find and return user, given username
    public User findUser(String username){

        // iterate database
        for (User user: userDB){
            // if current username = given username
            if(user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }


    // Reads file and loads the data into projectDB
    public void loadFileToProjectDB() throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(projectDBFilePath));

            // skip first line (column names)
            //inputFile.nextLine();

            // while there is another line in the file
            while (inputFile.hasNextLine()) {
                // get line
                String currentLine = inputFile.nextLine();
                //System.out.println(currentLine + "CurrentLine: " + currentLine); // for debugging
                if (!currentLine.equals("")) {
                    // split line
                    String[] projectRecords = currentLine.split(",");
                    //System.out.println(userRecords.length); // for debugging

                    // get all values
                    String projectName = projectRecords[0];
                    String projectGroup = projectRecords[1];
                    int projectScore = Integer.parseInt(projectRecords[2]);

                    // add into projectDB
                    addProjectToDB(projectName,projectGroup, projectScore);
                }
            }
            // close scanner
            inputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    public void loadFileToReferralDB() throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(referralDBFilePath));

            // skip first line (column names)
            //inputFile.nextLine();

            // while there is another line in the file
            while (inputFile.hasNextLine()) {
                // get line
                String currentLine = inputFile.nextLine();
                //System.out.println(currentLine + "CurrentLine: " + currentLine); // for debugging
                if (!currentLine.equals("")) {
                    // split line
                    String[] referralRecords = currentLine.split(",");
                    //System.out.println(userRecords.length); // for debugging

                    // get all values
                    String referrerUsername = referralRecords[0];
                    String referrerStatus = referralRecords[1];
                    String referrerinviteeEmail = referralRecords[2];

                    // add into projectDB
                    addReferralToDB(new Referral(referrerUsername,referrerStatus, referrerinviteeEmail));
                }
            }
            // close scanner
            inputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }


    // writes the complete projectDB to the projects database external file
    public void saveProjectDBToFile() throws IOException {
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(projectDBFilePath));

            for (int i =0; i< projectDB.size(); i++) {
                // current project
                Project currentProject = projectDB.get(i);

                // get fields
                String projectName = currentProject.getProjectName();
                String projectGroup = currentProject.getProjectGroup();
                String projectScore = String.valueOf(currentProject.getProjectScore());

                // format project properties to string
                String groupStr = projectName + "," + projectGroup + "," + projectScore;

                // write the string
                outputFile.newLine(); // select next line
                outputFile.write(groupStr); // write word
            }

            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    //
    public List<User> converToMembersList(String strMembersList) {
        List<User> groupMemberList = new LinkedList<>();
        // split line
        String[] membersList = strMembersList.split("-");
        for (String memberUserName : membersList) {
            groupMemberList.add(findUser(memberUserName));
        }
        return groupMemberList;
    }

    // add referral to db
    public void addReferralToDB(Referral referral){
        referralDB.add(referral);
    }

    public Referral findReferral(String givenUsername){
        // search for referral in the database
        for (Referral referral : referralDB) {
            if (referral.getReferrerUsername().equals(givenUsername)) {
                return  referral;
            }
        }
        return null; // not found
    }




    public void addPollToDB(Poll newPoll){
        pollDB.add(newPoll);
    }


    public void savePollDBToFile() throws IOException {
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(pollDBFilePath));

            for (int i =0; i< pollDB.size(); i++) {
                // current project
                Poll currentPoll = pollDB.get(i);

                // get fields
                String pollType = currentPoll.getType();
                String pollMembers =  currentPoll.membersToString();
                String meetingDate = currentPoll.getMeetingDate();
                String meetingTime = currentPoll.getMeetingTime();

                // format project properties to string
                String pollStr = pollType + "," + pollMembers + "," + meetingDate + "," + meetingTime;

                // write the string
                outputFile.newLine(); // select next line
                outputFile.write(pollStr); // write word
            }

            // close file
            outputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    public void loadFileToPollDB() throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(pollDBFilePath));

            // skip first line (column names)
            //inputFile.nextLine();

            // while there is another line in the file
            while (inputFile.hasNextLine()) {
                // get line
                String currentLine = inputFile.nextLine();
                //System.out.println(currentLine + "CurrentLine: " + currentLine); // for debugging
                if (!currentLine.equals("")) {
                    // split line
                    String[] pollRecords = currentLine.split(",");
                    //System.out.println(userRecords.length); // for debugging

                    String type = pollRecords[0];
                    List<User> members = converToMembersList((pollRecords[1]));
                    String meetingDate = pollRecords[2];
                    String meetingTime = pollRecords[3];

                    // add into pollDB
                    addPollToDB(new Poll(type, members, meetingDate, meetingTime));
                }
            }
            // close scanner
            inputFile.close();
            // catch exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Specified File could not be found!");
        }
    }

    // get poll for specific logged user
    public List<Poll> getPollDB(String loggedUsername){
        List<Poll> tmpPollDB = new ArrayList<>();

        // iterate all polls
        for (Poll poll : pollDB) {
            // iterate all members in the current poll
            for (User user : poll.getMembers()) {
                if (loggedUsername.equals(user.getUserName())){
                    tmpPollDB.add(poll);
                }
            }
        }
        return tmpPollDB;
    }

    public void removePoll(Poll poll){
        for (Poll currentPoll : pollDB) {
            if(currentPoll.getMeetingTime().equals(poll.getMeetingTime())){
                pollDB.remove(currentPoll);
            }
        }
    }



} // end ActiveTeamingSystem