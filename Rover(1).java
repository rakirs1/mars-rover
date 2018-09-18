
/**
 * Write a description of class Rover here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rover
{
    // instance variables
    private int x;
    private int y;
    private int dir;
    private String name;
    private boolean isAlive;

    public Rover(String name)
    {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.name = name;
        this.isAlive = true;
    }
    
    public Rover(String name, int x, int y, int dir)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.name = name;
        this.isAlive = true;
    }

    public void rotateRight()
    {
        dir = dir + 1;
        
        if (dir == 4) {
            dir = 0;
        }
        
        System.out.println(this.name + " turned to the right");
    }
    
    public void rotateLeft()
    {
        dir = dir - 1;
        
        if (dir == -1) {
            dir = 3;
        }
        
        System.out.println(this.name + " turned to the left");
    }
    
    public void move() 
    {
        if (isAlive) {
            if (dir == 0) {
                y = y + 1;
            }
            else if (dir == 1) {
                x = x + 1;
            }
            else if (dir == 2) {
                y = y - 1;
            }
            else {
                x = x - 1;
            }
            
            System.out.println(this.name + " moved forward");
        }
        else {
            System.out.println(this.name + " can't move. It's ded.");
        }
    }
    
    public void kill(Rover other) {
        System.out.println(this.name + " shoots " + other.name + " with space lasers.");
        System.out.println(other.name + " goes 'beep beep aaaaaaakkkkkk!' and dies");
        
        other.isAlive = false;
    }
    
    public String toString() {
        return "Rover[name=" + name + ",x=" + x + ",y=" + y + 
               ",dir=" + dir + ",isAlive=" + isAlive + "]";
    }
    
    public void getDirectionName()
    {
        if(dir == 0)
        {System.out.println (this.name + "is facing North.");
    }
    }
}
