
/**
 * This is the runner of the rover.
 *
 * @author Srikar Alaoati
 * @version 9/17/18
 */
public class run
{
    /**
     * This is where all the functions for the rover are run on. 
     */
    public static void main (String[] args)
    {
        
        Rover r1 = new Rover("Srikar",1,1,3);
        Rover r2 = new Rover("Owen");
        
        r1.move(4);
        System.out.println(r1);
        
        
        
        

        r1.takePicture();
        System.out.println(r1);
        
        System.out.println();
        
        r1.chainsaw(r2);
        
        System.out.println();
        
        r1.moveTo(17,5);
        System.out.println(r1);
        
        System.out.println();
        
        r1.teleport(9,43);
        System.out.println(r1);
        
        System.out.println();
        
        r1.goHome();
        System.out.println(r1);
    }
}
