class Booking {

    private String customerName;
    private int roomNumber;
    private String category;
    private double amount;

    public Booking(String customerName, int roomNumber,
                   String category, double amount) {

        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {

        return customerName + "," +
                roomNumber + "," +
                category + "," +
                amount;
    }
}
