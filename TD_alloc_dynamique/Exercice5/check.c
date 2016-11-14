#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct CHECK_SCell {
  int line;
  char *file;
  void *adr;
  struct CHECK_SCell *suiv;

} CHECK_Cell;


CHECK_Cell *head;

/**
 * Creation cellule + init (le suivant à null)
 */

CHECK_Cell *CHECK_createCell(int l,char *s,void *a) {

  CHECK_Cell *tmp = (CHECK_Cell*)malloc(sizeof(CHECK_Cell));
  
  if(tmp==NULL) {
    printf("Problème alloc mémoire file\n");
    exit(1);
  }
  
  tmp->line = l;
  tmp->adr = a;
  tmp->file = (char*)malloc(sizeof(char)*strlen(s));
  

  if(tmp->file==NULL) {
    printf("Problème alloc mémoire file\n");
    exit(1);
  }
  strcpy(tmp->file,s);

  tmp->suiv = NULL;
  return tmp;
}

/**
 * Suppresion d'une allocation dyn dans la table des allocs.
 * retourne 0 si pas trouve
 */

int CHECK_supCell(void *a,char *f,int line) {
    CHECK_Cell *toDel = head;
  if(head==NULL) {
    printf("Problème libération (mem non allouée) dans %s ligne %d \n",f,line);
    return 0;
  }
  
  if(head->adr == a) {
    toDel = head;
    head = head->suiv;
  } else {
    CHECK_Cell *prec=head,*cur = head->suiv;
    while((cur!=NULL) && (cur->adr!=a)) {
      prec = cur;
      cur = cur->suiv;
    }
    if(cur==NULL) {
      printf("Problème libération (mem non allouée) dans %s ligne %d \n",f,line);
      return 0;
    } 
    toDel = cur;
    prec->suiv = cur->suiv;
  }
  free(toDel->file);
  free(toDel);
  return 1;
}

/**
 * Ajout d'une cellule dans la liste chainee des allocations dynamiques
 */

void CHECK_addCell(int l,char *f,void *a) {

  CHECK_Cell *tmp = CHECK_createCell(l,f,a);
  tmp->suiv = head;
  head = tmp;
}


/**
 * Redirection de malloc
 */

void * CHECK_malloc(size_t a,char *file,int li) {
  void *adr = malloc(a);
  CHECK_addCell(li,file,adr);
  return adr; 
}


/**
 * Redirection de calloc
 */

void * CHECK_calloc(size_t siz,size_t nb,char *file,int li) {
  void *adr = calloc(siz,nb);
  CHECK_addCell(li,file,adr);
  return adr; 
}

/**
 * Redirection de realloc
 */

void * CHECK_realloc(void *a,size_t t,char *file,int li) {
  // On fait une reallocation donc l'alloc de a doit etre enleve de la liste
  // des allocations et ensuite on realloue....

  void *adr = NULL;
  if (CHECK_supCell(a,file,li)!=0) {
     adr = realloc(a,t);
     CHECK_addCell(li,file,adr);
  }
  return adr; 
}

/*
 * Redirection de free
 */

void CHECK_free(void *adr,char *file,int li) {

  if(CHECK_supCell(adr,file,li)!=0) {// Si on ne trouve pas la cellule il ne faut rien desallouer
    free(adr);
  }
}


/**
 * Report Leak
 */

int CHECK_reportLeak() {

  CHECK_Cell *tmp = head;
  int nb = 0;
  while(tmp!=NULL) {
    printf("Fuites mémoire %s ligne %d\n",tmp->file,tmp->line);
    tmp=tmp->suiv;
    nb++;
  }
  if(nb!=0) {
    printf("Nb fuites mémoires : %d \n",nb);
  }
  return nb;
}
