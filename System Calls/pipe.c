//PIPES 
#include<stdio.h>
#include<unistd.h>
void main()
{
int pipefd[2];
pipe(pipefd);
int fd=fork();
char ch[7];
if(fd>0)
{
fflush(stdin);
printf("\n Inside Parent \n");
write(pipefd[1],"Shilesh",7);
}
if(fd==0)
{
sleep(5);
fflush(stdin);
printf("\n Inside Child \n");
read(pipefd[0],ch,sizeof(ch));
write(1,ch,sizeof(ch));
}
}

