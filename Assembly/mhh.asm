TITLE Greatest Common Factor


INCLUDE Irvine32.inc


.data
N DWORD ?
K DWORD ?

.code
main PROC
push 3
push 3
Call pasc
Call WriteDec
Call CRLF
push 0
push 4
call pasc
call WriteDec
Call CRLF
push 2
push 5
call pasc
call WriteDec
call CRLF
main endp

pasc PROC 
push ebp
mov ebp, esp
mov ebx, [ebp+12]
mov edx, [ebp+8]
cmp ebx, 0 ; K < 0?
jl kick0
cmp ebx, edx ; K > N?
jg kick0
cmp ebx, 0 ; K == 0?
je kick1 
cmp ebx, edx ; K == N?
je kick1

kick0:
mov eax, 0
jmp quit
kick1:
mov eax, 1
jmp quit

recur: 
dec ebx
dec edx
call pasc
inc ebx
call pasc

quit:

pop ebp
ret 8
pasc endp


END main



COMMENT ~
TITLE Demonstrate reference parameters

; This program fills an array with 16-bit randomly generated integers.

INCLUDE Irvine32.inc
LENG EQU [ebp+12]
OFFS EQU [ebp+8]

.data
myArray WORD 100h, 200h, 300h

.code

main PROC
push LENGTHOF myArray
push OFFSET myArray
call ProcTwo 
add esp, 8
call WriteDec
call CRLF
exit
main ENDP

ProcTwo Proc
push ebp
mov ebp, esp
push esi
mov eax, 0
mov esi, OFFS
mov ecx, LENG
cmp ecx, 0
je L2
L1:
add ax, [esi]	

add esi, TYPE WORD
loop L1

L2: 
pop esi
pop ebp
ret
ProcTwo ENDP


END main

~