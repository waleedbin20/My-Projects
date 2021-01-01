-- Q: retrieve name, surname and gender from people that are from 'Essex'
select name, surname, gender from people where location = "Essex";

-- Q: Retrieve the name and surname from all women ('F') from 'Essex'
select name, surname from people where location = "Essex" and gender = "F";


-- Q: Retrive the name and surname from all women ('F') between 25 and 35 years old
select name, surname from people where gender = "F" and age<="35" and age >="25";

-- Q: Retrive the max age of women ('M'). Provide just the value of max age.
select MAX(age) from people where gender = "F";


-- Q: Retrive the different of age between the max age and min age of people living in Hertfordshire. 
-- Provide just the value of the difference.
select max(age) - min(age)  from people where location = "Hertfordshire";


-- Q: Count the number of people in each location. Provide the name of the location and respective count.
select location,COUNT(*) from people group by location ;


-- Q: Retrive the name, surname of people that are not in London
select name, surname from people where location != "London";

-- Q: Retrive both averages of the age of people that is located in Essex and Kent using the same query. Provide both averages (location name not needed).
select avg(age)  from people where location = "Kent" or location = "Essex" group by location;

-- Q: Retrive the surnames of people which surname ends in "son"
select surname from people where surname LIKE "%son" ;

-- Q: Retrive the names and surname of men who likes women in ascending alphabetic order by their surnanme 
select name, surname from people where gender = "M" and likes = "Women" order by surname ASC; 
 
-- Q: Add a new person into the database called 'Abigail Hillforest' who lives in London, 
-- is a woman ('F'), age 22 and her likes are unknown (NULL).
insert into people values (26,'Abigail','Hillforest','London','F',NULL,22);

-- Q: Insert the interest 'Jazz music' for 'Abigail Hillforest', don't input the values of the ids straight,
-- intead you can find them automatically by using the proper select queries in each value entry
 insert into people_interests select personid,interestid from people,interests  where name = "Abigail" and surname = "Hillforest" and interestname = "Jazz music";

-- Q: Udpate the location of 'Houston Harn' to 'Essex'
update people set location = 'Essex' where name = "Houston" and surname = "Harn";

-- Q: Retrieve the location that has more than 6 people registered in it. Provide the name of the location and its count.
select location , count(*) from people group by location having count(*)>6;

-- Q: Retrieve the interests that have a larger amount of people interests than two. Provide the interest name and its count.
select interestname, count(people_interests.interestid) from interests, people_interests where people_interests.interestid = interests.interestid group by interestname having count(people_interests.interestid)>2;

-- Q: retrieve the IDs from people that are looking for 'Friendship'.
select  personid from people_lookingfor, lookingfor where lookingfor.lookingforid = people_lookingfor.lookingforid and  lookingfor.lookingforname = 'Friendship';

-- Q: Count the number of people who is looking for 'Friendship'
select count(personid) from people_lookingfor, lookingfor where lookingfor.lookingforid = people_lookingfor.lookingforid and  lookingfor.lookingforname = 'Friendship';

-- Q: Retrieve the names and surnames from people who are looking for friendship
select  name, surname from people, people_lookingfor, lookingfor where lookingfor.lookingforid = people_lookingfor.lookingforid and people.personid = people_lookingfor.personid and  lookingfor.lookingforname = 'Friendship';

-- Q: Return the names of all interests and the number of people who is interested in it. 
select interestname, count(people_interests.interestid) from interests, people_interests where people_interests.interestid = interests.interestid group by interestname;

-- Q: Return the IDs of a pair of persons and the count of the common interests.
select p1.personid, p2.personid, count(*) from people_interests as p1 inner join people_interests as p2 on p1.interestid = p2.interestid and p1.personid < p2.personid group by p1.personid, p2.personid;

-- Q: Return now the pairs of persons from the query above but with their respective names and surnames
select concat (people1.name," ", people1.surname) as person1_name, concat(people2.name, " ", people2.surname) as person2_name, count(*) AS common_interests 
from people_interests as p1 inner join people_interests as p2 
inner join people AS people1 ON p1.personid = people1.personid 
inner join people AS people2 ON p2.personid = people2.personid 
where p1.interestid = p2.interestid  and p1.personid < p2.personid 
group by p1.personid, p2.personid;