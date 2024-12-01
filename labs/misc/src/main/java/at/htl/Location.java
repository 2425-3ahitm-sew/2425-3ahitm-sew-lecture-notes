package at.htl;

import java.util.Objects;

public class Location implements Cloneable {
    private String city;
    private String street;
    private int houseNo;

    public Location(String city, String street, int houseNo) {
        this.setCity(city);
        this.setStreet(street);
        this.setHouseNo(houseNo);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Location) obj;
        return Objects.equals(this.getCity(), that.getCity()) &&
                Objects.equals(this.getStreet(), that.getStreet()) &&
                this.getHouseNo() == that.getHouseNo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getHouseNo());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location[" +
                "city=" + getCity() + ", " +
                "street=" + getStreet() + ", " +
                "houseNo=" + getHouseNo() + ']';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }
}
