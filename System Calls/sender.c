#include<stdio.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#include<string.h>
void main()
{
key_t key=1024;
int size=26;
int shmid=shmget(key,size,IPC_CREAT | 0666);
printf("SHMID: %u\n",shmid);
char *ptr;
ptr=shmat(shmid,NULL,0666);
for(char i='a';i<='z';i++)
{
*ptr=(char)i;
ptr++;
}
shmdt(ptr);
}

