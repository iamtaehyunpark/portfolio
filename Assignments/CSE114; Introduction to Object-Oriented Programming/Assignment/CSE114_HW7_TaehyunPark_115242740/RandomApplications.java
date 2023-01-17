// How to run this program:
//
//  DOSorUnix> java RandomApplications 23
//
// if you want to generate an input file with 23 application records.
// 
// An output file named a7.txt will be created with that many student
// records.  If you want to change the output file name, search a7.txt
// in this file and change it to whatever you want it to be.  Or you
// make it a command line argument instead if you like.

import java.io.*;
import java.util.*;
import java.math.*;

public class RandomApplications {

    private static Random randgen = new Random();
    private static PrintWriter fileWriter = null;
    private static String[] fnames 
        = {"Adam", "Ann", "Art", "Amy", "Andrew", "Asuman",
           "Alfred", "Audrey", "April", "Anthony", "Andrea", 
           "Arash", "Amilia", 
           "Bonny", "Bobby", "Bevin", "Bettina",
           "Chris", "Christie", "Charles", "Carrie", "Cindy",
           "Cheryl", "Craig", 
           "Daniel", "Debbie", "Dustin", "Delia", "Diane", 
           "Edward", "Ellen", "Eric", "Esther", 
           "Frank", "Fay", "Farhad", "Fred", 
           "Gene", "Gary", "Gerry", "Gerald", "Grechen", "Gaston", 
           "Gregg", "Heather", "Henry", "Harry", "Hilary",
           "Ian", "Igor", "Jeff", "John", "Jack", "James", "Joe",
           "Jerome", "Jorge", "Jennifer", "Joshua", "Jodie", "Jay",
           "June", "Kimberly", "Kersey", "Kathleen", "Karen", "Kay", 
           "Larry", "Lynn", "Lauren", "Lisa", 
           "Micheal", "Michelle", "Minju", "Mario", 
           "Mary", "Miriam", "Mark", "Maria", "Majorie", 
           "Mercedes", "Nancy", "Nellie", "Newton", 
           "Pam", "Peter", "Penny", "Phillip", "Pari", "Patrick", 
           "Paul", "Ron", "Rob", "Rod", "Roger", "Robert", "Richard", 
           "Sally", "Shannah", "Sonny", "Sven", "Shana", 
           "Steven", "Scott", "Sam", "Sandra", "Sarah", 
           "Tom", "Todd", "Timothy", "Tobias", 
           "Ulrich", "Vaughn", "Walter", "Wayne", "William", "Zach",
           "Abir","Acelin","Acton","Adair","Adar","Addison","Aden",
           "Adir","Aiken","Aimon","Ainsley","Ajani","Akira","Ali",
           "Amadeus","Amal","Amir","Ammon","Amon","Aneurin","Angelo",
           "Annan","Ansari","Anwar","Archer","Arden","Ari","Ariel",
           "Arion","Arje","Arjuna","Arley","Arlo","Asher","Ashlin",
           "Asim","Aston","Avan","Ayer","Bae","Bakari","Barak",
           "Beck","Benedict","Blaine","Blair","Blaise","Boyce","Brady",
           "Brae","Brock","Brodie","Bryn","Bryce","Cadell","Cadmus",
           "Caedmon","Caesar","Cahil","Cailean","Cain","Caleb","Camden",
           "Carey","Carlin","Carne","Carrik","Carson","Casey","Caspar",
           "Cassidy","Cathan","Cato","Cavan","Chad","Chaim","Chaney",
           "Chase","Chet","Chiron","Cian","Ciaran","Ciro","Clay",
           "Cleary","Cody","Cole","Conall","Conan","Conn","Corey",
           "Crewe","Crispin","Cristian","Cristo","Cy","Cyrus","Dacey",
           "Dai","Dakota","Daley","Damas","Damon","Dane","Dante",
           "Darby","Darcy","Darien","Darius","Darnell","Delmar","Demas",
           "Dev","Diego","Dimitri","Donato","Drew","Duarte","Dyami",
           "Dyre","Eaton","Edison","Ehren","Elan","Eli","Ellery",
           "Emerson","Emil","Emyr","Ennis","Ephraim","Estes","Etienne",
           "Evander","Ezra","Fabian","Fabrice","Fane","Farquhar","Fariss",
           "Favian","Fenn","Fidel","Fineas","Finian","Finn","Flavien",
           "Frayne","Gabriel","Galen","Garek","Gaston","Geary","Germaine",
           "Garvais","Gianni","Giles","Giordano","Jourdano","Girvan","Grady",
           "Graison","Gye","Haine","Hakim","Hakon","Haley","Hamlin",
           "Hamon","Hanan","Hani","Hannes","Harlan","Harper","Harvae",
           "Hasim","Hassan","Haven","Heath","Hemi","Howell","Hume",
           "Hunter","Hyam","Iago","Iden","Ihaka","Innes","Ira",
           "Issac","Isaiah","Israel","Ives","Jacek","Jael","Jai",
           "Jaleel","Jamal","Jaron","Javed","Jervase","Jesse","Jett",
           "Joachim","Jourdan","Kadir","Kamal","Kane","Karan","Kareem",
           "Kasim","Kavan","Keane","Keenan","Kelan","Kent","Kerne",
           "Khalil","Kieran","Killian","Kim","Kinnard","Kinsey","Kiran",
           "Kito","Kolya","Kyne","Lachlan","Lafayette","Lal","Lamar",
           "Lamech","Lamont","Laine","Lani","Lann","Lars","Leal",
           "Leif","Lennon","Lennox","Levin","Levi","Linton","Lorant",
           "Lorenzo","Lorne","Lucian","Madoc","Mahir","Mahon","Makani",
           "Makis","Maksim","Malachi","Malik","Malin","Malise","Manas",
           "Manaia","Mani","Manu","Marcello","Marius","Marley","Marlon",
           "Mason","Massimo","Matai","Mayan","Mayer","Melor","Mercer",
           "Micah","Midas","Milan","Miles","Milos","Mischa","Myall",
           "Myron","Naaman","Nadir","Nairn","Namir","Narayn","Nasir",
           "Niall","Nico","Nikita","Nils","Niran","Nishan","Nur",
           "Nye","Nyall","Omar","Oran","Orion","Orlando","Orton",
           "Paige","Paine","Paris","Parker","Pascal","Payton","Pearce",
           "Perry","Phelan","Philemon","Phineas","Phoenix","Pearson","Qadir",
           "Qasim","Quillan","Quilliam","Quincy","Quinlan","Quinn","Rafe",
           "Rafferty","Rafi","Rafiq","Rainer","Ramiro","Rasheed","Ravi",
           "Reeve","Reid","Regan","Reilly","Remy","Renato","Renzo",
           "Riordan","Roarke","Rocco","Rohan","Roman","Ronan","Rory",
           "Roshan","Royce","Rune","Ryder","Back","Sabian","Sacha",
           "Sage","Saleem","Sancho","Sandor","Santos","Saul","Saviero",
           "Saville","Saxton","Sayed","Sebastian","Semyon","Seth","Severn",
           "Shae","Shakir","Sharif","Sheehan","Shen","Sheridan","Shiloh",
           "Sloane","Sol","Soren","Steele","Steede","Sumner","Swayne",
           "Tahir","Tai","Tait","Tanner","Tariq","Tarn","Tarquin",
           "Tarun","Tashi","Tehan","Thane","Theon","Thierry","Tierney",
           "Timon","Tobias","Torin","Travis","Tremaine","Tynan","Tyne",
           "Tyson","Ultan","Upton","Uriah","Urian","Vachel","Valentino",
           "Valerian","Valles","Van","Varden","Varian","Varick","Vartan",
           "Venn","Vere","Vidal","Vidas","Vidya","Vijay","Vitale",
           "Vyasa","Wade","Waite","Weston","Willard","Wren","Xavier",
           "Xylon","Yael","Yannis","Yasir","Yeshe","Yves","Zahir",
           "Zaki","Zamir","Zaine","Zed","Zeke"};
    private static String[] mnames 
        = {"A.", "B.", "C.", "D.", "E.", "F.", "G.", "H.", "I.", "J.", "K.",
           "L.", "M.", "N.", "O.", "P.", "Q.", "R.", "S.", "T.", "U.", "V.",
           "W.", "X.", "Y.", "Z."};
    private static String[] lnames 
        = {"Adams", "Adamson", "Adolfo", "Adolphson", "Aerus", "Affin",
           "Aksoy", "Antecol", "Appel", "Appelbaum", "Amacost",
           "Arndt", "Ascher", "Ashmiller",
           "Black", "BlackBurn", "Blackham", "Bishop", "Brown", 
           "Brunvand", "Baduini", "Balitzer", "Bessette", "Bilger",
           "Black", "Biltz", "Blomberg", "Bowman", "Bradley",
           "Burdekin", "Burton", "Busch", 
           "Chang", "Chi", "Chin", "Clinton", "Calichman",
           "Camp", "Campbell", "Candaele", "Casad", "Castro",
           "Chamorel", "Chase", "Chorba", "Clark", "Cody",
           "Dimagio", "Davis", "Dershem", "Douville", 
           "Eby", "Edwards", "Elliott", "Espinosa",
           "Eldregde", "Eggett", "Ehrig", "Egg", "Fahim", "Featherstone",
           "Flatt", "Faggen", "Farell", "Fucaloro",
           "Garris", "Gilbert", "Goeree", "Goodrich", "Gould",
           "Greth", "Griffiths", "Gross", "Goss", "Guthrie",
           "Hahn", "Hanscom", "Heerwald", "Hiskey", "Haley",
           "Haskell", "Helland", "Hess", "Higdon", "Huang",
           "Jackson", "Kell", "Keil", "Kind", "Kim", "Kirkland",
           "Kennedy", "Kerry", "Krauss",
           "Lee", "Lepereu", "Lim", "Lindstrom",
           "Mayfield", "Mansfield", "Monroe", "Myer", "Miller", "Milton", 
           "Mintz", "Miyasaki", 
           "Nelson", "O'malley", "Peterson",
           "Petersen", "Riloff", "Robinson",
           "Sampson", "Slind", "Smith",
           "Thom", "Thompson", "Trang",
           "Williams", "Woods",
           "Zachary", "Zamin", "Zone"};
    private static String[] directions = {"North", "South", "East", "West"};
    private static String[] streets 
        = {"Abel Dr.", "Broglie Blvd.", "Buffon", "Leibniz", "Malus St.",
           "Monge Dr.", "Jefferson St.", "E St.", "F st.", "De Vinci Ave.",
           "Stanford", "Princeton", "Pensylvania", "Harvard", "Cornell",
           "Herbert", "Hubbard", "Wilson Ave.", "Main St.", "Loren Von Ave.",
           "Kennedy", "Kerry", "Young Oak", "Good One", "Nice One",
           "Lucky One", "Interesting One", "Fortuna", "Wilson Ave."};
    private static String[] cities 
        = {"Andover", "Atlanta",
           "Bahgdad", "Baker", "Bakersville", "Bakerfield",
           "Boise", "Bountiful",
           "Claremont", "Chicago",
           "Denver", "Dayton",
           "East Haven", "Eugene",
           "Fresno", "Florence",
           "Glendale", "Garrison",
           "Jackson", "Jolly",
           "Las Vegas", "Los Angeles",
           "Moscow", "Monroe", "Maryville", "Moab", "Monroe",
           "page", "Philladelphia", "Pomona", "Portland",
           "Richfield", "Riverside", "Riverton",
           "Salt Lake", "San Diego", "Springville", "Stuckyville",
           "St. Paul", "Sacramento", "Sherman", "Newtown", "Runt", "Seoul",
           "Seattle", "Stamford", "Sandy",
           "Southbury", "Stafford", "Stockton",
           "Tacoma", "Torry",
           "Vancouver", "Victoria",
           "Wayne", "Wonderful"};

    private static String[] states
        = {"Alabama", "Alaska", "Arizona", "Arkansas", "California",
           "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
           "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
           "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
           "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
           "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
           "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
           "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
           "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
           "Virginia", "Washington", "West Virginia", "Wisconsin",
           "Wyoming"};

    private static String[] majors 
        = {"Accounting", "Aerospace Studies", 
  	   "Anthropology", "Applied Math", "Architecture", "Art", "Asian Studies",
           "Ballet", "Behavior Science", "Biology", "Biochemistry", 
           "Business", "Bioengineering",
           "Chemistry", "Chemical Engineering", "Civil Engineering",
           "Communication", "Computer Engineering", "Computer Science",
           "Economics", "Education", "Electrical Engineering", "English",
           "Family and Consumer Studies", "Fine Arts",
           "Geography", "Geology",
           "History",
           "International Studies", "Law", "Linguistics",
           "Management", "Marketing", "Math", "Mining Engineering",
           "Music", "Medicine", "Mechanical Engineering", "Nursing",
           "Pharmacy", "Pre-Dental", "Pre-Med", "Psychology",
           "Philosophy", "Physics",
           "Sociology", "Social Work", "Special Education", "Theater",
           "Undeclared"};

    private static int idgenerator = 100;

    // Default constructor that does nothing.
    public RandomApplications() {
        ;
    }

    private static void createDataFile (int n) {
        try {
            fileWriter = new PrintWriter 
                (new BufferedWriter (new FileWriter(".//a9.txt")));
	    
            // number of records
	    //            fileWriter.println(n);
	    
            for (int i = 0; i < n; i++) {
                fileWriter.println(idgenerator++);
                fileWriter.println(fnames[rand(fnames.length)] + " " +
                                   mnames[rand(mnames.length)] + " " + 
                                   lnames[rand(lnames.length)] );
		
                if (rand(9) == 1 || rand(9) == 7) {
                    fileWriter.println(randomNdigits(4) + " " + 
                                       streets[rand(streets.length)]);
                }
                else {
                    fileWriter.println(randomNdigits(3) + " " + 
                                       directions[rand(directions.length)] + " " 
                                       + randomNdigits(4) + " " 
                                       + directions[rand(directions.length)]);
                }
                fileWriter.println(cities[rand(cities.length)]);
                fileWriter.println(states[rand(states.length)]);
                fileWriter.println(randomNdigits(5));  // zip
                fileWriter.println(randomNdigits(3) + " " + 
                                   randomNdigits(3) + " " + 
                                   randomNdigits(4));
                fileWriter.println(majors[rand(majors.length)]);
		
                if (rand(40) == 4) {
                    fileWriter.println("4.0");
                }
                else {
		    /*
		      BigDecimal b = new BigDecimal(rand(4) + randgen.nextDouble());
		      b = b.setScale(2, BigDecimal.ROUND_FLOOR);
		      fileWriter.println(b);
		    */
		    double initialValue = randgen.nextInt(5) + randgen.nextDouble();
		    if (initialValue > 4.0) {
			initialValue = 4.0;
		    }
		    long rounded = Math.round(initialValue * 100);
		    double finalValue = rounded / 100.0;
                    fileWriter.println(finalValue);
                }
		
		/*
		if (rand(2) == 0) {
                    fileWriter.println("No");
                }
                else {
                    fileWriter.println("Yes");
                }
		*/

		fileWriter.println("Yes");
	    }
	    fileWriter.println(-1);
	    fileWriter.close();
	}
	catch (IOException e) {
	    System.out.println("BLAH");
	}
    }
    
    private static String randomNdigits (int n) {
        String toReturn = "" + randgen.nextInt(9);
        for (int i = 0; i < n - 1; i++) {
            toReturn = toReturn + randgen.nextInt(9);
        }
        return toReturn;
    }

    /*
    private static int rand (int n, int digits) {
        for (double i = 1; i<(Math.pow(10,digits)); i = i * 10) {
            n += (randgen.nextInt(8) + 1) * i;
        }
        return n;
    }
    */

    private static int rand (int n) {
        return randgen.nextInt(n);
    }
    
    public static void main (String[] args) {
        createDataFile(Integer.parseInt(args[0]));
    }
    
}




