# Employee Reimbursement System (ERS)

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used:  
  Java, 
  SQL, 
  CSS, 
  HTML, 
  JavaScript, 
  JUnit, 
  Hibernate, 
  AWS RDS, 
  Log4J, 
  Javalin

## Features:  
  Login  
  Two account types with different access to features  
  All employees can submit reimbursement requests  
  All employees can view their past and pending reimbursements  
  Finance managers can view all reimbursement requests  
  Managers can approve or deny requests  

**Possible future developement features:**  
Multiple pages/ routing to hide inaccessbile functionality  
Prettier user interace

## Setting up the application:

**Clone the repository onto your computer**  
![](./imgs/cloning.jpg)

**Import an existing Maven project into your IDE**
![](./imgs/importing.jpg)

**Select the folder into which you cloned the repository**
![](./imgs/selecting.jpg)

**Run the Main class as a java application**
![](./imgs/running.png)

**Run the PostgreSQL script in a database instance**
![](./imgs/database.png)

**Head to a browser and navigate to http://localhost:8081/proj1.html**
![](./imgs/navigating.png)

## Technical Requirements

The back-end system shall use Hibernate to connect to an AWS RDS Postgres database. The middle tier shall use Javalin technology for dynamic Web application development. The front-end view shall use HTML/JavaScript to make an application that can call server-side components RESTfully. Passwords shall be encrypted in Java and securely stored in the database. The middle tier shall follow proper layered architecture, have reasonable (~70%) test coverage of the service layer, and implement Logback for appropriate logging. 

**Stretch Goals:**
* Replace HTML/JavaScript with an Angular single page application.
* Users can upload a document or image of their receipt when submitting reimbursements which can stored in the database and reviewed by a financial manager.
* Application shall be hosted remotely on an EC2.
* Static files (webpages) shall be hosted on an S3 bucket. 
