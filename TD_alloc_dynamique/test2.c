// test2.c
#include<stdlib.h>
int f() {
  int *p,a,i;
  p = (int*)malloc(sizeof(int)*13);
  for(i = 0;i<10;i++) p[i] = i;
  p[11] = 12;
  a = p[12];
  free(p);
  return 0;
}
int main() {
  f();
}

//~ p = (int*)malloc(sizeof(int)*10);
//~ le programme test2.c alloue à p un bloc de 10 entiers et 
//~ essaie d’écrire au niveau 11 et de lire au niveau 12. 
//~ Il suffit pour cela de réserver par exemple 13 entiers pour résoudre corriger le programme.
  
  
