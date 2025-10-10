TITLE Fourth Program

; This program reverses an array of numbers (BYTE, WORD, or DWORD) and outputs the reversed array from memory
; Author: Chris Pruett
; Creation Date: 9/26/2011


INCLUDE Irvine32.inc

.data
myArray BYTE 1,2,3,4,5,6,7
pointer DWORD OFFSET myArray
arrayType = TYPE myArray

.code
start PROC
mov esi, SIZEOF myArray - arrayType   ; End of array
mov ebx, pointer                      ; Point to the first number in the array
mov ecx, LENGTHOF myArray / 2         ; Set the counter for switching

L1:
mov eax, DWORD PTR myArray[esi]       ; Move (casted) the last number in the array to al
xchg [ebx], al                        ; Exchange the number in al with the first number in the array
mov DWORD PTR myArray[esi], eax       ; Move number in al to other (casted) number in array
sub esi, arrayType ; sub 1 from esi ; Subtract the arrayType from esi
add ebx, arrayType ; add 1 to ebx   ; Add arrayType from ebx
loop L1                             ; Loop again
call CRLF
	mov esi, OFFSET myArray   ; Offset of variable   
	mov ebx, TYPE myArray    ; Array format          
	mov ecx, LENGTHOF myArray   ; Counter                    
	call DumpMem             ; Display array from memory                                   
exit
start ENDP

END start