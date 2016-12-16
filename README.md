# CPE810J_2016F_XDF
# XdfPrint
This is the print part of CPE810J project

@author Alex Qu

It include printer setup part and background service.

11/3/2016 create the basic frame of the class.

11/4/2016 put a small dialog sample in GUI class

11/11/2016 change the class method put a test printer class in it

In last week we changed our class method. since we should not convert Pdf to Ps, we remove it from service class. 
To replace of convert part, we added two methods: convertTxt2Ps, convertImg2Ps. The first method is to convert string to ps format.
The second is to convert image to ps. And we may add a layout control method to put string and image on right place.
We finished the setup Gui and printer service part but there is still a problem we should delivery the setup information to service part.
we will fix it later. Next weed our group will work individually I had assigned our task, one for convert string to ps, 
one for convert image to ps, the last one make a layout control. In addition, I will fix the connection of setup gui and service.

11/11/2016
Did a print test to make sure that the file could be printed out and could choose printer. Convert the image to Ps is the next to do.
11/18/2016
Make the image formats convert to eps format.

public abstract class Shape

It's the basic class that decide all the graph.

public class Circle 
extends Shape

constructor

Circle(String x,String y,String r, String color, String strokeWidth)

x,y are the variable that decide where the center should be.
r is the radius.
color decide the circle fill in the circle.
strokeWith is the stroke of the line.

Notice that the color must be 3 variable that decide the rgb color each of their value should range in 0 to 1.  

example  Circle c = new Circle("400","720","30","0.1 1 0.1","4");

method 

paint()

when decided the parameter of the graph, deploying this method to draw it.

public class Ellipse
extends Shape

constructor

Ellipse(String x, String y, String x1, String y1, String x2, String y2, String x3, String y3, String color, String strokeWidth)

x,y,x1,y1,x2,y2,x3,y3 are the variable that the four points of the edge of ellipse.
color decide the circle fill in the shape.
strokeWith is the stroke of the line.

method 

paint()

when decided the parameter of the graph, deploying this method to draw it.

public class Line
extends shape

constructor

Line (String x,String y,String LastX, String LastY,String color,String strokeWidth)

x,y LastX,LastY are two point that the line start and finish.
color is the line's color

method 

paint()

when decided the parameter of the graph, deploying this method to draw it.

public class Rect

constructor

Rect (String x,String y,String LastX, String LastY,String color,String lineColor, String strokeWidth)

x,y LastX,LastY are two points that be the diagonal points of the rectangle.

method 

paint()

when decided the parameter of the graph, deploying this method to draw it.

public class printcode

It's the class that create the print job, use new in the main function. It will create a dialog of the print setup.

public class Text

constructor 

Text (String text,String font,String x, String y,String fontsize, String color)

text is the content that users want to put in.