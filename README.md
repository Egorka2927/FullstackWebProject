<h1 style="text-align: center">Web Engineering Project</h1>

## Table of Contents

* [About the Project](#about-the-project)
* [Technologies](#technologies)
* [Behaviour](#behaviour)
* [Level of Maturity](#level-of-maturity)
* [Work Distribution](#work-distribution)

## About the Project

The goal of our project is to deliver to the user the features on the
provided dataset as a Web application.

We have implemented the backend and frontend of this application in such manner that they
are easy to understand and work with. Our goal is to retrieve data about the countries of the world from
the database, handle the data in our back end and present it to the user.

The user has the freedom to select much of the data available and, for some fields, even create, update or delete data from
the database.

## Technologies

For our application we used Spring for the backend, React for the frontend and MySQL for our database.

We chose to use Spring for the backend because we have worked in JAVA for the past half a year and find
it very comfortable to work with. Spring is a very well known and mature framework for JAVA applications that is
easy to understand. It is well documented and a lot of information can be found online.

We used React for the frontend because the tutorial was easy enough to understand, plus we found videos online
explaining it in great detail. React also allows a considerable amount of customization, which is a very important feature
for any frontend.

MySQL is one of the most used relational database management systems in the world. It has great documentation, and it is very
easy to use.

## Behaviour

The backend contains all the functionalities requested in REQ1. Our queries are made using a combination of SQL and ORM from Spring.
The more complex queries are made using pure SQL, while the easy ones are made using ORM.

All our endpoints support both JSON and CSV formats, including error messages. The JSON format is default for all endpoints. This covers REQ2.

Our specification file contains all the information about the API. The documentation of the API covers all the points required. We used OpenAPI for this. REQ3 is covered.

We have implemented the API as the backend of our application using Spring and have documented the implementation accordingly. We have also updated our documentation and specification. This covers REQ4.

The frontend of our application offers an accessible UI for the user. All the necessary data can be recovered using the frontend, without any restrictions. Errors are clearly displayed and information is easy to comprehend.
The use of Web technologies discussed during the lectures and tutorials is guaranteed. This covers REQ5.

Our app has been dockerized to allow it to be run and tested on any machine. The frontend, backend and database will be deployed on separate containers. REQ6 is covered.

## Level of Maturity

Our Web application is completely functional and deployable, and can perform all the required actions. A user can POST, GET, PUT and DELETE data from the database based on a number of different conditions.
We have created a sturdy foundation for our app, on which the basic and more advanced functionality sits on. Of course, we could significantly improve our design to allow for more extensive and sophisticated functionality.

Our application does suffer from a number of issues that, unfortunately, we did not have enough time to fully address. Some lines of code are duplicated in many places, performance could be greatly increased by using more advanced logic and 
data fetching could be implemented in a more robust manner. Despite all of these, our app is fully functional and easy to use.

## Work Distribution

Our team consists two members. We have split the workload evenly between the two of us. Every time we have worked on this project we did it together. We did not assign roles to each other, we just worked on the same things from start to finish.
We both understand how our application works and we both know how to infrastructure is deployed. Essentially, the work as been split evenly in half.