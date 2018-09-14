- metoden findNearestSmallerThan(int value) er jeg litt usikker paa hva skal gjoere.
  Jeg tolker det som at den skal finne den stoerste inten i treet som er mindre enn
  value.
  altsaa hvis det f.eks er et tree med verdiene 1,2,3,4,5,6,7,8,9,
  Saa vil findNearestSmallerThan(6) returnere 5.
  Hvis det ikke finnes noen verdi i treet som er mindre enn value, saa vil metoden
  returnere den minste verdien i treet. Hvis treet er tomt vil metoden returnere 0
  
- Jeg gaar ut fra at metoden findInRange(int low, int high) er inklusiv.

- De 3 private metodene find(), findParent() og findGrandparent() skal egentlig vaere
  private, men jeg har gjort dem til package istedet slik at jeg kan bruke de i test-
  programmet.

- remove() er en boolsk metode og jeg tolker det som at den skal returnere falks hvis
  metoden feiler på å fjerne den spesifiserte noden, og true ellers.
  
