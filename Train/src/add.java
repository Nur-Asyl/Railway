import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class add {
    private String ticketName;
    private String name;
    private int date;

    public add() {

    }

    public String getTicketName() {
        return ticketName;
    }



    public int getDate() {
        return date;
    }

    public ArrayList<person> buy = new ArrayList<person>();

    public add(String name, int date, String ticketName) {
        this.name = name;
        this.date= date;
        this.ticketName= ticketName;
    }
    public void buy(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write your name:");
        String name = input.nextLine();
        System.out.println("Date:");
        int date = input.nextInt();
        System.out.println("Where");
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();
        Map<String, String> cityRoads = new HashMap<>();
        cityRoads.put("Almaty", "Almaty - Taraz" +"," + "5400 tg" + " ," + "Plackart"+""+
                "Almaty - Astana"+" ," + "6500 tg"+" ,"+"Coupe"+""+
                "Almaty - Kostanai" +" ,"+ "15000 tg"+" ,"+ "Luxury"+""+
                "Almaty - KODA" +" ,"+ "5400 tg"+" ," + "Plackart");
        cityRoads.put("Taraz", "Astana-Shymkent" + ", "+ "8091 tg" + ","+ "Plackart"+""+
                "Kokshetau-Kyzylorda"+" ," + "6696 tg"+" ,"+"Plackart"+""+
                "Pavlodar-Shymkent" +" ,"+ "11242 tg"+" ,"+ "Luxury"+""+
                "Kostanai-Shymkent" +" ,"+ "7400 tg"+" ," + "Plackart");
        if (cityRoads.containsKey(city)) {
            System.out.println(cityRoads.get(city));
            System.out.println("Choose one of them:");
            Scanner sc1 = new Scanner(System.in);
            String choose = sc1.nextLine();
            System.out.println("---------------------------------------");
            System.out.println("Сongratulations, you have successfully bought a ticket!!!");
            System.out.println("---------------------------------------");
            System.out.println();
            person train = new person(name,date,ticketName);
            buy.add(train);
        } else {
            System.out.println("Sorry, information on roads in that city is not available.");
            System.out.println("---------------------------------------");
        }

    }

    public void searchPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter ticketname");
        String ticketName= scanner.nextLine();
        for(person person : buy){
            if(person.getName().equals(name)){
                System.out.println("Refund issued");
                System.out.println("---------------------------------------");
            }
            else{
                System.out.println("Refund not issued");
                System.out.println("---------------------------------------");
            }
        }
        System.out.println();
    }
    public void startAdd(){
        System.out.println("SELLECT PLESE:");
        Scanner input = new Scanner(System.in);
        int menu = 0;
        while(menu!=1){
            System.out.println("To buy, press 1");
            System.out.println("To refund ticket, press 2");
            menu = input.nextInt();
            switch (menu){
                case 1:
                    buy();
                    break;
                case 2:
                    searchPerson();
                    break;
            }
        }
    }
}