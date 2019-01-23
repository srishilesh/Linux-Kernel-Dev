#!/bin/bash
index=0
while true
do
read -p "Enter new element: " x
[ "$x" = "" ] && break
inputarray[$index]=$x
((index++))
done
echo "The array contains ${#inputarray[*]} elements"
echo "Elements are ${inputarray[*]}"
read -a array
sum=0
for i in "${array[@]}"
do 
sum=`expr $sum + $i`
done
echo "The sum is $sum"
array1=(one two three)
echo ${#array1[0]} " , " ${#array1[1]} " , " ${#array1[2]}
