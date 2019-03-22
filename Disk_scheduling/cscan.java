import java.io.*;
import java.util.*;

public class csan
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

        int headloc=0;
        ArrayList a =new ArrayList<>(q);
        Collections.sort(a);
        for(int i=0;i<n;i++)
        {
            if(head==(int)a.get(i))
            headloc=i;

        }
        int no=0;
        for(int i=headloc+1;i<n;i++)
        {
            System.out.println("Request : "+a.get(i));
            if(i<n-1)
            no=no+(int)a.get(i+1)-(int)a.get(i);
            System.out.println("Movement in cylinder is "+no);
            System.out.println();

        }
        System.out.println("Request : "+end);
        no=no+end-(int)a.get(n-1);
        System.out.println("Movement in cylinder is "+no);
        for(int i=0;i<headloc;i++)
        {
            System.out.println("Request : "+a.get(i));
            no=no+(int)a.get(i+1)-(int)a.get(i);
            System.out.println("Movement in cylinder is "+no);
            System.out.println();

        }
        System.out.println("Total seek time is "+(seek*no));
        
    }
}
