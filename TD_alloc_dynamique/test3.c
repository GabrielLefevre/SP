// test3.c
#include<stdlib.h>

int f() {
  int *p,a,i;
  p = (int*)malloc(sizeof(int)*10);
  for(i = 0;i<10;i++) p[i] = i;
  free(p);
  //free(p);
  return 0;
}

int main() {
  f();
}

// le programme effectuais 2x une désallocation
