public class Instructor {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String title;


    void Instructor(int id, String firstName, String lastName, String email, String phoneNumber, String title){
         this.id = id;
         this.firstName = firstName;
         this.lastName = lastName;
         this.email = email;
         this.phoneNumber = phoneNumber ;
         this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTitle() {
        return title;
    }
}
