"""
Assignment 2
exercise1.py
"""
lname=[]
club=[]
def function_1(x): # x represents the argument of  listname
    print(30 * "-" +" " + 15 * "-" +" " + 15 *"-" + " " + 15 * "-" )
    print('NAME'.center(30)+'|'+'SALARY'.center(15)+'|'+'POSITION'.center(15)+'|'+'CLUB'.center(15)) # Creating table with appropriate fixed width
    print(30 * "-" +" " + 15 * "-" +" " + 15 *"-" + " " + 15 * "-" )
    for i in x: # reads in the file
        tup=tuple(i.split())
        lname.append((tup[3],tup[2],tup[4],tup[1],tup[0])) # sending these data inside an empty list where the order of arrangement to be output changes and has to be used in function2 
        print((tup[3]+','+ " " +tup[2]).center(30)+':'+tup[4].center(15)+':'+tup[1].center(15)+':'+tup[0].center(15))   # output values in the table from the given input file
    print(30 * "-" +" " + 15 * "-" +" " + 15 *"-" + " " + 15 * "-" )
    function_2(lname)
    
#passing lname in function_2

def function_2(z):
    running = True
    while running: # when the porgramsit keeps asking questions until the user wants to terminate it
        print()
        print("1. Full details of player")
        print("2. Players of a team")
        print("3. Exit program. \n")
        a = int(input("Choose one of the options above: ")) 
        if a == 1 : # checking the option 1 if user inputs that
            print()
            print("i. Search using Last Name") # show two other option for user to select
            print("ii. Enter Range of Salary")
            print()
            a1 = input("Choose one of your choice: ")
            if a1=='i': # if the user enters i
                c=0
                print()
                name=input("Enter player Last Name: ") # asks for the last name of player
                print()
                for i in z:
                    if name in i:
                        print((i[0]+','+ " " +i[1]).center(20)+i[2].center(5)+i[3].center(15)+i[4].center(10)) # format to print the output
                        c+=1
                    
                if c==0:
                    print("No such player found\nTRY AGAIN")
            elif a1=='ii': # if the user presses secodn option it asks for range of salary
                print()
                lower=int(input("Enter lower range salary of the player: "))   
                upper=int(input("Enter upper range salary of the player: "))
                c=0
                print()
                print('NAME'.center(30)+'|'+'SALARY'.center(15)+'|'+'POSITION'.center(15)+'|'+'CLUB'.center(15))
                print(30 * "-" +" " + 15 * "-" +" " + 15 *"-" + " " + 15 * "-" )
                for i in sorted(z, key=lambda x:x[2]): # sorting salary which is the third item in the tuple
                    a=i[2].replace(',','')
                    if int(a)>=lower and int(a)<=upper:
                        print((i[0]+','+ " " +i[1]).center(30)+':'+i[2].center(15)+':'+i[3].center(15)+':'+i[4].center(15)) # giving appropriate output based on the user input
                        c+=1
                if c==0:
                    print("No such player found")
            else:
                print("Wrong Choice!")
                print("TRY AGAIN")
        elif a==2: # if the user enters 2 it shows the team name and asks the user to input team 
            print()
            print("Teams available")
            for i in z:
                if i[4] in club:
                    continue    # if the club is already in the list it continues the program otherwise it adds a new club if there is any and then gives apporpriate output based on the chosen club
                else:
                    print(i[4])
                club.append(i[4])
            print()
            ch=input("Enter the Club you like: ")
            print()
            for i in z:
                if ch in i:
                    print((i[0]+','+ " " +i[1]).center(30)) # gives output of last name and first name of the player in that club
                    
        elif a==3: # if the user presses the third option which for the program to be terminated
            print()
            print("The program has been successfully terminated!")
            running = False
        else:
            print("Wrong Choice \nTRY AGAIN ")

        
# opening file  
file=input("Enter file name: ")
try:
    listname=open(file,"r") # reads every single line in the file
    function_1(listname) # sending the text file in function_1
except:
    print("Wrong file name", file)



    

    
    
    
    
    
    
    
    
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
