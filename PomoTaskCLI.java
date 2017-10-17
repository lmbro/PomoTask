
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
        System.out.println();
        System.out.println( "Press Enter to continue" );
        try{
            System.in.read();
        } catch( Exception e ) {
        }
    }

    /**
     * Clears terminal screen, requries terminal to support ANSI escape codes ( most UNIX terminals and terminal emulators ).
     */
    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /** 
     * Prints the program header, uses {@link #clearTerminal()} to clear terminal.
     */
    public static void printHeader() {
        clearTerminal();
        System.out.println( "//////////////////" );
        System.out.println( "  PomoTask Alpha " );
        System.out.println( "//////////////////" );
        System.out.println();
    }


    /**
     * Prints the program's menu and returns the user's choice
     * 
     * @param Scanner
     * @return User's choice
     */
    public static int printMenu( Scanner scan ) {

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


    public static void main( String[] args ) {

        Scanner scan = new Scanner( System.in );
        int option;

        do {
            printHeader();
            System.out.println( "Task List: " );
            System.out.println();
            option = printMenu( scan );

            switch( option ) {
                case 1:
                    // createTask()
                    break;
                case 2:
                    // createSubTask()
                    break;
                case 3:
                    // editTask();
                    break;
                case 4:
                    // completePom();
                    break;
                case 5:
                    //completeTask();
                    break;
                case 6:
                    break;
                default:
                    System.out.println( "ERROR: Invalid option" );
            }
        } while( option != 6 );

        scan.close();
    }

}