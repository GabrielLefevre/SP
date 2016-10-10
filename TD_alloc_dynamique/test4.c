// test4.c
#include <stdlib.h>
#include <unistd.h>

int f() {
  int *p,a,i;
  p = (int*)malloc(sizeof(int)*10);
  read(0,p,100); 
  free(p);
  return 0;
}

int main() {
  f();
}
