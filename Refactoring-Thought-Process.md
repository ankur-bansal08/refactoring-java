# Refactoring thought process

1. I first went through the codebase and tried to outline the flow and domain actors and transaction behaviour.

2. Then It was time to decide how to design/refactor the codebase and I had 2 options in my mind
   i. Put Domain specific logic with domain classes itself
   ii. Create service, Domain based segregation.
   I have mostly worked with business logic segregation design while working with APIs but here I didn't feel the need of it as I couldn't see the need of service interface and possible multiple implementations with the current scope of problem set.

3. I spent some time on deciding the domain classes and their respective attributes while keeping Solid principles and Oops in mind.

4. There was a lot of logic written in rentalInfo.statement method which is hard to maintain and scale. So I tried to break the flow into smaller part and moved statement method to customer class.

5. After this I further broken down the methods and move them to their respective domain classes.

6. I created an Enum to refer to movie category codes.

7. Then I tried to rewrite rental amount calculation logic which was based on multiple if else conditions and it would meant that if in future we add/remove a movie category for rental, we would need to modify the existing logic always and that's error prone and can break the existing functionality as well. Again I considered 2 options here.
   i. Create a RentalPrice interface and then create category code specific classes with their respective rental and frequentEnterPoints calculations. As at present the category codes were only influencing the rental amount and calculations transactional data logic.
   ii. Create Classes for respective MovieCategory Codes by extending Movie class, which would help having category code specific changes at one single place if we introduce new movie features based on the category codes.

8. Since we are currently hard coding the master data for movies, I have currently handled it by keeping a static block in Movie class along with a MovieFactory class which will help with creating respective Objects based on Movie Category Codes.

9. I made class properties as final and added additional checks for null or empty where ever it was required.

10. Since we are searching on Movie master data and getting statement details on top of it. I felt a need of custom Exception class which can throw an exception, if a requested Movie details are not found in master data.

11. currently the variables which impacts the rental price for a specific movie category code are saved as string constants in respective classes.



# Scope of improvements-

1. We can create a master data and related APIs to apply CRUD operations on Movies master data while saving the data in a database.
2. Customer details can also be saved in system if we are looking to create login based mechanism.
3. Config related to rental manipulation can be saved in a DB.
4. Remove static block from Movie class as the data would be read from DB.
5. Currently the code is written and maintained with plain java based system and from scalability or usability point of view we would either need a Application or APIs which can be integrated with a user friendly UI/apps using which the whole end to end rental transactions can take place.
6. Unit testing would be required for the same as well.
7. For Code coverage and quality we can integrate SonarQube.
8. Logger needs to be integrated for proper logging and monitoring help.
9. CI/CD can be taken care as per the usage expectations.
