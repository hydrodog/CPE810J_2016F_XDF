package FlifImage;
import java.util.ArrayList;

import FlifImage.Image;
/**
 * 
 * @author chenxi
 *
 */

//It is a common function hub, it will resolve color range
public class Common {
 public int[] computerGrey(ColorRanges ranges){
	 int[] greys = null; // a pixel with values in the middle of the bounds
	    for (int p = 0; p < ranges.numPlanes(); p++) 
	    	greys[p] = ((ranges.min(p)+ranges.max(p))/2);
	    return greys;
 }
}
