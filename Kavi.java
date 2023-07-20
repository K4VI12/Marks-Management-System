import java.util.*;
public class Kavi{

    public static void menu(String[][] student, int[][] marks) {
        Scanner input = new Scanner(System.in);
       for (int i=0; i<81; i++)
		{
			System.out.printf("-");
		}
		
		System.out.printf("\n|\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t|\n");
		for (int i=0; i<81; i++)
		{
			System.out.print("-");
		}
		System.out.print("\n[1] Add New Student\t\t\t[2] Add New Student with Marks\n[3] Add Marks\t\t\t\t[4] Update Student Details\t\t\t\t\n");
		System.out.print("[5] Update Marks \t\t\t[6] Delete Student\n[7] Print Student Details\t\t[8] Print Student Ranks\n");
		System.out.println("[9] Best in Programming Fundamentals\t[10] Best in Database Management System\n");
		
		
        System.out.print('\n' + "Enter an option to continue > ");
        int option = input.nextInt();
        
        
		
        switch (option){
            case 1:
                add_New_Student(student, marks);
                break;
            case 2:
                add_New_Student_With_Marks(student, marks);
                break; 
            case 3:
                add_Marks(student, marks);
                break;
            case 4:
                update_Student_Details(student, marks);
                break;
            case 5:
                update_Marks(student, marks);
                break;
            case 6:
                delete_Student(student, marks);
                break;
            case 7:
                print_Student_Details(student, marks);
                break;
            case 8:
                Print_Student_Ranks(student,marks);
                break;
            case 9:
                best_In_Programming_Fundamentals(student,marks);
                break;
            case 10:
                best_in_Database_Management_System(student,marks);
                break;
            default:
                System.out.println("\nWrong number\n");
				menu(student, marks);
			
			
        }
        
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
// Handle any exceptions.
        }
    }

    public static int nextValues(String[][] student) {//__for next ______________________
        int index = student.length;
        for (int i = 0; i < student.length; i++) {
            if (student[i][0] == null) {
                index = i;
                break;

            }

        }

        return index;
    }

    public static void add_New_Student(String[][] student, int[][] marks) {
        Scanner input = new Scanner(System.in);
        clearConsole();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tADD NEW STUDENT\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------");

        int index = nextValues(student);

        L1:
        for (int i = index; i < student.length; i++) {
            index = nextValues(student);
            System.out.print("Enter student id \t: ");
            String id = input.nextLine();
			
            for (int j = 0; j < student.length; j++) {
                if (id.equals(student[j][0])) {
                    System.out.println("Already exist!");
                    i--;
                    continue L1;
                }
            }
            student[index][0] = id;

            System.out.print("Enter student name \t: ");
            student[index][1] = input.nextLine();
            System.out.print('\n' + "Student has been Successful.Do you want to add a new student( Y/N ) : ");
            String x = input.nextLine();
            if (x.equals("N") | x.equals("n"))
            {
                menu(student, marks);
            }

            if (x.equals("Y") | x.equals("y"))
            {
				continue L1;
            
			}else if (x.equals("N") | x.equals("n")){
				menu(student, marks);
				
			}else {
				System.out.print("Wrong option !\n ");
				continue L1;
			}
        }
    }

    public static void add_New_Student_With_Marks(String[][] student, int[][] marks) {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                        ADD NEW STUDENT WITH MARKS                      |");
        System.out.println("--------------------------------------------------------------------------");

        int index = nextValues(student);
        L1:
        for (int i = index; i < student.length; i++) {
            index = nextValues(student);
            System.out.print("Enter student id \t: ");
            String id = input.nextLine();
            
            for (int j = 0; j < student.length; j++) {
                if (id.equals(student[j][0])) {
                    System.out.println("Already exist!");
                    i--;
                    continue L1;
                }
            }
            student[index][0] = id;
            System.out.print("Enter student name \t: ");
            student[index][1] = input.nextLine();

            for (int x = index; ; x++) {
                System.out.print("Program fundamental marks : ");
                marks[x][0] = input.nextInt();
                if (marks[x][0] < 0 | marks [x][0]>100) {
                    System.out.println("Invalid marks please enter correct marks." + '\n');

                } else
                    break;
            }
            for (int x = index; ; x++) {
                System.out.print("Database management marks  : ");
                marks[x][1] = input.nextInt();
                if (marks[x][1] < 0 | marks[x][1]>100 )
                {
                    System.out.println("Invalid marks please enter correct marks." + '\n');
                } else
					
                    break;
            }
            System.out.print('\n' + "Student has been successfully added.Do you want to add a new student(Y/N): ");
            String x = input.next();
            if (x.equals("N") | x.equals("n"))
            {
                menu(student, marks);

            }if (x.equals("Y") | x.equals("y"))
                add_New_Student_With_Marks(student, marks);

            else {
				System.out.print("Wrong option !\n ");
				continue L1;
			}
        }
    }

    public static void add_Marks(String[][] student,int [][]marks) {//____________Add Marks sub method______________
        Scanner input = new Scanner(System.in);

        clearConsole();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                          Add Marks                                           |");
        System.out.println("--------------------------------------------------------------------------------");

        for (int h = 0; h < student.length; h++) {
            String check;
            int x = -1;//if 676  line x=0 ,condition true...
            for (int z = 0; z < student.length; z++) {
                System.out.print("Enter Student ID : ");
                String id = input.nextLine();

                L3:
                for (int i = 0; i < student.length; i++) {
                    if (id.equals(student[i][0]))//check id in all Array
                        x = i;//if true assign i to x
                    if (i == x)
                        break L3;
                }
                if (x == -1) {//--->check (-) numbers
                    System.out.print("Invalid Student ID.Do you want to Search again?(Y/N) : ");
                    check = input.nextLine();
                    if (check.equals("Y") | check.equals("y")){
                        continue;
					}
                    if (check.equals("N") | check.equals("n")){
                        menu(student, marks);
					}
                } else
                    break;
            }
            System.out.println("Student Name     : " + student[x][1]);
            if (marks[x][0] == 0 && marks[x][1] == 0) {
                System.out.println();
            } else {
                System.out.println("programming Fundamental Marks : " + marks[x][0]);
                System.out.println("Database Management Marks     : " + marks[x][1]);
                System.out.println('\n' + "This Student's have been already added.");
                System.out.println("If you want to update the marks.please use [4] Update Marks Option." + '\n');
                System.out.print('\n' + "DO you want to add mark for another student? (Y/N) :");
                String q = input.nextLine();
                if (q.equals("Y") | q.equals("y")){
                    continue;
				}if (q.equals("N") | q.equals("n")){
					
                    menu(student, marks);
				}
            }

            for (int i = 0; ; i++) {//equls to while loop
				
                System.out.print("programming Fundamental Marks : ");
                marks[x][0] = input.nextInt();
                //int t = marks[x][0];
                if (marks[x][0] < 0  | marks[x][0]>100 ) {
                    System.out.println("Invalid marks,please enter correct marks." + '\n');
                } else {
                    break;
                }
            }

            for (int i = 0; ; i++) {
				
                System.out.print("Database Management Marks : ");
                marks[x][1] = input.nextInt();
                int t = marks[x][1];
                if (t < 0)
                    System.out.println("Invalid marks,please enter correct marks." + '\n');
                else
                    break;
            }

            System.out.print('\n' + "Student has been Successively.Do you want to add a new student( Y/N ) : ");
            String N = input.next();
            if (N.equals("N")|N.equals("n")) {
                menu(student,marks);
            }if (N.equals("Y")|N.equals("y"))
                continue;
        }
    }

    public static void update_Student_Details(String[][] student, int[][] marks) {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                          UPDATE STUDENT DETAILS                               |");
        System.out.println(" -------------------------------------------------------------------------------");
        System.out.println();

        L1:
        for (int i = 0; i < student.length; i++) {
            System.out.print("Enter student id :");
            String id = input.nextLine();
            int j = 0;
            for (; j < student.length; j++) {
                if (id.equals(student[j][0])) {
                    break;

                }

            }
            System.out.print("Student name :");
            System.out.print(student[j][1]);

            System.out.print(" \n Enter the new student name :");
            student[j][1] = input.nextLine();


            System.out.print('\n' + "Student has been added successfully,Do you want to add a new student(Y/N) : ");
            String N = input.nextLine();
            if (N.equals("N") | N.equals("n")) {
                menu(student, marks);
            }
            if (N.equals("Y") | N.equals("y"))
                continue L1;
        }
    }

    public static void update_Marks(String[][] student, int[][] marks) {//_____Update Student Details________-------------------------
        Scanner input = new Scanner(System.in);
        clearConsole();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                            Update Marks                                     |");
        System.out.println(" ------------------------------------------------------------------------------");
        System.out.println();

        L1:
        for (int i = 0; i < student.length; i++) {
            System.out.print("Enter Student ID : ");
            String id = input.nextLine();
            int x = 0;
            for (; x < student.length; x++) {
                if (id.equals(student[x][0])) {
                    break;

                }
            }

            System.out.print("Student Name : ");
            System.out.println(student[x][1] + '\n');
            for (int n = 0; n < student.length; n++) {
                if (student[x][2] == null) {
                    System.out.println("This Student's marks yet to be added");

                    System.out.print("Do you want to Update marks for anther student ( Y/N ) :");
                    String y = input.nextLine();
                    if (y.equals("N") | y.equals("n")) {

                        menu(student, marks);
                    }

                    if (y.equals("Y") | y.equals("y")) {
                        continue L1;


                    }
                }

                System.out.print("programming fundamentals Marks  : ");
                System.out.println(marks[x][0]);

                System.out.print("Database Management System Marks  : ");
                System.out.println(marks[x][1] + '\n');

                System.out.print("Enter new programming fundamentals Marks  : ");
                marks[x][0] = input.nextInt();

                System.out.print("Enter new Database Management System Marks  : ");
                marks[x][1] = input.nextInt();

                System.out.println('\n' + "Marks have been Updated Successively.");
                System.out.print("Do you want to Update marks for anther student ( Y/N ) : ");
                String y = input.nextLine();
                if (y.equals("N") | y.equals("n")) {

                    menu(student, marks);
                }

                if (y.equals("Y") | y.equals("y")) ;
                continue L1;


            }

        }
    }

    public static void delete_Student(String[][] student, int[][] marks) {
        Scanner input = new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("|                          DELETE STUDENT                                 |");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();

        L1:
        for (int i = 0; i < student.length; i++) {

            System.out.print("Enter Student ID : ");
            String id = input.next();

            int a = 0;
            int x = 0;
            for (; a < student.length; a++) {
                if (id.equals(student[a][0])) {
                    x = a;

                    student[x][1] = null;
                    student[x][0] = null;
                    marks[x][0] = 0;
                    marks[x][1] = 0;


                    System.out.println("Student has been deleted successfully ");
                    System.out.println("Do you want to Delete another student ( Y/N ) : ");


                    String y = input.nextLine();
                    if (y.equals("N") | y.equals("n")) {

                        menu(student, marks);
                    } else if (y.equals("Y") | y.equals("y")) ;
                    continue L1;


                }


            }
        }
    }

    public static void print_Student_Details(String[][] student, int[][] marks) {
        Scanner input = new Scanner(System.in);
        clearConsole();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                             Print Student Details                            |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();


        L1:
        for (int i = 0; i < student.length; i++) {
            System.out.print("Enter Student ID : ");
            String id = input.nextLine();//Enter Student ID


            int x = 0;
            L2:
            for (; x < student.length; x++) {
                if (id.equals(student[x][0])) {
                    System.out.println("Student Name : " + student[x][1]);
                    break L2;
                }
            }

            if (marks[x][0]==(0)){
                System.out.println("Marks yet to be added");
            } else{
                int tot = 0;
                tot = (marks[x][0]) + (marks[x][1]);//total


                String[][] temp = rank(student,marks);//Calling Rank method
                int rank = 0;
                for (; rank < student.length; rank++) {//find  Rank
                    if (id.equals(temp[rank][0]))
                        break;
                }
                double avg;
                System.out.println("--------------------------------------------------------------------");
                System.out.printf("|programming fundamentals Marks               |                    ");
                System.out.print(marks[x][0]);
                System.out.println(" |");
                System.out.printf("|Database Management System Marks             |                    ");
                System.out.print(marks[x][1]);
                System.out.println(" |");
                System.out.printf("|Total Marks                                  |                    ");
                System.out.print(tot);
                System.out.println(" |");
                System.out.printf("|Avg. Marks                                   |                  ");
                System.out.print(avg = tot / 2);
                System.out.println(" |");
                System.out.printf("|Rank                                         |                    ");
                System.out.print(rank + 1);
                System.out.println(" |");
                System.out.println("--------------------------------------------------------------------");
            }

            System.out.print("Do you want to Search anther Student Details  ( Y/N ) : ");//back to menu or this method
            String y = input.nextLine();
            if (y.equals("N") | y.equals("n")) {
                menu(student, marks);
            }
            if (y.equals("Y") | y.equals("y")) ;
            continue L1;
        }
    }

    public static String[][] rank(String[][] student, int[][] marks) {//-------------------THIS METHOD USES BY RANK-------------------------------------------
        String temp[][] = new String[student.length][5];
        int[] arr = new int[student.length];

        for (int c = 0; c < temp.length; c++) {

            arr[c] = marks[c][0] + marks[c][1];//total



            temp[c][0] = student[c][0];//Copy ID
            temp[c][2] = student[c][1];
            temp[c][3] = String.valueOf(arr[c] / 2);
            temp[c][1] = String.valueOf(arr[c]);// Copy total


        }


        String t;
        String h;
        String v;
        String a;
        for (int u = temp.length - 1; u > 0; u--) {//sort

            for (int j = 0; j < u; j++)

                if (Integer.parseInt(temp[j][1]) < Integer.parseInt(temp[j + 1][1])) {
                    t = temp[j][1];//total
                    temp[j][1] = temp[j + 1][1];
                    temp[j + 1][1] = t;

                    h = temp[j][0];//ID
                    temp[j][0] = temp[j + 1][0];
                    temp[j + 1][0] = h;

                    v = temp[j][2];//Name
                    temp[j][2] = temp[j + 1][2];
                    temp[j + 1][2] = v;

                    a = temp[j][3];//avg
                    temp[j][3] = temp[j + 1][3];
                    temp[j + 1][3] = a;
                }

        }
        return temp;
    }


    public static void Print_Student_Ranks(String[][] student, int[][] marks) {//------------------------Print_Student_Ranks----------------------------------
        Scanner input = new Scanner(System.in);
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                        Print Student Ranks                                   |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("+-----------+------------+--------------------------+------------------+------------------");
        System.out.printf("|");
        System.out.printf("Rank");
        System.out.printf("       |");
        System.out.printf("ID");
        System.out.printf("          |");
        System.out.printf("Name");
        System.out.printf("                      |");
        System.out.printf("Total Marks");
        System.out.printf("       |");
        System.out.printf("AVG. Marks");
        System.out.println("       |");

        System.out.println("+-----------+------------+--------------------------+------------------+------------------");

        String[][] temp = rank(student, marks);//calling Rank method

        L1:
        for (int i = 0; i < student.length; i++) {

            if (student[i][0] == null)
                break L1;
            System.out.println("|" + (i + 1) + "          |" + temp[i][0] + "        |" + temp[i][2] + "                    |" + temp[i][1] + "            |" + temp[i][3] + "               |");
        }

        System.out.println("+-----------+------------+--------------------------+------------------+------------------");

        System.out.print("DO you want to go back to main menu (y/n) : ");
        String y = input.nextLine();
        if (y.equals("Y") | y.equals("y")){
            menu(student, marks);
		}else
		{
			clearConsole();
            Print_Student_Ranks(student,marks);
			
		}
	}


    public static void best_In_Programming_Fundamentals(String[][] student,int [][] marks) {
        Scanner input = new Scanner(System.in);
        clearConsole();

        int[] arr = new int[student.length];
        for (int a = 0; a < student.length; a++) {
            arr[a] = marks[a][0];


            String id;
            String name;
            int prf;
            int dbm;
            for (int u = student.length - 1; u > 0; u--) {//sort
                for (int j = 0; j < u; j++)
                    if (arr[j] < arr[j + 1]) {
                        id = student[j][0];//id
                        student[j][0] = student[j + 1][0];
                        student[j + 1][0] = id;

                        name = student[j][1];//name
                        student[j][1] = student[j + 1][1];
                        student[j + 1][1] = name;

                        prf = marks[j][0];//prf
                        marks[j][0] = marks[j + 1][0];
                        marks[j + 1][0] = prf;

                        dbm = marks[j][0];//dbm
                        marks[j][1] = marks[j + 1][1];
                        marks[j + 1][1] = dbm;
                    }
            }
            System.out.println("--------------------------------------------");
            System.out.println("|      Best In Programming Fundamentals     |");
            System.out.println("---------------------------------------------");
            System.out.println();
            System.out.println("+-----------+------------------------+------------------+------------------");
            System.out.printf("|");
            System.out.printf("ID");
            System.out.printf("          |");
            System.out.printf("Name");
            System.out.printf("                      |");
            System.out.printf("PRF Marks");
            System.out.printf("       |");
            System.out.printf("DBM Marks");
            System.out.println("       |");

            System.out.println("+-----------+------------------------+------------------+------------------");
            L1:
            for (int i = 0; i < student.length; i++) {

                if (student[i][0] == null)
                    break L1;
                System.out.println("|" + student[i][0] + "        |" + student[i][1] + "                    |" + marks[i][0] + "            |" + marks[i][1] + "               |");
            }
            System.out.println("+-----------+------------------------+------------------+------------------");


            System.out.print("DO you want to go back to main menu (Y/N) : ");
            String y = input.nextLine();
            if ("Y".equals(y))
                menu(student, marks);

        }
    }

    public static void best_in_Database_Management_System (String[][] student,int [][]marks) {
        Scanner input = new Scanner(System.in);
        clearConsole();

        int []arr=new int[student.length];
        for (int i=0;i<student.length;i++){
              arr[i] = marks[i][1];

        }


        String id;
        String name;
        int prf;
        int dbm;
        //this veritable i get for sorting
        for (int u = student.length - 1; u > 0; u--) {//sorting
            for (int j = 0; j < u; j++)
                if (arr[j]< arr[j+1]) {
                    id = student[j][0];//id
                    student[j][0] = student[j + 1][0];
                    student[j + 1][0] = id;

                    name = student[j][1];//Name
                    student[j][1] = student[j + 1][1];
                    student[j + 1][1] = name;

                    prf= marks[j][0];//PRF
                    marks[j][0] = marks[j + 1][0];
                    marks[j + 1][0] = prf;

                    dbm = marks[j][1];//DBM
                    marks[j][1] = marks[j + 1][1];
                    marks[j + 1][1] = dbm;
                }
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                 Best in Database Management System                          |");
        System.out.println(" ------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("+-----------+------------------------+------------------+------------------");
        System.out.printf("|");
        System.out.printf("ID");
        System.out.printf("          |");
        System.out.printf("Name");
        System.out.printf("                      |");
        System.out.printf("PRF Marks");
        System.out.printf("       |");
        System.out.printf("DBM Marks");
        System.out.println("       |");

        System.out.println("+-----------+------------------------+------------------+------------------");
        L1:for (int i=0;i<student.length;i++){

            if(student[i][0]==null)
                break L1;
            System.out.println("|"+student[i][0]+"        |"+student[i][1]+"                    |"+marks[i][0]+"            |"+marks[i][1]+"               |");
        }
        System.out.println("+-----------+------------------------+------------------+------------------");

        System.out.print("DO you want to go back to main menu (Y/N) : ");
        String y = input.nextLine();
        if (y.equals("y")){
            menu(student,marks);
		}
    }

        public static void main (String[]args){
            String[][] student = new String[100][3];
            int[][] marks = new int[student.length][3];

            menu(student, marks);

        }
    }
