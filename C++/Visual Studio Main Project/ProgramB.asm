TITLE Second Program

COMMENT ~ This program calculates the first seven values of the Fibonacci number sequence and places the summed value in the EAX register. 
          The results are then diplayed in the registers. The Fib numbers are then stored and printed from memory.~
; Author: Chris Pruett
; Creation Date: 9/20/2011

INCLUDE Irvine32.inc
.data
target DWORD 7 DUP(?)

.code
begin PROC

mov ebp, 0 ; First Tracker
mov edx, 1 ; Second Tracker
mov esi, 0 ; Target Index

mov ebx, edx ; Save second tracker value
mov ecx, 7 ; Loop Counter
L1:
     mov eax, edx ; Move second tracker to accumulator
	 mov ebp, eax ; Move eax value to first tracker
	 mov edx, ebx ; Restore saved second tracker value
	 add ebx, ebp ; 
	 mov target[esi], eax ; Store number in memory
	 inc esi              ; Add 1 to the index location
	 call DumpRegs
	 
loop L1
mov esi, OFFSET target ; Move the offset of the first location in the target array to esi
mov ebx, 1             ; Specify amount of information to be displayed
mov ecx, 7             ; counter
call DumpMem
exit
begin ENDP

END begin