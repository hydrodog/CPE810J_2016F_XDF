import java.io.*; 
public class HexWriter {
	 private int initCap;  
	    private int[] data;  
	    private int pos = 0;  
	      
	    /*************************************************************************** 
	     * Creates a new instance of HexWriter 
	     */  
	    public HexWriter(int initCapacity) {  
	        if (initCapacity < 16) initCapacity = 16;  
	        data = new int[initCapacity];  
	        initCap = initCapacity;  
	        pos = 0;  
	    }  
	  
	    /**************************************************************************/  
	    public void putValue(int x) {  
	        data[pos] = x;  
	        if (++pos >= data.length) realloc();  
	    }  
	  
	    /**************************************************************************/  
	    public void newLine() {  
	        data[pos] = -1;  
	        if (++pos >= data.length) realloc();  
	    }  
	      
	    /**************************************************************************/  
	    private void realloc() {  
	        int newLen = data.length * 3/2;  
	        int[] newData = new int[newLen];  
	        System.arraycopy(data, 0, newData, 0, data.length);  
	        data = newData;  
	    }  
	      
	    /**************************************************************************/  
	    public int size() {  
	        int res = 0;  
	        for (int i=0; i<pos; i++) {  
	            if (data[i] >= 0) res++;  
	        }  
	        return res;  
	    }  
	  
	    /**************************************************************************/  
	    public void writeAll(BufferedWriter fw, int itemSize) throws Exception {  
	        boolean begin = true;  
	        StringBuffer sb = new StringBuffer(3*1024);  
	        String lastLine = null;  
	          
	        for (int i=0; i<pos; i++) {  
	            int item = data[i];  
	            if (begin) {  
	                //fw.write("<");  
	                sb.append('<');  
	                begin = false;  
	            }  
	            if (item >= 0) {  
	                if (itemSize >= 4) writeHex(sb, (item >> 24) & 0xFF);  
	                if (itemSize >= 3) writeHex(sb, (item >> 16) & 0xFF);  
	                if (itemSize >= 2) writeHex(sb, (item >> 8) & 0xFF);  
	                writeHex(sb, item & 0xFF);  
	            }  
	            else {  
	                //fw.write(">");  
	                sb.append('>');  
	                String line = sb.toString();  
	                if (line.equals("<6366a1575ec96c7edc6c7edc6f83da748bdb6f8fdec7a029000001000004ede6d1dfc787ad9f560000010000054084b582aac5fefffcbfd1e04084b50000010000046f8fde74a0e7cfe1f6d6e1ef8d90de6f8fde6f8fde6f8fde7492e9b4e0f5d5c9ea6f8fde6f8fde82bdf5cfe1f6a9a2e174a0e7cfe1f6babdeccfe1f6cfe1f6c9c0e482bdf5cfe1f6cfe1f6c9c0e46f8fde6f8fdea4c8f3cfe1f6cfe1f6cfe1f6a9a2e17392e2a6d7f8cfe1f6cfe1f6cfe1f6d5c9ea7492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea6f8fdea4c8f3cfe1f6cfe1f6cfe1f6a9a2e10000010000056f8fde6faff3cfe1f6b6ade00000010000066f8fde7492e9b4e0f5d5c9ea6f8fde6f8fde6f8fdea4c8f3d6e1ef8d90de7392e2a6d7f8d2d2ea8291db00000100000d6f8fde74a0e7000001000005cfe1f6a9a2e16f8fde7492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea6f8fde74a0e7cfe1f6cfe1f6cfe1f6b6ade06f8fde74a0e7cfe1f6cfe1f6d2d2ea8291db6f8fde74a0e7cfe1f6cfe1f6cfe1f6c9c0e46f8fde6f8fde7392e2a6d7f8cfe1f6cfe1f6d2d2ea8d90dea6d7f8cfe1f6cfe1f6cfe1f6d5c9ea0000010000046f8fdea4c8f3cfe1f6cfe1f6cfe1f6b6ade0a4c8f3cfe1f6d6e1ef8d90de7492e9b4e0f5d2d2ea8291db6f8fde74a0e7cfe1f6cfe1f6cfe1f6c9c0e46f8fde6f8fdea4c8f3cfe1f6b6ade00000010000056f8fde6faff3cfe1f6b6ade00000010000066f8fdea4c8f3cfe1f6b6ade06f8fde6f8fde82bdf5d5c9ea6f8fde6f8fde7492e9b4e0f5d5c9ea6f8fde6f8fde6faff3cfe1f6c9c0e47492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea6f8fde74a0e7cfe1f6cfe1f6cfe1f6b6ade06f8fde74a0e7cfe1f6cfe1f6d2d2ea8291db6f8fde74a0e7cfe1f6cfe1f6cfe1f6c9c0e46f8fde6f8fde7392e2a6d7f8cfe1f6cfe1f6d2d2ea8d90dea6d7f8cfe1f6cfe1f6cfe1f6d5c9ea7392e2a6d7f8cfe1f6cfe1f6d6e1ef8d90de6f8fde82bdf5d5c9ea6f8fde6f8fde74a0e7cfe1f6d6e1ef8d90de6f8fde6f8fde6f8fde7492e9b4e0f5d5c9ea6f8fde6f8fde82bdf5cfe1f6a9a2e174a0e7cfe1f6babdeccfe1f6cfe1f6c9c0e482bdf5cfe1f6cfe1f6c9c0e46f8fde6f8fdea4c8f3cfe1f6cfe1f6cfe1f6a9a2e17392e2a6d7f8cfe1f6cfe1f6cfe1f6d5c9ea7492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea6f8fdea4c8f3cfe1f6cfe1f6cfe1f6a9a2e16f8fde6f8fde6f8fde7492e9b4e0f5d2d2ea8291db0000010000046f8fde7492e9b4e0f5d2d2ea8291db6f8fde6f8fde6f8fde82bdf5d5c9ea6f8fde6f8fde74a0e7cfe1f6d6e1ef8d90de6f8fde6f8fde6f8fde7492e9b4e0f5d5c9ea6f8fde6f8fde82bdf5cfe1f6a9a2e174a0e7cfe1f6babdeccfe1f6cfe1f6c9c0e482bdf5cfe1f6cfe1f6c9c0e46f8fde6f8fdea4c8f3cfe1f6cfe1f6cfe1f6a9a2e17392e2a6d7f8cfe1f6cfe1f6cfe1f6d5c9ea7492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea6f8fdea4c8f3cfe1f6cfe1f6cfe1f6a9a2e10000010000056f8fde74a0e7cfe1f6d5c9ea6f8fde6f8fde82bdf5d5c9ea6f8fde6f8fde74a0e7000001000005cfe1f6a9a2e16f8fde7492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea6f8fde74a0e7cfe1f6cfe1f6cfe1f6b6ade06f8fde74a0e7cfe1f6cfe1f6d2d2ea8291db6f8fde74a0e7cfe1f6cfe1f6cfe1f6c9c0e46f8fde6f8fde7392e2a6d7f8cfe1f6cfe1f6d2d2ea8d90dea6d7f8cfe1f6cfe1f6cfe1f6d5c9ea7392e2a6d7f8cfe1f6cfe1f6d6e1ef8d90de6f8fde82bdf5d5c9ea6f8fde6f8fde74a0e7000001000005cfe1f6a9a2e16f8fde7492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea6f8fde74a0e7cfe1f6cfe1f6cfe1f6c9c0e46f8fde7392e2a6d7f8cfe1f6cfe1f6d6e1ef8d90de6f8fde74a0e7cfe1f6cfe1f6cfe1f6c9c0e46f8fde7492e9b4e0f5b7c4eecfe1f6cfe1f6cfe1f6a9a2e17392e2a6d7f8cfe1f6cfe1f6cfe1f6d5c9ea6f8fdea4c8f3cfe1f6cfe1f6cfe1f6a9a2e17392e2a6d7f8cfe1f6cfe1f6cfe1f6d5c9eaa4c8f3cfe1f6d6e1ef8d90de6f8fde74a0e7cfe1f6cfe1f6cfe1f6b6ade06f8fde7492e9b4e0f5b7c4eecfe1f6cfe1f6cfe1f6a9a2e10000010000066f8fde7392e2a6d7f8cfe1f6cfe1f6d6e1ef8d90de74a0e7000001000005cfe1f6a9a2e16f8fde7492e9b4e0f5d5c9eaa6d7f8cfe1f6d5c9ea74a0e7cfe1f6cfe1f6d2d2ea8291db0000010001426f8fdeb7c4ee4f79e90000010000055e7fe70000010000044f79e90000010000083e6be24263cababdec6f8fde6f8fdeb7c4ee4f79e95e7fe75e7fe75e7fe7fefffc5e7fe70000010000044f79e90000010000043e6be2fefffc3e6be23e6be23e6be24263cababdec748bdb748bdbb7c4eea96c81000001000005aa7995a76b87000001000005fefffc000001000006a05e72925976babdec6c7edc6c7edc6c7edc616bc9616bc9>")) {  
	                    int err = 10;  
	                }  
	                if (line.equals(lastLine)) {  
	                    fw.write("<>");  
	                }  
	                else {  
	                    if (!line.startsWith("<")) {  
	                        int error = 10;  
	                    }  
	                    fw.write(line);  
	                    lastLine = line;  
	                }  
	                fw.newLine();  
	                begin = true;  
	                sb.delete(0, sb.length());  
	            }  
	        }  
	    }  
	  
	    /**************************************************************************/  
	    private void writeHex(StringBuffer sb, int byteValue) throws Exception {  
	        String s = Integer.toHexString(byteValue);  
	        if (s.length() < 2)  
	            sb.append('0'); //s = "0" + s;  
	        sb.append(s);  
	    }  
	      
	    /**************************************************************************/  
	    public void clear() {  
	        data = new int[initCap];  
	        pos = 0;  
	    }  
}
