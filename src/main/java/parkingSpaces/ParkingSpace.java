package parkingSpaces;

public abstract class ParkingSpace {
    private int Id;
    private boolean taken = false;
    private String carInSpace;

    public ParkingSpace(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String getCarInSpace() {
        return carInSpace;
    }

    public void setCarInSpace(String carInSpace) {
        this.carInSpace = carInSpace;
    }
}
