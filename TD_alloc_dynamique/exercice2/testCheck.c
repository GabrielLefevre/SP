// testCheck.c
#include <stdio.h>
#include "check.h"

int f() {
  int *p,*q,a,i;
  p = (int*)malloc(sizeof(int)*10);
  q = (int*)malloc(sizeof(int)*10);
  for(i = 0;i<10;i++) p[i] = i;
  free(p);free(p);
  free(q);
  return 0;
}

int main() {
  f();
  reportLeak();
}
