package master.sedemo.tasks;

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

//Fehlerfreier Code
//package master.sedemo.tasks;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Class of entity type <i>Customer</i>.
// * <p>
// * Customer is an individual (a person, not a business) who creates and holds (owns) orders in the system.
// * </p>
// *
// * @version <code style=color:green>{@value application.package_info#Version}</code>
// * @author <code style=color:blue>{@value application.package_info#Author}</code>
// */
//public class Customer {
//
//    /**
//     * Unique Customer id attribute, {@code id < 0} is invalid, id can only be set once.
//     */
//    private long id = -1;
//
//    /**
//     * Customer's surname attribute, never null.
//     */
//    private String lastName = "";
//
//    /**
//     * None-surname name parts, never null.
//     */
//    private String firstName = "";
//
//    /**
//     * Customer contact information with multiple contacts.
//     */
//    private final List<String> contacts = new ArrayList<String>();
//
//
//    /**
//     * Default constructor.
//     */
//    public Customer() { }
//
//    /**
//     * Constructor with single-String name argument.
//     * @param name single-String Customer name, e.g. "Eric Meyer".
//     * @throws IllegalArgumentException if name argument is null.
//     */
//    public Customer(String name) {
//        setName(name);	// throws IllegalArgumentException when name==null
//        if(lastName.length()==0)
//            throw new IllegalArgumentException("name empty.");
//    }
//
//
//    /**
//     * Id getter.
//     *
//     * @return customer id, returns {@code null}, if id is unassigned.
//     */
//    public Long getId() { return id >=  0? id : null; }
//
//
//    /**
//     * Id setter. Id can only be set once with valid id, id is immutable after assignment.
//     *
//     * @param id value to assign if this.id attribute is still unassigned {@code id < 0} and id argument is valid.
//     * @throws IllegalArgumentException if id argument is invalid ({@code id < 0}).
//     * @return chainable self-reference.
//     */
//    public Customer setId(long id) {
//        if(id < 0)
//            throw new IllegalArgumentException("invalid id (negative).");
//        //
//        // set id only once; id cannot be changed afterwards
//        this.id = this.id < 0? id : this.id;
//        return this;
//    }
//
//
//    /**
//     * LastName getter.
//     *
//     * @return value of lastName attribute, never null, mapped to "".
//     */
//    public String getLastName() { return lastName; }
//
//
//    /**
//     * FirstName getter.
//     *
//     * @return value of firstName attribute, never null, mapped to "".
//     */
//    public String getFirstName() { return firstName; }
//
//
//    /**
//     * Setter that splits a single-String name (for example, "Eric Meyer") into first-
//     * ("Eric") and lastName ("Meyer") parts and assigns parts to corresponding attributes.
//     *
//     * @param first value assigned to firstName attribute, null is ignored.
//     * @param last value assigned to lastName attribute, null is ignored.
//     * @return chainable self-reference.
//     */
//    public Customer setName(String first, String last) {
//        this.firstName = first==null? this.firstName : trimStr(first);
//        this.lastName = last==null? this.lastName : trimStr(last);
//        return this;
//    }
//
//
//    /**
//     * Setter that splits a single-String name (e.g. "Eric Meyer") into first- and
//     * lastName parts and assigns parts to corresponding attributes.
//     *
//     * @param name single-String name to split into first- and lastName parts.
//     * @throws IllegalArgumentException if name argument is null.
//     * @return chainable self-reference.
//     */
//    public Customer setName(String name) {
//        return splitName(name);		// throws IllegalArgumentException when name==null
//    }
//
//
//    /**
//     * Return number of contacts.
//     *
//     * @return number of contacts.
//     */
//    public int contactsCount() { return contacts.size(); }
//
//
//    /**
//     * Contacts getter (as {@code String[]}).
//     *
//     * @return contacts (as {@code String[]}).
//     */
//    public String[ ] getContacts() {
//        // return contacts.toArray(String[]::new);
//        return contacts.toArray(new String[contacts.size()]);
//    }
//
//
//    /**
//     * Add new contact for Customer. Only valid contacts (not null, "" or duplicates) are added.
//     *
//     * @param contact valid contact (not null or "" nor duplicate), invalid contacts are ignored.
//     * @throws IllegalArgumentException if contact argument is null or empty "" String.
//     * @return chainable self-reference.
//     */
//    public Customer addContact(String contact) {
//        if(contact==null || contact.length()==0)
//            throw new IllegalArgumentException("contact null or empty.");
//        //
//        String cont = trimStr(contact);
//        int minLength = 6;
//        if(cont.length() < minLength)
//            throw new IllegalArgumentException("contact less than " +
//            minLength + " characters: \"" + contact + "\".");
//        //
//        if( ! contacts.contains(cont)) {
//            contacts.add(cont);
//        }
//        return this;
//    }
//
//
//    /**
//     * Delete the i-th contact with {@code i >= 0} and {@code i < contactsCount()}, otherwise method has no effect.
//     *
//     * @param i index of contact to delete.
//     */
//    public void deleteContact(int i) {
//        if( i >= 0 && i < contacts.size() ) {
//            contacts.remove(i);
//        }
//    }
//
//
//    /**
//     * Delete all contacts.
//     */
//    public void deleteAllContacts() { contacts.clear(); }
//
//
//    /**
//     * Split single-String name into last- and first name parts.
//     *
//     * @param name single-String name to split into first- and last name parts.
//     * @throws IllegalArgumentException if name argument is null.
//     * @return chainable self-reference.
//     */
//    private Customer splitName(String name) {
//        if(name==null)
//            throw new IllegalArgumentException("name null.");
//        //
//        String first="", last="";
//        String[] spl1 = name.split("[,;]");
//        if(spl1.length > 1) {
//            // two-section name with last name first
//            last = spl1[0];
//            first = spl1[1];	// ignore higher splitters in first names
//        } else {
//        	// no separator [,;] -> split by white spaces;
//            for(String s : name.split("\\s+")) {
//                if( last.length() > 0 ) {
//                    // collect firstNames in order and lastName as last
//                    first += (first.length()==0? "" : " ") + last;
//                }
//                last = s;
//            }
//        }
//        return setName(first, last);
//    }
//
//
//    /**
//     * Trim leading and trailing white spaces, commata {@code [,;]} and quotes {@code ["']} from String.
//     * @param s String to trim.
//     * @return trimmed String.
//     */
//    private String trimStr(String s) {
//        s = s.replaceAll("^[\\s\"',;]*", "");	// trim leading white spaces[\s], commata[,;] and quotes['"]
//        s = s.replaceAll( "[\\s\"',;]*$", "");	// trim trailing.
//        return s;
//    }
//}



