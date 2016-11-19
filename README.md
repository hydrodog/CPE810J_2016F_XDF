# CPE810J_2016F_XDF
# XdfPrint
This is the print part of CPE810J project

@author Alex Qu

It include printer setup part and background service.

V0.0.1 11/3/2016 create the basic frame of the class.

V0.0.2 11/4/2016 put a small dialog sample in GUI class

V0.0.3 11/11/2016 change the class method put a test printer class in it

In last week we changed our class method. since we should not convert Pdf to Ps, we remove it from service class. 
To replace of convert part, we added two methods: convertTxt2Ps, convertImg2Ps. The first method is to convert string to ps format.
The second is to convert image to ps. And we may add a layout control method to put string and image on right place.
We finished the setup Gui and printer service part but there is still a problem we should delivery the setup information to service part.
we will fix it later. Next weed our group will work individually I had assigned our task, one for convert string to ps, 
one for convert image to ps, the last one make a layout control. In addition, I will fix the connection of setup gui and service.

@author Zhe Wang
11/11/2016
Did a print test to make sure that the file could be printed out and could choose printer. Convert the image to Ps is the next to do.
11/18/2016
Make the image formats convert to eps format.
