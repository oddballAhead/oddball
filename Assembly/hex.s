      .globl    hex

      # void hex(hex h) {}

hex:  pushl   %ebp
      movl    %esp,%ebp


      movl    8(%ebp),%ebx
      movl    $0x10,%eax
      movl    $0,%edx

      divl    %ebx

      
