import java.util.*;
import java.io.*;


public class Enrollment {


    // Creates arrays of 20 elements for students
    Student[] studentArray = new Student[20];

    // Initialises counters for students
    int noOfStuds = 0;

    private Scanner scan;

    public static void main(String[] args)
    {
        //Creates a new instance of the Enrolment class
        Enrollment moduleEnrollment = new Enrollment();
        //Call the Menu method
        moduleEnrollment.menu();
    }


    public Enrollment()
    {
        //Calls the scanner class
        scan = new Scanner(System.in);
        File textFile = new File("student.txt");
        try (Scanner in = new Scanner(textFile)) {

            while (in.hasNext()){
                studentArray[noOfStuds] = new Student();
                studentArray[noOfStuds].setName(in.next());
                studentArray[noOfStuds].setAddress(in.next());
                studentArray[noOfStuds].setDOB(in.next());
                studentArray[noOfStuds].setGender(in.next());
                in.nextLine();
                noOfStuds++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            System.out.println(noOfStuds + " Records Added");
        }
    }

    public void menu()
    {
        int ans;

        //Menu list showing options and corresponding numbers

        System.out.println("--Student Enrolment System--");
        System.out.println();
        System.out.println("(1) - Add Student");
        System.out.println("(2) - Delete Student");
        System.out.println("(3) - Search for Student");
        System.out.println("(4) - Print Report");
        System.out.println("(5) - Save & Exit");
        System.out.println();
        System.out.println("Please Choose an option between 1-6");
        System.out.println();

        ans = scan.nextInt();

        switch(ans)
        {
            case 1: //add a student to the array
                addStudent();
                break;
            case 2: //delete a student from the array
                deleteStudent();
                break;
            case 3: //search for a student in the array
                searchStudent();
                break;
            case 4: //print a report on the students enrolled and the percentage of males/females
                printReport();
                break;
            case 5: //save the student array to a file and exit the program.
                saveFile();
                System.exit(0);
        }
    }

    private void saveFile() {
        try {
            PrintWriter outFile = new PrintWriter(new FileWriter("student.txt"));

            for (int p = 0; p < noOfStuds; p++) {                       //until the student is found and prints
                outFile.println(studentArray[p].getStudentDetails());
            }
            outFile.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //=====================================================================================
    public void addStudent() {
        if (noOfStuds < 20) {

            scan = new Scanner(System.in);          //scanner class to allow system input

            studentArray[noOfStuds] = new Student();
            System.out.println("Please enter Students name: ");
            studentArray[noOfStuds].setName(scan.nextLine());
            System.out.println("Please enter student's date of birth DD/MM/YY: ");
            studentArray[noOfStuds].setAddress(scan.nextLine());
            System.out.println("Please enter student's address: ");
            studentArray[noOfStuds].setDOB(scan.nextLine());
            System.out.println("Please enter student's gender M or F: ");
            studentArray[noOfStuds].setGender(scan.nextLine());

            noOfStuds++;
        }

        else {
            System.out.println("Enrolement is now full");       //tells us the array is now full
        }
        //display details();
        menu();
    }
    //=====================================================================================


    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        String target;                                      //target delcares the name we are looking for
        System.out.print("Student Search");                 //this is entered in using the console
        System.out.print("Enter name of student: ");
        target = sc.nextLine();

        BreakLoop:

        for (int p = 0; p < noOfStuds; p++) {
            if (studentArray[p].equalsName(target)) {                                                   //until the student is found and prints
                System.out.println("Student details found:");       //the student details and then breaks
                System.out.println();                               //to the menu when they are found
                System.out.println(studentArray[p].getStudentDetails());
                break;
            }
        }
        menu();
    }



    //=====================================================================================

    public void deleteStudent()
    {
        scan = new Scanner(System.in);
        String searchName;
        int j = 0;

        System.out.println("Please Enter the student you wish to delete");
        searchName = scan.nextLine();

        for(int i = 0; i < noOfStuds; i++) {
            // check if there is a match
            if(studentArray[i].equalsName(searchName)) {
                // found decrement number of studens
                noOfStuds--;
                // push back the other students
                for(j = i; j < noOfStuds; j++)
                    studentArray[j] = studentArray[j+1];	 // replaced by following one
                System.out.println(searchName + " has been deleted");
                break;		// exits loop back menu
            }
        }
        menu();
    }

    public void printReport()

    {

        int maleCount = 0;
        int femaleCount = 0;
        int sum = noOfStuds;

        for (int i = 0; i < noOfStuds; i++)
        {
                if (studentArray[i].equalsMale())   //if the gender matches male, +1 to the counter
                {
                    maleCount++;
                }
                else   //if the gender matches female, +1 to the counter
                {
                    femaleCount++;
                }
        }

        double percentage1 = (double) maleCount++ / (double) sum * 100;   //counts are divided by total number of students
        double percentage2 = (double) femaleCount++ / (double) sum * 100;   // then multiplied by 100 to give the percentage of male /female

        System.out.println("Number of students on the course :" + noOfStuds + "\n");       //prints to screen
        System.out.println("Percentage of Male Students :" + percentage1 +  "\n" + "Percentage of Female Students :" + percentage2 + "%");

        menu();

    }

}