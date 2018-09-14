from complex import Complex

def test_add():
    a = Complex(3, 4)
    b = Complex(4, -1)
    assert (a + b) == (7 + 3j)

def test_subtract():
    a = Complex(3, 4)
    b = Complex(4, -1)
    assert (a - b) == (-1 + 5j)

def test_conjugate():
    a = Complex(3, 4)
    b = Complex(-3, 8)
    c = Complex(5, -5)
    assert (a.conjugate()) == (3 - 4j)
    assert (b.conjugate()) == (-3 - 8j)
    assert (c.conjugate()) == (5 + 5j)

def test_modulus():
    a = Complex(3, 4)
    assert (a.modulus()) == 5

def test_eq():
    a = Complex(4, -1)
    b = Complex(4, -1)
    c = Complex(7, 3)
    assert a == b
    assert b != c

def test_mul():
    a = Complex(0, 0)
    b = Complex(0, 0)
    c = Complex(2, 3)
    d = Complex(4, 1)
    assert (a * b) == 0j
    assert (c * d) == (5 + 14j)

a = Complex(4, 5)
b = 7
c = (-3+8j)
    
def test_radd():
    assert (a + b) == (11 + 5j)
    assert (c + a) == (1 + 13j)

def test_rsub():
    assert (c - a) == (-7 + 3j)

def test_rmul():
    assert (a * c) == (-52 + 17j)

test_add()
test_subtract()
test_conjugate()
test_modulus()
test_eq()
test_mul()
test_radd()
test_rsub()
test_rmul()
