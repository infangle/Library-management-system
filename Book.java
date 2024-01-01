interface LibraryItem{
    void displayDetails();
    void checkout();
}
class Book implements LibraryItem {
    private String title;
    private String author;
    private boolean available;
    

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.available = true;

    }
    @Override
    public void displayDetails(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.print("Availability: ");
        if (available){
            System.out.println("Available");   
        }
        else{
            System.out.println("Not Available");
        }
    }

    @Override
    public void checkout(){
        if (available){
            available = false;
            System.out.println("Checkout Successful");
        }
        else{
            System.out.println("Book  not Available");
        }
    }


}

class DVD implements LibraryItem{
    private String title;
    private String director;
    private boolean available;

    public DVD(String title, String director){
        this.title = title;
        this.director = director;
        this.available = true;
    }

    @Override
    public void displayDetails(){
        System.out.println("Title: "+title);
        System.out.println("Director"+director);
        System.out.print("Availability: ");
        if(available){
            System.out.println("Available");
        }
        else{
            System.out.println("Not Available");
        }
    }

    @Override
    public void checkout(){
        if(available){
            available = false;
            System.out.println("Checkout Successful");
        }
        else{
            System.out.println("DVD not available");
        }
    }
}

interface LibraryUser{
    int getUserId();
    void displayUserInfo();
}

class Student implements LibraryUser{
    private int studId;

    public Student(int studId){
        this.studId = studId;
    }

    @Override
    public int getUserId(){
        return studId;
    }

    @Override
    public void displayUserInfo(){
        System.out.println("Student: "+studId);
    }
}

class Faculty implements LibraryUser{
    private int facultyId;

    public Faculty(int facultyId){
        this.facultyId = facultyId;
    }

    @Override
    public int getUserId(){
        return facultyId;
    }

    @Override
    public void displayUserInfo(){
        System.out.println("Faculty Member: "+facultyId);
    }

}

interface Transaction{
    void  IssueItem(LibraryItem item, LibraryUser user);
    void returnItem(LibraryItem item, LibraryUser user);
}

class LibraryTransaction implements Transaction{
        @Override
        public void IssueItem(LibraryItem item, LibraryUser user) {
            System.out.print("Issuing an item to ");
            item.checkout(); 
            user.displayUserInfo(); 
            System.out.println("User Information :");
            user.displayUserInfo();
        }
        
        @Override
        public void returnItem(LibraryItem item, LibraryUser user) {
            System.out.println("Returning the item ");
            item.checkout();
            System.out.println("User Information: ");
            user.displayUserInfo();

        }


        }
class Main{
public static void main(String[] args){
    Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    DVD dvd = new DVD("Inception", "Christopher Nolan");
    Student student = new Student(1673);
    Faculty faculty = new Faculty(1763);

    LibraryTransaction transaction = new LibraryTransaction();

    transaction.IssueItem(book, student);

    transaction.IssueItem(dvd, faculty);

    transaction.returnItem(book, student);

    transaction.returnItem(dvd, faculty);


}
}
        

