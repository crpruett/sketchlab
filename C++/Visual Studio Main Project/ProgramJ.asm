TITLE Chess Board

INCLUDE Irvine32.inc

SetColor PROTO forecolor:BYTE, backcolor:BYTE
WriteColorChar PROTO char:BYTE, forecolor:BYTE, backcolor:BYTE
PrintRowOdd PROTO color:BYTE
PrintRowEven PROTO color:BYTE

.data
rows = 8
columns = 8
horizCharsPerSquare = 2

.code
main PROC
mov ecx, rows / horizCharsPerSquare ; How many rows to print
L1: ; Loop for printing multiple rows
INVOKE PrintRowOdd, gray
call CRLF
INVOKE PrintRowEven, gray
call CRLF
loop L1
INVOKE SetColor, lightGray, black ; Lightgray characters against a black background. Returns to that state.
call CRLF

exit
main ENDP

PrintRowOdd PROC USES ecx,
color:BYTE

mov ecx, columns / horizCharsPerSquare ; 

L1: INVOKE WriteColorChar, ' ', color, color ; Grey square first
    INVOKE WriteColorChar, ' ', color, color
    INVOKE WriteColorChar, ' ', white, white ; White square Second
    INVOKE WriteColorChar, ' ', white, white
    loop L1

ret
PrintRowOdd ENDP

PrintRowEven PROC USES ecx,
color:BYTE

mov ecx, columns / horizCharsPerSquare

L1: INVOKE WriteColorChar, ' ', white, white ; White square first
    INVOKE WriteColorChar, ' ', white, white
    INVOKE WriteColorChar, ' ', color, color ; Gray square second
    INVOKE WriteColorChar, ' ', color, color
    loop L1

ret
PrintRowEven ENDP

WriteColorChar PROC USES eax, 
char:BYTE, forecolor:BYTE, backcolor:BYTE,

INVOKE SetColor, forecolor, backcolor
mov al, char
call WriteChar
ret
WriteColorChar ENDP

SetColor PROC, forecolor:BYTE, backcolor:BYTE
movzx eax, backcolor
shl eax, 4   ;Shift background color left by 4 bits
or al, forecolor ; Or the background color with the foreground color
call SetTextColor ; Requires to set up a byte the contains both fore/background colors
ret
SetColor ENDP
END main