import java.io.*;
import java.util.*;

public class scan
{
    public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);
        Queue<Integer> q=new LinkedList<>();
        
        System.out.println("Enter the Start of Track: ");
        int start=sc.nextInt();
        System.out.println("Enter the End of Track: ");
        int end=sc.nextInt();
        System.out.println("Enter the Seek time of each request: ");
        int seek=sc.nextInt();
        System.out.println("Enter the head pointer: ");
        int head=sc.nextInt();
        q.add(head);
        System.out.println("Enter the Disk Request size: ");
        int n=sc.nextInt();
        System.out.println("Enter the Disk request sequence: ");
        for(int i=0;i<n;i++)
        q.add(sc.nextInt());

        ArrayList a=new ArrayList<>(q);
        Collections.sort(a);
        int headloc=0;
        for(int i=0;i<n;i++)
        {
            if(head==(int)a.get(i))
            headloc=i;

        }
        int no=0;
        for(int i=headloc;i>=0;i--)
        {
            System.out.println("Request : "+a.get(i));
            if(i>0)
            no=no+(int)a.get(i)-(int)a.get(i-1);
            System.out.println("Difference in cylinders: "+no);
            System.out.println("Seek time: "+(seek*no));
        }
        System.out.println("Request : 0");
        System.out.println("Difference in cylinders: "+(no+(int)a.get(headloc+1)));
        System.out.println("Seek time: "+((no+(int)a.get(headloc+1)))*seek);
        for(int i=headloc+1;i<n;i++)
        {
            System.out.println("Request : "+a.get(i));
            if(i<n)
            no=no+(int)a.get(i)-(int)a.get(i-1);
            System.out.println("Difference in cylinders: "+no);
            System.out.println("Seek time: "+(seek*no));
        }
    }
     
}
        
/*
queue: 98, 183, 37, 122, 14, 124, 65, 67
head:53
*/
