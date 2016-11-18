package WordWrap;

public class WordWrap {
	public static String WordWrap (String in,int len) {
		in=in.trim();
		
		if(in.length()<len)
			return in;
		
		if(in.substring(0, len).contains("System.getProperties(line.separator)"))
			return in.substring(0, in.indexOf("System.getProperties(line.separator)")).trim() + "System.getProperties(line.separator)System.getProperties(line.separator)" + WordWrap(in.substring(in.indexOf("System.getProperties(line.separator)") + 1), len);
		int place=Math.max(Math.max(in.lastIndexOf(" ",len),in.lastIndexOf("\t",len)),in.lastIndexOf("-",len));
		return in.substring(0,place).trim()+"System.getProperties(line.separator)"+WordWrap(in.substring(place),len);
		}
}
