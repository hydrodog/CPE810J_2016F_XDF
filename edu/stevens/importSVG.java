package edu.stevens;
/*
 * @author:Yujie Ren
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
	public importSVG(){
		File file = new File("rectangle2.svg");
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
		
		// Get the root element (the SVG element)
		Element svgRoot = doc.getDocumentElement();
		
		// set the width and height attribute on the svg root element
		svgRoot.setAttributeNS(null, "width", "1000");
		svgRoot.setAttributeNS(null, "height", "1000");
		svgRoot.setAttributeNS(null, "viewBox", "0 0 1000 1000");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			//read SVG file line by line.
			Line = reader.readLine();
			
			while(Line != null){
				Pattern pRectStart = Pattern.compile("rect");
				Matcher mRectStart = pRectStart.matcher(Line);
				Pattern pPathStart = Pattern.compile("path");
				Matcher mPathStart = pPathStart.matcher(Line);
				Pattern pCircleStart = Pattern.compile("circle");
				Matcher mCircleStart = pCircleStart.matcher(Line);
				Pattern pEllipseStart = Pattern.compile("ellipse");
				Matcher mEllipseStart = pEllipseStart.matcher(Line);
				Pattern pLineStart = Pattern.compile("<line");
				Matcher mLineStart = pLineStart.matcher(Line);
				Pattern pPolygonStart = Pattern.compile("polygon");
				Matcher mPolygonStart = pPolygonStart.matcher(Line);
				boolean findPolygonStart = mPolygonStart.find();
				Pattern pPolylineStart = Pattern.compile("polyline");
				Matcher mPolylineStart = pPolylineStart.matcher(Line);
				boolean findPolylineStart = mPolylineStart.find();
				if(mRectStart.find()){//parse tag of rectangles
					Pattern pRectEnd = Pattern.compile("/>");
					Matcher mRectEnd = pRectEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line);
					while(!mRectEnd.find()){
						Line = reader.readLine();
						Sb.append(Line);
						mRectEnd = pRectEnd.matcher(Line);	
					}
					parseRect pr = new parseRect(Sb.toString());
					pr.parse();
					System.out.println(pr);
					if(!pr.getWidth().equals("0")||!pr.getHeight().equals("0")){
						Rect drawRect = new Rect(pr.getX(),pr.getY(),pr.getWidth(),pr.getHeight(),pr.getRx(),pr.getRy(),pr.getFill(),pr.getStroke(),pr.getStrokewidth(),pr.getStrokeOpacity(),pr.getOpacity(),pr.getFillOpacity(),doc);
						svgRoot.appendChild(drawRect.paint());
					}		
				}
				if(mPathStart.find()){//parse tag of paths
					Pattern pPathEnd = Pattern.compile(">");
					Matcher mPathEnd = pPathEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line);
					while(!mPathEnd.find()){
						Line = reader.readLine();
						Sb.append(Line);
						mPathEnd = pPathEnd.matcher(Line);	
					}
					parsePath pp = new parsePath(Sb.toString());
					pp.parse();
					System.out.println(pp);
					if(!pp.getD().equals("none")){
					Path drawPath = new Path(pp.getD(),pp.getFill(),pp.getStroke(),pp.getStrokeWidth(),pp.getStrokeOpacity(),pp.getFillOpacity(),pp.getOpacity(),doc);
					svgRoot.appendChild(drawPath.paint());
					}
				}
				if(mCircleStart.find()){//parse tag of cricles
					Pattern pCircleEnd = Pattern.compile("/>");
					Matcher mCircleEnd = pCircleEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line);
					while(!mCircleEnd.find()){
						Line = reader.readLine();
						Sb.append(Line);
						mCircleEnd = pCircleEnd.matcher(Line);	
					}
					parseCircle pc = new parseCircle(Sb.toString());
					pc.parse();
					System.out.println(pc);
					if(!pc.getR().equals("0")){
						Circle drawCircle = new Circle(pc.getCx(),pc.getCy(),pc.getR(),pc.getFill(),pc.getStroke(),pc.getStrokeWidth(),pc.getStrokeOpacity(),pc.getStrokeOpacity(),pc.getOpacity(),doc);
						svgRoot.appendChild(drawCircle.paint());
					}
				}
				if(mEllipseStart.find()){//parse tag of ellipse
					Pattern pEllipseEnd = Pattern.compile("/>");
					Matcher mEllipseEnd = pEllipseEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line);
					while(!mEllipseEnd.find()){
						Line = reader.readLine();
						Sb.append(Line);
						mEllipseEnd = pEllipseEnd.matcher(Line);	
					}
					parseEllipse pe = new parseEllipse(Sb.toString());
					pe.parse();
					System.out.println(pe);
					if(!pe.getRx().equals("0")||!pe.getRy().equals("0")){
						Ellipse drawEllipse = new Ellipse(pe.getCx(),pe.getCy(),pe.getRx(),pe.getRy(),pe.getFill(),pe.getStroke(),pe.getStrokeWidth(),pe.getStrokeOpacity(),pe.getFillOpacity(),pe.getOpacity(),doc);
						svgRoot.appendChild(drawEllipse.paint());
					}
				}
				if(mLineStart.find()){//parse tag of lines
					Pattern pLineEnd = Pattern.compile("/>");
					Matcher mLineEnd = pLineEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line);
					while(!mLineEnd.find()){
						Line = reader.readLine();
						Sb.append(Line);
						mLineEnd = pLineEnd.matcher(Line);	
					}
					parseLine pl = new parseLine(Sb.toString());
					pl.parse();
					System.out.println(pl);
					if(!pl.getX1().equals("0")||!pl.getY1().equals("0")||!pl.getX2().equals("0")||!pl.getY2().equals("0")){
						Line drawLine = new Line(pl.getX1(),pl.getY1(),pl.getX2(),pl.getY2(),pl.getStroke(),pl.getStrokeWidth(),doc);
						svgRoot.appendChild(drawLine.paint());
					}
				}
				if(findPolygonStart||findPolylineStart){//parse tag of polygons or polylines
					Pattern pPolygonEnd = Pattern.compile("/>");
					Matcher mPolygonEnd = pPolygonEnd.matcher(Line);
					StringBuilder Sb = new StringBuilder("");
					Sb.append(Line);
					while(!mPolygonEnd.find()){
						Line = reader.readLine();
						Sb.append(Line);
						mPolygonEnd = pPolygonEnd.matcher(Line);	
					}
					parsePoly pPo = new parsePoly(Sb.toString());
					pPo.parse();			
					if(!pPo.getPoints().equals("none")){
						if(findPolygonStart){
							Polygon drawPolygon = new Polygon(pPo.getPoints(),pPo.getFill(),pPo.getStroke(),pPo.getStrokeWidth(),pPo.getStrokeOpacity(),pPo.getFillRule(),pPo.getFillOpacity(),pPo.getOpacity(),doc);
							svgRoot.appendChild(drawPolygon.paint());
						}else{
							Polyline drawPolyline = new Polyline(pPo.getPoints(),pPo.getFill(),pPo.getStroke(),pPo.getStrokeWidth(),pPo.getStrokeOpacity(),pPo.getFillRule(),pPo.getFillOpacity(),pPo.getOpacity(),doc);
						    svgRoot.appendChild(drawPolyline.paint());
						}
					}
				}
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