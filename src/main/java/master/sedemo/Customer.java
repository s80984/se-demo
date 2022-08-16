package master.sedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Customer {

    private Long id;

    private String name;
    private String firstName;
    private String lastName;
    private ArrayList<String> data;

    public Customer(){
        System.out.println("Calling The empty Constructor");
    }
    public Customer(String name) {
        System.out.println("Calling The Constructor");
        this.setName(name);
    }

    public Long getId() {
        return id;
    }

    public Customer setId(long id) {
        this.id = this.id == null ? id : this.id;
        return this;
    }


    public String getName() {
        if(lastName == "" || firstName == ""){
            return "";
        } else{
            String fullName = lastName + ", " + firstName;
            return fullName;
        }
    }
    public Customer setName(String name) {
        splitName(name);
        return this;
    }

    public Customer setName(String first, String last){
        this.firstName = first;
        this.lastName = last;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void splitName(String name){
        if (name.contains(",")){
            this.lastName = name.split(",")[0];
            this.firstName = name.split(",")[1];

        } else if (name.contains(";")) {
            this.firstName = name.split(";")[1];
            this.lastName = name.split(";")[0];
        } else {
            int idx = name.lastIndexOf(' ');
            if (idx == -1)
                throw new IllegalArgumentException("Only a single name: " + name);
            this.firstName = name.substring(0, idx);
            this.lastName  = name.substring(idx + 1);
        }
    }

    public Customer addContact(String data){
        if(this.data == null) {
            this.data = new ArrayList<String>();
            this.data.add(data);
        }
        else if(this.data.contains(data)) return this;
        else this.data.add(data);

        return this;
    }


    public String[] getContacts() {
        ArrayList<String> contacts = new ArrayList<String>();
        if(this.data != null)
            for (String item:this.data) {
                contacts.add(item);
            }

        String[] stringArray = contacts.toArray(new String[0]);
        return stringArray;
    }

    public Integer contactsCount() {
        return getContacts().length;
    }

    public String[] deleteContact(int index){
        ArrayList<String> contacts = new ArrayList<String>();
        if(this.data != null)
            for (String item:this.data) {
                contacts.add(item);
            }

        if (contacts == null || index < 0 || index >= contacts.toArray().length) {
            return contacts.toArray(new String[0]);
        }

        // Remove the specified element
        contacts.remove(index);
        String[] stringArray = contacts.toArray(new String[0]);
        // return the resultant array
        return stringArray;
    }

    public String[] deleteAllContacts(){
        this.data = new ArrayList<String>();
        String[] stringArray = this.data.toArray(new String[0]);
        return stringArray;
    }
}
