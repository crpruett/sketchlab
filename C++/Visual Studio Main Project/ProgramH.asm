TITLE BUBBLESORT ; If not satisfactory, edit and turn in.

INCLUDE Irvine32.inc

.data
A DWORD 400, 200, 100, 700, 500, 800, 600, 300
B DWORD 5555, 3333, 8888, 0000, 7777, 1111, 6666, 9999, 2222, 4444
N DWORD ?
PASS DWORD ?
FIRST BYTE "First Array: ",0
SECOND BYTE "Second Array: ",0
.code

main PROC
mov edx, OFFSET FIRST
mov ebx, OFFSET A
mov N, 8
mov PASS, 32
call BubbleSort
call Display
mov edx, OFFSET SECOND
mov ebx, OFFSET B
mov N, 9 
mov PASS, 36 
mov ecx, 1
call BubbleSort
call Display

exit
main ENDP

;-----------------------------------------------------
BubbleSort PROC
;
; Runs the BubbleSort Algorithm 
; Receives: EBX and N
; Returns: nothing
;-----------------------------------------------------
pushad
mov esi, 0 ; First Counter
mov eax, 0 ; Second Counter
.WHILE esi < 6 ; Make more flexible
.WHILE eax < N 
mov ebp, [ebx]
mov edx, [ebx+4]
.IF  ebp > edx
xchg ebp, [ebx+4]
mov [ebx], edx
.ENDIF
add ebx, 4 ; Next element
inc eax ; Increment the first counter
.ENDW
mov eax, 0 ; Reset second counter
sub ebx, PASS ; Pass complete. Reset to the beginning (or offset) of the array
inc esi ; Increment the first counter
.ENDW
popad
ret
BubbleSort ENDP
;-----------------------------------------------------
Display PROC
;
; Prints the array
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
pushad
call CRLF
call WriteString
call CRLF ; Could use "0Dh, 0Ah" or "13, 12". (13 and 12 are the ASCII codes for carriage return and line feed)
add ecx, N
L1:
mov eax, [ebx]
call WriteDec
call CRLF
add ebx, 4
loop L1
popad
ret
Display ENDP

END main