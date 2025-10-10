TITLE Third Program

; This Program reverse copies a string and outputs the result. It also stores and prints the reversed string from memory.
;Author: Chris Pruett
;Creation Date: 9/20/2011

INCLUDE Irvine32.inc
.data
source  BYTE  "This is the source string",0
strSize = ($ - source) - 1
target  BYTE  SIZEOF source DUP(?)


.code
getgoing PROC

     mov esi, 24		   ; End of source string
     mov ebx, OFFSET target ; Beginning of target string
	mov  ecx,strSize	   ; Loop counter
	mov edx,OFFSET source
	call WriteString
L1:
	mov  al,source[esi]		; Get a character from source
	mov  [ebx],al		     ; Store it in the target
	inc ebx                  ; Move to next character in target
	dec  esi				; Minus index location by 1
	loop L1				; Repeat for entire string
	mov edx,OFFSET target
	call CRLF
	call WriteString
	call CRLF
	mov esi, OFFSET target   ; Offset of variable
	mov ebx,1                ; Byte format
	mov ecx, SIZEOF target   ; counter
	call DumpMem
exit
getgoing ENDP

END getgoing