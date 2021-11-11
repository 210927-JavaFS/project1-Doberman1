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

##Setting up my application:

**Clone the repository onto your computer**  
![](./imgs/logical.jpg)

**Logical Model**
![](./imgs/logical.jpg)

**Physical Model**
![](./imgs/physical.jpg)

**Use Case Diagram**
![](./imgs/use-case.jpg)

**Activity Diagram**
![](./imgs/activity.jpg)

## Technical Requirements

The back-end system shall use Hibernate to connect to an AWS RDS Postgres database. The middle tier shall use Javalin technology for dynamic Web application development. The front-end view shall use HTML/JavaScript to make an application that can call server-side components RESTfully. Passwords shall be encrypted in Java and securely stored in the database. The middle tier shall follow proper layered architecture, have reasonable (~70%) test coverage of the service layer, and implement Logback for appropriate logging. 

**Stretch Goals:**
* Replace HTML/JavaScript with an Angular single page application.
* Users can upload a document or image of their receipt when submitting reimbursements which can stored in the database and reviewed by a financial manager.
* Application shall be hosted remotely on an EC2.
* Static files (webpages) shall be hosted on an S3 bucket. 
