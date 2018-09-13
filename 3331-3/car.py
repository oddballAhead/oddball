class Car:
    """A class representing a car"""

    def __init__(self, year, fuel):
        self.year = year
        self.fuel = fuel
        self.speed = 0

    def __str__(self):
        return("This is a car from {} driving on {} at speed {}".format(self.year, self.fuel, self.speed))


    def start(self):
        if self.fuel == "electric":
            print("sssss")
        else:
            print("Wohmmm")

    def accelerate(self, new_speed):
        self.speed = new_speed

class Golf(Car):
    def __init__(self, color):
        Car.__init__(self, color)

        self.sound = "(Golf) RRROOAR"


mycar = Car(2007, "Bensin")
mycar.start()
mycar.accelerate(100)
print(mycar)

golf = Golf("White")
golf.start()
