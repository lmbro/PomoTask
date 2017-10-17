
import java.util.Scanner;

/**
 * Command-line interface to be used until the replacement GUI is complete. Static intializer block prints a welcome message, nothing more.
 * 
 * @author  Lucas Brown <lucasbrown1871@gmail.com>
 * @version 0.1
 * @since   0.1
 */
public class PomoTaskCLI {

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
            printTaskList();
            switch( option ) {
                case 1:
                    System.out.println( "Create Task" );
                    System.out.println( "------------" );
                    createTask( scan );
                    break;
                case 2:
                    System.out.println( "Create Sub Task" );
                    System.out.println( "----------------" );
                    createSubTask( scan );
                    break;
                case 3:
                    System.out.println( "Edit Task" );
                    System.out.println( "----------" );
                    editTask( scan );
                    break;
                case 4:
                    System.out.println( "Complete Pom" );
                    System.out.println( "-------------" );
                    completePom( scan );
                    break;
                case 5:
                    System.out.println( "Complete Task" );
                    System.out.println( "--------------" );
                    completeTask( scan );
                    break;
                case 6:
                    break;
                default:
                    System.out.println( "ERROR: Invalid option" );
            }
        } while( option != 6 );

        scan.close();

        return;
    }

    /**
     * TODO: Needs to be built, currently holds placeholder
     */
    public static void printTaskList() {

        System.out.println( "Task List" );
        System.out.println( "----------" );        
        System.out.println( "- Feed the dogs" );
        System.out.println( "- Take the dogs on a walk" );
        System.out.println( "- Feed the dogs" );
        System.out.println( "- Read the dogs their bedtime story" );
        System.out.println( "- I don't actually read to my dogs" );
        System.out.println( "- I hope that as obvious " );
        System.out.println( "- I just like dogs better than quick brown foxes" );
        System.out.println();
        
        return;
    }

    public static void createTask( Scanner scan ) {

        System.out.print( "Task Name.....: " );
        String name = scan.next();
        System.out.print( "Description...: " );
        String description = scan.next();
        System.out.print( "Number of Poms: " );
        int numPom = scan.nextInt();

        // TODO: Create task through Task constructor

        System.out.println( "\nTask Created!" );

        // TODO: Replace print statements with Task class methods

        System.out.println( name );
        System.out.println( description );
        System.out.println( numPom );

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
        System.out.println( "(3) Edit Task/Subtask" );
        System.out.println( "(4) Complete Pomdoro" );
        System.out.println( "(5) Complete Task" );
        System.out.println( "(6) Quit" );
        System.out.println();
        System.out.print( "Enter your choice (1-6): " );

        int choice = scan.nextInt();

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