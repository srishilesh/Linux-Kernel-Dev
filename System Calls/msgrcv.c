#include<stdio.h>
#include<string.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<stdlib.h>
struct msg
{
long type;
char txt[20];
}m;
void main()
{
int msqid;
key_t key=1024;
msqid=msgget(key,IPC_CREAT | 0666);
m.type=7;
if(msgrcv(msqid,&m,sizeof(m),m.type,IPC_NOWAIT) <0)
{
perror("message received failed");
exit(1);

}
printf("TEXT: %s\n",m.txt);
msgctl(msqid,IPC_RMID,NULL);
}

