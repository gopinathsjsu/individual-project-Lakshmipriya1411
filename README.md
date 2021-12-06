# individual-project-Lakshmipriya1411

202 Individual project: 

Inventory Application:
This is an inventory management application which takes inventory input in csv format and formats the data to check whether each item stock availability is exceeded and then verifies if the total category-based items count exceeds a max cap on the capacity per category. After successful validation, it prints the output of check failed items to txt file in case of failure and to csv file in case of success with total Amount details and also adds the missing credit card numbers to the database (HashMap) used in the application.
Database: Hashmap
Application layers:Client, middleware,server
Project IDE: Eclipse
Project Language: Java
How to run/Invoking the code:
Steps to run:
1.	Git clone the repository by going to Window-> Show view-> Other -> Git -> Git Repositories -> Clone a Git Repository -> choose the working directory in local.
2.	Configure the Dataset and CrediCards csv file path 
a.	Go to inventory.management.server.DAL package 
b.	Click on InventoryItemDAOImpl.java file
c.	Update the paths of the files/names of the files (To use project root directory just change the name of the file)

![image](https://user-images.githubusercontent.com/88259438/144788413-6216f60e-5fa1-4a89-82bd-fd97d4c07c90.png)
 
3.	Configure input csv file path/name
a.	Go to inventory.management.client package 
b.	Select InventoryClient.java file and update the name or path (To use project root directory just change the name of the file)

![image](https://user-images.githubusercontent.com/88259438/144788461-cf7e9089-066e-4dd1-9357-8bb375d322c8.png)

4.	To run the project -> Right Click on inventory.management.client project package and choose Run As -> Java Application. The same is shown in the screenshot below.

![image](https://user-images.githubusercontent.com/88259438/144788477-363d4e90-4de1-405a-9dd6-878d68f33097.png)

5.	Path to output files is in root directory

![image](https://user-images.githubusercontent.com/88259438/144788497-6ac1b571-3cc9-415e-9611-03fc75dcd27b.png)

6.	Path for output files can be configure in ProcessSuccessOutput.java file

![image](https://user-images.githubusercontent.com/88259438/144788517-9203a80f-7530-4fa6-93e7-81909c042a11.png)

7.	Path for failed output can be configure in ProcessFailedOutput.java file

![image](https://user-images.githubusercontent.com/88259438/144788529-eddcb46e-8c96-4768-a981-f706bdcbb408.png)

Design patterns Used: 
Factory Pattern: 

Patten Description: A creational design pattern that allows subclasses to decide which object to be invoked. The invoked object is of the type parent interface.

Pattern usage: This pattern is used in the project to print success or failed output with a common interface defined for output method signature.

Adapter Pattern: 

Pattern Description: A structural design pattern used to match between two incompatible objects.

Pattern Usage: This pattern is used here to convert List<List<InputInventory>> to List<String[]> for printing the output to the txt file.
 
Iterator Pattern:
 
Pattern Description: A behavioral design pattern that allows a way to access through aggregate objects without exposing underlying structure.
 
Pattern Usage: This pattern is used here to iterate through List<T> to be used as a common iterator pattern for different types Lists.
 
Chain of Responsibility:
 
Pattern Description: A behavioral design pattern which allows the requests through a chain of handlers.
 
Pattern Usage: This pattern is used here to validate the input request through a two handler chain where one verifies if it’s a valid repository by verifying each item stock and next handler verifies if the overall category quantity exceeds the max cap on the category.
 
Repository Pattern:
 
Pattern Description: A special kind of Façade(Structural) pattern where it hides the data persistence layer logic with the business logic.
 
Pattern Usage: This pattern is used here to abstract the Data reading /database storage from middleware which can only read /modify the required data items using repository in between.

Class Diagram:
 
![image](https://user-images.githubusercontent.com/88259438/144788549-8b268041-4dbd-4a88-9df6-fb606733dbc0.png)
  
Intermediate terminal screenshots:
 
Intermediate terminal: Input1 – Sheet1.csv
 
![image](https://user-images.githubusercontent.com/88259438/144788570-217983cf-c84b-4ea7-8bc8-9723ca6acf67.png)
 
Intermediate terminal: Input2 – Sheet1.csv
 
![image](https://user-images.githubusercontent.com/88259438/144788587-afd097b4-ee4f-460c-8e6f-312731e96de4.png)
 
Intermediate terminal: Input3 – Sheet1.csv
 
![image](https://user-images.githubusercontent.com/88259438/144788598-6ccf2692-e6ea-459d-b387-70d140aeafd3.png)
 
Result:
 
1.Testcase1(Input1 – sheet1.csv)
 
Result: Successfully processed order
 
![image](https://user-images.githubusercontent.com/88259438/144788619-66699717-fc85-4f96-91eb-e9838d979776.png)
 
Test case2(Input2 – sheet1.csv)
 
Result: Exceeded quantity stock
 
![image](https://user-images.githubusercontent.com/88259438/144788626-d72f528b-ef04-490d-9fcc-ce1fce570cac.png)
 
Test case3(Input3 – sheet1.csv)  
 
Result: Successfully processed order
 
![image](https://user-images.githubusercontent.com/88259438/144788665-83c4ce52-1233-4683-9b72-8e27e2e466bd.png)
 
 

