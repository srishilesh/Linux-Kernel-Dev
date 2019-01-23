#include<stdio.h>
#include<stdlib.h>
void main()
{
system("gcc msgsend.c");
system("./a.out");
system("gnome-terminal");
system("gcc msgrcv.c");
system("./a.out");
}
