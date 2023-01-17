// You will have to complete this file by replacing FILL_IT_IN with
// appropriate Java code (most likely multiple lines) and by adding
// additional code where needed.

import java.io.*;

public class ProcessApplications {

    public static String readALine (BufferedReader input) {
        String line = "";
        try {
            line = input.readLine();
        }
        catch (IOException e) {
            System.out.println("Oops");
        }
        return line;
    }

    // Rather than catching IOException's in main, main can pass it on
    // by 'throw'ing it, which is what I chose to do here.
    //
    public static void main (String[] args) throws IOException {

        // The Usage of this application is:
        //
        // java ProcessApplications [ApplicationFileName]
        // The input file to process is taken from the command line. Remember if you
        // are using IntelliJ Idea, you will have to set the argument in the run configuration panel!


        // Make sure there are enough arguments and set the inputFile from
        // the first command line argument.
        String file = args[0];
        String inputFile = file + ".txt";

        // Pattern to be used to "open an input file"
        BufferedReader input = new BufferedReader(new FileReader(inputFile));

        // I am assuming there will be only up to 150 applications so we are going
        // to create an array of 150 Application objects.

        final int numApplications = 150;
        Application[] applications = new Application[numApplications];

        String idstring = readALine(input);
        int id;
        if (idstring != null) {
            id = Integer.parseInt(idstring);
        }
        String name;
        String addr;
        String city;
        String state;
        String zip;
        String num;
        String major;
        String GPA;
        String scholarship;

        int i = 0;

        try {
            while (idstring != null) {   // Reached the end of the input file?
                id = Integer.parseInt(idstring);
                // When id is < 0, we are finished! (The 'sentinal' value is -1!)
                // Remember not to exceed the size of the application array. You may
                // want to quit processing applications if that limit is reached as well.
                name = readALine(input);
                addr = readALine(input);
                city = readALine(input);
                state = readALine(input);
                zip = readALine(input);
                num = readALine(input);
                major = readALine(input);
                GPA = readALine(input);
                scholarship = readALine(input);

                applications[i] = new Application(id, name, addr, city, state, zip, num, major, GPA, scholarship);

                i = i + 1;
                idstring = readALine(input);  // Read the next entry if exists
                if (Integer.parseInt(idstring) < 0) {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            ;
        }

        input.close();  // Close it when done reading from it.


        // Now that we have all the application objects in an array, we can
        // use those objects to do whatever we want to do.

        // Find scholarship recipients. An applicant is considered a scholarship
        // recipient if:
        //   (1) his or her high school GPA is higher than 3.70,
        //   (2) his or her intented major is one of the following: Computer Science,
        //       Applied Math, or Mechanical Engineering
        //   (3) s/he is from Montana, Wyoming, or Iowa, and
        //   (4) s/he is applying for scholarship.
        // Find and print all the scholarship recipients.

        Application[] schoList = new Application[applications.length];
        for (int s = 0; s < applications.length; s++) {
            if (applications[s] != null) {
                if (Double.parseDouble(applications[s].getGPA()) > 3.70){
                    if(applications[s].getMajor().equals("Computer Science") ||
                        applications[s].getMajor().equals("Applied Math") ||
                        applications[s].getMajor().equals("Mechanical Engineering")){
                        if(applications[s].getState().equals("Montana") ||
                        applications[s].getMajor().equals("Wyoming") ||
                        applications[s].getMajor().equals("Iowa")) {
                            if (applications[s].getScholarship().equals("Yes")) {
                                schoList[s] = applications[s];
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The scholarship recpients are: ");
        for (Application s : schoList) {
            if (s != null) {
                System.out.print(s.getName() + ", ");
            }
        }
        System.out.println();


        // Print the average GPA of all the applicants from California:
        double sumCali = 0;
        int countCali = 0;
        for (int k = 0; k < applications.length; k++) {
            if (applications[k] != null) {
                if ("California".equals(applications[k].getState())) {
                    sumCali += Double.parseDouble(applications[k].getGPA());
                    countCali++;
                }
            }
        }
        System.out.println("The average GPA of all the applicants from California: " + sumCali / countCali);

        // Find the applicant whose GPA is the highest among the applicants
        // from the state of Washington and print the name and the GPA of
        // that applicant.
        Application[] highest = new Application[applications.length];
        Double tempHighest = 0.00;
        for (int j = 0; j < applications.length; j++) {
            if (applications[j] != null) {
                if ("Washington".equals(applications[j].getState())) {
                    if (tempHighest <= Double.parseDouble(applications[j].getGPA())) {
                        tempHighest = Double.parseDouble(applications[j].getGPA());
                    }
                }
            }
        }
        for (int j = 0; j < applications.length; j++) {
            if (applications[j] != null) {
                if ("Washington".equals(applications[j].getState())) {
                    if (tempHighest == Double.parseDouble(applications[j].getGPA())) {
                        highest[j] = applications[j];
                    }
                }
            }
        }

        for (Application j : highest) {
            if (j != null) {
                System.out.println("State: " + j.getState() + " Name: " + j.getName() + " GPA: " + j.getGPA());
            } else if (tempHighest == 0) {
                System.out.println("There is no applicant from Washington");
                break;
            }
        }
        // Find and print the number of applicationss from each state
        // in this format (alphabetical order):
        //
        //   State, No of Applications
        //   Arizona, 5
        //   California, 20
        //   Oregon, 6
        //   Washington, 7
        //
        // You may assume that the only valid state names are the 50
        // states in the USA.  That is, you will only see at most
        // those names in your input file.  In your output, do NOT
        // include the state names from which there is no application.

        String[][] stateList = {{"Alabama", "Alaska", "Arizona", "Arkansas", "California",
                "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
                "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
                "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
                "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
                "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
                "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
                "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
                "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                "Virginia", "Washington", "West Virginia", "Wisconsin",
                "Wyoming"},{"0","0","0","0","0","0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0",}};
        for (Application z : applications) {
            if (z != null) {
                for (int l = 0; l < stateList[0].length; l++) {
                        if (stateList[0][l].equals(z.getState())) {
                            int count = Integer.parseInt(stateList[1][l]);
                            count++;
                            stateList[1][l] = count + "";
                            break;
                        }
                    }
            }
        }
        System.out.println("State, No of Applications");
        for (int z = 0; z < 50; z++){
            if (!stateList[1][z].equals("0")) {
                System.out.println(stateList[0][z] + ", " + stateList[1][z]);
            }
        }
        
    }
}
