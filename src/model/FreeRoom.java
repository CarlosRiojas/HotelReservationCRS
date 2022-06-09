package model;

public class FreeRoom extends Room{
    public FreeRoom() {
        this.price = 0.0;
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumartion=" + enumartion +
                '}';
    }
}
