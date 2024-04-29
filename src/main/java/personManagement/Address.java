package personManagement;

public class Address {
    private String postalCode;
    private String city;
    private String streetName;
    private String houseNumber;

    public Address(String postalCode, String city, String streetName, String houseNumber) {
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setStreetName(streetName);
        this.setHouseNumber(houseNumber);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return streetName + " " + houseNumber + ", " + postalCode + " " + city;
    }
}
