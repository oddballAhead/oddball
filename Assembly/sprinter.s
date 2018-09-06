              .globl    sprinter

#Name:        sprinter
#Synopsis:    Forenklet implementasjon av c-fuksjonen sprintf()
#C-signatur:  int sprinter(unsigned char *res, unsigned char *format, ...);
#Registre:    EAX - brukes til generelle flytte-operasjoner
#             ECX - Holder pekeren til slutt-strengen.
#             EDX - Holder pekeren til input-strengen.
#             EBX - brukes til å peke på det neste argumentet i parameterlisten
#
#


#-----------------------------------------------------------------------

sprinter:
              pushl   %ebp                  #Standard
              movl    %esp,%ebp             #funksjons-start

              movl    $1,counter
              movl    8(%ebp),%ecx          #hent pekern til output-strengen til
                                            #ecx
              movl    12(%ebp),%edx         #hent pekern til input-strengen
              movl    %ebp,%ebx             #Sett ebx til å peke på
              addl    $16,%ebx              #adressen til det første argumentet
                                            #som kommer etter de to første pekerne



                                            #do {
mys_1:        movb    (%edx),%al            # %al = *format
              incl    %edx                  #   ++.

              cmpb    $0x25,%al             # if(%al == '%')
              je      if_format             # jump to if_format-seksjonen
                                            #else {

              movb    %al,(%ecx)            # resultat = %al
              incl    %ecx                  #  ++

mys_2:
              incl    counter               # counter++
              cmpb    $0,%al                #
              jne     mys_1                 # } while( %al != 0 )

              jmp     mys_10                #hopp til slutten når løkken
                                            #er ferdig

if_format:    movb    (%edx),%al            #Her er en slags switch-test som sjekker
              incl    %edx                  #hva slags char som kom etter %-tegnet

              cmpb    $0x25,%al             #Hvis det er en ny '%'
              je      if_percent

              cmpb    $0x63,%al             #Hvis det er en 'c'
              je      if_char

              cmpb    $0x73,%al             #Hvis det er en 's'
              je      if_str

              cmpb    $0x78,%al             #hvis det er en 'x'
              je      if_hex

              cmpb    $0x23,%al             #hvis det er en '#'
              je      if_hash

              cmpb    $117,%al              #Hvis det er en 'u'
              je      if_unsigned

              cmpb    $100,%al              #Hvis det er en 'd'
              je      if_signed


              jmp     mys_10                #Hvis ingen av if-testene
                                            #slår til, hopp til slutten.
                                            #dette skal ikke skje


if_percent:   movb    %al,(%ecx)            #legg %al, som allerede er en '%'
              incl    %ecx                  # i exc-strengen, og iterer videre
              jmp      mys_2                #hopper tilbake til hovedløkken


if_char:      movb    (%ebx),%al            #legg charen som ebx peker på i %al
              movb    %al,(%ecx)            #legg dette inn i ecx-strengen
              incl    %ecx                  #index++
              addl    $4,%ebx               #oppdater argument-pekern til å peke
              #leal    4(,%ebx,),%ebx       #på neste argument
              jmp     mys_2                 #hopp tilbake til hovedløkken


if_str:       pushl   %edx                  #lagre edx- på stacken
              movl    (%ebx),%edx           #legg pekern til stringen i edx

str_loop:     movb    (%edx),%al            #legg første char-verdi i %al
              incl    %edx                  #++
              cmpb    $0,%al
              je      str_exit

              movb    %al,(%ecx)            #legg til charen i resultat-string
              incl    %ecx                  # ++i
              incl    counter
              jmp     str_loop              #hopp tilbake i loopen

str_exit:     popl    %edx                  #returner den gamle edx-pekerverdien
              addl    $4,%ebx               #tilbake til edx
              addb    $1,%al                #må ha noe annet enn $0 i eax
              decl    counter               #counter-1 fordi den økes med en når
                                            #den kommer til hovedløkken
              jmp     mys_2                 #hopp tilbake til hovedløkken




if_hex:       pushl   %edx                  #Her må vi frigjøre edx og ebx
              movl    (%ebx),%eax           #La %eax inneholde hex-verdien som skal settes inn
              pushl   %ebx                  #
              movl    $0x10,%ebx            #flytt $16 inn i %ebx
              movl    $1,hexcounter

hex_loop:     movl    $0,%edx               #tøm %edx for div-operasjon
              divl    %ebx                  #del hex-tallet på %ebx
              pushl   %edx                  #lagre resten
              incl    hexcounter            #++hexcounter
              cmpl    $0,%eax               #hvis vis har gått gjennom alle sifrene, vil
                                            #%eax == $0
              je      hex2                  #Isåfall hopper vi videre
              jmp     hex_loop              #Ellers fortsetter vi loopen

hex2:         popl    %eax                  #hent det første sifret lagret på stacken
              decl    hexcounter            #hexcounter--
              cmp     $10,%eax              #if(sifferet < 10) {
              jge     letter                #
              jmp     number

number:       addl    $48,%eax              # legg til $48, for å få char-representasjonen
              movb    %al,(%ecx)            # legg til i stringen
              incl    %ecx                  # string-index++
              incl    counter               # counter++
              jmp     next                  #}

                                            #else {
letter:       addl    $87,%eax              # legg til $87, for charen
              movb    %al,(%ecx)            # legg til i string
              incl    %ecx                  # c
              incl    counter               #}
              jmp     next

next:         cmpl    $1,hexcounter         #Avslutt hvis hexcounter har nådd $1
              jne     hex2                  #
              movl    $1,%eax               #%eax kan ikke være $0
              popl    %ebx                  #hent den gamle argument-pekern
              popl    %edx                  #het pekern til input-strengen
              addl    $4,%ebx               #gå til neste argument på parameterlisten
              decl    counter               #counter-- fordi den økes i mys_2
              jmp     mys_2                 #tilbake til hovedløkken



if_hash:      movb    $48,(%ecx)            #legg til '0'
              incl    %ecx                  #string-index++
              movb    $120,(%ecx)           #legg til 'x'
              incl    %ecx                  #--
              addl    $2,counter            #counter + 2
              incl    %edx                  #index++ på input-string
              jmp     if_hex                #hopp deretter til vanlig hex


if_unsigned:  pushl   %edx                  #frigjør registre
              movl    (%ebx),%eax           #sett inten i %eax
              movl    $1,intcounter         #sørg for at intcounter er 1
              pushl   %ebx                  #--
              movl    $10,%ebx              #her skal vi dele på $10

u_loop:       movl    $0,%edx               #tøm %edx
              divl    %ebx                  #del på $10
              pushl   %edx                  #lagre resten
              incl    intcounter            #intcounter++
              cmpl    $0,%eax               #når %eax == 0, avslutt loopen
              jne     u_loop

u_loop2:      popl    %eax                  #begynn å hent sifrene fra stacken
              decl    intcounter            #intcounter--
              addl    $48,%eax              #legg til $48, for å få char-representasjonen
              movb    %al,(%ecx)            #legg til i stringen
              incl    %ecx                  #
              incl    counter               #
              cmpl    $1,intcounter         #når intcounter er $1, avslutt loopen
              jne     u_loop2               #

              movl    $1,%eax               #%eax kan ikke være $0
              popl    %ebx                  #hent argumentpeker
              popl    %edx                  #hent peker til input-string
              addl    $4,%ebx               #flytt peker til neste argument
              decl    counter               #counter--, siden denne økes 1 gang
              jmp     mys_2                 #når vi kommer tilbake til hovedløkken



if_signed:    pushl   %edx                  #Samme som if_unsigned
              movl    (%ebx),%eax           #
              and     $0x00000000,scounter  #sørg for at scounter er tom
              movl    $1,scounter           #
              pushl   %ebx                  #
              movl    %eax,%ebx             #kopier int-verdien til %ebx, så vi kan
                                            #gjøre maske-operasjoner på den

              and     $0x80000000,%ebx      #null ut %ebx unntatt sign-biten
              cmp     $0,%ebx               #hvis sign-biten var 0, hopp til sloop
              je      sloop                 #

              movb    $45,(%ecx)            #hvis ikke, legg til '-' i stringen
              incl    %ecx                  #
              incl    counter               #counter++
              xor     $0xffffffff,%eax      #flip int-verdien, og
              addl    $1,%eax               #legg til $1, slik at vi kan behandle
              jmp     sloop                 #tallet som en vanlig unsigned

sloop:        movl    $0,%edx               #samme opplegg som i if_unsigned
              movl    $10,%ebx              #
              divl    %ebx                  #
              pushl   %edx                  #
              incl    scounter              #
              cmpl    $0,%eax               #
              jne     sloop                 #

sloop2:       popl    %eax                  #samme opplegg som tidligere
              decl    scounter              #
              addl    $48,%eax              #
              movl    %eax,(%ecx)           #
              incl    %ecx                  #
              incl    counter               #
              cmpl    $1,scounter           #
              jne     sloop2                #

              movl    $1,%eax               #
              popl    %ebx                  #
              popl    %edx                  #
              addl    $4,%ebx               #
              decl    counter               #
              jmp     mys_2                 #



mys_10:       movl    counter,%eax          #  resultat.
              subl    $2,%eax               # -2 fordi vi startet på 1, og må i
              popl    %ebp                  # tillegg fjerne null-byten fra tellingen
              ret                           # return


              .data
counter:      .long   1
hexcounter:   .long   1
intcounter:   .long   1
scounter:     .long   1
