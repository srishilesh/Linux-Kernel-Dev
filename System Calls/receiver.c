#include<stdio.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#include<sys/types.h>
#include<string.h>
void main()
{
int key=1024;
int size=26;
char *ptr;
int shmid=shmget(key,size,IPC_CREAT | 0666);
ptr=shmat(shmid,NULL,0666);
for(int i=0;i<26;i++)
{
printf("%c\n",(char)*ptr);
ptr++;
}
shmctl(shmid,IPC_RMID,0);
}
