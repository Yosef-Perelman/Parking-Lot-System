# Hi!

I designed and implemented a basic parking lot system According to the requirements of the assingment.
I used some design patterns, and i tried to follow the principles of object-oriented programming.
Here a brief explanation of the system design:

- The main class is the "ParkingLot" class, where The main logic of the system is managed.
This class is a singleton because we are dealing with only one parking lot.
In addition, to make it simple and understandable, it has a separate class that holds operations of entering and exiting the parking lot.

- The "ParkingSpace" is a parent class for parking spaces. It is an abstract class, and it has children classes according to the different types of parking spaces. In addition, I created a factory class for this class that receives the desired parking type and returns a new object of this type.

- The "Vehicle" is a parent class for vehicles. It is also an abstract class, and it is also has children classes and factory class.

- In the vehicle class there's a "paymentMethod" member. This member is an interface that has implementations, and it allows us to enter the correct payment method for each vehicle. This is useful if, for example, we want each vehicle to have a separate payment method in the future. Currently, the payment is fixed according to the exercise instructions.

- (I initialized the number of parking spaces with a low generic number to test the case that the parking spaces ran out. It can be easily changed).

- To deal with a situation where multiple cars are trying to perform actions at the same time, I made the "enter" and "leave" methods synchronized.

#### I added tests with junit.

#### A diagram of the system attached to the repo.

### To run the system there are two options: 
First, download the jar file and enter the terminal from the directory where the jar file in it, and run the command "java -jar ParkingLotSystem.jar".
This will run main class with a basic operations on the system.
Second, and especially if you want to make changes and tests, clone the repo to your IDE.

- (I used maven version 3.3.9, junit version 5, and jdk 22).
