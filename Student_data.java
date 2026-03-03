import java.util.*;
 class Student{
     int rollno;
     int marks;
     String name;
     Student(int rollno,String name,int marks){
         this.rollno=rollno;
         this.name=name;
         this.marks=marks;
     }
     void display(){
         System.out.println("Name- "+name);
         System.out.println("Roll No- "+rollno);
         System.out.println("Marks- "+marks+"\n");
             
     }   
}
public class Student_data {
    
        static Scanner sc = new Scanner(System.in);
        static ArrayList<Student> student= new ArrayList<>();
    
    public static void main(String[] args){
        int again=7;
        do{
            // menu for all features to show to do Operations  
         int choice;
          System.out.println("---------------------------------------------------");
        System.out.println("1.Add Students\n2.Search Student\n3.Delete Student\n4.View All Students\n5.Topper\n6.update Student data\n7.Exit");
          System.out.println("---------------------------------------------------");
        System.out.println("Enter Choice to Proceed");
        if (sc.hasNextInt()) {
             choice = sc.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                 sc.next(); 
                 continue;
                }
        // switch case for calling methods for operations by taking Number of operation from user

        switch(choice){
            case 1: addStudent();
                    break;
            case 2: search(); 
                    break;
            case 3:  delete();
                    break;
            case 4: viewAll();
                    break;
            case 5: topper();
                    break;
            case 6: update();
                    break;
            case 7: again=0;
                    break;
            default: System.out.println("Enter Proper Choice");
            
        }            
            
        }while(again==7);    
         System.out.println("Thank you...");       
     }
     //student adding Method
     
        static void addStudent(){
         System.out.println("Enter No.of Students To Add");
         int num=sc.nextInt();
         
         for(int i=1;i<=num;i++){
             System.out.println("Add Student- "+i);
             System.out.println("Enter Name");
             sc.nextLine();
             String name=sc.nextLine();
             
             System.out.println("Enter Rollno");
             int rollno=sc.nextInt();
             for(Student s : student){
                  if(s.rollno == rollno){
                     System.out.println("Roll Number Already Exists!");
                     return;
                     }
                    }
             
             System.out.println("Enter Marks");
             int marks =sc.nextInt();
             
             student.add( new Student(rollno,name,marks));
         }
     }
     // display all students
    static void viewAll(){
        if(student.isEmpty()){
            System.out.println("No Student Data Exist");
        }
        else{
        for(Student s : student){
            s.display();
        }
            
        }
    }
    //searching student 
    static void search(){
        System.out.println("Enter Search Type-");
        System.out.println("1.By Name\n2.By Rollno\n3.By Marks");
        int type=sc.nextInt();
        switch(type){
        case 1: byName();
               break;

        case 2: byRollno();
               break;

        case 3: byMarks();
               break;            
        default: System.out.println("Enter Valid Choice Number");    
        }
           
    }
    //searching student by name
    static void byName(){
        System.out.println("Enter Name");
        sc.nextLine();
        String stu= sc.nextLine();
        boolean found= false;
        for(Student s : student){
            if(s.name.equalsIgnoreCase(stu)){
                s.display();
                found=true;                
            }
                
        }
        if(found==false){
            System.out.println("Student Not Found");
            
        }
        
    }
    //searching student by roll no.
    static void byRollno(){
        boolean found=false;
        System.out.println("Enter Roll No");
        int rollno =sc.nextInt();
        for(Student s: student){
            if(s.rollno==rollno){
                s.display();
                found=true;
            }
        }
        if(found==false){
            System.out.println("Student Not Found OF Roll No-"+rollno);
        }
    }
    //searching student by marks
    static void byMarks(){
          System.out.println("Enter Marks to Find Students");
          int marks=sc.nextInt();
         boolean found=false;
        for(Student s: student){
            if(s.marks==marks){
                s.display();
                found=true; 
            }
            
        }
        if(found==false){
            System.out.println("No Student Found Of Marks-"+marks);
        }        
    }
    //topper among all students
    static void topper(){
        if(student.isEmpty()){
        System.out.println("No Student Data Exist");
        return;
    }
        int max=0;
        for(Student s: student){
            if(max<s.marks){
                max=s.marks;
            }
            
        }
        for(Student s: student){
        if(max==s.marks){
            s.display();
        }
        }
    }
    //updating studnet data by name
    static void update() {
    System.out.println("Enter Name to Update:");
    sc.nextLine(); 
    String name = sc.nextLine();

    boolean found = false;

    for (Student s : student) {
        if (s.name != null && s.name.equalsIgnoreCase(name)) {

            System.out.println("Enter New Name:");
            s.name = sc.nextLine();

            System.out.println("Enter New Marks:");
            s.marks = sc.nextInt();

            System.out.println("Enter New Rollno:");
            s.rollno = sc.nextInt();

            System.out.println("Student Updated Successfully!");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student Not Found");
    }
}
static void delete() {
    System.out.println("Enter Roll no to Delete Student:");
    int roll = sc.nextInt();

    boolean removed = student.removeIf(s -> s.rollno == roll);

    if (removed) {
        System.out.println("Student data Deleted Successfully");
    } else {
        System.out.println("Student Not Found");
    }
}
}
