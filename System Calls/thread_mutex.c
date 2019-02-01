#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
#include<string.h>
pthread_t tid[2];
int counter=0;
pthread_mutex_t lock;       // CREATING A MUTEX VARIABLE

void *trythis(void *arg)
{
    pthread_mutex_lock(&lock);      //LOCKING THE MUTEX
    unsigned long i=0;
    counter++;
    printf("Job %d started \n",counter);
    for(i=0;i<(0xFFFFFFFF);i++);
    printf("Job %d ended \n",counter);
    pthread_mutex_unlock(&lock);      //UNLOCKING THE MUTEX
    return NULL;
}


int main(void)
{
    int i=0;
    if(pthread_mutex_init(&lock,NULL)!=0)   // INITIALIZING MUTEX
    {
        printf("Mutex init failed\n");
        return 1;
    }
    while(i<2)
    {
        if(pthread_create(&tid[i],NULL,trythis,NULL)!=0)
        {
            printf("Cannot create thread\n");
        }
        i++;
    }
    pthread_join(tid[0],NULL);
    pthread_join(tid[1],NULL);
    pthread_mutex_destroy(&lock);       // DESTROYING MUTEX
    return 0;

}