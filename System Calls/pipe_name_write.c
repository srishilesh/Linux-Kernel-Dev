#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<sys/stat.h>
#include<sys/types.h>
void main()
{
int fd,reval;
char ch[7]="SHILESH";
fflush(stdin);
reval=mkfifo("/tmp/fifo",0666);
fd=open("/tmp/fifo",O_WRONLY);
write(fd,ch,sizeof(ch));
close(fd);
}
