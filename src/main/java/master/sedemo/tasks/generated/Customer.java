package master.sedemo.tasks.generated;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of entity type <i>Customer</i>.
 * <p>
 * Customer is an individual (a person, not a business) who creates and holds (owns) orders in the system.
 * </p>
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */
public class Customer {

//    /**
//     * Default constructor
//     */
//    public Customer() {
//    }

    /**
     * Unique Customer id attribute, {@code id < 0} is invalid, id can only be set once.
     */
    private long id = -1;

    /**
     * Customer's surname attribute, never null.
     */
    private String lastName = "";

    /**
     * None-surname name parts, never null.
     */
    private String firstName = "";

    /**
     * Customer contact information with multiple contacts.
     */
    private final List<String> contacts = new ArrayList<String>();


    /**
     * Default constructor.
     */
    public Customer() {
        // TODO implement here
    }


    /**
     * Constructor with single-String name argument.
     * 
     * @param name single-String Customer name, e.g. "Eric Meyer".
     * @throws IllegalArgumentException if name argument is null.
     */
    public Customer(String name) {
        // TODO implement here
    }


    /**
     * Id getter.
     * 
     * @return customer id, returns {@code null}, if id is unassigned.
     */
    public Long getId() {
        // TODO implement here
        return null;
    }


    /**
     * Id setter. Id can only be set once with valid id, id is immutable after assignment.
     * 
     * @param id value to assign if this.id attribute is still unassigned {@code id < 0} and id argument is valid.
     * @throws IllegalArgumentException if id argument is invalid ({@code id < 0}).
     * @return chainable self-reference.
     */
    public Customer setId(long id) {
        // TODO implement here
        return null;
    }


    /**
     * LastName getter.
     * 
     * @return value of lastName attribute, never null, mapped to "".
     */
    public String getLastName() {
        // TODO implement here
        return "";
    }


    /**
     * FirstName getter.
     * 
     * @return value of firstName attribute, never null, mapped to "".
     */
    public String getFirstName() {
        // TODO implement here
        return "";
    }


    /**
     * Setter that splits a single-String name (for example, "Eric Meyer") into first-
     * ("Eric") and lastName ("Meyer") parts and assigns parts to corresponding attributes.
     * 
     * @param first value assigned to firstName attribute, null is ignored.
     * @param last value assigned to lastName attribute, null is ignored.
     * @return chainable self-reference.
     */
    public Customer setName(String first, String last) {
        // TODO implement here
        return null;
    }


    /**
     * Setter that splits a single-String name (e.g. "Eric Meyer") into first- and
     * lastName parts and assigns parts to corresponding attributes.
     * 
     * @param name single-String name to split into first- and lastName parts.
     * @throws IllegalArgumentException if name argument is null.
     * @return chainable self-reference.
     */
    public Customer setName(String name) {
        // TODO implement here
        return null;
    }


    /**
     * Return number of contacts.
     * 
     * @return number of contacts.
     */
    public int contactsCount() {
        // TODO implement here
        return 0;
    }


    /**
     * Contacts getter (as {@code String[]}).
     * 
     * @return contacts (as {@code String[]}).
     */
    public String[ ] getContacts() {
        // TODO implement here
        return null;
    }


    /**
     * Add new contact for Customer. Only valid contacts (not null, "" or duplicates) are added.
     * 
     * @param contact valid contact (not null or "" nor duplicate), invalid contacts are ignored.
     * @throws IllegalArgumentException if contact argument is null or empty "" String.
     * @return chainable self-reference.
     */
    public Customer addContact(String contact) {
        // TODO implement here
        return null;
    }


    /**
     * Delete the i-th contact with {@code i >= 0} and {@code i < contactsCount()}, otherwise method has no effect.
     * 
     * @param i index of contact to delete.
     */
    public void deleteContact(int i) {
        // TODO implement here
    }


    /**
     * Delete all contacts.
     */
    public void deleteAllContacts() {
        // TODO implement here
    }


    /**
     * Split single-String name into last- and first name parts.
     * 
     * @param name single-String name to split into first- and lastName parts.
     * @throws IllegalArgumentException if name argument is null.
     * @return chainable self-reference.
     */
    private Customer splitName(String name) {
        // TODO implement here
        return null;
    }

}