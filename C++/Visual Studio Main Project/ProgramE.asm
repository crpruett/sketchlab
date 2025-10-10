TITLE Fifth Program

; Generates a random number between M and N-1. An improved version of the RandomRange procedure.
; Author: Chris Pruett
; Creation Date: 9/27/2011


INCLUDE Irvine32.inc

.data
; No Variables

.code 
main PROC
mov ebx, -300  ; Lower Bound
mov eax, 100   ; Higher Bound
call BetterRandomRange


exit
main ENDP

;-----------------------------------------------------
BetterRandomRange PROC
;
; Generates an integer between M and N-1.  
; Receives: EAX = Higher Bound and EBX = Lower Bound
; Returns:  nothing
;-----------------------------------------------------
sub eax, ebx  ; Stores the difference of EAX and EBX and places it in EAX
mov edx, eax  ; Moves the value in EAX to EDX
mov ecx, 50   ; Counter
output:
mov eax, edx     ; Reset
call RandomRange ; Generate a random number between 0 and EAX - EBX
add eax, ebx     ; Adds the random number and M (lower bound value)
call WriteInt    ; Print the integer
call CRLF
loop output
ret
BetterRandomRange ENDP
END main