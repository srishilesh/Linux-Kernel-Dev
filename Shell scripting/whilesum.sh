#!/bin/sh
echo -n 'Choose command[1-2]>'
read reply
echo
case $reply in
"1") i=1
sum=0
while [ $i -le 100 ]
do
sum=`expr $sum + $i`
i=`expr $i + 1`
done
echo "sum is $sum"
;;
"2") x=1
until [ $x -gt 3 ]
do
echo x=$x
x=`expr $x + 1`
done
;;
*) echo Invalid choice
;;
esac
