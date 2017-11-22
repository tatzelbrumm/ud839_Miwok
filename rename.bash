#!/bin/bash
# usage:
# rename directory pattern filename
#
# find pattern in directory tree
# replace file name without extension to filename
for feile in $(find $1 -name $2)
do
  mv ${feile} ${feile%/*}/$3.${feile##*.}
done

