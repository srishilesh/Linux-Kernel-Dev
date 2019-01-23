#!/bin/sh
file='ls'
count=0
for i in *
do
if test $i
then
count=`expr $count + 1`
fi
done
echo "The total number of files is $count"

