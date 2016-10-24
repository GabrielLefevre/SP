#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include "check.h" 

typedef  struct SCell {
  char nom[100]; // le nom 
  int  age;      //  age
  struct SCell *suiv; // le pointeur vers le suivant
} Cell;

// La tete de la liste
Cell *tete  = NULL;

//  ajout d'un élément
// #define malloc(a) CHECK_malloc(a,__FILE__,__LINE__)

void addHead(char*s, int a) {
  Cell *tmp = (Cell*)malloc(sizeof(Cell));

  if(tmp==NULL) {
  	printf("Erreur l'allocation\n");
  	exit(1);
  }	
  strcpy(tmp->nom,s);
  tmp->age = a;
  tmp->suiv = tete;
  tete = tmp;
}

// Suppresion de la tete
  
void delHead() {

  if(tete!=NULL) {
  	Cell *tmp = tete;
  	tete = tete->suiv;
  }	
}

int main() {
  int i;
  char nom[99];
  strcpy(nom,"aaaaaaaaaaaaaaaaaaaaaa");

  //  Au départ on met 10 elements

  for(i=0;i<10;i++) {
    addHead(nom,i);
  }
  
  // On supprime la tete et on ajoute quelque chose
  for(i = 0;i<15;i++) {
  	printf ("Ajout %d element\n",i);
    delHead();
    addHead(nom,i);
  } 
   
  // On vérfie ....
  if (CHECK_reportLeak()==0) printf("Bravo !\n"); 
  return 0;

}
