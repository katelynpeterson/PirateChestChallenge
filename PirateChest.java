//This program is intended to solve the pirate chest problem. Our retired pirate friend needs to hide his chest of treasure in the pond. He wants to know how big his chest can be and still be hidden beneath the water. That is the goal
import java.util.*;

public class PirateChest{
    static int pondVolume;
    static int chestUnits;
    static int chestVolume;
    static int height =1;
    static int solution;
    static int chestLength;
    static int chestWidth;
    static int [][] pondDimensions;

    public static void main(String[] args){
        System.out.println("Enter dimensions: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Chest Length: ");
        int maxChestLength = input.nextInt();
        System.out.println("Chest Width: ");
        int maxChestWidth = input.nextInt();
        chestLength = Math.max(maxChestLength, maxChestWidth);
        chestWidth = Math.min(maxChestLength, maxChestWidth);
        System.out.println("Pond Length: ");
        int pondLength = input.nextInt();
        System.out.println("Pond Width: ");
        int pondWidth = input.nextInt();
        pondDimensions = new int[pondWidth][pondLength];

        for(int i=0; i<chestWidth; i++)
            for(j=0; j<chestLength; j++)
                pondDimensions[i][j]= input.nextInt();

        CalculateDimensions(chestLength, chestWidth, pondLength, pondWidth);
        System.out.println("The solution is: " + FindLargestPossibleChest(chestLength, chestWidth, pondLength, pondWidth));
        input.close();
    }

    public static void CalculateDimensions(int cLength, int cWidth, int pLength, int pWidth){
        pondVolume = pLength * pWidth * pondDepth;
        chestVolume = chestUnits = cLength * cWidth * height;
    }

    public static int FindLargestPossibleChest(int chestLength, int chestWidth, int pondLength, int pondWidth){
        if(chestLength > pondWidth || chestWidth > pondWidth || chestVolume > pondVolume){
            return solution = 0;
        }
        else{
            return solution;
        }
    }
}