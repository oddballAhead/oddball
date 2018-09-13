#!/usr/bin/env python

import sys
import os

if len(sys.argv) == 1 :
    print("""Error, please give a filename as a command-line argument.""")
    sys.exit()
    
for x in range(1, len(sys.argv)):
    filename = sys.argv[x]
    with open(filename) as fp:
        cnt = 0
        wordcount = 0
        chars = 0
        for line in fp:
            line = line.strip(os.linesep)
            cnt += 1
            words = line.split()
            wordcount = wordcount + len(words)
            chars = chars + len(line)

        print(cnt, wordcount, chars, filename)
    

#print("Hello")
