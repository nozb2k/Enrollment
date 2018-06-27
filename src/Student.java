
public class Student
{
    private	String name;
    private	String DOB;
    private String address;
    private String gender;

    public Student(String studentName,String DateOfBirth,String Address,String Gender)
    {
        name    = studentName;
        address = Address;
        DOB     = DateOfBirth;
        gender  = Gender;

    }

    public Student() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    //=====================================================================================
    public boolean equalsName(String searchName)        //searches the array for the name entered by the user
    {                                                   //lets us know when it has been found or not
        if(name.equals(searchName))
        {
            System.out.println(searchName + " has been found");
            return true;
        }
        else
        {
            System.out.println("No match found");
            return false;
        }
    }

    //=====================================================================================
    public boolean equalsMale()           //searches the array for the name entered by the user
    //lets us know when it has been found or not

    {
        if(gender.equals("M"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //=====================================================================================
    public String getStudentDetails() //returns student details when they have been searched for. Allows details to be printed to screen
    {
        return this.name + "\t" + this.address + "\t" + this.DOB + "\t" + this.gender;
    }

}
