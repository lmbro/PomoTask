
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Command-line interface to be used until the replacement GUI is complete. Static intializer block prints a welcome message, nothing more.
 * 
 * @author  Lucas Brown <lucasbrown1871@gmail.com>
 * @version 0.1
 * @since   0.1
 */
public class PomoTaskCLI {

    private static ArrayList<Task> taskList = new ArrayList<Task>();

    static {
        printHeader();
        System.out.println( "  Version: 0.1" );
        System.out.println( "  Author:  Lucas Brown" );
        System.out.println( "           <lucasbrown1871@gmail.com>" );
        enterToContinue();
    }

    public static void main( String[] args ) {
        
        Scanner scan = new Scanner( System.in );
        int option;

        do {
              
            printHeader();
            printTaskList();
            option = printMenu( scan );

            printHeader();
            switch( option ) {
                case 1:
                    printTaskList();
                    System.out.println( "Create Task" );
                    System.out.println( "------------" );
                    createTask( scan );
                    break;
                case 2:
                    if( taskList.isEmpty() ) {
                        printTaskList();
                        System.out.println( "Can't add sub task to an empty task list!" );
                        enterToContinue();
                        break;
                    }
                    printTaskListID();
                    System.out.println( "Create Sub Task" );
                    System.out.println( "----------------" );
                    createSubTask( scan );
                    break;
                case 3:
                    System.out.println( "View Task" );
                    System.out.println( "----------" );
                    viewTask( scan );
                    break;
                case 4:
                    System.out.println( "Edit Task" );
                    System.out.println( "----------" );
                    editTask( scan );
                    break;
                case 5:
                    System.out.println( "Complete Quarter" );
                    System.out.println( "-----------------" );
                    completePom( scan );
                    break;
                case 6:
                    System.out.println( "Complete Task" );
                    System.out.println( "--------------" );
                    completeTask( scan );
                    break;
                case 7:
                    printHeader();
                    System.out.println( "Goodbye!" );
                    System.out.println();
                    break;
                default:
                    System.out.println( "ERROR: Invalid option" );
            }
        } while( option != 7 );

        scan.close();

        return;
    }

    /**
     * Prints Task list - names only
     */
    public static void printTaskList() {

        System.out.println( "Task List" );
        System.out.println( "----------" );        
        
        if( taskList.isEmpty() ) {
            System.out.println( "EMPTY" );
            System.out.println();
            System.out.println( "Choose menu option 1 to add new tasks" );
            System.out.println( " --- or ---" );
            System.out.println( "Crack open a beer and enjoy the rest of your day!" );
        } else {
            for( Task task : taskList ) {
                task.printAll();
            }
        }

        System.out.println();
        
        return;
    }

    /**
     * Prints task list with IDs displayed. Intended for use with functions that require a task object to be specified.
     */
    public static void printTaskListID() {

        System.out.println( "Task List" );
        System.out.println( "----------" );

        int i = 0;
        for( Task task : taskList ) {
            System.out.printf( "[ID: %d] ", i++ );
            task.printAll();
        }

        System.out.println();

        return;
    }

    /**
     * Creates a root (no parent) task
     */
    public static void createTask( Scanner scan ) {

        System.out.print( "Task Name....: " );
        String name = scan.nextLine();
        System.out.print( "Description..: " );
        String description = scan.nextLine();
        System.out.print( "Hours Planned: " );
        int planQuarters = (int)( scan.nextDouble() * 100 ) / 25;

        // Create task through Task constructor
        Task task = new Task( name, description, planQuarters );
        taskList.add(task);

        // Display confirmation message and Task information
        System.out.println();
        System.out.println( "Task Created!" );
        System.out.println( "--------------" );
        task.printTaskExpand();

        enterToContinue();

        return;        
    }

    /**
     * TODO: Needs to be built, currently holds placeholder
     */
    public static void createSubTask( Scanner scan ) {

        System.out.println( "NOT YET BUILT" );
        
        enterToContinue();

        return;
    }

    /**
     * TODO: Needs to be built, currently holds placeholder
     */
    public static void viewTask( Scanner scan ) {

        System.out.println( "NOT YET BUILT" );
        
        enterToContinue();

        return;
    }

    /**
     * TODO: Needs to be built, currently holds placeholder
     */
    public static void editTask( Scanner scan ) {

        System.out.println( "NOT YET BUILT" );

        enterToContinue();

        return;
    }

    /**
     * TODO: Needs to be built, currently holds placeholder
     */
    public static void completePom( Scanner scan ) {

        System.out.println( "NOT YET BUILT" );

        enterToContinue();

        return;
    }

    /**
     * TODO: Needs to be built, currently holds placeholder
     */
    public static void completeTask( Scanner scan ) {

        System.out.println( "NOT YET BUILT" );

        enterToContinue();

        return;
    }

    /**
     * Prints the program's menu and returns the user's choice
     * 
     * @param Scanner
     * @return User's choice
     */
    private static int printMenu( Scanner scan ) {
        
        System.out.println( "Menu" );
        System.out.println( "-----" );        
        System.out.println( "(1) New Task" );
        System.out.println( "(2) New Subtask" );
        System.out.println( "(3) View Task" );
        System.out.println( "(4) Edit Task/Subtask" );
        System.out.println( "(5) Complete Quarter" );
        System.out.println( "(6) Complete Task" );
        System.out.println( "(7) Quit" );
        System.out.println();
        System.out.print( "Enter your choice (1-7): " );

        int choice = scan.nextInt();
        scan.nextLine(); // CHOMP CHOMP, eat the \n from user hitting enter.

        return choice;
    }

    /** 
     * Prints the program header, uses {@link #clearTerminal()} to clear terminal.
     */
    private static void printHeader() {
        clearTerminal();
        System.out.println( "//////////////////" );
        System.out.println( "  PomoTask Alpha " );
        System.out.println( "//////////////////" );
        System.out.println();
    }

    /**
     * Clears terminal screen, requries terminal to support ANSI escape codes ( most UNIX terminals and terminal emulators ).
     */
    private static void clearTerminal() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * "Press Enter to continue"
     */
    private static void enterToContinue() {
        System.out.print( "\nPress Enter to continue" );
        try{
            System.in.read();
        } catch( Exception e ) {
        }
    }


}