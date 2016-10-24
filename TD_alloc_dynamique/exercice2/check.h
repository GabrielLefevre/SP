//check.h
#define malloc(a) CHECK_malloc(a,__FILE__,__LINE__)
#define calloc(a,b) CHECK_calloc(a,b,__FILE__,__LINE__)
#define realloc(a,b) CHECK_realloc(a,b,__FILE__,__LINE__)
#define free(a) CHECK_free(a,__FILE__,__LINE__)
