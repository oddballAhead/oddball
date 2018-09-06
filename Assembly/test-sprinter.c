#include <stdarg.h>
#include <stdio.h>
#include <string.h>

typedef unsigned char uc;

extern int sprinter (uc *res, uc *format, ...);


/* check: Check the resulting string and return value: */

void check (int n, int ret1, int ret2, uc *buf1, uc *buf2)
{
  if (ret1==ret2 && strcmp(buf1,buf2)==0) {
    printf("Test %2d OK.\n", n);  return;
  }

  if (strcmp(buf1,buf2) != 0) {
    printf("Test %2d: Teksten er \"%s\" og ikke \"%s\".\n",
	   n, buf1, buf2);
  }
  if (ret1 != ret2) {
    printf("Test %2d: Returverdi er %d og ikke %d.\n",
	   n, ret1, ret2);
  }
}


/* The main program: */

int main (void)
{
  uc t1[2000], t2[2000];
  int r1, r2;

  r1 = sprinter(t1, "");
  r2 = sprintf (t2, "");
  check(1, r1, r2, t1, t2);

  r1 = sprinter(t1, "En lang tekst med kun ett %%-tegn.");
  r2 = sprintf (t2, "En lang tekst med kun ett %%-tegn.");
  check(2, r1, r2, t1, t2);

  r1 = sprinter(t1, "Ett tegn: '%c'.", 'x');
  r2 = sprintf (t2, "Ett tegn: '%c'.", 'x');
  check(3, r1, r2, t1, t2);

  r1 = sprinter(t1, "To tegn: '%c' og '%c'.", 'x', 'y');
  r2 = sprintf (t2, "To tegn: '%c' og '%c'.", 'x', 'y');
  check(4, r1, r2, t1, t2);

  r1 = sprinter(t1, "Tre tegn: '%c', '%c' og '%c'.", 'x', 'y', 'z');
  r2 = sprintf (t2, "Tre tegn: '%c', '%c' og '%c'.", 'x', 'y', 'z');
  check(5, r1, r2, t1, t2);

  r1 = sprinter(t1, "Lovlige %s er '%%%%', '%cc', '%%d', '%c%c', '%%s' og '%%x'.",
		"%-spesifikasjoner", '%', '%', 'u');
  r2 = sprintf (t2, "Lovlige %s er '%%%%', '%cc', '%%d', '%c%c', '%%s' og '%%x'.",
	        "%-spesifikasjoner", '%', '%', 'u');
  check(6, r1, r2, t1, t2);

  r1 = sprinter(t1, "Tre tekster: '%s', '%s' og '%s'.",
       "abc...���", "alfa -> omega", "");
  r2 = sprintf (t2, "Tre tekster: '%s', '%s' og '%s'.",
       "abc...���", "alfa -> omega", "");
  check(7, r1, r2, t1, t2);

  r1 = sprinter(t1, "En �kning p� %d%% er bedre enn en p� %d%%!", 27, 8);
  r2 = sprintf (t2, "En �kning p� %d%% er bedre enn en p� %d%%!", 27, 8);
  check(8, r1, r2, t1, t2);

  r1 = sprinter(t1, "Tallet %d ligger i intervallet %d-%d.",
	      -2230, -10000, -1000);
  r2 = sprintf (t2, "Tallet %d ligger i intervallet %d-%d.",
	      -2230, -10000, -1000);
  check(9, r1, r2, t1, t2);

  r1 = sprinter(t1, "Tallene er %d, %d og %d.", 0, 1000, 1000000000);
  r2 = sprintf (t2, "Tallene er %d, %d og %d.", 0, 1000, 1000000000);
  check(10, r1, r2, t1, t2);

  r1 = sprinter(t1, "Det %s tallet med fortegn er %d.",
		"st�rste positive", 2147483647);
  r2 = sprintf (t2, "Det %s tallet med fortegn er %d.",
	       "st�rste positive", 2147483647);
  check(11, r1, r2, t1, t2);

  r1 = sprinter(t1, "Det nest %s tallet er %d (-%d).", "st�rste negative",
	      -2147483647, 1);
  r2 = sprintf (t2, "Det nest %s tallet er %d (-%d).", "st�rste negative",
	      -2147483647, 1);
  check(12, r1, r2, t1, t2);

  r1 = sprinter(t1, "Det aller %s tallet er %d.", "st�rste negative",
	      -2147483647-1);
  r2 = sprintf (t2, "Det aller %s tallet er %d.", "st�rste negative",
	      -2147483647-1);
  check(13, r1, r2, t1, t2);

  r1 = sprinter(t1, "%d = %u", 1234, 1234);
  r2 = sprintf (t2, "%d = %u", 1234, 1234);
  check(14, r1, r2, t1, t2);

  r1 = sprinter(t1, "%d = %u.", -1, -1);
  r2 = sprintf (t2, "%d = %u.", -1, -1);
  check(15, r1, r2, t1, t2);

  r1 = sprinter(t1, "%d lagres likt med %u.", -2147483647, -2147483647);
  r2 = sprintf (t2, "%d lagres likt med %u.", -2147483647, -2147483647);
  check(16, r1, r2, t1, t2);

  r1 = sprinter(t1, "%d = %x", 0, 0);
  r2 = sprintf (t2, "%d = %x", 0, 0);
  check(17, r1, r2, t1, t2);

  r1 = sprinter(t1, "%d = 0x%x", 1234, 1234);
  r2 = sprintf (t2, "%d = 0x%x", 1234, 1234);
  check(18, r1, r2, t1, t2);

  r1 = sprinter(t1, "Adressen til %s er %#x.", "r1", &r1);
  r2 = sprintf (t2, "Adressen til %s er %#x.", "r1", &r1);
  check(19, r1, r2, t1, t2);

  return 0;
}
