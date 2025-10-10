; Prompt for the key
; Store the key and save it's length
; Change the TranslateBuffer procdure to compare the new key with the plain text (USE CONDITIONALS)

TITLE Encryption Program               (Encrypt.asm)

; This program demonstrates simple symmetric
; encryption using the XOR instruction.

INCLUDE Irvine32.inc
KEYMAX = 128        ; maximum key size
BUFMAX = 128     	; maximum buffer size

.data
sPrompt  BYTE  "Enter the plain text: ",0
kPrompt  BYTE  "Enter the encryption key: ",0
sEncrypt BYTE  "Cipher text:          ",0
sDecrypt BYTE  "Decrypted:            ",0
buffer   BYTE   BUFMAX+1 DUP(0)
keybuffer BYTE  KEYMAX+1 DUP(0)
bufSize  DWORD  ?
keybufSize DWORD ?

.code
main PROC
	call	InputTheString		; input the plain text
	call InputTheKey
	call	TranslateBuffer	; encrypt the buffer
	mov	edx,OFFSET sEncrypt	; display encrypted message
	call	DisplayMessage
	call	TranslateBuffer  	; decrypt the buffer
	mov	edx,OFFSET sDecrypt	; display decrypted message
	call	DisplayMessage

	exit
main ENDP

;-----------------------------------------------------
InputTheString PROC
;
; Prompts user for a plaintext string. Saves the string 
; and its length.
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	mov	edx,OFFSET sPrompt	; display a prompt
	call	WriteString
	mov	ecx,BUFMAX		; maximum character count
	mov	edx,OFFSET buffer   ; point to the buffer
	call	ReadString         	; input the string
	mov	bufSize,eax        	; save the length
	call	Crlf
	popad
	ret
InputTheString ENDP

;-----------------------------------------------------
InputTheKey PROC
;
; Prompts user for a key. Saves the key 
; and its length.
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	mov	edx,OFFSET kPrompt	; display a prompt
	call	WriteString
	mov	ecx,KEYMAX		; maximum character count
	mov	edx,OFFSET keybuffer   ; point to the buffer
	call	ReadString         	; input the string
	mov	keybufSize,eax        	; save the length
	call	Crlf
	popad
	ret
InputTheKey ENDP

;-----------------------------------------------------
DisplayMessage PROC
;
; Displays the encrypted or decrypted message.
; Receives: EDX points to the message
; Returns:  nothing
;-----------------------------------------------------
	pushad
	call	WriteString
	mov	edx,OFFSET buffer	; display the buffer
	call	WriteString
	call	Crlf
	call	Crlf
	popad
	ret
DisplayMessage ENDP

;-----------------------------------------------------
TranslateBuffer PROC
;
; Translates the string by exclusive-ORing each
; byte with the encryption key byte.
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	mov	ecx,bufSize		; loop counter
	mov	esi, 0	; index 0 in buffer
	mov edi, 0     ; index 0 in the key
L1:
     mov al, keybuffer[edi]  ; move character at index to al register
	xor	buffer[esi], al ; translate a byte
	inc	esi             ; point to next byte in buffer
	inc edi              ; point to next byte in key
	cmp edi, keybufSize  ; end of key?
	jb next             ; if false reset to index 0 in key. If true continue loop.
	mov edi, 0
next:	loop	L1  

	popad
	ret
TranslateBuffer ENDP
END main