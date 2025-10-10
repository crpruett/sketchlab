TITLE GCD

INCLUDE Irvine32.inc

.data

.code
main PROC
push 0
push 0
CALL RecGCD
push 1
push 5
CALL RecGCD
push 8
push 3
CALL RecGCD
push 7
push 0
CALL RecGCD
push 0
push 9
CALL RecGCD
exit
main ENDP

;-----------------------------------------------------
RecGCD PROC
;
; Computes the Greatest Common devisor between value A
; and B. (Using Euclid's Algorithm)
; Receives: The values of A and B (from stack)
; Returns: The Greatest common divisor
;-----------------------------------------------------
start:
push ebp
mov ebp, esp ; Could just use Enter 0, 0
cmp DWORD PTR [ebp+12], 0 ; A == 0?
je foundgcd ; Jump to foundgcd

recursion:
mov eax, [ebp+8] ; Store B in eax
mov edx, 0 ; Clear edx (for division)
div DWORD PTR [ebp+12] ; A / B
push edx       ; Store edx by pushing onto stack
mov eax, [ebp+12]  ; Move A to eax
push eax         ; Store eax by pushing onto stack
call RecGCD   ; Recursive call
mov esp, ebp
pop ebp     ; Could just use LEAVE directive
ret 


foundgcd:
mov eax, [ebp+8] ; Store GCD in eax
Call WriteDec
Call CRLF

leave
ret
RecGCD ENDP
COMMENT ~
;-----------------------------------------------------
GCD PROC
;
; Computes the Greatest Common devisor between value A
; and B.
; Receives: The values of A and B
; Returns: The Greatest common divisor
;-----------------------------------------------------
push ebp
mov ebp, esp
;sub esp, 8
mov ebx, 0
;mov DWORD PTR [ebp-4], 20
;mov DWORD PTR [ebp-8], 40
beginWhile:
cmp ebx, [ebp+12]  ; If A = 0
je endWhile ; Short Circuit The Condition
cmp ebx, [ebp+8]
je endWhile ; If B = 0
mov eax, [ebp+12]  ; Divdend
cdq         ; EDX:EAX 
mov ebx, [ebp+8] ; Divisor
mov eax, ebx; A = B
mov ebx, edx; B = T
cmp ebx, 0  ; If B = 0 end the loop
je endWhile
mov eax, edx  ; A = T
cdq         ; EDX:EAX
div ebx     ; Divide and store quotient in eax and remainder in edx. A = A % B
jmp beginWhile               

endWhile:
call WriteDec ; Prints GCD
call CRLF
mov esp, ebp
pop ebp
ret 8
GCD ENDP
~
END main