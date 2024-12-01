package at.htl;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Cloneable {

    private int id;
    private String name;
    private LocalDate dob;
    private Location location;

    public Person() {
    }

    public Person(int id, String name, LocalDate dob, Location location) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return getId() == person.getId() && Objects.equals(getName(), person.getName()) && Objects.equals(getDob(), person.getDob()) && Objects.equals(getLocation(), person.getLocation());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getDob());
        result = 31 * result + Objects.hashCode(getLocation());
        return result;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Person clone = (Person) super.clone();
//        clone.setLocation(
//                new Location(location.getCity(),
//                        location.getStreet(),
//                        location.getHouseNo()
//                )
//        );
//        return clone;
//    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        Location cloneLocation = (Location) location.clone();
        clone.setLocation(cloneLocation);
        return clone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
