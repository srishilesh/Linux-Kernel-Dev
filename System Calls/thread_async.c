#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
int count=0;
pthread_t thread[2];
//          WITHOUT MUTEX NO SYNCHRONIZATION


void trythis()
{
    unsigned long i=0;
    count++;
    printf("Job %d started\n",count);

    for(long i=0;i<(0xFFFFFFFF);i++);
    printf("Job %d ended\n",count);
    
    return NULL;


}
int main()
{
    
    int i=0;
    while(i<2)
    {
    if(pthread_create(&thread[i],NULL,trythis,NULL)!=0)
    {
        printf("Thread not created\n");
    }
    i++;
    }
    pthread_join(thread[0],NULL);
    pthread_join(thread[1],NULL);
    
    pthread_exit(NULL);
    return 0;

}