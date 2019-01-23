#!/bin/sh
big=0
for i in 5 2 3 1 4
do
if [ $big -lt $i ]
then
big=$i
fi
done
echo "Biggest is $big"
files=`ls`
for i in $files
do
echo -n "$i"
echo
grep $i $i
done

