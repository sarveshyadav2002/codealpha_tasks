class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean available;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        available = status;
    }

    @Override
    public String toString() {
        return roomNumber + " | " + category + " | ₹" + price + " | "
                + (available ? "Available" : "Booked");
    }
}
