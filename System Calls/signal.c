#include<stdio.h>
#include<stdlib.h>
#include<signal.h>
#include<unistd.h>
#include<sys/types.h>
void print(int signo)
{
printf("Signal caught %d\n",signo);
}
void main()
{
signal(SIGINT,print);
while(1)
{
printf("Hello\n");
sleep(1);
}
}
