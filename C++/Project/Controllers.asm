TITLE Controllers


INCLUDE Irvine32.inc

.data
Banked_Points DWORD  0
BankedString BYTE "Banked Points: ", 0
Current_Points DWORD 0
CurrentString BYTE "Current Points: ",0
Max_Points DWORD 10000
buffer BYTE 1 DUP(0)
Rules BYTE "Welcome To Farkle!!!", 0Dh, 0Ah
      BYTE "The Rules: ", 0Dh, 0Ah
	 BYTE "1. You will be given six dice in order to score/bank points.", 0Dh, 0Ah
	 BYTE "2. You have to get at least 500 points in order to bank them.", 0Dh, 0Ah
	 BYTE "3. If you roll and you don't receive any points from the roll, you farkle.", 0Dh, 0Ah
	 BYTE "4. If you have 0 points when you farkle or have farkled three times, you lose.", 0Dh, 0Ah
	 BYTE "5. Every time you farkle you lose 200 points.", 0Dh, 0Ah
	 BYTE "6. If you roll and score points with a few dice you have the option of trying to score more with the remaining dice.", 0Dh, 0Ah
	 BYTE "7. If you score with every dice you get a bonus roll.", 0Dh, 0Ah, 0Dh, 0Ah
	 BYTE " The scoring will be displayed while you are playing the game.", 0Dh, 0Ah
	 BYTE "ENJOY!!", 0
	 
endMSG BYTE " Thanks for playing!", 0Dh, 0Ah
rPrompt BYTE "Press (capital) 'R' to roll: ", 0
exitPrompt BYTE "Do you want to quit? (Q for yes)", 0
.code
main PROC

exit
main ENDP

;-----------------------------------------------------
InputController PROC
;
; Takes the input for rolling the dice
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	mov edx, OFFSET rPrompt 
	call WriteString      ; Output rPrompt
	mov edx, OFFSET buffer ; Point to buffer
	start: 
	call ReadString
	cmp buffer, "R" ; Was R entered?
	jne start       ; No. Wait for it.
	; INVOKE diceModel, [params] ; Yes. Call models and view.
	; INVOKE rulesModel, [params]
	; INVOKE scoreModel, [params]
	call mainView
	popad
	ret
InputController ENDP

;-----------------------------------------------------
GameController PROC
;
; Controls the gameflow input.
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	call RulesView
	cmp Banked_Points, 10000 ; Banked_Points >= the maximum amount of points? (Max points can be changed to whatever)
	jge exitloop  ; Yes. Call views.
	mov edx, OFFSET exitPrompt 
	call WriteString  ; Prompt for exit
	mov edx, OFFSET buffer   ; Point to buffer
	call ReadString   ; Read input
	cmp buffer, "Q"   ; Input == Q?
	je exitloop      ; Yes. Call views.
	call InputController ; No. Call controllers.
	call AIController
	jmp exitproc  ; Exit
	exitloop:
	call scoreView
	call endGameView
	exitproc: 
	popad
	ret
GameController ENDP

;-----------------------------------------------------
RulesView PROC
;
; Displays the rules to the player.
;
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	mov edx, OFFSET Rules
	call WriteString
	Call CRLF
	popad
	ret
RulesView ENDP

;-----------------------------------------------------
endGameView PROC
;
; Displays the ending message.
;
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	mov edx, OFFSET endMSG
	call WriteString
	Call CRLF
	popad
	ret
endGameView ENDP


;-----------------------------------------------------
AIController PROC
;
; Conrols "AI"
;
; Receives: nothing
; Returns: nothing
;-----------------------------------------------------
	pushad
	; INVOKE diceModel, [params]
	; INVOKE rulesModel, [params]
	; INVOKE scoreModel, [params]
	call mainView
	popad
	ret
AIController ENDP
END main