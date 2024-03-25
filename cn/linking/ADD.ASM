section .data
    format db "Address of a: %p and b: %p", 10, 0  ; Format string for printf

section .text
    global add
    extern printf

add:
    ; Prologue
    push    ebp
    mov     ebp, esp

    ; Function body
    ; Load the parameters (pointers to integers) from the stack
    mov     eax, [ebp + 8]  ; Load pointer to a
    mov     ebx, [ebp + 12] ; Load pointer to b

    ; Print the addresses of a and b
    push    ebx             ; Push pointer to b (second argument)
    push    eax             ; Push pointer to a (first argument)
    push    format          ; Push format string
    call    printf          ; Call printf
    add     esp, 12         ; Clean up the stack after function call

    ; Load the integer values from memory
    mov     eax, [eax]      ; Load value of a
    mov     ebx, [ebx]      ; Load value of b

    ; Calculate the sum of a and b
    add     eax, ebx

    ; Epilogue
    mov     esp, ebp
    pop     ebp
    ret
