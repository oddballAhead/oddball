#include <stdio.h>
#include <stdlib.h>
#include <string.h>

extern int sprinter (char *til, char *fra, ...);

char s[500];
int counter;
char c = 'c';
char f = 'f';
char tall[50] = "skade";
char *tallstreng = &tall[50];
int hex = 0x34ab549f;
//char f = 'f';

int main(void) {
  counter = sprinter(s, "Abcd%%e1");
  printf("\"%s\" har %d tegn.\n", s, strlen(s));
  printf("Counter: %d\n", counter);

  counter = 0;

  counter = sprinter(s, "ae13%c%clala", f, 'g');
  printf("\"%s\" har %d tegn.\n", s, strlen(s));
  printf("Counter: %d\n", counter);

  counter = sprinter(s, "Abcd%%e1");
  printf("\"%s\" har %d tegn.\n", s, strlen(s));
  printf("Counter: %d\n\n", counter);

  //printf("%s\n", tall);

  sprinter(s, "a %s b %c %s %d", "123", '{', "fj", -54);
  printf("\"%s\" har %d tegn.\n", s, strlen(s));


  //printf("hex = %s\n", "32ab542f");
  sprinter(s, "jzc3 %x lala", hex);
  printf("%s\n", s);

  sprinter(s, "q %x wert", hex);
  printf("%s\n", s);

  int teller = sprinter(s, "jzc3 %#x <<", hex);
  printf("%s\n", s);
  printf("%d\n", teller);

  printf("%x\n\n", hex);

  sprinter(s, "a %x b", hex);
  printf("%s\n\n", s);

  hex = 0xffffffff;
  int hex2 = 0xabab1212;
  int hex3 = 0x3232cccc;
  sprinter(s, "{ %x } %x } %x @ %#x ! #%x", hex, hex2, hex3, 0x11abcabc, 0xff999999);
  printf("%s\n\n", s);


  sprinter(s, "a %u bc", 12453);
  printf("%s\n\n", s);

  sprinter(s, "a %d fj", 54321);
  printf("%s\n\n", s);

  sprinter(s, "c %d ba", -4987);
  printf("%s\n\n", s);

  sprinter(s, "a %d b", -147);
  printf("%s\n", s);

  sprinter(s, "a%d b%d c%d d%d e%d f%d g%d h", -1, -2, -3, -7800, -43, -147, 5000);
  printf("%s\n\n", s);

  sprinter(s, "a %d\n", -147);
  printf("%s\n", s);

  hex = 0x00000abc;
  sprinter(s, "%x %a %22d\n", hex, 43, -48);
  printf("%s\n",s);


  exit(0);


}
