import java.io.*;
import java.util.*;
public class sjf
{
    static ArrayList<Integer> proc = new ArrayList<Integer>(4); 
    static ArrayList<Integer> bt = new ArrayList<Integer>(4); 
    static ArrayList<Integer> at = new ArrayList<Integer>(4); 
    static ArrayList<Integer> st = new ArrayList<Integer>(4); 
    static ArrayList<Integer> ft = new ArrayList<Integer>(4); 
    static ArrayList<Integer> wt = new ArrayList<Integer>(4); 
    static ArrayList<Integer> tat = new ArrayList<Integer>(4); 

    static int waittime(int start,int arrival)
    {
        return start-arrival;
    }
    static int turnaroundtime(int start,int finish)
    {
        return finish-start;
    }
    static int choosearrivaltime()
    {
        int min=Collections.min(at);
        at.indexOf(min);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Process numbers: ");
        
        for(int i=0;i<4;i++)
        proc.add(sc.nextInt());
        System.out.println("Enter the Burst Time of each process: ");
        for(int i=0;i<4;i++)
        bt.add(sc.nextInt());
        System.out.println("Enter the Arrival Time of each process: ");
        for(int i=0;i<4;i++)
        at.add(sc.nextInt());
        sc.close();
    }
}
