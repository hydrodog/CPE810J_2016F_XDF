package edu.stevens.XDF._2dgraphics;
/*
 * @author:
 * Read in SVG file and parse the attributes of SVG. The class can only parse rectangle,circle,ellipse,and path.
 * TODO: parse more shapes in SVG.
 */
import java.io.*;
import java.util.regex.*;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;


public class importSVG {
	private String Line="";
	private SVGDocument doc;
	private boolean findGStart = false;
	private parseCircle pc;
	private parseEllipse pe;
	private parseG pG;
	private parseLine pl;
	private parsePath pp;
	private parsePoly pPo;
	private parseRect pr;
	public importSVG(){
		File file = new File("rectangle2.svg");
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
		
		// Get the root element (the SVG element)
		Element svgRoot = doc.getDocumentElement();
		
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			//read SVG file line by line.
			Line = reader.readLine();
			while(Line != null){
				Pattern pRootStart = Pattern.compile("<svg");
				Matcher mRootStart = pRootStart.matcher(Line);
				Pattern pGStart = Pattern.compile("<g[^A-Za-z0-9]");
				Matcher mGStart = pGStart.matcher(Line);
				Pattern pGElementEnd = Pattern.compile("</g>");
				Matcher mGElementEnd = pGElementEnd.matcher(Line);
				boolean findGElementEnd = mGElementEnd.find();
				Pattern pRectStart = Pattern.compile("<rect");
				Matcher mRectStart = pRectStart.matcher(Line);
				Pattern pPathStart = Pattern.compile("<path");
				Matcher mPathStart = pPathStart.matcher(Line);
				Pattern pCircleStart = Pattern.compile("<circle");
				Matcher mCircleStart = pCircleStart.matcher(Line);
				Pattern pEllipseStart = Pattern.compile("<ellipse");
				Matcher mEllipseStart = pEllipseStart.matcher(Line);
				Pattern pLineStart = Pattern.compile("<line");
				Matcher mLineStart = pLineStart.matcher(Line);
				Pattern pPolygonStart = Pattern.compile("<polygon");
				Matcher mPolygonStart = pPolygonStart.matcher(Line);
				boolean findPolygonStart = mPolygonStart.find();
				Pattern pPolylineStart = Pattern.compile("<polyline");
				Matcher mPolylineStart = pPolylineStart.matcher(Line);
				boolean findPolylineStart = mPolylineStart.find();
				if(mRootStart.find()){//parse tag of svg
					System.out.println("I am Root");
					Pattern pRootEnd = Pattern.compile(">");
					Matcher mRootEnd = pRootEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mRootEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mRootEnd = pRootEnd.matcher(Line);	
					}
					parseRoot pRo = new parseRoot(Sb.toString());
					pRo.parse();	
					// set the width and height attribute on the svg root element
					svgRoot.setAttributeNS(null, "width", pRo.getWidth());
					svgRoot.setAttributeNS(null, "height", pRo.getHeight());
		         	svgRoot.setAttributeNS(null, "viewBox", pRo.getViewbox());
				}
				if(mGStart.find()){
					findGStart = true;
					System.out.println("I am G");
					Pattern pGEnd = Pattern.compile(">");
					Matcher mGEnd = pGEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mGEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mGEnd = pGEnd.matcher(Line);	
					}
					pG = new parseG(Sb.toString());
					pG.parse();	
					System.out.println(pG);
				}
				if(mRectStart.find()){//parse tag of rectangles
					System.out.println("I am rect");
					Pattern pRectEnd = Pattern.compile("/\\>");
					Matcher mRectEnd = pRectEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mRectEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mRectEnd = pRectEnd.matcher(Line);	
					}
					if(findGStart){
						pr = new parseRect(Sb.toString(),pG.getStroke(),pG.getFill(),pG.getStrokeWidth(),pG.getOpacity(),pG.getFillOpacity(),pG.getStrokeOpacity(),pG.getTransform(),pG.getStyle());	
					}else{
						pr = new parseRect(Sb.toString());
					}	
					pr.parse();
					System.out.println(pr);
					if(!pr.getWidth().equals("0")||!pr.getHeight().equals("0")){
						Rect drawRect = new Rect(pr.getX(),pr.getY(),pr.getWidth(),pr.getHeight(),pr.getRx(),pr.getRy(),pr.getFill(),pr.getStroke(),pr.getStrokewidth(),pr.getStrokeOpacity(),pr.getOpacity(),pr.getFillOpacity(),pr.getStyle(),pr.getTransform(),doc);
						svgRoot.appendChild(drawRect.paint());
					}		
				}
				if(mPathStart.find()){//parse tag of paths
					System.out.println("I am path");
					Pattern pPathEnd = Pattern.compile(">");
					Matcher mPathEnd = pPathEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mPathEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mPathEnd = pPathEnd.matcher(Line);	
					}
					if(findGStart){
						pp = new parsePath(Sb.toString(),pG.getStroke(),pG.getFill(),pG.getStrokeWidth(),pG.getOpacity(),pG.getFillOpacity(),pG.getStrokeOpacity(),pG.getTransform(),pG.getStyle());	
					}else{
				        pp = new parsePath(Sb.toString());
					}
					pp.parse();
					System.out.println(pp);
					if(!pp.getD().equals("none")){
					Path drawPath = new Path(pp.getD(),pp.getFill(),pp.getStroke(),pp.getStrokeWidth(),pp.getStrokeOpacity(),pp.getFillOpacity(),pp.getOpacity(),pp.getStyle(),pp.getTransform(),doc);
					svgRoot.appendChild(drawPath.paint());
					}
				}
				if(mCircleStart.find()){//parse tag of cricles
					System.out.println("I am circle");
					Pattern pCircleEnd = Pattern.compile("/>");
					Matcher mCircleEnd = pCircleEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mCircleEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mCircleEnd = pCircleEnd.matcher(Line);	
					}
					if(findGStart){
						pc = new parseCircle(Sb.toString(),pG.getStroke(),pG.getFill(),pG.getStrokeWidth(),pG.getOpacity(),pG.getFillOpacity(),pG.getStrokeOpacity(),pG.getTransform(),pG.getStyle());	
					}else{
						pc = new parseCircle(Sb.toString());
					}
					pc.parse();
					System.out.println(pc);
					if(!pc.getR().equals("0")){
						Circle drawCircle = new Circle(pc.getCx(),pc.getCy(),pc.getR(),pc.getFill(),pc.getStroke(),pc.getStrokeWidth(),pc.getStrokeOpacity(),pc.getStrokeOpacity(),pc.getOpacity(),pc.getStyle(),pc.getTransform(),doc);
						svgRoot.appendChild(drawCircle.paint());
					}
				}
				if(mEllipseStart.find()){//parse tag of ellipse
					System.out.println("I am ellipse");
					Pattern pEllipseEnd = Pattern.compile("/>");
					Matcher mEllipseEnd = pEllipseEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mEllipseEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mEllipseEnd = pEllipseEnd.matcher(Line);	
					}
					if(findGStart){
						
						pe = new parseEllipse(Sb.toString(),pG.getStroke(),pG.getFill(),pG.getStrokeWidth(),pG.getOpacity(),pG.getFillOpacity(),pG.getStrokeOpacity(),pG.getTransform(),pG.getStyle());	
					}else{
						
						pe = new parseEllipse(Sb.toString());
					}
					pe.parse();
					System.out.println(pe);
					if(!pe.getRx().equals("0")||!pe.getRy().equals("0")){
						Ellipse drawEllipse = new Ellipse(pe.getCx(),pe.getCy(),pe.getRx(),pe.getRy(),pe.getFill(),pe.getStroke(),pe.getStrokeWidth(),pe.getStrokeOpacity(),pe.getFillOpacity(),pe.getOpacity(),pe.getStyle(),pe.getTransform(),doc);
						svgRoot.appendChild(drawEllipse.paint());
					}
				}
				if(mLineStart.find()){//parse tag of lines
					System.out.println("I am line");
					Pattern pLineEnd = Pattern.compile("/>");
					Matcher mLineEnd = pLineEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mLineEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mLineEnd = pLineEnd.matcher(Line);	
					}
					if(findGStart){
						pl = new parseLine(Sb.toString(),pG.getStroke(),pG.getFill(),pG.getStrokeWidth(),pG.getOpacity(),pG.getFillOpacity(),pG.getStrokeOpacity(),pG.getTransform(),pG.getStyle());	
					}else{
						pl = new parseLine(Sb.toString());
					}
					pl.parse();
					System.out.println(pl);
					if(!pl.getX1().equals("0")||!pl.getY1().equals("0")||!pl.getX2().equals("0")||!pl.getY2().equals("0")){
						Line drawLine = new Line(pl.getX1(),pl.getY1(),pl.getX2(),pl.getY2(),pl.getStroke(),pl.getStrokeWidth(),pl.getStyle(),pl.getTransform(),doc);
						svgRoot.appendChild(drawLine.paint());
					}
				}
				if(findPolygonStart||findPolylineStart){//parse tag of polygons or polylines
					System.out.println("I am poly");
					Pattern pPolygonEnd = Pattern.compile("/>");
					Matcher mPolygonEnd = pPolygonEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line+" ");
					while(!mPolygonEnd.find()){
						Line = reader.readLine();
						Sb.append(Line+" ");
						mPolygonEnd = pPolygonEnd.matcher(Line);	
					}
					if(findGStart){
						pPo = new parsePoly(Sb.toString(),pG.getStroke(),pG.getFill(),pG.getStrokeWidth(),pG.getOpacity(),pG.getFillOpacity(),pG.getStrokeOpacity(),pG.getTransform(),pG.getStyle());	
					}else{
						pPo = new parsePoly(Sb.toString());
					}
					pPo.parse();	
					System.out.println(pPo);
					//System.out.println(Sb.toString());
					if(!pPo.getPoints().equals("none")){
						
						if(findPolygonStart){
							Polygon drawPolygon = new Polygon(pPo.getPoints(),pPo.getFill(),pPo.getStroke(),pPo.getStrokeWidth(),pPo.getStrokeOpacity(),pPo.getFillRule(),pPo.getFillOpacity(),pPo.getOpacity(),pPo.getStyle(),pPo.getTransform(),doc);
							svgRoot.appendChild(drawPolygon.paint());
						}else{
							Polyline drawPolyline = new Polyline(pPo.getPoints(),pPo.getFill(),pPo.getStroke(),pPo.getStrokeWidth(),pPo.getStrokeOpacity(),pPo.getFillRule(),pPo.getFillOpacity(),pPo.getOpacity(),pPo.getStyle(),pPo.getTransform(),doc);
						    svgRoot.appendChild(drawPolyline.paint());
						}
					}
				}
				if(findGElementEnd)
					findGStart=false;
				Line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public SVGDocument getDoc(){
		return doc;
	}
//	public static void main(String[] args){
//		importSVG i1 = new importSVG();
//	}

}