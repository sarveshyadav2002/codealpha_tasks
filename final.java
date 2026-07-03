
import java.io.*;
import java.util.*;

class HotelSystem {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public HotelSystem() {

        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));
        rooms.add(new Room(301, "Suite", 5000));

        loadBookings();
    }

    public void searchRooms() {

        System.out.println("\nAvailable Rooms");

        for (Room r : rooms) {

            if (r.isAvailable()) {

                System.out.println(r);
            }

        }

    }

    public void bookRoom(String name, int roomNo) {

        for (Room r : rooms) {

            if (r.getRoomNumber() == roomNo && r.isAvailable()) {

                if (Payment.makePayment(r.getPrice())) {

                    r.setAvailable(false);

                    Booking b = new Booking(name,
                            roomNo,
                            r.getCategory(),
                            r.getPrice());

                    bookings.add(b);

                    saveBookings();

                    System.out.println("Booking Successful");

                }

                return;
            }

        }

        System.out.println("Room not available.");

    }

    public void cancelBooking(int roomNo) {

        Iterator<Booking> it = bookings.iterator();

        while (it.hasNext()) {

            Booking b = it.next();

            if (b.getRoomNumber() == roomNo) {

                it.remove();

                for (Room r : rooms)

                    if (r.getRoomNumber() == roomNo)

                        r.setAvailable(true);

                saveBookings();

                System.out.println("Booking Cancelled");

                return;
            }

        }

        System.out.println("Booking not found.");

    }

    public void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No Bookings.");

            return;
        }

        for (Booking b : bookings) {

            System.out.println("----------------------");

            System.out.println("Customer : " + b.getCustomerName());

            System.out.println("Room : " + b.getRoomNumber());

            System.out.println("Category : " + b.getCategory());

            System.out.println("Amount : ₹" + b.getAmount());

        }

    }

    private void saveBookings() {

        try {

            PrintWriter pw = new PrintWriter(new FileWriter("bookings.txt"));

            for (Booking b : bookings)

                pw.println(b);

            pw.close();

        }

        catch (Exception e) {

            System.out.println(e);

        }

    }

    private void loadBookings() {

        File file = new File("bookings.txt");

        if (!file.exists())

            return;

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String data[] = sc.nextLine().split(",");

                Booking b = new Booking(

                        data[0],

                        Integer.parseInt(data[1]),

                        data[2],

                        Double.parseDouble(data[3]));

                bookings.add(b);

                for (Room r : rooms)

                    if (r.getRoomNumber() == b.getRoomNumber())

                        r.setAvailable(false);

            }

            sc.close();

        }

        catch (Exception e) {

            System.out.println(e);

        }

    }

}