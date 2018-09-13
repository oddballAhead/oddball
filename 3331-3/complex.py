import math
from test_complex import *

class Complex:

    def __init__(self, real, imag):
        self.real = real
        self.imag = imag

    def __str__(self):
        if self.imag >= 0:
            return("(" + str(self.real) + "+" + str(self.imag) + "j" + ")")
        else:
            return("(" + str(self.real) + str(self.imag) + "j" + ")")


    # Assignment 3.3

    def conjugate(self):
        self.imag = self.imag * -1

    def modulus(self):
        return(math.sqrt((self.real*self.real) + (self.imag*self.imag)))

    def __add__(self, other):
        return Complex((self.real + other.real), (self.imag + other.imag))

    def __sub__(self, other):
        return Complex((self.real - other.real), (self.imag - other.imag))

    def __mul__(self, other):
        return Complex((self.real * other.real) + (self.imag * other.imag) * -1, (self.real * other.imag) + (self.imag * other.real))

    def __eq__(self, other):
        if self.real == other.real and self.imag == other.imag:
            return True
        else:
            return False

    # Assignment 3.4
    def __radd__(self, other):
        return Complex((self.real + other.real), (self.imag + other.imag))

    def __rsub__(self, other):
        return Complex((-1 * self.real) + other.real, (-1 * self.imag) + other.imag)

    def __rmul__(self, other):
        if
        return Complex((self.real * other.real) + (self.imag * other.imag) * -1, (self.real * other.imag) + (self.imag * other.real))


    # Optional, possibly useful methods

    # Allows you to write `-a`
    def __neg__(self):
        pass

    # Make the `complex` function turn this into Python's version of a complex number
    def __complex__(self):
        pass

complex = Complex(5, 7)
print(complex)
complex.conjugate()
print(complex)
print(complex.modulus())
complex2 = Complex(4, 3)
print(complex2.modulus())
# print(complex.add(complex2))
print(complex + complex2)
print(complex - complex2)
print(complex == complex2)
complex3 = Complex(4, 3)
print(complex2 == complex3)
complex4 = Complex(3, 2)
complex5 = Complex(1, 4)
print(complex4 * complex5)
a = Complex(2, 3)
b = (a + (2 + 2j))
print(b)
print(type(b))
c = Complex(3, 4)
d = 4 * c - 2
print(d)
print(type(d))
complex6 = Complex(4, -3)
print(complex6 * complex5)

# test_add()
