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
 
// La tete de la liste
Cell *tete  = NULL;
 
//  ajout d'un élément
 
 int getAge (int annee) {
    // Convertit annee de naissance en age
    time_t timestamp; 
    struct tm * t; 
    timestamp = time(NULL); 
    t = localtime(&timestamp); 
    return 1900 + t->tm_year - annee; 
}

void addHeadTmp(char*s, int a, Cell ** newHead ) {	
	
  Cell *tmp = (Cell*) malloc(sizeof(Cell));
  if(tmp==NULL) {
  	printf("Erreur l'allocation\n");
  	exit(1);
  }	
  tmp->nom= (char *) malloc (sizeof(char)*(strlen(s)+1)); 
  strcpy(tmp->nom,s);
  tmp->anneeNaissance = a;
  tmp->suiv = tete;
  *newHead = tmp;
}
 
void addHead(char*s, int a) {
  Cell *tmp = (Cell*) malloc(sizeof(Cell));
  if(tmp==NULL) {
  	printf("Erreur l'allocation\n");
  	exit(1);
  }	
  tmp->nom= (char *) malloc (sizeof(char)*(strlen(s)+1)); 
  strcpy(tmp->nom,s);
  tmp->anneeNaissance = a;
  tmp->suiv = tete;
  tete = tmp;
}

int tailleListe () {
  int taille = 0; 
  Cell * p = tete; 
  while (p != NULL) {
	  p= p-> suiv; 
	  taille ++; 
  }
  return taille; 	  
}	

// Suppresion de la tete
 
void delHead() {
 
   if(tete!=NULL) {
  	Cell *tmp = tete;
  	tete = tete->suiv;
  	free(tmp->nom);
  	free(tmp);
  }		
}
 
void printListe() {
  Cell * t=tete; 
  if (t==NULL) {
  	 printf ("Liste vide \n"); 
  	 return;
  }	 
  while (t!=NULL) {
  	printf ("%s : %d\n",t->nom,t->anneeNaissance);
  	t=t->suiv;
  }
}
 
 
void printListeAge() {
 Cell * t=tete; 
  if (t==NULL) {
  	 printf ("Liste vide \n"); 
  	 return;
  }	 
  while (t!=NULL) {
	  int age = (2016-t->anneeNaissance);
  	printf ("%s : %d\n",t->nom,age);
  	t=t->suiv;
  }
}
 
void delNbPremiersListe(int nb)  {
	if (nb == 0)
		return;
   for(int i=0;i<nb;i++) {
	   delHead();
	}
}
 
void mettreALaRetraite () {
	while (tete!=NULL && getAge(tete->anneeNaissance)>65) {
		delHead();
	}
	if( tete!=NULL) {
		Cell *p = tete;
		Cell *pre = p;
		p = p->suiv;
		while(p!=NULL) {
			if(getAge(p->anneeNaissance)>=65) {
				pre->suiv=p->suiv;
				free(p->nom);
				free(p);
				p=pre->suiv;
			}
			else {
				pre=p;
				p=p->suiv;
			}
		} // while
	} // if
}
 
void testDelHead () {
  int apres, avant = tailleListe(); 
  delHead(); 
  apres = tailleListe(); 
  
  if (avant!=apres+1) {
    printf("----- Erreur delHead %d-%d---- \n",avant,apres);
  } else {
	printf("++++ delHead OK ++++ \n");
  }
}	
 
void testDelNbPremiersListe (int nb) {
  int apres, avant = tailleListe(); 
  if (nb>avant) {
	printf("!!!! Nombre éléments insuffisant %d-%d \n",avant,nb);  
	return;
  }
  delNbPremiersListe(nb); 
  apres = tailleListe(); 
  
  if (avant!=apres+nb) {
    printf("----- Erreur DelNbPremiersListe %d-%d---- \n",avant,apres);
  } else {
	printf("++++ DelNbPremiersListe OK ++++ \n");
  }
} 
 
int main() {
  int i;
  char * noms [] = {"Tintin", "Asterix", "Gaston Lagaffe", "Thorgal", "Bart Simpson", "Peter Parker", "Francis Blake", "Hebus", "Natasha", "Pim, Pam et Poum"};
  int anneeNaissances[] = {1928, 1958, 1955, 1975, 1988, 1961, 1944, 1992, 1970, 1896}; 
 
  
  for(i=0;i<MAX;i++) {
    addHead(noms[i],anneeNaissances[i]);
  }
	printf("----------ListeAnnee--------- \n");
	printListe();
	printf("----------ListeAge--------- \n");
	printListeAge(); 
	printf("----------ListeRetraite--------- \n");
	mettreALaRetraite(); 
	printListeAge();
  
	testDelHead();
	testDelNbPremiersListe(5);
	printf("----------DelnbPremiers(5)--------- \n");
	printListe();

   
   // On vérfie ...
   
    for(i=0;i<MAX;i++) {
    delHead();
  }
  if (CHECK_reportLeak()==0) printf("Bravo !\n"); 
  return 0;
 
}
