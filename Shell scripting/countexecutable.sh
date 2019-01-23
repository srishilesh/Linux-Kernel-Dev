#!/bin/sh
count=0
for file in *
do
if test -x $file
then
count = `expr $count + 1`
fi
done
echo "Number of executable files is $count"
