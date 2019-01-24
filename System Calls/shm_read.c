#include<stdio.h>
#include<string.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#include<sys/types.h>
int main()
{
int shmid,retval;
char *memory=NULL;
char *p;
key_t key=1023;
shmid=shmget(key,5,IPC_CREAT | 0666);
printf("shmid:%d\n",shmid);
memory=shmat(shmid,NULL,0);
if(memory==NULL)
{
printf("Not attached\n");
return 0;
}
p=(char*)memory;
printf("The message is %s\n",p);
retval=shmdt(p);
if(retval<0)
{
printf("Detachment failed\n");
return 0;
}
shmctl(shmid,IPC_RMID,0);
return 0;
}
