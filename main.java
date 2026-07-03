
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HotelSystem hotel = new HotelSystem();

        while (true) {

            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");

            System.out.println("1.Search Rooms");

            System.out.println("2.Book Room");

            System.out.println("3.Cancel Booking");

            System.out.println("4.View Booking");

            System.out.println("5.Exit");

            System.out.print("Enter Choice : ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:

                    hotel.searchRooms();

                    break;

                case 2:

                    System.out.print("Customer Name : ");

                    sc.nextLine();

                    String name = sc.nextLine();

                    System.out.print("Room Number : ");

                    int room = sc.nextInt();

                    hotel.bookRoom(name, room);

                    break;

                case 3:

                    System.out.print("Room Number : ");

                    int r = sc.nextInt();

                    hotel.cancelBooking(r);

                    break;

                case 4:

                    hotel.viewBookings();

                    break;

                case 5:

                    System.out.println("Thank You");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");

            }

        }

    }

}