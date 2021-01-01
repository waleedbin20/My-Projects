##########################################
## CE151 ASSIGNMENT 1: DO NOT REMOVE    ##
##########################################
import unittest
##########################################
## CE151 ASSIGNMENT 1: DO NOT REMOVE    ##
##########################################
"""
 assignment1.py
 done by waleed 13/11/2018
 """
## Exercise 1
def fun_exercise_1(x,y):
    for i in range(len(y)):
        if x%2==1 :
            y[i] = y[i] - 1
        if x%2 == 0 and x!=0 :
            y[i] = y[i] * 2
        if x==0 :
            y[i] = y[i]
    return sum(y)
        
       
#### Exercise 2        
def fun_exercise_2(y):
    prod = 1
    if y[0]%2 == 1:
        for i in range(len(y)):
            y[i] = y[i]*2
            prod = prod * y[i]
        
    elif y[2]%2 == 1:
        prod = 0
        for i in range(len(y)):
            y[i] = y[i]/2
            prod = prod + y[i]
            
    else :
        prod = 0
        for i in range(len(y)):
            y[i] = y[i] * y[i]
            prod = prod + y[i]
    return prod
        

        
#### Exercise 3
def fun_exercise_3(y):
    z = []
    s = int(len(y)/2)
    t = len(y) -1
    for i in range(s):
        if y[t] < y[i]:
            z.append(True)
            s=s-1
        else:
            z.append(False)
    return (z)


#### Exercise 4
def fun_exercise_4(y):
    y.sort(reverse = True)
    if y == []:
        return(None)
    elif len(y) < 5:
        numb = len(y)-2
        return(y[numb])
    else:
        return(y[2])
    
###### Exercise 5
def fun_exercise_5(x):
    for i in range(len(x)//2):
        x = x.lower()
        if x[i] != x[-1-i]:
                 return True
    return False

#### Exercise 6
def fun_exercise_6(x):
    wrd = ""
    for i in x :
        if i in "ABCDEFGHIJKLabcdefghijkl" :
            wrd = wrd + i.lower()
        if i in "mnopqrstuvwxyzMNOPQRSTUVWXYZ" :
            wrd = wrd + i.upper()
    return wrd

#### Exercise 7
def fun_exercise_7(x):
     for i in range(len(x)):
        matches = 0
        for string in x:
            if x[i] in string:
                matches += 1
        if matches > 1:
            return i        
     return -1

#### Exercise 8
def fun_exercise_8(x) :
   x = ''.join(sorted(x))
   x = list(x)
   x = sorted(x, key=x.count, reverse=True)
   one = x[0]
   while one in x :
       x.remove(one)
   return(x[0])
        
    
 

##############################################
## BEGIN: CE151 TEST CODE: DO NOT REMOVE    ##
##############################################
class TestAssignment1(unittest.TestCase):

#function 1
    def test1_exercise_1(self):
        self.assertTrue(fun_exercise_1(3,[4,2,3]) == 6)

    def test2_exercise_1(self):
        self.assertTrue(fun_exercise_1(2,[2,3,4]) == 18)

    def test3_exercise_1(self):
        self.assertTrue(fun_exercise_1(0,[5,3,2]) == 10)

    def test4_exercise_1(self):
        self.assertTrue(fun_exercise_1(3,[1,1,1]) == 0)

#function 2
    def test1_exercise_2(self):
        self.assertTrue(fun_exercise_2([3, 2, 4]) == 192)

    def test2_exercise_2(self):
        self.assertTrue(fun_exercise_2([6, 2, 3]) == 5.5)

    def test3_exercise_2(self):
        self.assertTrue(fun_exercise_2([6, 5, 4]) == 77)

    def test4_exercise_2(self):
        self.assertTrue(fun_exercise_2([1, 2, 3]) == 48)

#function 3 *****
    def test1_exercise_3(self):
        self.assertTrue(fun_exercise_3([2, 3, 4, 5, 6, 7]) ==[False, False,False])

    def test2_exercise_3(self):
        self.assertTrue(fun_exercise_3([6, 4, 3, 2, 1, 0]) == [True,True,True])

    def test3_exercise_3(self):
        self.assertTrue(fun_exercise_3([6, 5, 4, 2]) == [True, True])

    def test4_exercise_3(self):
        self.assertTrue(fun_exercise_3([1, 2, 3, 4]) == [False, False])
##
###function 4
    def test1_exercise_4(self):
        self.assertTrue(fun_exercise_4([5, 3, 4, 2 , 6]) == 4)

    def test2_exercise_4(self):
        self.assertTrue(fun_exercise_4([3, 2, 6]) == 3)

    def test3_exercise_4(self):
        self.assertTrue(fun_exercise_4([]) == None)

    def test4_exercise_4(self):
        self.assertTrue(fun_exercise_4([2, 3, 4, 7, 6, 5]) == 5 )
##
###function 5
    def test1_exercise_5(self):
        self.assertTrue(fun_exercise_5("osso") == False)

    def test2_exercise_5(self):
        self.assertTrue(fun_exercise_5("goat") == True)

    def test3_exercise_5(self):
        self.assertTrue(fun_exercise_5("Mom") == False)

    def test4_exercise_5(self):
        self.assertTrue(fun_exercise_5("boat") == True )

#function 6
    def test1_exercise_6(self):
        self.assertTrue(fun_exercise_6("osso") == "OSSO")

    def test2_exercise_6(self):
        self.assertTrue(fun_exercise_6("goat") == "gOaT")

    def test3_exercise_6(self):
        self.assertTrue(fun_exercise_6("bag") == "bag")

    def test4_exercise_6(self):
        self.assertTrue(fun_exercise_6("boat") == "bOaT" )

#function 7
    def test1_exercise_7(self):
        list1 = ["goat"]
        ptr = fun_exercise_7(list1)
        self.assertTrue(ptr == -1)

    def test2_exercise_7(self):
       list1 = ["soul", "soulmate", "origin"]
       ptr = fun_exercise_7(list1)
       self.assertTrue(ptr == 0)

    def test3_exercise_7(self):
        list1 = ["FASER", "submission", "online", "drive", "frequent"]
        ptr = fun_exercise_7(list1)
        self.assertTrue(ptr == -1)

    def test4_exercise_7(self):
        list1 = ["banana", "applejuice", "kiwi", "strawberry", "apple", "peer"]
        ptr = fun_exercise_7(list1)
        self.assertTrue(ptr == 4)

##function 8
    def test1_exercise_8(self):
        self.assertTrue(fun_exercise_8("GTTAAA") == "T")


    def test2_exercise_8(self):
        self.assertTrue(fun_exercise_8("unforeseen") == "n")


    def test3_exercise_8(self):
        self.assertTrue(fun_exercise_8("developed") == "d")


    def test4_exercise_8(self):
        self.assertTrue(fun_exercise_8("circumstances") == "s")

if __name__ == '__main__':
   unittest.main()
##############################################
## END: CE151 TEST CODE: DO NOT REMOVE      ##
##############################################
