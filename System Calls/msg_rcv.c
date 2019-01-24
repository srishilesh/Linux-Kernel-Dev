#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/types.h>
#include<sys/msg.h>
#include<sys/ipc.h>
#include<stdlib.h>
struct message
{
long type;
char text[100];
};
void main()
{
struct message msg;
key_t key;
if((key=ftok("msg_rcv.c",'b'))==-1)
{
perror("key");
exit(1);
}
int msgid;
if((msgid=msgget(key,IPC_CREAT|0666))==-1)
{
perror("MSGID\n");
exit(1);
}
msg.type=1;
for(; ;)
{
if(msgrcv(msgid,&msg,sizeof(msg),msg.type,0)==-1)
{
perror("Message not received");
exit(1);
}
printf("%s\n",msg.text);
}
if(msgctl(msgid,IPC_RMID,NULL)==-1)
{
perror("MSGCTL\n");
exit(1);
}
}
