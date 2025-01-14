Hi!

The main class is the "ParkingLot" class. This class is a singleton because we are dealing with only one parking lot.
This class has a separate class that holds the operations of entering and exiting the parking lot.

The "ParkingSpace" is a parent class for parking spaces. It is an abstract class, and it has children classes according to the different types of parking spaces. In addition, there is a factory class for this class that receives the desired parking type and returns a new object of this type.

The "Vehicle" is a parent class for vehicles. It is also an abstract class, and it is also has children classes and factory class.

In the vehicle class there's a "paymentMethod" member. This member is an interface that has implementations, and it allows us to enter the correct payment method for each vehicle. This is useful if, for example, we want each vehicle to have a separate payment method in the future. Currently, the payment is fixed according to the exercise instructions.

Inside the main class there are lists that hold information about the available and occupied parking spaces. The lists are divided for the different types. When a vehicle arrives and wants to enter, we will check whether there's a space for it in the list of available spaces of its type.

I initialized the number of parking spaces with a generic number that can be easily changed.

I added tests with junit for all the classes that have more activity than getters and setters.
