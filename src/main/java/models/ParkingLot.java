package models;

class ParkingLot {

    private static ParkingLot parkingLot = null;

    private ParkingLot(){}

    public static ParkingLot getInstance(){
        if (parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
}
