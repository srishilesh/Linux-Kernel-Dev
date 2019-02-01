#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
pthread_t tid[2];
pthread_mutex_t lock=PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t condvar= PTHREAD_COND_INITIALIZER;
int c=0;
void *f1()
{
    for(int i=1 ;i<=10 ;i++)
    {
    
        pthread_mutex_lock(&lock);
        pthread_cond_wait(&condvar,&lock);
        
        c++;
        printf("T1 %d\n",c);
        pthread_mutex_unlock(&lock);
    
    }
    return NULL;
}
void *f2()
{
    for(int i=1;i<=10 ;i++ )
    {
        pthread_mutex_lock(&lock);
        if(c<3 || c>6)
        {
            pthread_cond_signal(&condvar);

        }
        else
        {
            c++;
            printf("t2 %d \n",c);
        }
        pthread_mutex_unlock(&lock);
    }
}

//      ERROR IN THIS

int main()
{
    if(pthread_create(&tid[0],NULL,f2,NULL)!=0)
    {
        printf("Thread cannot be created\n");
        
    }
    sleep(1);
    if(pthread_create(&tid[1],NULL,f1,NULL)!=0)
    {
        printf("Thread cannot be created\n");
        
    }
    pthread_join(tid[0],NULL);
    pthread_join(tid[1], NULL);
}
