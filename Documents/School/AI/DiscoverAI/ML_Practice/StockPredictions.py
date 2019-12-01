import pandas as pd
import numpy as np
import sklearn.linear_model
def printTransactions(m, k, d, name, owned, prices):
    days = [1, 2, 3, 4, 5]
    df2 = pd.DataFrame(days)
    df = pd.DataFrame(prices)
    Y = df2.iloc[:,0].values.reshape(-1,1)
    predictions = list()
    for i, row in enumerate(df.values):
        X = df.iloc[i,:].values.reshape(-1,1)
        linear_regressor = sklearn.linear_model.LinearRegression()
        reg = linear_regressor.fit(X,Y)
        '''Y_pred = linear_regressor.predict(X)'''
        predictions.append(reg.coef_)
    
    best = max(predictions)
    bestIn = predictions.index(best)
    print(k)
    #print the 10 transcations
    for i in range(k):
        if (i is not bestIn):
            print(name[i], "SELL ",owned[i])
        else:  
            print(name[i], " BUY ", 100//(float(prices[bestIn][-1])))
        
input1 = input()
lis1 = [x for x in input1.split()]
m = float(lis1[0])
k = int(lis1[1])
d = int(lis1[2])
name = []
owned = []
prices = [] #This will be a matrix
for i in range(k):
    lis2 = [x for x in input().split()]
    name.append(lis2[0])
    owned.append(lis2[1])
    prices.append(lis2[2::])
printTransactions(m, k, d, name, owned, prices)
'''print("d: ", d)
print("K: ", k)
print("m: ",m)
print("name: ",name)
print("owned: ",owned)
print("prices: ",prices)'''
