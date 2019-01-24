#include<unistd.h>
#include<stdio.h>
void main()
{
pid_t pid;
pid=fork();
printf("Forking\n");
if(pid==0)
{
printf("Child's process\n");
printf("PID: %d\n",getpid());
}
else
{
printf("Parent process\n");
printf("PID: %d\n",getpid());
}
}
