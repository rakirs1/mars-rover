
/**
 * Write a description of class rover here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rover
{
    // instance variables - replace the example below with your own
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
        this.y = x;
        this.dir = dir;
        this.name = name;
        this.isAlive = true;
    }

    public void move(int n)
    {
        if (isAlive){
            if (dir == 0){
                y=this.y+n;
            }
            if (dir == 1){
                x=this.x+n;
            }
            if (dir == 2){
                y=this.y-n;
            }
            if (dir == 3){
                x=this.x-n;
            }
            System.out.println(this.name + " moved " + n + " spaces forward");
        }
        else {
            System.out.println(this.name + " cannot move. It ded.");
        }
    }

    public void rotateLeft()
    {
        dir = dir - 1;
        System.out.println(this.name + " rotated left");

        if(dir == -1){
            dir = 3;
        }
    }

    public void rotateRight()
    {
        dir = dir + 1;
        System.out.println(this.name + " rotated right");

        if(dir == 4){
            dir = 0;
        }
    }

    public String toString()
    {
        return("Rover[name = " + name + ",x=" + x + ",y=" + y + ",dir=" + dir + ",isAlive=" + isAlive +"]");    
    }

    public void kill(Rover other)
    {
        System.out.println(this.name + " shoots " + other.name + " with space lasers.");
        System.out.println(other.name + " goes 'beep beep aaaaaaakkkkkk!' and dies");

        other.isAlive = false;
    }

    public void getDirectionName()
    {
        if(dir ==  0){
            System.out.println(this.name +" is facing the North direction.");
        }
        if(dir ==  1){
            System.out.println(this.name +" is facing the East direction.");
        }
        if(dir ==  2){
            System.out.println(this.name +" is facing the South direction.");
        }
        else if(dir ==  3){
            System.out.println(this.name +" is facing the West direction.");
        }
    }

    public void teleport(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void rotate1(int n)
    {
        if(n >= 0){
            dir = (dir + n) % 4;
            System.out.println(this.name + " has rotated " + n + " units to the right.");
        }
        else {
            /**
            int var = dir + n;
            int abs = Math.abs(var);
            System.out.println(abs);
            dir = abs % 3;
            
            System.out.println(this.name + " has rotated " + n + " units to the left.");
            **/
            /**
            dir = (dir + n) % 4;
            System.out.println(this.name + " has rotated " + n + " units to the left.");
            **/
            
            int abs = Math.abs(n);
            int dir1 = abs % 4;
              
            dir += 4 - dir1;
            
        }
    }
    
    public void moveTo (int x, int y)
    {
        int run = x - this.x;
        int rise = y - this.y;
        
        if(run > 0){
            dir = this.dir * 0;
            rotate(1);
            System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
            move(run);
            System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
            if(rise > 0){
                rotate(-1);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
                move(rise);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
            }
            else if(rise < 0){
                rotate(1);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
                move(rise);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
            }
        }
        else if (run < 0){
            dir = this.dir * 0;
            rotate(-1);
            System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
            move(run);
            System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
             if(rise > 0){
                rotate(-1);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
                move(rise);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
            }
            else if(rise < 0){
                rotate(1);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
                move(rise);
                System.out.println(this.name+ " ("+this.x+", "+this.y+", "+this.dir+")");
            }
        }
    }
    
    public void rotate(int n)
    {
        int math1 = (dir + Math.abs(n)) % 4;
        if(n >= 0){
            dir = math1;
        }
        else{
            if(math1 == 1){
                dir = 3;
            }
            else if(math1 == 3){
                dir = 1;
            }
            else{
                dir = math1;
            }
        }
    }
}
