/**
@author xi chen
**/

public class ColorRanges{

    public  ~ColorRanges() {};
    public  int numPlanes();
    public ColorVal min(int p);
    public ColorVal max(int p);
    public  void minmax(final int p, final prevPlanes &, ColorVal &minv, ColorVal &maxv) { minv=min(p); maxv=max(p); }
    public void snap(final int p, final prevPlanes &pp, ColorVal &minv, ColorVal &maxv, ColorVal &v) {
        minmax(p,pp,minv,maxv);
        if (minv > maxv) { 
            // this should only happen on malicious/corrupt input files, or while adding loss
           maxv=minv; return;
        }
        assert(minv <= maxv);
        if(v>maxv) v=maxv;
        if(v<minv) v=minv;
        assert(v <= maxv);
        assert(v >= minv);
    }
    public boolean isStatic()  { return true; }
    public final ColorRanges* previous() { return NULL; }
}

class StaticColorRanges extends ColorRanges
{
	public Map<ColorVal,ColoVal> StaticColorRangeList;
	protected final StaticColorRangeList ranges;
    public StaticColorRanges(StaticColorRangeList &r) : ranges(r) {}
    public int numPlanes() { return ranges.size(); }
    public ColorVal min(int p) { if (p >= numPlanes()) return 0; assert(p<numPlanes()); return ranges[p].first; }
    public ColorVal max(int p) { if (p >= numPlanes()) return 0; assert(p<numPlanes()); return ranges[p].second; }
}


class DupColorRanges extends ColorRanges {
   protected final ColorRanges *ranges;
   public final ColorRanges *getRanges(Image &image);
   public DupColorRanges(ColorRanges *rangesIn) : ranges(rangesIn) {}

    public int numPlanes() { return ranges->numPlanes(); }
    public ColorVal min(int p)  { return ranges->min(p); }
    public ColorVal max(int p) { return ranges->max(p); }
    public void minmax(final int p, final prevPlanes &pp, ColorVal &minv, ColorVal &maxv) { ranges->minmax(p,pp,minv,maxv); }
    public boolean isStatic()  { return ranges->isStatic(); }
    public final ColorRanges* previous() { return ranges; }
}