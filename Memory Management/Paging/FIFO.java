import java.util.*;
import java.io.*;

public class fifo1
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int blk;
        System.out.println("Enter the number of block: ");
        blk=sc.nextInt();   // Accepting Block size
        int alloc[]=new int[blk];
        System.out.println("Enter the number of Requests:");
        int n=sc.nextInt();     // Accepting the number of Requests
        System.out.println("Enter the requests: ");
        int req[]=new int[n];
        for(int i=0;i<n;i++)
            req[i]=sc.nextInt();        // Accepting the requests
        int page=0;int found=-1,x=0;
        for(int i=0;i<blk;i++)
            alloc[i]=-1;        // Initializing Alloc to -1
        for(int i=0;i<n;i++)
        {

            //while(x<3)
            {
                //if(found==-1)
                
                if(alloc[x]!=req[i])    // Check repetition of values
                {
                    alloc[x]=req[i];    // Does Allocation
                    page=page+1;        // Increment Page fault
                }
                
                x=(x+1)%3;      // Works as Circular Queue to switch between blocks

            }
            

            
        }
        for(int i=0;i<blk;i++)      // Printing data
            System.out.print(alloc[i]+" ");
        System.out.println("Number of Page Faults is "+page);
        System.out.println("Percentage of page Faults are: "+(page/n)*100);
    }
}
