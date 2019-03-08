import java.util.*;
import java.io.*;

public class fifo1
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int blk=3;
        int alloc[]=new int[blk];
        System.out.println("Enter the number of Requests:");
        int n=sc.nextInt();
        System.out.println("Enter the requests: ");
        int req[]=new int[n];
        for(int i=0;i<n;i++)
            req[i]=sc.nextInt();
        int page=0;int found=-1,x=0;
        for(int i=0;i<blk;i++)
            alloc[i]=-1;
        for(int i=0;i<n;i++)
        {

            //while(x<3)
            {
                //if(found==-1)
                
                if(alloc[x]!=req[i])
                {
                    alloc[x]=req[i];
                    page=page+1;
                }
                
                x=(x+1)%3;

            }
            

            
        }
        for(int i=0;i<blk;i++)
            System.out.print(alloc[i]+" ");
        System.out.println("Number of Page Faults is "+page);
        System.out.println("Percentage of page Faults are: "+(page/n)*100);
    }
}
