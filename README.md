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
Run from Command Prompt:
1.	Create a folder in any directory(preferrably C) and download the jar file into that folder

![image](https://user-images.githubusercontent.com/88259438/144795602-9c3217ee-8f17-488f-8189-951b5200cdc9.png)

2.	Download the InventoryApp.jar file from Git Repository.
3.	Place all the input and dataset and creditcard csv files in the same folder (Ex: C:/InventoryApp/)
4.	Run the jar file from command prompt in windows using this command

![image](https://user-images.githubusercontent.com/88259438/144795685-6101441b-496e-4c23-b087-8397628b4bae.png)

5.	Output files are found in the same folder as shown above. Output sheet1,Output sheet2, Output sheet3.
6. To verify new test cases Use the filename with similar format starting with "Inputx - " and the output file will be generated with the number x provided in the input.

Run from Eclipse:

1.	Git clone the repository by going to Window-> Show view-> Other -> Git -> Git Repositories -> Clone a Git Repository -> choose the working directory in local.
2.	Place all the dataset, creditcard and input csv files in the project root folder.

![image](https://user-images.githubusercontent.com/88259438/144795952-7f11ff3b-3744-412f-9a88-91785931a5ad.png)

3.	To run the project -> Right Click on inventory.management.client project package and choose Run As -> Java Application. The same is shown in the screenshot below.

![image](https://user-images.githubusercontent.com/88259438/144788477-363d4e90-4de1-405a-9dd6-878d68f33097.png)

4.	Path to output files is in root directory

![image](https://user-images.githubusercontent.com/88259438/144795995-30dd7553-6952-42fa-8431-ef4ff88a954d.png)

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

Result from command prompt: 
 
![image](https://user-images.githubusercontent.com/88259438/144796092-5f6f92a4-0dbe-48a3-ac53-1071431b2aa5.png)

Result if ran from Eclipse:
 
![image](https://user-images.githubusercontent.com/88259438/144796142-716ce6d4-8bfc-4842-8a2d-c5af9f4338bd.png)
 
1.Testcase1(Input1 – sheet1.csv)
 
Result running from command prompt: Successfully processed order
 
![image](https://user-images.githubusercontent.com/88259438/144796176-9b933827-cf71-46d7-85b4-24b8ca6fbc5f.png)
 
Test case2(Input2 – sheet1.csv)
 
Result running from command prompt: Exceeded quantity stock
 
![image](https://user-images.githubusercontent.com/88259438/144796237-eb5ebd7e-20a2-42ec-b13e-cf75cf2976a4.png)
 
Test case3(Input3 – sheet1.csv)  
 
Result running from command prompt: Successfully processed order
 
![image](https://user-images.githubusercontent.com/88259438/144796255-6c2997f4-d12d-4eeb-9a69-c4148f64327d.png)
 
 

