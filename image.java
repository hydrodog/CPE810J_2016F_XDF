package yue;
import javax.activation.MimetypesFileTypeMap;
import java.io.File;
public class image {
    public static void main(String[] args) {
        String filepath = "/the/file/path/image.jpg";
        File f = new File(filepath);
        String mimetype= new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
            System.out.println("It's an image");
        else 
            System.out.println("It's NOT an image");
    }





}
