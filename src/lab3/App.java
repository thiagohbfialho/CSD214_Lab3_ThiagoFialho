package lab3;

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

    public App(){
        this.listBooks = new ArrayList<Book>();
        this.listMagazines = new ArrayList<Magazine>();
        this.listDiscMags = new ArrayList<DiscMag>();
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
        System.out.println("1. Add a Book");
        System.out.println("2. Edit a Book");
        System.out.println("3. Delete a Book");
        System.out.println("4. List Book");
        System.out.println("5. Add Magazine");
        System.out.println("6. List Magazine");
        System.out.println("7. Add Disc Magazine");
        System.out.println("8. List Disc Magazine");
        System.out.println(" ");
        System.out.println("9. Quit");
    }

    public static void run(){

        App app = new App();

        int exit = 0;

        while (exit != 9){

            app.menu();
            System.out.println(" Choose one option!");

            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();

            exit = Integer.parseInt(nextLine);
            if(exit == 1){
                //Add a new Book
                if(!app.addBook()) exit = 9;
            }else if(exit == 2){
                //Edit a book
                app.editBook();
            }else if(exit == 3){
                //Delete a book
                app.deleteBook();
                System.out.println("Book deleted");
            }else if(exit == 4){
                //Book listed
                app.getListBooks();
            }else if(exit == 5){
                //Add Magazine
                if(app.addMagazine(false)) exit = 9;
                System.out.println("Magazine added");
            }else if(exit == 6){
                //List Magazine
                app.getListMagazines();
            }else if(exit == 7){
                //Add Disc Magazine
                if(app.addMagazine(true)) exit = 9;
                System.out.println("Disc Magazine added");
            }else if(exit == 8){
                //List Disc Magazine
                app.getListDiscMagazines();
                System.out.println("Disc Magazine listed");
            }

            if(exit == 9) {
                System.out.println("Bye!!!");
            }
        }
    }
}
