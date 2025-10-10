TITLE First Program

; This program creates an array of symbolic constants and assigns the sum to the EAX general-purpose register then prints the result.
; Author: Chris Pruett
; Creation Date: 9/20/2011

INCLUDE Irvine32.inc
.data
ZERO = 0
ONE = 1
TWO = 2
THREE = 3
FOUR = 4
array DWORD ZERO, ONE, TWO, THREE, FOUR

.code
start PROC
mov eax, [array]
add eax, [array+4] ; Add 4 for DWORD (32-bit)
add eax, [array+8]
add eax, [array+12]
add eax, [array+16]

call DumpRegs ; 'A' is the hex that is summed into the eax register in the end. A=10
exit
start ENDP

END start