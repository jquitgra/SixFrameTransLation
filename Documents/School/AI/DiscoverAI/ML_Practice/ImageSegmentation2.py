#This is a DFS problem so I am going to treat the matirx as a graph (s/o GFG)
class Graph:
    #contructor
    def __init__(self, r, c, g):
        self.MAX_ROW = r
        self.MAX_COL = c
        self.graph = g
    #safe transition function
    def safeTrans(self, i, j, visited):
        return (i>= 0 and i<self.MAX_ROW and 
        j>=0 and j<self.MAX_COL and (i,j) not in visited and
        self.graph[i][j])
    
    def DFS(self, i, j, visited):
        rowNbr = [-1, -1, -1,  0, 0,  1, 1, 1]; 
        colNbr = [-1,  0,  1, -1, 1, -1, 0, 1]; 
          
        #add coordinate to visited
        visited.add((i,j))

        #recursive DFS
        for k in range(8): 
            if self.safeTrans(i + rowNbr[k], j + colNbr[k], visited): 
                self.DFS(i + rowNbr[k], j + colNbr[k], visited)

    def countConnPixels(self):
        #print("yah")
        visited = set()

        count = 0
        for i in range(self.MAX_ROW):
            for j in range(self.MAX_COL):
                #print("yeah")
                if ((i,j) not in visited and self.graph[i][j] == 1):
                    #print(self.graph[i][j])
                    self.DFS(i,j,visited)
                    count +=1
        return count

image = []
#I am assuming I am receving an image with a depth of 4
for i in range(4):
    input1 = input()
    imgCol = []
    for i in input1:
        imgCol.append(int(i))
    image.append(imgCol)
row = len(image) 
col = len(image[0]) 
g = Graph(row, col, image)  
print(g.countConnPixels())
