#include <stdio.h>

extern int add(int *a, int *b);
int multiply(int *a, int *b) {
    return (*a * *b);
}

int main() {
    int a = 3, b = 8;
    int result = add(&a,&b);
    printf("Result: %d\n", result);
    printf("Product is %d\n", multiply(&a, &b));
    return 0;
}
