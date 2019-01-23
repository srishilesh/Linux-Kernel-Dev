#!/bin/sh
#file=$1
#sed -i -e 's/[/[/g' $file
#sed -i -e 's/]/]/g' $file
file=/Srishilesh
cd $file
loop=`ls`
for i in loop
do
[ -w $i ] && w="write=yes" || w="write=no"
done
echo $w

