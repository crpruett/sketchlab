TITLE Greatest Common Factor


INCLUDE Irvine32.inc

.data
A DWORD 20
B DWORD 40
T DWORD ?
I     dd  ?
P     dd  ? 
G     dd  ?
Prime dd  ?
PStr  db  'Prime',0
NPStr db  'not Prime',0


.code
main PROC

;call GCD
;call BF

main ENDP

;-----------------------------------------------------
GCD PROC
;
; Computes the Greatest Common devisor between value A
; and B.
; Receives: The values of A and B
; Returns: The Greatest common divisor
;-----------------------------------------------------
pushad
mov ebx, 0
beginWhile:
cmp ebx, A
je endWhile ; Short Circuit The Condition
cmp ebx, B
je endWhile
          ; A = A % B
		; T = A
		; A = B
		; B = T


jmp beginWhile
endWhile:
popad
ret
GCD ENDP

;-----------------------------------------------------
BF PROC
;
; Calculates the prime numbers from 3 through 10,000.
; Receives: Unknown ATM (I and G values)
; Returns: Nothing
;-----------------------------------------------------
pushad
mov I, 3
mov eax, I ;I moved to eax temporarily. Subject to change
.WHILE eax <= 10000
mov Prime, 1
mov G, 2
 .WHILE (G <= 1) && (Prime == 1)
        ;  P = GCD( I, G);
 .IF (P != 1) && (P != eax)
 mov Prime, 0
 inc G
 .ENDIF

.IF Prime == 1
mov edx, OFFSET PStr
call WriteString
.ELSE
mov edx, OFFSET NPStr
call WriteString
.ENDIF
.ENDW
inc I
.ENDW
popad
BF ENDP

END main