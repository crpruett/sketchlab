TITLE Sixth Program

COMMENT ~ This program prompts the user to specify the number of integers to be processed out of the array
 , stores them in an array, calculates the sum of the array, and displays the sum. ~
 ; Author: Chris Pruett
 ; Creation Date: 9/26/2011

INCLUDE Irvine32.inc

ARRAY_SIZE = 20

.data
str1  BYTE  "Enter a signed integer: ",0
str2  BYTE  "The sum of the integers is: ",0
str3  BYTE  "How many integers will be added?: ",0
array DWORD  ARRAY_SIZE DUP(?)

.code 
main PROC
	call	Clrscr
	mov	esi,OFFSET array
	mov	ecx,ARRAY_SIZE
	call PromptForArraySize
	call	PromptForIntegers
	call	ArraySum
	call	DisplaySum
	exit
main ENDP
;-----------------------------------------------------
PromptForArraySize PROC USES edx
;
; Prompts the user to specify a number of integers to  
; be processed.
; Receives: EDX
; Returns:  nothing
;-----------------------------------------------------
mov ax, cyan + (lightGray * 16)
call SetTextColor

mov edx, OFFSET str3

call WriteString
call GetTextColor
call ReadInt
mov ecx, eax
call CRLF
ret
PromptForArraySize ENDP
;-----------------------------------------------------
PromptForIntegers PROC USES ecx edx esi
;
; Prompts the user for an arbitrary number of integers 
; and inserts the integers into an array.
; Receives: ESI points to the array, ECX = array size
; Returns:  nothing
;-----------------------------------------------------
	mov	edx,OFFSET str1	; "Enter a signed integer"
	
L1:	call	WriteString		; display string
	call	ReadInt			; read integer into EAX
	call	Crlf				; go to next output line
	mov	[esi],eax			; store in array
	add	esi,TYPE DWORD		; next integer
	loop	L1

	ret
PromptForIntegers ENDP

;-----------------------------------------------------
ArraySum PROC USES esi ecx
;
; Calculates the sum of an array of 32-bit integers.
; Receives: ESI points to the array, ECX = number 
;   of array elements
; Returns:  EAX = sum of the array elements
;-----------------------------------------------------
	mov	eax,0		; set the sum to zero
L1:	add	eax,[esi]		; add each integer to sum
	add	esi,TYPE DWORD	; point to next integer
	loop	L1			; repeat for array size
	ret				; sum is in EAX
ArraySum ENDP

;-----------------------------------------------------
DisplaySum PROC USES edx
;
; Displays the sum on the screen
; Receives: EAX = the sum
; Returns:  nothing
;-----------------------------------------------------
	mov	edx,OFFSET str2	; "The sum of the..."
	call	WriteString
	call	WriteInt			; display EAX
	call	Crlf
	ret
DisplaySum ENDP
END main