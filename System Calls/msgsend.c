#include<unistd.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<stdio.h>
#include<string.h>
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
strcpy(m.txt,"HELLO I AM SHILESH");
msgsnd(msqid,&m,sizeof(m),IPC_NOWAIT);
//sleep(10);
}
