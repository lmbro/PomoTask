import java.util.ArrayList;

/**
 * @author  Lucas Brown <lucasbrown1871@gmail.com>
 * @version 0.1
 * @since   0.1
 */
public class Task {

    private Task parent;
    private ArrayList<Task> children = new ArrayList<Task>();

    private String name = "";
    private String description = "";

    private int planQuarters = 0;
    private int compQuarters = 0;

    private boolean complete = false;

    // Constructors 

    public Task( String name ) {
        this.name = name;
    }

    public Task( String name, String description ) {
        this.name = name;
        this.description = description;
    }

    public Task( String name, String description, int planQuarters ) {
        this.name = name;
        this.description = description;
        this.planQuarters = planQuarters;
    }

    public Task( Task parent, String name ) {
        this.parent = parent;
        this.name = name;
        parent.addChild(this);
    }

    public Task( Task parent, String name, String description ) {
        this.parent = parent;
        this.name = name;
        this.description = description;
        parent.addChild(this);
    }

    public Task( Task parent, String name, String description, int planQuarters ) {
        this.parent = parent;
        this.name = name;
        this.description = description;
        this.planQuarters = planQuarters;
        parent.addChild(this);
    }

    // Getters

    public Task getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPlanQuarters() {
        return this.planQuarters;
    }

    public int getCompQuarters() {
        return this.compQuarters;
    }

    // Setters

    public void setParent( Task parent ) {
        this.parent = parent;
        return;
    }

    public void setName( String name ) {
        this.name = name;
        return;
    }

    public void setDescription( String description ) {
        this.description = description;
        return;
    }

    public void setPlanQuarters( int planQuarters ) {
        this.planQuarters = planQuarters;
        return;
    }

    public void setCompQuarters( int compQuarters ) {
        this.compQuarters = compQuarters;
        return;
    }

    // Methods

    /**
     * Add child task (sub task) to this task 
     */
    public void addChild( Task child ) {
        children.add(child);
        return;
    }
    
    /**
     * Complete a quarter of time planned for task. If all quarters are complete, complete the entire task.
     */
    public void completeQuarter() {
        compQuarters++;
        if( compQuarters == planQuarters ) {
            completeTask();
        }
        return;
    }

    /**
     * Complete this task
     */
    public void completeTask() {
        complete = true;
        return;
    }

    public void printTask() {
        printTask( 0 );
        return;
    }

    private void printTask( int depth ) {

        String indent = "-";
        
        for( int i = 0; i < depth; i++ ) {
            indent += "--";
        }

        System.out.printf( "%s %s [%.2f]%n", indent, name, (planQuarters-compQuarters)/4.0 );

        return;
    }

    public void printAll() {
        printAll( 0 );
        return;
    }

    private void printAll( int depth ) {

        printTask( depth );

        for( Task task : children ) {
            printAll( depth + 1 );
        }

        return;
    }
    
    /**
     * Print information stored in task.
     * <p>
     * Print information stored in task by calling the private method {@link #printTask(int)} with a parameter of 0.
     * 
     */
    public void printTaskExpand() {
        printTaskExpand( 0 );
        return;
    }

    /**
     * Print task information at specified indentation depth. Called by {@link #printTask()} and {@link #printAll(int)}
     * 
     * 
     * 
     * @param depth indentation depth - signifies task/subtask relationship in CLI.
     */
    private void printTaskExpand( int depth ) {
        
        String indent = "";
        
        for( int i = 0; i < depth; i++ ) {
            indent += "    ";
        }

        System.out.printf( "%sTask Name.......: %s%n", indent, name );
        System.out.printf( "%sDescription.....: %s%n", indent, description );
        System.out.printf( "%sQuarters Planned: %d%n", indent, planQuarters );
        System.out.printf( "%sHours Planned...: %.2f%n", indent, planQuarters/4.0 );

        return;
    }

    /**
     * Print task and all subtasks (and subtasks of subtasks.... ).
     * <p>
     * Print task and all contained subtasks by starting the recursive calling of {@link #printAll(int)} with a depth (parameter) of zero, indicating the nested 'distance,' for lack of a better term, of the current task.
     */
    public void printAllExpand( ) {
        printAllExpand( 0 );
        return;
    }

    /**
     * Print task and all subtask information at specified identation depth. Called by {@link #printAll()}.
     * 
     * @param depth indentation depth - signifies task/subtask relationship in CLI.
     */
    public void printAllExpand( int depth ) {

        printTaskExpand( depth );

        for( Task task : children ) {
            printAllExpand( depth + 1 );
        }

        return;
    }

}