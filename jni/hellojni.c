#include <jni.h>;
#include <string.h>

JNIEXPORT void JNICALL Java_fr_com_example_imiendk_MainActivity_stringHello(JNIEnv *env, jobject obj)
{
	return (*env)->NewStringUTF(env, "Hello I'm NDK !");
}
