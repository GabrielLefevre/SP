#include<stdlib.h>
 #include<stdio.h>
 #include<string.h>
 #include <time.h> 
 #include "check.h" 
 #define MAX 10
  
  
 typedef  struct SCell {
   char *nom; // le nom 
   int  anneeNaissance;      //  age
   struct SCell *suiv; // le pointeur vers le suivant
 } Cell;
  
 // pile
 Cell ** pile ;
 int taillePile, sommet;
  
 //  ajout d'un élément
  
 int getAge (int annee) {
 	time_t timestamp; 
     struct tm * t; 
     timestamp = time(NULL); 
     t = localtime(&timestamp); 
     return 1900 + t->tm_year - annee; 
 }
 
 void afficherCell (Cell * element) {
     printf ("  nom : %s\n",element->nom);  
     printf ("  annee : %d\n",element->anneeNaissance); 
 }
  
  
 void initPile (int size) {
 	pile = (Cell **) calloc (sizeof(Cell), size); 
 	int i=0; 
 	for (i=0;i<size;i++) pile[i]=NULL; 
 	sommet = 0; 
 	taillePile = size; 
 }
 
 int pilePleine () {
 	return sommet==taillePile-1; 
 }
 
 int pileVide () {
 	return sommet==0; 
 }
  
 void empiler(char*s, int a) {
   if (! pilePleine()) {
     Cell *tmp = (Cell*) malloc(sizeof(Cell));
     if(tmp==NULL) {
   	  printf("Erreur l'allocation\n");
   	  exit(1);
     }	
     tmp->nom= (char *) malloc (sizeof(char)*(strlen(s)+1)); 
     strcpy(tmp->nom,s);
     tmp->anneeNaissance=a; 
     pile[sommet]=tmp; 
    sommet ++; 
  }  
}
 
int hauteurPile () {
  return sommet+1;   
}	
 
int depiler() {
  if(pile ==NULL) {
	  printf("La pile est vide");
	  return NULL;
	}
	return -1;
	
	
  
}
 
void printListe() {
  int i; 
  for (i=0; i< sommet; i++) {
	  printf ("pile[%d] :\n",i);
	  afficherCell(pile[i]); 	  
  }
}

void printListeAge (int age) {
  int i; 
  for (i=0; i< sommet; i++) {
	  if(getAge(pile[i]->anneeNaissance)>age) {
		 printf ("pile[%d] :\n",i);
	  afficherCell(pile[i]);  
	  }
	  	  
  }
 }
  
 
int main() {
  int i;
  char * noms [] = {"Tintin", "Asterix", "Gaston Lagaffe", "Thorgal", "Bart Simpson", "Peter Parker", "Francis Blake", "Hebus", "Natasha", "Pim, Pam et Poum"};
  int anneeNaissances[] = {1928, 1958, 1955, 1975, 1988, 1961, 1944, 1992, 1970, 1896}; 
  
  initPile(2*MAX);  
 
  for(i=0;i<MAX;i++) {
    empiler(noms[i],anneeNaissances[i]);
  }

  printListeAge(60);
 
  // On vérfie ...
 
  if (CHECK_reportLeak()==0) printf("Bravo !\n"); 
  return 0;
}
