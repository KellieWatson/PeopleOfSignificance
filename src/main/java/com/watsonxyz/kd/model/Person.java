package com.watsonxyz.kd.model;

import java.util.Objects;



public class Person extends AbstractEntity {

    private final String firstName;
    private final String lastName;
    private final String email;
    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName =lastName;
        this.email = email;
    }

    public String getName() {
        return this.getFirstName() +" " + this.getLastName();
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

    @Override
    public int compareTo(AbstractEntity other) {
        Objects.requireNonNull(other);
        var compare = -1;
        if(other instanceof Person){
            compare = compareEmail((Person)other);
            if( compare == 0){
                compare = compareName((Person)other);
            }
            else{
                throw new IllegalArgumentException("Object Instance of type Customer Required for Comparison of this Entity Type.");

            }
        }
        return compare;
    }
    @Override
    public String toString(){
        return (this.getFirstName() + " " + this.getLastName()+ " " + this.getEmail());
    }
    @Override
    public int hashCode(){
        return this.getEmail().hashCode();
    }
    @Override
    public boolean equals(Object other){
        Objects.requireNonNull(other);
        boolean equal;
        if( other instanceof Person){
            Person otherUser = (Person)other;
            equal = this.isEmail(otherUser) &&
                    this.isLastName(otherUser) &&
                    this.isFirstName(otherUser);
        }
        else{
            equal = false;
        }
        return equal;
    }
    private int compareEmail(Person other){
        return(this.getEmail().compareTo(other.getEmail()));
    }
    private int compareLastName(Person other){
        return(this.getLastName().compareTo(other.getLastName()));
    }
    private int compareFirstName(Person other){
        return(this.getFirstName().compareTo(other.getFirstName()));
    }
    private int compareName(Person other){
        var compare = compareLastName(other);
        if(compare == 0){
            compare = compareFirstName(other);
        }
        return(compare);
    }
    private boolean isEmail(Person other){
        return this.getEmail().equals(other.getEmail());
    }
    private boolean isLastName(Person other){
        return this.getLastName().equals(other.getLastName());
    }
    private boolean isFirstName(Person other){
        return this.getFirstName().equals(other.getFirstName());
    }
}


