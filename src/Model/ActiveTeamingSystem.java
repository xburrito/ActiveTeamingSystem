package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActiveTeamingSystem {
    // ArrayList, holds all data from user database
    private List<User> userDB;
    // ArrayList, holds all data from group database
    private List<Group> groupDB;
    // ArrayList, holds top profiles
    private List<TopProfile> topProfilesList;


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
                System.out.println(i);
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
                    String dayOfBirth = userRecords[0];
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
                    addUser(dayOfBirth, dateJoined, userID, password, email, username, lastName, firstName, repScore, status);
                }
            }
            // close scanner
            inputFile.close();
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

    // getters

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
    
} // ActiveTeamingSystem