#include <jni.h>
#include <string.h>
#include <stdio.h>
#include <string.h>

JNIEXPORT int JNICALL Java_com_example_imiendk_CheckActivity_isPrimeC(JNIEnv *env, jobject obj, jint number)
{
    int i;
    for (i=2; i<number; i++) {
        if (number % i == 0 && i != number) return 0;
    }
    return 1;
}

JNIEXPORT jstring JNICALL Java_com_example_imiendk_ListActivity_getPrimesC(JNIEnv *env, jobject obj, jint max)
{
    int primes[max];
    int n_primes = 0;
    int i;

    char strbuf[15];

    char *result = "";

    for (i = 2; n_primes < max; i++) {
        int j;

        for (j = 0; j < n_primes; j++) {
            if (i % primes[j] == 0) {
                goto not_prime;
            }
        }
        primes[n_primes] = i;
        n_primes++;

        not_prime:
            ;
    }

    /* Now display the list. */

    printf ("The first %d primes are:\n", max);
    for (i = 0; i < n_primes; i++) {
        printf ("%4d ", primes[i]);

        //strcat(*result, sprintf(strbuf, "%d", i));

        if (i % 10 == 9) {
            printf ("\n");
        }
    }

		return (*env)->NewStringUTF(env, result);
}
