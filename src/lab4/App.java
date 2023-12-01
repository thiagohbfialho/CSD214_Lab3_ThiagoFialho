package lab4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author tfialho
 */
public class App {

    private ArrayList<Book> listBooks;
    private ArrayList<Magazine> listMagazines;
    private ArrayList<DiscMag> listDiscMags;
    private ArrayList<Ticket> listTickets;
    private CashTill cashTill;

    public App(){
        this.listBooks = new ArrayList<Book>();
        this.listMagazines = new ArrayList<Magazine>();
        this.listDiscMags = new ArrayList<DiscMag>();
        this.listTickets = new ArrayList<Ticket>();
        cashTill = new CashTill();
    }

    public boolean addBook(){
        System.out.println("------------------ Add Books ------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Author ('q' to quit):");
        String name = scanner.nextLine();
        if(name.equals("q")) return false;
        System.out.println("Copies:");
        int copies = Integer.parseInt(scanner.nextLine());
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Price:");
        double price = Double.parseDouble(scanner.nextLine());
        Book book = new Book(name, title, price, copies);
        this.listBooks.add(book);
        return true;
    }

    public boolean  addMagazine(boolean discMag){
        if(discMag){
            System.out.println("------------------ Add DiscMags ------------------");
        }else{
            System.out.println("------------------ Add Magazines ------------------");
        }
        System.out.println("------------------ Magazines ------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Title: ('q' to quit):");
        String title = scanner.nextLine();
        if(title.equals("q")) return true;
        System.out.println("Copies:");
        int copies = Integer.parseInt(scanner.nextLine());
        System.out.println("Quantity to Order:");
        int orderQty = Integer.parseInt(scanner.nextLine());
        System.out.println("Price:");
        double price = Double.parseDouble(scanner.nextLine());
        Date currIssue = new Date();
        if(discMag){
            DiscMag discMagazine = new DiscMag(title,price,orderQty,currIssue,copies);
            this.listDiscMags.add(discMagazine);
        }else{
            Magazine magazine = new Magazine(title,price,orderQty,currIssue,copies);
            this.listMagazines.add(magazine);
        }
        return false;
    }

    public boolean addTicket(){
        System.out.println("------------------ Add Ticket ------------------");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the description ('q' to quit):");
        String description = scanner.nextLine();
        if(description.equals("q")) return false;
        System.out.println("Price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Client");
        String client = scanner.nextLine();
        Ticket ticket = new Ticket(description, price, client);
        this.listTickets.add(ticket);
        return true;
    }

    public boolean editBook(){
        this.getListBooks();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book's number:");
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= this.listBooks.size() && !this.listBooks.isEmpty()){
            System.out.println("------------------ Edit Books ------------------");
            System.out.println("Enter new Author ('q' to quit):");
            String name = scanner.nextLine();
            if(name.equals("q")) return false;
            listBooks.get(number-1).setAuthor(name);
            System.out.println("Copies:");
            listBooks.get(number-1).setCopies(Integer.parseInt(scanner.nextLine()));
            System.out.println("Title:");
            listBooks.get(number-1).setTitle(scanner.nextLine());
            System.out.println("Price:");
            listBooks.get(number-1).setPrice(Double.parseDouble(scanner.nextLine()));
            return true;
        }
        return false;
    }

    public boolean editTicket(){
        this.getListTickets();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ticket's number:");
        int numberTicket = Integer.parseInt(scanner.nextLine());
        if(numberTicket <= this.listTickets.size() && !this.listTickets.isEmpty()){
            System.out.println("------------------ Edit Tickets ------------------");
            System.out.println("Enter new Description ('q' to quit):");
            String description = scanner.nextLine();
            if(description.equals("q")) return false;
            listTickets.get(numberTicket-1).setDescription(description);
            System.out.println("Price:");
            listTickets.get(numberTicket-1).setPrice(scanner.nextDouble());
            System.out.println("Client:");
            listTickets.get(numberTicket-1).setClient(scanner.nextLine());
            return true;
        }
        return false;
    }

    public boolean editMagazine(){
        this.getListDiscMagazines();
        System.out.println("Enter the magazine's number:");
        System.out.println("------------------ Edit DiscMags ------------------");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= this.listMagazines.size() && !this.listMagazines.isEmpty()) {
            System.out.println("Enter Title: ('q' to quit):");
            String title = scanner.nextLine();
            if(title.equals("q")) return true;
            listMagazines.get(number-1).setTitle(title);
            System.out.println("Copies:");
            listMagazines.get(number-1).setCopies(Integer.parseInt(scanner.nextLine()));
            System.out.println("Quantity to Order:");
            listMagazines.get(number-1).setOrderQty(Integer.parseInt(scanner.nextLine()));
            System.out.println("Price:");
            listMagazines.get(number-1).setPrice(Double.parseDouble(scanner.nextLine()));
            listMagazines.get(number-1).setCurrIssue(new Date());
            return true;
        }
        return false;
    }

    public boolean deleteBook(){
        this.getListBooks();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book's number:");
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= this.listBooks.size() && !this.listBooks.isEmpty()){
            this.listBooks.remove(number-1);
            return true;
        }
        return false;
    }

    public boolean deleteTicket(){
        this.getListTickets();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ticket's number:");
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= this.listTickets.size() && !this.listTickets.isEmpty()){
            this.listTickets.remove(number-1);
            return true;
        }
        return false;
    }

    public boolean deleteMagazine(){
        this.getListMagazines();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the magazine's number:");
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= this.listMagazines.size() && !this.listMagazines.isEmpty()){
            this.listMagazines.remove(number-1);
            return true;
        }
        return false;
    }

    private void viewBook() {
        this.getListBooks();
    }

    private void viewTicket() {
        this.getListTickets();
    }

    private void viewMagazine() {
        this.getListMagazines();
    }

    public boolean sellBook(){
        this.getListBooks();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book's number:");
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= this.listBooks.size() && !this.listBooks.isEmpty()){
            if(this.listBooks.get(number-1).getCopies()>0){
                cashTill.sellItem((SaleableItem) this.listBooks.get(number-1));
            }else{
                System.out.println("Item unavailable");
            }
            return true;
        }
        return false;
    }

    public boolean sellTicket(){
        this.getListTickets();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ticket's number:");
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= this.listTickets.size() && !this.listTickets.isEmpty()){
            cashTill.sellItem((SaleableItem) this.listTickets.get(number-1));
            //this.listTickets.get(number-1).sellCopy();
            return true;
        }
        return false;
    }

    public void getList(ArrayList<Publication> listPub, String name){
        if(!listPub.isEmpty()){
            System.out.println("------------------ " + name + " ------------------");
            int count = 1;
            for (Publication p : listPub){
                System.out.println(count + ". " + p.getTitle());
            }
            System.out.println("-------------------------------------------");
        }
    }

    public void getListBooks(){
        if(!listBooks.isEmpty()){
            System.out.println("------------------ Books ------------------");
            int count = 1;
            for (Book b : listBooks){
                System.out.println(count + ". " + b.getTitle());
                count++;
            }
            System.out.println("-------------------------------------------");
        }
    }

    public void getListTickets(){
        if(!listTickets.isEmpty()){
            System.out.println("------------------ Tickets ------------------");
            int count = 1;
            for (Ticket t : listTickets){
                System.out.println(count + ". " + t.getDescription());
                count++;
            }
            System.out.println("-------------------------------------------");
        }
    }

    public void getListMagazines(){
        if(!listMagazines.isEmpty()){
            System.out.println("------------------ Magazines ------------------");
            int count = 1;
            for (Magazine m : listMagazines){
                System.out.println(count + ". " + m.getTitle());
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void getListDiscMagazines(){
        if(!listDiscMags.isEmpty()){
            System.out.println("------------------ DiscMags ------------------");
            int count = 1;
            for (DiscMag d : listDiscMags){
                System.out.println(count + ". " + d.getTitle());
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void menu(){

        System.out.println("-------------------------Main---------------------------------");
        System.out.println("1. Books");
        System.out.println("2. Tickets");
        System.out.println("3. Magazines");
        System.out.println("4. exit");
        System.out.println("--------------------------------------------------------------");
    }

    public void menuBooks(){

        System.out.println("-------------------------Books---------------------------------");
        System.out.println("1. Add a Book");
        System.out.println("2. Edit a Book");
        System.out.println("3. Delete a Book");
        System.out.println("4. List a Book");
        System.out.println("5. Sell a Book");
        System.out.println("6. exit");
        System.out.println("--------------------------------------------------------------");
    }

    public void menuTickets(){

        System.out.println("-------------------------Tickets---------------------------------");
        System.out.println("1. Add a Ticket");
        System.out.println("2. Edit a Ticket");
        System.out.println("3. Delete a Ticket");
        System.out.println("4. List a Ticket");
        System.out.println("5. Sell a Ticket");
        System.out.println("6. exit");
        System.out.println("--------------------------------------------------------------");

    }

    public void menuMagazines(){

        System.out.println("-------------------------Magazines---------------------------------");
        System.out.println("1. Add Magazine");
        System.out.println("2. Edit a Magazine");
        System.out.println("3. Delete a Magazine");
        System.out.println("4. List Magazine");
        System.out.println("5. exit");
        System.out.println("--------------------------------------------------------------");
    }


    public static void run(){

        App app = new App();

        int exit = 0;
        boolean close = false;

        while (!close){

            app.menu();
            System.out.println(" Choose one option!");

            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();

            exit = Integer.parseInt(nextLine);

            switch (exit){
                case 1:
                    app.menuBooks();
                    System.out.println(" Choose one option!");
                    nextLine = scanner.nextLine();
                    int submenu = Integer.parseInt(nextLine);
                    switch (submenu){
                        case 1:
                            if(!app.addBook()) {
                                close = true;
                            }
                            continue;
                        case 2:
                            if(!app.editBook()) {
                                close = true;
                            }
                            continue;
                        case 3:
                            app.deleteBook();
                            continue;
                        case 4:
                            app.viewBook();
                            continue;
                        case 5:
                            app.sellBook();
                            continue;
                        case 6:
                            close = true;
                            continue;
                        default:
                            System.out.println("Number invalid!");
                            continue;
                    }
                case 2:
                    app.menuTickets();
                    System.out.println(" Choose one option!");
                    nextLine = scanner.nextLine();
                    int submenu2 = Integer.parseInt(nextLine);
                    switch (submenu2){
                        case 1:
                            if(!app.addTicket()) {
                                close = true;
                            }
                            continue;
                        case 2:
                            if(!app.editTicket()) {
                                close = true;
                            }
                            continue;
                        case 3:
                            app.deleteTicket();
                            continue;
                        case 4:
                            app.viewTicket();
                            continue;
                        case 5:
                            app.sellTicket();
                            continue;
                        case 6:
                            close = true;
                            continue;
                        default:
                            System.out.println("Number invalid!");
                            continue;
                    }
                case 3:
                    app.menuMagazines();
                    System.out.println(" Choose one option!");
                    nextLine = scanner.nextLine();
                    int submenu3 = Integer.parseInt(nextLine);
                    switch (submenu3){
                        case 1:
                            if(!app.addMagazine(false)) {
                                close = true;
                            }
                            continue;
                        case 2:
                            if(!app.editMagazine()) {
                                close = true;
                            }
                            continue;
                        case 3:
                            app.deleteMagazine();
                            continue;
                        case 4:
                            app.viewMagazine();
                            continue;
                        case 5:
                            close = true;
                            continue;
                        default:
                            System.out.println("Number invalid!");
                            continue;
                    }
                case 4:
                    close = true;
            }

            if(close) {
                System.out.println("Bye!!!");
            }
        }
    }


}
