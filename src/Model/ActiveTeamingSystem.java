package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActiveTeamingSystem {
    // ArrayList, holds all data from user database
    private List<User> userDB;
    // ArrayList, holds all data from group database
    private List<Group> groupDB;
    // ArrayList, holds top profiles
    private List<TopProfile> topProfilesList;
    // Logged in User
    private User loggedUser;
    // group of Logged in user
    private Group loggedUserGroup;

    // default constructor
    public ActiveTeamingSystem(){
        // initialize userDB
        userDB = new ArrayList<User>();
        // initialize groupDB
        groupDB = new ArrayList<Group>();
        // initialize topProfilesList
        topProfilesList = new ArrayList<TopProfile>();
    }

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
    public void addGroup(int groupID, String groupName, String groupLeader, int memberCount) {
        // simply add the new record
        groupDB.add(new Group(groupID, groupName, groupLeader, memberCount));
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
    public Group removeGroup(int groupID) {
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
    public void readFileToUser(String filePath) throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(filePath));

            // skip first line (column names)
            inputFile.nextLine();

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
    public void readFileToGroup(String filePath) throws Exception {
        try {
            // file to read
            Scanner inputFile = new Scanner(new File(filePath));

            // skip first line (column names)
            inputFile.nextLine();

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
                    String groupName = userRecords[0];
                    int groupID = Integer.parseInt(userRecords[1]);
                    String groupLeader = userRecords[2];
                    int memberCount = Integer.parseInt(userRecords[3]);

                    // add into groupDB
                    addGroup(groupID, groupName, groupLeader, memberCount);
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
    public void overwriteUserFile(String filePath) throws IOException {
        // ok when we remove a user from our userDB the user is also removed from the external user database
        // so I just have to make a copy of the database and overwrite the external file.
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(filePath));

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

                // format transaction properties to string
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
    public void overwriteGroupFile(String filePath) throws IOException {
        // ok when we remove a group from our groupDB the user is also removed from the external group database
        // so I just have to make a copy of the database and overwrite the external file.
        try {
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(filePath));

            for (int i =0; i< groupDB.size(); i++) {
                // current group
                Group currentGroup = groupDB.get(i);

                // get fields
                String groupID = String.valueOf(currentGroup.getGroupID());
                String groupName = currentGroup.getGroupName();
                String groupLeader = currentGroup.getGroupLeader();
                String memberCount = String.valueOf(currentGroup.getMemberCount());


                // format transaction properties to string
                String groupStr = groupID + "," + groupName + "," + groupLeader + "," + memberCount;

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

} // end ActiveTeamingSystem