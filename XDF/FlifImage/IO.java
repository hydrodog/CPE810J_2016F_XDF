/**
 @author xi chen
 **/

public class IO{
static{
System.loadLibrary("lib_IO.jnilib");
}
public boolean IogetInt8bit(IOStream io, int *result);
public boolean IogetInt16bit(IOStream io, int *result);
public static void main(String[]args){
	new IO().IogetInt8bit(IOStream io, int *result);
	new IO().IogetInt16bit(IOStream io, int *result);
}
}
