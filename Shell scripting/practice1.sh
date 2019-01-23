#!/bin/sh
sum=0
for i in $1 $2 $3 $4 $5 $6 $7 $8 $9
do
if test $i -gt 10
then 
sum=`expr $sum + $i`
fi
done
echo "The total sum is $sum"
