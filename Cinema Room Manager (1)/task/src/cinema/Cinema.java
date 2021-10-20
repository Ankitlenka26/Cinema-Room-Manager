package cinema;

import java.awt.*;
import java.util.Scanner;

public class Cinema {

    public static void statistics(char[][] seats,int row , int col){
        int totalIncome = 0;
        int currIncome = 0 ;
        int purchasedTickets = 0;
        for(int i=0 ;i<row ; i++){
            for(int j=0 ; j<col ; j++){
                if(seats[i][j] == 'B'){
                    purchasedTickets++;
                    if(row*col <= 60){
                        currIncome += 10;
                    }else{
                        if((i+1) <= row/2){
                            currIncome += 10;
                        }else{
                            currIncome += 8;
                        }
                    }
                }
            }
        }
        if(row*col <= 60){
            totalIncome = row*col*10;
        }else{
            int half = row/2;
            totalIncome = half*col*10;
            totalIncome += (row-half)*col*8;
        }
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.print("Percentage: ");
        System.out.printf("%.2f", (purchasedTickets*100/(float)(row*col)));
        System.out.println("%");
        System.out.println("Current income: $" + currIncome);
        System.out.println("Total Income: $" + totalIncome);
    }
    public static int ticketPrice(int row , int col , int currRow , int currCol){
        if(row*col <= 60){
            return 10;
        }else{
            int half = row/2;
            if(currRow > half){
                return 8;
            }else{
                return 10;
            }
        }
    }
    public static void printCinema(char[][] seats, int row , int col){
        System.out.println("Cinema:");
        for(int i=0 ; i< col + 1; i++){
            if(i==0){
                System.out.print("");
            }else{
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for(int i=0 ;i<row ; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < col; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void buyTicket(char[][] seats , int row , int col){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int currRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int currCol = scanner.nextInt();
        if(currRow-1 < 0 || currCol-1 < 0 || currRow-1 >= row || currCol-1 >= col){
            System.out.println("Wrong input!");
            buyTicket(seats,row,col);
        }else if(seats[currRow-1][currCol-1] == 'B'){
            System.out.println("That ticket has already been purchased!");
            buyTicket(seats,row,col);
        }else{
            int price = ticketPrice(row , col , currRow ,currCol);
            System.out.println("Ticket price: $" + price);
            seats[currRow-1][currCol-1] = 'B';
        }
    }
    public static void main(String[] args) {
//        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = scanner.nextInt();
        char[][] seats = new char[row][col];
        for(int i=0 ;i<row;i++){
            for(int j=0 ;j<col ; j++){
                seats[i][j] = 'S';
            }
        }
        System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit");
        int option = scanner.nextInt();
        while(option != 0) {
            if (option == 1) {
                printCinema(seats, row, col);
            } else if (option == 2) {
                buyTicket(seats , row , col);
            }else if(option == 3){
                statistics(seats , row , col);
            }
            System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit");
            option = scanner.nextInt();
        }
    }
}