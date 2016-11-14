#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "check.h"

typedef  struct SCell {
  struct SAbr *f;
  struct SCell *suiv; // le pointeur vers le suivant
} Cell;

// La structure d'arbre
typedef struct SAbr {
  char *value;
  Cell *fils;
} ABR;

void supRoot(ABR *r) ;
void supListe(Cell *l);

void supRoot(ABR *r) {
}

void supListe(Cell *l) {
}

// on veut supprimer un seul fils de r

int supFils(ABR *r,char *s) {
  
  return 0;
}

void supNoeudFils (Cell * nf) {
  if (nf->f != null) {
     supRoot(nf->f);
  }
  free(nf);
}

/// Ajoute un fils à la liste chainee
ajoutListe(Cell **head,ABR *fils) {
  Cell *c = (Cell*)malloc(sizeof(Cell));
  c->f = fils;
  c->suiv = *head;
  *head = c;
}

// Cree une feuille
ABR *creeFeuille(char *s) {
  ABR *tmp = (ABR*)malloc(sizeof(ABR));
  tmp->fils = NULL;
  tmp->value = (char*)malloc(sizeof(char)*strlen(s));
  strcpy(tmp->value,s);
  return tmp;
}

// Cree un fils
void insereFils (ABR *a,char *s) {
  if(a==NULL) {
    printf("Arbre n'existe pas, creation fils impossible\n");
    exit(1);
  }
  ajoutListe(&(a->fils),creeFeuille(s));
}

// Est Feuille ?
int estFeuille(ABR *a) {
  if(a==NULL) {
    printf("Arbre n'existe pas, n'est pas feuille\n");
    exit(1);
  }
  return (a->fils==NULL);
}

//Affiche 

void affichePrefixe(ABR *a,int nbspace) {
  int i;
  Cell *tmp;
  if(a!=NULL) {
    if(nbspace!=0) {
      for(i=0;i<nbspace-3;i++) 
	printf(" ");
      printf("|__");
    }
    printf("%s\n",a->value);
      tmp = a->fils;
    while(tmp!=NULL) {
      affichePrefixe(tmp->f,nbspace+3);
      tmp = tmp->suiv;
    }
  }
}
// Cherche si s appartient à a et retourne 
// l'arbre associe si trouve NULL sinon
ABR *cherche(ABR *a,char *s) {
  Cell *tmp;
  
  // Fin de la recursivite
  if(a==NULL) return NULL;
  if(!strcmp(a->value,s)) return a;
  
  // On va voir chez les fils
  tmp = a->fils;
  while(tmp!=NULL) {
    ABR *tmp2;
    if((tmp2=cherche(tmp->f,s))) return tmp2;
    tmp = tmp->suiv;
  }
  return NULL;
}

/////////////////////

int main() {
  ABR *root;
  root = creeFeuille("/");
  insereFils(root,"etc");
  insereFils(root,"bin");
  insereFils(root,"home");
 
  insereFils(cherche(root,"etc"),"resolv.conf");
  insereFils(cherche(root,"etc"),"passwd");
  insereFils(cherche(root,"etc"),"group");

  insereFils(cherche(root,"bin"),"ls");
  insereFils(cherche(root,"bin"),"mkdir");
  insereFils(cherche(root,"bin"),"rm");
  
  insereFils(cherche(root,"home"),"marcel");
  insereFils(cherche(root,"marcel"),"TODO");
  insereFils(cherche(root,"marcel"),"Xrootenv.0");

  affichePrefixe(root,0);
  supFils(root,"etc");
  printf("--------------------------");
  affichePrefixe(root,0);
  supRoot(root);
  CHECK_reportLeak();
}
