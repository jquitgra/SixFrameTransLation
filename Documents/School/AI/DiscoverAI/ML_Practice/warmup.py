# Enter your code here. Read input from STDIN. Print output to STDOUT
from collections import Counter
import math
# Compute the mean.
def findMean(n, arr):
    sumNum = 0
    for i in arr:
        sumNum += i
    mean = sumNum/n
    return mean

#compute the median
def findMedian(n, arr):
    arr.sort()
    median = (arr[n//2]*0.5+arr[(n-1)//2]*0.5)
    return median

#compute the mode 
def findMode(n, arr):
    minOcc = 1;
    minMode = arr[0];
    what = dict(Counter(arr))
    #iterate through keys
    for i in what:
        curVal = i;
        #look at value of dict (occurrences) of current key
        curOcc = what.get(i)
        if(curOcc >= minOcc and curVal < minMode):
            minOcc = curOcc
            minMode = curVal
    return minMode

#compute the standard deviation
def findStandDev(n,arr, mean):
    sumDev = 0
    for i in arr:
        sumDev += (i - mean)**2
    stnDev = math.sqrt(sumDev/n)
    return stnDev

#compute the confidence intervals to 95%
def findConfInter(n, arr, mean, sdev):
    conf1 = mean+1.96*sdev/math.sqrt(n)
    conf2 = mean-1.96*sdev/math.sqrt(n)
    return (conf1, conf2)
#type cast inputs
input1 = int(input())
input2 = input()
input2 = [int(i) for i in input2.split()]

#invoke functions
mean = findMean(input1, input2)
median = findMedian(input1, input2)
mode = findMode(input1, input2)
sdev = findStandDev(input1,input2,mean)
confs = findConfInter(input1, input2, mean, sdev)
conf1 = confs[1]
conf2 = confs[0]
print(mean)
print(median)
print(mode)
print("{:.1f}".format(sdev))
print("{:.1f}".format(conf2), " ", "{:.1f}".format(conf1))
