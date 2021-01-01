"""
Assignment 2
exercise2.py
"""
import math
name=[]
def function_1(x): # x represents the argument of  listname
    print(30 * "-" +" " + 15 * "-" +" " + 15 *"-" + " " + 15 * "-" )
    print('NAME'.center(30)+'|'+'LATITUDE'.center(15)+'|'+'LONGITUDE'.center(15)+'|'+'POPULATION'.center(15)) # Creating table with appropriate fixed width
    print(30 * "-" +" " + 15 * "-" +" " + 15 *"-" + " " + 15 * "-" )
    for i in x: 
        tup=tuple(i.split())
        name.append((tup[0],tup[1],tup[2],tup[3]))# adding into empty list name whcih will then be passed in function 2
        print(tup[0].center(30)+':'+tup[1].center(15)+':'+tup[2].center(15)+':'+tup[3].center(15))# output values in the table from the given input file
    print(30 * "-" +" " + 15 * "-" +" " + 15 *"-" + " " + 15 * "-" )
    function_2(name)


def function_2(z):
    running = True
    while running: #when the code is running it keeps up showing opetion until we press the option D
        print()
        print("A. Details about a city")
        print("B. Find cities using coordinates")
        print("C. Finding distance between two cities")
        print("D. Exit program \n")
        a = input("Choose on of your choice:- ")
        if a == 'A' : # starting if condition with checking opion A
            print()
            print("i.  Name of the city  ")
            print("ii. Population of the city \n")
            chose = input("Enter your choice: ")
            if chose=='i': # checking first option in A which is 'i'
                c=0
                print()
                name=str(input("Enter name of City:- "))
                print()
                for i in z: # enterig loop
                    if name in i: # checks if the input name is inside the table
                        print('{:^50}'.format(i[0]+' '+'n. citizens: '+i[3])) # print the output printed
                        c+=1
                if c==0:
                    print('Ops! There is no such city')
                    
            elif chose=='ii': # checks option 'ii' in A
                print()
                lower=int(input("Enter lower range of population: ")) # asks for lower and upper range
                upper=int(input("Enter upper range of population: "))
                c=0
                print()
                for i in z:  # enter a loop
                    a = i[3] # 'a' represents the population which is the 4th column in the table and is i[3]
                    if int(a)>=lower and int(a)<=upper: # if the inputs are with in the range 
                        print('{:^50}'.format(i[0]+' '+'n. citizens: '+i[3]))
                        c+=1
                if c==0:
                    print("Ops! There is no city in that population range")
            else :
                print("Please TRY AGAIN")

        elif a =='B': # checks the option B
            c=0
            print()
            print("Provide the Longitude and Latitude coordinates(km) to find your city.\n")
            lati =  int(input('* Enter Latitude of the city: ')) # asks for latitude and lonigtude from the user
            longi = int(input('* Enter Longitude of the city: '))
            for i in z: # looping in to longitude and latitude values to check if there is any city available
                lat = int(i[1])
                lon = int(i[2])
                if abs((lati-lat))<=10 and abs((longi-lon))>=10: # abs is used to print the output to be positvie and check wether its within 10km
                    print()
                    print(('    The city we found in the range provided above is - '+i[0]))
                    c+=1
                if abs((lati-lat))==0 and abs((longi-lon))==0 :
                    print()
                    print(('    The city we found in the range provided above is - '+i[0]))
                    c+=1

            if c==0:
                print("\n  There is no city in range")



        elif a == 'C': # checks the third option which is C
            city1 = input(' *Enter first city: ')
            city2 = input(' *Enter second city: ')
            print()
            print('NAME'.center(20)+'|'+'LATITUDE'.center(15)+'|'+'LONGITUDE'.center(15))
            print(20 * "-" +" " + 15 * "-" +" " + 15 *"-")
            city_list=[] # creating empty list which will be used in the for loop
            for i in z: 
                city_list.append(i[0]) # it adds in the city names inside the empty list
            if (city1) in city_list and city2 in city_list:      
                for i in z:
                    cities=i[0]
                    if (city1) in cities:   # checking if city 1 is present inide the cities
                        x = int(i[1])
                        y = int(i[2])
                        print(i[0].center(20)+':'+i[1].center(15)+':'+i[2].center(15))
                    if (city2) in cities:    # checking if city 2 is present inide the cities
                        x1 = int(i[1])
                        y1 = int(i[2])
                        print(i[0].center(20)+':'+i[1].center(15)+':'+i[2].center(15))
                    # performing calculation for the distance between the cities
                        part1=(x-x1)**2
                        part2=(y-y1)**2
                        result= (part1+part2)**0.5
                        print('\n    The distance between {} and {} is: {:.2f} KM'.format(city1,city2,result))
           
            if not city1 in city_list: # if the city is not present in the list gives an error
                    print(' There is no such city one')
            if not city2 in city_list:
                    print(' There is no such city two')
                    
        elif a == 'D': # checks the option d whihc is exit the program
            running = False
            print('The program has been terminated!')


file=input("Enter file name: ")        
try :
    listname=open(file,"r") # reads every single line in the file
except :
    print("Wrong file") # sending the text file in function_1
    quit()
function_1(listname)
        



