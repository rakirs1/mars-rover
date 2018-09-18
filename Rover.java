/**
 * Code for functions of mars rover.
 *
 * @author Srikar Alapati
 * @version 9/17/18
 */
public class Rover
{
    // instance variables - used throughout the code in various different functions
    private int x;
    private int y;
    private int dir;
    private String name;
    private boolean isAlive;
    private int numPics;
    private String dirName;
    private int health;
    private int energy;
    private int startX = x;
    private int startY = y;

    /**
     * Sets the variables to zero when creating a new rover.
     * 
     * @param name Name of the rover
     */
    public Rover(String name)
    {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.name = name;
        this.isAlive = true;
        this.numPics = 0;
        this.health = 100;
        this.energy = 500;
    }

    /**
     * Sets the variables to a specific input value when creating a new rover. 
     * 
     * @param x X position of the rover
     * @param y Y position of the rover
     * @param dir Directin the rover is facing.
     */
    public Rover(String name, int x, int y, int dir)
    {
        this.x = x;
        this.y = x;
        this.dir = dir;
        this.name = name;
        this.isAlive = true;
        this.numPics = 0;
        this.health = 100;
        this.energy = 500;
    }
    
    /**
     * Moves the rover towards the direction it is facing for an inputed amount of units.
     * 
     * @param n Number of units the rover will go forward in the direction it is facing
     */
    public void move(int n)
    {
        int energyVal = 40;
        int enoEnergy = this.energy - energyVal;
        
        if (isAlive){
            if(enoEnergy >= 0){
                if (dir == 0){
                this.y += n;
                }
                if (dir == 1){
                this.x += n;
                }
                if (dir == 2){
                this.y -= n;
                }
                if (dir == 3){
                this.x -= n;
                }
                System.out.println(this.name + " moved " + n + " spaces.");
                this.energy -= energyVal;
                }
                else{
                    System.out.println(this.name + " does not have enough energy to do this funtion.");
                }
        }
        else {
            System.out.println(this.name + " cannot move. It ded.");
        }
    }

    /**
     * Rotates the rover to the left once. 
     */
    public void rotateLeft()
    {
        int energyVal = 20;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                dir = dir - 1;
                System.out.println(this.name + " rotated left");

                if(dir == -1){
                    dir = 3;
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot rotate at all. It dead.");
        }
    }

    /**
     * Rotates the rover to the right once. 
     */
    public void rotateRight()
    {
        int energyVal = 20;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                dir = dir + 1;
                System.out.println(this.name + " rotated right");

                if(dir == 4){
                    dir = 0;
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot rotate at all. It dead.");
        }
    }

    /**
     * Gives the name of rover, x/y position, direction, whether it is alive or not, number of pictures it has stored, health, and energy.
     */
    public String toString()
    {
        return("Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + ", isAlive=" + isAlive +", numPics=" + numPics + ", health=" + health + ", energy=" + energy +"]");    
    }

    /**
     * Gives the name of the direction the rover is facing based on numerical value.
     */
    public void getDirectionName()
    {
        int energyVal = 5;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
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
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot get the direc. It dead.");
        }
    }

    /**
     * Teleports the rover to an input location.
     * 
     * @param x X coordinate the rover will be teleported to
     * @param y Y coordinate the rover will be teleported to
     */
    public void teleport(int x, int y)
    {
        int energyVal = 70;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                this.x = x;
                this.y = y;
                this.energy -= energyVal;
                System.out.println(this.name + " has teleported to (" + x + ", " + y + ").");
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot teleport. It dead.");
        }
    }

    /**
     * This will rotate the rover in either direction for an inputed amount of units.
     * 
     * @param n Direction and number of units of rotation
     */
    public void rotate(int n)
    {
        int dir1 = (Math.abs(n) + dir) % 4;
        int energyVal = 25;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                if(n >= 0){
                dir = dir1;
                System.out.println(this.name + " has rotated " + n + " units to the right.");
                }
                else {
                    if(dir1 == 3){
                        dir = 1;
                }
                else if(dir1 == 1){
                    dir = 3;
                }
                else {
                    dir = dir1;
                }
                System.out.println(this.name + " has rotated " + n + " units to the left.");
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot rotate. It dead.");
        }
    }

    /**
     * This moves the rover to an inputed location using the move function and the rotate function.
     * 
     * @param x X coordinate the rover will be moved to
     * @param y Y coordinate the rover will be moved to
     */
    public void moveTo(int x, int y)
    {
        int rise = y - this.y;
        int run = x - this.x;
        int energyVal = 60;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                if(run < 0){
                    this.dir *= 0;
                    rotate(1);
                    move(run);
                    if(rise < 0){
                        rotate(-1);
                        move(rise);
                    }
                     else{
                         rotate(1);
                         move(rise);
                    }
                }
                else{
                    this.dir *= 0;
                    rotate(-1);
                    move(run);
                    if(rise < 0){
                        rotate(1);
                        move(rise);
                    }
                    else{
                        rotate(-1);
                        move(rise);
                    }
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot move. It dead.");
        }
    }
    
    /**
     * This takes the rover back the location in which it was instantiated.  
     */
    public void goHome()
    {
        int energyVal = 40;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                moveTo(startX,startY);
                System.out.println(this.name + " moved to (" + startX + ", " + startY + ").");
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot go home. It dead.");
        }
    }
    
    /**
     * This takes a picture of the location of the rover and stores it. 
     */
    public void takePicture()
    {
        int energyVal = 15;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                if(dir == 0){
                    this.dirName = "North";
                }
                else if(dir == 1){
                    this.dirName = "East";
                }
                else if(dir == 2){
                    this.dirName = "South";
                }
                else if(dir == 3){
                    this.dirName = "West";
                }
                if((this.numPics += 1) > 10){
                    this.numPics = 10;
                    System.out.println(this.name + " cannot take any more pictures. The camera is full.");
                }
                else{
                    System.out.println(this.name + "took a picture at " + "[" + x + ", " + y + "] facing " + this.dirName + ".");
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot take picture. It dead.");
        }
    }
    
    /**
     * This transmits the pictures stored back to Earth and resets the stored pictures back to zero.
     */
    public void transmitPictures()
    {
        int energyVal = 20;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive){
            if(enoEnergy >= 0){
                this.numPics = 0;
                System.out.println(this.name + " sent the pictures back to Earth.");
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            System.out.println(this.name + " cannot transmit the pictures back to Earth. It dead.");
        }
    }
    
    /**
     * This is an attack using a chainsaw to another rover to deal damage and possibly kill.
     * The rover needs to be within in two units of the other rover in order to do this attack. 
     * 
     * @param other The other rover being attacked
     */
    public void chainsaw(Rover other)
    {
        double distForm = Math.sqrt((this.x - other.x) + (this.y - other.y));
        int energyVal = 50;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive && other.isAlive){
            if(enoEnergy >= 0){
                if(distForm <= 2){
                    other.health -= 15;
                    System.out.println(this.name + " used a chainsaw on " + other.name + ".");
                    System.out.println(other.name + " lost 15 health.");
                    if(other.health < 0){
                        other.health = 0;
                        isAlive = false;
                        System.out.println(other.name + " died by the wrath of " + this.name);
                    }
                }
                else {
                    System.out.println(this.name + " is too far from " + other.name + " and missed the attack.");
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            if(isAlive == false){
                System.out.println(this.name + " cannot use chainsaw on " + other.name + ". It dead.");
            }
            else{
                System.out.println(this.name + " cannot use chainsaw on " + other.name + ". " + other.name + " is already dead.");
            }
        }
    }
    
    /**
     * This is an attack using a flamethrower on another rover to deal damage and possible burn to a crisp.
     * The rover needs to be within five units of the other rover in order to do this attack.
     * 
     * @param other The other rover being burned
     */
    public void flamethrower(Rover other)
    {
        double distForm = Math.sqrt((this.x - other.x) + (this.y - other.y));
        int energyVal = 60;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive && other.isAlive){
            if(enoEnergy >= 0){
                if(distForm <= 5){
                    other.health -= 20;
                    System.out.println(this.name + " set " + other.name + " on fire.");
                    System.out.println(other.name + "lost 20 health.");
                    if(other.health < 0){
                        other.health = 0;
                        isAlive = false;
                        System.out.println(other.name + " died in flames by " + this.name);
                    }
                }
                else {
                    System.out.println(this.name + " is too far from " + other.name + " and missed the attack.");
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            if(isAlive == false){
                System.out.println(this.name + " cannot use flamethrower on " + other.name + ". It dead.");
            }
            else{
                System.out.println(this.name + " cannot use flamethrower on " + other.name + ". " + other.name + " is already dead.");
            }
        }
    }
    
    /**
     * This is the best and most risky attack as there is a 50/50 chance to deal a very small amount of damage and to deal a very large amount of damage.
     * There is no distance the rover needs to cover to do this attack.
     * 
     * @param other The other rover that could possibly die or could live with little health or have almost full health. 
     */
    public void megaKick(Rover other)
    {
        int energyVal = 140;
        int enoEnergy = this.energy - energyVal;
        
        if(isAlive && other.isAlive){
            if(enoEnergy >= 0){
                int random = (int) Math.random();
                if(random >= 0.5){
                    int rando = (int) Math.random() * 20 + 40;
                    other.health -= rando;
                    if(other.health < 0){
                        other.health = 0;
                        isAlive = false;
                        System.out.println(other.name + " died by a mega kick by " + this.name);
                    }
                }
                else {
                    other.health -= 5;
                    if(other.health < 0){
                        other.health = 0;
                        isAlive = false;
                        System.out.println(other.name + " died by a mega kick by " + this.name);
                    }
                }
                this.energy -= energyVal;
            }
            else{
                System.out.println(this.name + " does not have enough energy to do this funtion.");
            }
        }
        else{
            if(isAlive == false){
                System.out.println(this.name + " cannot mega kick " + other.name + ". It dead.");
            }
            else{
                System.out.println(this.name + " cannot mega kick " + other.name + ". " + other.name + " is already dead.");
            }
        }
    }
    
    /**
     * This gives the rover and inputed amount of energy.
     * The maximum it can charge to is sthree-hundred energy. 
     * 
     * @param n Amount of energy given to rover. 
     */
    public void charge(int n)
    {
        int sum = this.energy += n;
        if(sum > 300){
            this.energy = 300;
        }
        else{
            this.energy = sum;
        }
    }
}
