/**
@author xi chen
**/


public class FLIFIO{
static{
System.loadLibrary("lib_flifio.jnilib");
}
public native void flush();
public native boolean isEOF();
public native long ftell();
public native int getc();
public native char* gets(char *buf,int n);
public native int fputs(final char *s);
public native int fputc(int c);
public native void fseek(long offset, int where);

public static void main(String[] args){
new FLIF().flush();
new FLIF().isEOF();
new FLIF().ftell();
new FLIF().getc();
new FLIF().gets(char *buf, int n);
new FLIF().fputs(final char *c);
new FLIF().fputc(int c);
new FLIF().fseek(long offset, int where);
}
}