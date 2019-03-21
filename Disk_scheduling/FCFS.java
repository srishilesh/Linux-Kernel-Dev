import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class fcfs
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Queue<Integer> q=new LinkedList<>();
        System.out.println("Enter the Start of Track: ");
        int start=sc.nextInt();
        System.out.println("Enter the End of Track: ");
        int end=sc.nextInt();
        System.out.println("Enter the seek time of each request: ");
        int seek=sc.nextInt();
        System.out.println("Enter the head pointer: ");
        int head=sc.nextInt();
        q.add(head);
        System.out.println("Enter the Disk Request size: ");
        int n=sc.nextInt();
        System.out.println("Enter the Disk request sequence: ");
        for(int i=0;i<n;i++)
        q.add(sc.nextInt());

        int no;
        if(head>q.peek())
        no=head-q.peek();
        else
        no=q.peek()-head;

        for(int i=0;i<q.size();i++)
        {
            int a=q.poll();
            int b=q.peek();
            System.out.println("Request : "+a);
            if(a<b)
            {
                no=no+(b-a);
                System.out.println("Difference in cylinders is "+(b-a));
            }
            else
            {
                no=no+(a-b);
                System.out.println("Difference in cylinders is "+(a-b));
            }
            System.out.println("Number of cylinders moved : "+no);
            System.out.println("Seek time of the request "+a+" is "+(seek*no));
            System.out.println();
        }

        
    }
}
/*
queue: 45, 21, 67, 90, 4, 50, 89, 52, 61, 87, 25
head:50

*/
/*
queue: 98,183,37,122,14,124,14,124,65,67
head:53
*/
