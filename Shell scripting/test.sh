#!/bin/sh
files=`ls`
value=`expr 1 + 2`
echo $value
value1=`expr $value + 1`
echo $value1
if test $value -lt $value1
then
echo "$value is less than $value1"
else
echo "$value is greater than $value1"
fi
if test -f sample
then
echo "found"
else
echo "not found"
fi
a="a"
b="hello"
if test $a = $b
then
echo "Equal"
else
echo "Not equal"
fi
echo $files
