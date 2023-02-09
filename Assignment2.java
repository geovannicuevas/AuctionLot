/*
Class: CSE 1322L
Section: JO5
Instructor: Harshitha Nirujogi
Term: Spring'23
Name: Geovanni Cuevas
Assignment: 2
 */
import java.util.ArrayList;
import java.util.Scanner;


public class Assignment2 {
    public static Lot getNextLot(ArrayList<Lot> auctionArrayList) {
        if (auctionArrayList.size() > 0) {
            Lot lot = auctionArrayList.get(0);
            auctionArrayList.remove(lot);
            return lot;
        }
        else {
            return new Lot();
        }
    }public static void addItem(ArrayList<Lot> lots) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the description of this item ");
        String description = sc.nextLine();
        System.out.println("What is the starting bid ");
        int startingBid = sc.nextInt();
        System.out.println("What is the bid increment ");
        int bidIncrement = sc.nextInt();
        Lot newLot = new Lot (description, startingBid, bidIncrement);
        lots.add(newLot);
    }public static void bid(Lot lot) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to bid?\n" + "Minimum bid is " + lot.nextBid());
        int newBid = sc.nextInt();
        if (newBid < lot.nextBid()) {
            System.out.println("You must bid at least " + lot.nextBid());
        }
        else lot.setCurrentBid(newBid);
    }
    public static void markSold(Lot lot) {
        lot.markSold();
        System.out.println(lot);
    }
    public static void mainMenu(ArrayList<Lot> arrayList) {
        Scanner sc = new Scanner(System.in);
        Lot currentLot = null;
        int userChoice = 0;
        do {
            if (currentLot != null && !currentLot.getDescription().equals("Unknown Item")){
                System.out.println("Current Lot:\n" + currentLot + "\n");
            }
            else {
                System.out.println("We are not currently bidding\n");
            }
            System.out.println("1. Add Lot to Auction\n" +
                    "2. Start bidding on next Lot\n" +
                    "3. Bid on current Lot\n" +
                    "4. Mark current Lot sold\n" +
                    "5. Quit");
            userChoice= sc.nextInt();
            switch (userChoice) {
                case 1:
                    addItem(arrayList);
                    break;
                case 2:
                    if (arrayList.size() == 0 ) {
                        System.out.println("There is nothing to bid on, add an item first");
                    }
                    else if (currentLot != null && !currentLot.getSold()){
                        System.out.println("You must mark the current lot as sold before bringing up the next " + "Lot");}

                    else{ currentLot = getNextLot(arrayList);
                    }
                    break;
                case 3:
                    if (currentLot == null || currentLot.getDescription().equals("Unknown Item") || currentLot.getSold()) {
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else bid(currentLot);
                    break;
                case 4:
                    if (currentLot == null || currentLot.getDescription().equals("Unknown Item") || currentLot.getSold()) {
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else markSold(currentLot);
                    break;
            }
        }
        while(userChoice !=5);
    }
    public static void main(String[] args) {
        ArrayList<Lot> Auction = new ArrayList<Lot>();
        mainMenu(Auction);
    }
}