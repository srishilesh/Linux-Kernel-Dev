#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
void main()
{
int fd,reval;
char ch[7];
fd=open("/tmp/myfifo",O_RDONLY);
reval=read(fd,ch,sizeof(ch));
fflush(stdin);
write(1,ch,sizeof(ch));
close(fd);
}
