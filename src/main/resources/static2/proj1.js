const URL = "http://localhost:8081/";
//const URL = "http://mybucketforprojects.s3-website.us-east-2.amazonaws.com/"

let employeeLoginStatus = 0;
let managerLoginStatus = 0;
let user = {
    username:null,
    password:null
}
let para = document.createElement("p");
        para.innerText = " ";

let loginButton = document.getElementById("loginButton");
let addReimbursement = document.getElementById("addReimbursement");
let showEmployeeTable = document.getElementById("showEmployeeTable");
let showManagerTable = document.getElementById("showManagerTable");
let submitApproval = document.getElementById("submitApproval");

loginButton.onclick = submitLogin;
addReimbursement.onclick = createReimb;
showEmployeeTable.onclick = showEmployeeReimb;
showManagerTable.onclick = showAllReimb;
submitApproval.onclick = changeReimbStatus;

    async function submitLogin(){

        employeeLoginStatus = 0;
        managerLoginStatus = 0;

       

         user = {
            username:document.getElementById("username").value,
            password:document.getElementById("password").value
          }
    
          let response = await fetch(URL+"login", {
            method:"POST",
            body:JSON.stringify(user),
            //credentials:"include"
          });


          if(response.status===201){
            managerLoginStatus = 1;
            employeeLoginStatus = 1;
            para.setAttribute("style", "color:green")
            para.innerText = "Logged in as manager"
            document.getElementById("loginFailure").appendChild(para);

          }else if(response.status===200){
            employeeLoginStatus = 1;
            para.setAttribute("style", "color:green")
            para.innerText = "Logged in as employee"
            document.getElementById("loginFailure").appendChild(para);
    
          }else{
            para.setAttribute("style", "color:red")
            para.innerText = "LOGIN FAILED"
            employeeLoginStatus = 0;
            managerLoginStatus = 0;
          }
          document.getElementById("loginFailure").appendChild(para);
    }

    async function createReimb(){
        if(employeeLoginStatus === 1){
            let reimb = getReimb();
            if(reimb.amount!=null && reimb.description!=null && reimb.status.reimbStatus != null && reimb.amount >= 0){

            
            let response = await fetch(URL+"reimbursements", {
              method:'POST',
              body:JSON.stringify(reimb),
            });
          
            if(response.status===200){
              console.log("Reimbursement created successfully.");
            }else{
              console.log("Something went wrong creating your reimbursement.")
            }
        }else{
            console.log("Please check your input.")

        }

        } else{
           console.log("Need to login");
        }
    }

    function getReimb(){

      let type = "   ";

        let newAmount = document.getElementById("amount").value;
        let newDescription = document.getElementById("description").value; 
        let newUserRole = {userRoleID: 1, userRole: "employee"}
        let newAuthor = {username: user.username, password: 111, firstName: "Elves", lastName: "Prestintoservice", email:"oopsie", userRole:newUserRole}
        let newStatus = {reimbStatusID: 4, reimbStatus: "pending"};
        let newTypeObj = {reimbTypeID: parseInt(document.querySelector('input[name="Type"]:checked').value)}


      
        let reimb =  {
          amount:newAmount,
          submitted:Date.now(),
          resolved:null,
          description:newDescription,
          author:newAuthor,
          resolver:null,
          status:newStatus,
          type:newTypeObj
        }
      
        
        return reimb;

    }

    async function showEmployeeReimb(){
        if(employeeLoginStatus === 1){
        
    let response = await fetch(URL+"userinfo");
    if(response.status===200){
        let data = await response.json();
        populateEmployeeTable(data);
    }else{
        console.log("Your reimbursement history isn't available.");
        }
    }else{
        console.log("Need to login");
    }

    }

    function populateEmployeeTable(data){

        
        let tbody = document.getElementById("employeeBody");

         tbody.innerHTML="";

         for(let employee of data){
           let row = document.createElement("tr");
       
           for(let cell in employee){
            let td = document.createElement("td");
            if(cell === "author"){
               td.innerText = employee[cell].firstName+" "+employee[cell].lastName;
            }else if(cell === "resolver"){
               if(employee[cell] != null){td.innerText = employee[cell].firstName+" "+employee[cell].lastName;}else{td.innerText = null}
            }else if(cell === "status"){
              td.innerText=employee[cell].reimbStatus;
            }else if(cell === "type"){
               td.innerText=employee[cell].reimbType;
             }else if(cell === "password"){
               break;
             }else if(cell === "submitted"){
              let date = new Date(employee[cell]);
               td.innerText= date.toString();
             }else if(cell === "resolved"){
              if(employee["resolver"]!=null){
             let date = new Date(employee[cell]);
             td.innerText= date.toString();}
              }else{
               td.innerText=employee[cell];
            }
             row.appendChild(td);
           }
           tbody.appendChild(row);
         }

         
    }

    async function showAllReimb(){
        if(managerLoginStatus === 1){
            let response = await fetch(URL+"reimbursements");
            if(response.status===200){
                let data = await response.json();
                populateManagerTable(data);
            }else{
                console.log("Reimbursement history isn't available.");
                }


        }else{
            console.log("Need to login");
        }

    }

    function populateManagerTable(data){

        let tbody = document.getElementById("managerBody");

         tbody.innerHTML="";

         for(let employee of data){
           let row = document.createElement("tr");
       
           for(let cell in employee){
             let td = document.createElement("td");
             if(cell === "author"){
                td.innerText = employee[cell].firstName+" "+employee[cell].lastName;
             }else if(cell === "resolver"){
                if(employee[cell] != null){
                  
                  td.innerText = employee[cell].firstName+" "+employee[cell].lastName;}else{td.innerText = null}
             }else if(cell === "status"){
               td.innerText=employee[cell].reimbStatus;
             }else if(cell === "type"){
                td.innerText=employee[cell].reimbType;
              }else if(cell === "password"){
                break;
              }else if(cell === "submitted"){
                let date = new Date(employee[cell]);
                 td.innerText= date.toString();
               }else if(cell === "resolved"){
                 if(employee["resolver"]!=null){
                let date = new Date(employee[cell]);
                td.innerText= date.toString();
                 }
               }else{
                td.innerText=employee[cell];
             }
             row.appendChild(td);
           }
           tbody.appendChild(row);
         }

    }

    async function changeReimbStatus(){
        if(managerLoginStatus === 1){
            let reimb = getUpdate();

            let response = await fetch(URL+"reimbursements", {
              method:'PUT',
              body:JSON.stringify(reimb),
            });
          
            if(response.status===200){
              console.log("Reimbursement updated successfully.");
            }else{
              console.log("Something went wrong updating the reimbursement.")
            }
        }else{
            console.log("Need to login");
        }
    }

    function getUpdate(){

        let newAmount = document.getElementById("approvalID").value;
        let newDescription = document.getElementById("description").value; 
        let newUserRole = {userRoleID: 1, userRole: "employee"}
        let newAuthor = {username: user.username, password: 111, firstName: "Elves", lastName: "Prestintoservice", email:"oopsie", userRole:newUserRole}
        let newStatus = {reimbStatusID: parseInt(document.querySelector('input[name="approval"]:checked').value)};
        let newTypeObj = {reimbTypeID: 1, reimbType: "other"}


      
        let reimb =  {
          amount:newAmount,
          submitted:Date.now(),
          resolved:Date.now(),
          description:newDescription,
          author:newAuthor,
          resolver:newAuthor,
          status:newStatus,
          type:newTypeObj
        }
      
        return reimb;

    }