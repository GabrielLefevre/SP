// test5.c
#include <stdlib.h>
#include <stdio.h>
void f(int size) {

  int i,*a1 = (int*)malloc(sizeof(int)*size);

  a1[0] = 2;
  for(i = 1;i<size;i++) a1[i] = a1[i-1]*3;
  for(i = 0;i<size;i++) printf("%d ",a1[i]);
  printf("\n");
  free(a1);
}

int main() {
  f(10);
}
