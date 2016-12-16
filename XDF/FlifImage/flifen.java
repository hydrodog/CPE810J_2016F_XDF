/**
 @author xi chen
 **/

public class flifen{
static{
System.loadLibrary("lib_flifen.jnilib");
}

public native boolean FlifEn();
public static void main(String[] args){
new flifen().FlifEn();
}
}
