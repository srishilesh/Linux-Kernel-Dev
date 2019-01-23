#!/bin/sh
filename=$1
sed -i -e 's/(/[/g' $filename
sed -i -e 's/)/]/g' $filename
