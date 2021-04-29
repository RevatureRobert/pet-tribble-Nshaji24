package model;

public class Lab {
    private int labId;
    private int numOfEmployees;

    public int getLabId() {
        return labId;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "labId=" + labId +
                ", numOfEmployees=" + numOfEmployees +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public Lab() {
    }

    public Lab(int labId, int numOfEmployees, String location, int capacity) {
        this.labId = labId;
        this.numOfEmployees = numOfEmployees;
        this.location = location;
        this.capacity = capacity;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private String location;
    private int capacity;

}
