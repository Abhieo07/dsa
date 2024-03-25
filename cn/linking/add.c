#include <stdio.h>

int add(int *a, int *b) {
    printf("Address of a %d and b %d\n", &a,&b);
    return (*a + *b);
}

