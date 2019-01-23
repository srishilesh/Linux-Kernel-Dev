#include<stdio.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#include<sys/stat.h>
#include<string.h>
#include<unistd.h>
#include<stdlib.h>
#include<ctype.h>
#include<fcntl.h>
int main(int argc,char* argv[])
{
key_t key=1234;
int size=10;
char *ptr;
int fd=creat("produce.txt",S_IRWXU);
int sz=read(fd,ptr,1);
ptr[sz]='\0';
printf("Read data from file %d\n",*ptr);
int shmid=shmget(key,size,IPC_CREAT | 0666);
printf("Enter the number of items to be produced: %s\n",argv[1]);
char *x=argv[1];
//printf("Number of items to be produced: %s\n",x);
if(atoi(x)>10)
{
printf("Production size exceeded\n");
exit(1);
}
char *p=ptr;
printf("File pointer %c\n",*p);
ptr=shmat(shmid,NULL,0666);
int sum=0;
//if(*ptr1!=0)
//sum=*ptr1;
if(sum<=10)
{
sum=sum+*x;
*ptr=sum+'\0';
}
printf("No of items is %s\n",ptr);
write(fd,ptr,1);
shmdt(ptr);
close(fd);
return 0;
}




