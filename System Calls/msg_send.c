#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<fcntl.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<string.h>
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

if((key=ftok("msg_send.c",'b'))==-1)
{
perror("key");
exit(1);
}
int msgid;
if((msgid=msgget(key,IPC_CREAT | 0666))==-1)
{
perror("MSGID");
exit(1);
}
printf("Message ID: %d",msgid);
printf("Enter a text:\n ");
while(scanf("%s",msg.text)&&!feof(stdin))
{
if(msgsnd(msgid,&msg,sizeof(msg),0)==-1)
{
perror("Message not sent\n");
exit(1);
}
}
if(msgctl(msgid,IPC_RMID,NULL)==-1)
{
perror("Message Queue Not removed\n");
exit(1);

}
}
