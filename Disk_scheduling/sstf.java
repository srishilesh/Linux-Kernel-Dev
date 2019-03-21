import java.io.*;
import java.util.*;

public class sstf
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
        //System.out.println(Collections.min(q));
        int no;

        ArrayList a=new ArrayList<>(q);
        for(int i=0;i<n;i++)
        {
            if(head>(int)a.get(i))
            a.set(i,(head-(int)a.get(i)));      
            else
            a.set(i,((int)a.get(i)-head));
        }
        Collections.sort(a);
        Queue<Integer> q1=new LinkedList<>(a);
        

        if(head>q1.peek())
        no=head-q1.peek();
        else
        no=q1.peek()-head;

        int c,b;
        for(int i=0;i<n;i++)
        {
            
            c=q1.poll();
            b=q1.peek();
            System.out.println("Request : "+(c+head));
            if(c<b)
            {
                no=no+(b-c);
                System.out.println("Difference in cylinders is "+(b-c));
            }
            else
            {
                no=no+(c-b);
                System.out.println("Difference in cylinders is "+(c-b));
            }
            System.out.println("Number of tracks moved : "+(no+head));
            System.out.println("Seek time of the request "+c+" is "+(seek*no));
            System.out.println();

        }

    }
}
/*
queue: 98, 183, 37, 122, 14, 124, 65, 67
head:53
*/
