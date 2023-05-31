package entity;

public abstract class House {
    private double price;
    private double squareMeter;
    private int rooms;
    private int saloons;

    House(double price, double squareMeter, int rooms, int saloons) {
        this.price = price;
        this.squareMeter = squareMeter;
        this.rooms = rooms;
        this.saloons = saloons;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareMeter() {
        return squareMeter;
    }

    public int getRooms() {
        return rooms;
    }

    public int getSaloons() {
        return saloons;
    }
}