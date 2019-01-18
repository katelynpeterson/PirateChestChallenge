//This program is intended to solve the pirate chest problem. Our retired pirate friend needs to hide his chest of treasure in the pond. He wants to know how big his chest can be and still be hidden beneath the water. That is the goal
import java.util.*;

public class PirateChest{
    static int deepestSpot=0;
    static int availablePondVolume=0;
    static int sumObjectsVolumes=0;
    static int chestVolume=0;
    static int height=1;
    static int solution = 0;
    static int chestLength=0;
    static int chestWidth=0;
    static int pondLength =0;
    static int pondWidth =0;
    static int [][] pondDimensions;

    public static void main(String[] args){
    	
        Scanner input = new Scanner(System.in);
        int maxChestLength = input.nextInt();
        int maxChestWidth = input.nextInt();
        chestLength = Math.max(maxChestLength, maxChestWidth);
        chestWidth = Math.min(maxChestLength, maxChestWidth);
        pondLength = input.nextInt();
        pondWidth = input.nextInt();
        pondDimensions = new int[pondWidth][pondLength];

        for(int i=0; i<pondWidth; i++) {
            for(int j=0; j<pondLength; j++) {
                pondDimensions[i][j]= input.nextInt();
            }
        }

        System.out.println("The solution is: " + CalculateDimensions());
        input.close();
    }

    public static int CalculateDimensions(){
        //find the deepest spot in the pond to calculate total pond volume
    	int [] depth = new int[pondLength*pondWidth];
        for(int i =0; i<pondWidth; i++) {
            for(int j=0; j<pondLength; j++) {
                depth[j]= pondDimensions[i][j];
                deepestSpot = depth[j] > deepestSpot ? depth[j] : deepestSpot;
            }
        }

        //find any objects in pond that take away volume
        for(int k=0; k<depth.length;k++)
        	sumObjectsVolumes += depth[k]<deepestSpot? depth[k]: 0;
        
        //subtract the volume taken by the objects in the pond from the total pond volume to get the available volume for the pirate chest to occupy
        availablePondVolume = (pondLength * pondWidth * deepestSpot) - sumObjectsVolumes;

        //initial chest volume
        chestVolume = chestLength * chestWidth * height;
        
        return FindLargestPossibleChest(chestLength, chestWidth, height, pondLength, pondWidth, chestVolume, availablePondVolume);
    }

    //Recursive solution
    public static int FindLargestPossibleChest(int cLength, int cWidth, int cHeight, int pLength, int pWidth, int cVolume, int pVolume){
    	//base case and compare values
    	if(cVolume>pVolume)
    		return solution;
    	if(cLength>pLength || cWidth > pWidth)
    		return solution;
    	
    	//increment values and try again
    	height = cHeight++;
    	availablePondVolume = pVolume + (cVolume/(pLength*pWidth));    	
    	
    	return solution = FindLargestPossibleChest(chestLength, chestWidth, height, pondLength, pondWidth, chestVolume, availablePondVolume);
    }
}