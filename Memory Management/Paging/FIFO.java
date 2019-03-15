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
                
                if(checkall(alloc,blk,req[i])==false)    // Check repetition of values by comparison with all the requests
                {
                    alloc[x]=req[i];    // Does Allocation
                    page=page+1;        // Increment Page fault
                    x=(x+1)%3;      // Works as Circular Queue to switch between blocks
                }
                
                

            }
            //System.out.println("x = "+x);
            for(int j=0;j<blk;j++)      // Printing data
            System.out.print(alloc[j]+" ");
            System.out.println();
           
        }
        
        System.out.println("Number of Page Faults is "+page);
        System.out.println("Percentage of page Faults are: "+(page/n)*100);
    }
    public static boolean checkall(int a[],int n,int x)     //Checkall
    {
        int f=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]!=x)
            {f=0;
            //return false;
            }
            else
            {
                f=1;
                return true;
            }

        }
        if(f==1)
        return true;
        else
        return false;
        
    }
}

