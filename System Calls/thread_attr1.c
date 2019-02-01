#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
//#include<pthread/types.h.
int ctr=0;  // GLOBAL VARIABLE
void *function(int *args)
{
    //if(ctr==0)
    {
        printf("Arguments passed %d\n",*args);
        printf("Enter thread %d\n",ctr);
        printf("Exit thread %d\n",ctr);
        ctr++;      //COUNTNG THREADS
    }
}



int main()
{
    int arg=10;
    pthread_t thd_id;
    pthread_attr_t tattr;       // CREATE ATTRIBUTE NAME
    pthread_attr_init(&tattr);  // INITIALIZE ATTRIBUTE TO DEFAULT VALUES
    pthread_attr_setdetachstate(&tattr,PTHREAD_CREATE_JOINABLE);    
    // JOINABLE - WAITS UNTIL THREAD IS TERMINATED, BUT DETACHED - DOES NOT WAIT UNTIL THREAD TERMINATES
    pthread_create(&thd_id,&tattr,function,&arg);
    pthread_create(&thd_id,&tattr,function,&arg);
    pthread_exit(NULL);
    return 0;

}
