Import PDF Group:

Author:Ashutosh Gajankush, Xiaolu Wang and Yue Fang

Responsibilities:

1. Parse through the PDF file to Extract the required data from it.
2. Data includes Text and Image.

Google doc:
https://docs.google.com/document/d/179vrcB70IQ0TEsmw5ytlIfXFNVNaG5fc8qRVNTtpm_g/edit?ts=581bcf8f#

Downloading PDFBox library jar file:

http://mirrors.gigenet.com/apache/pdfbox/2.0.3/pdfbox-app-2.0.3.jar(pdfbox)
http://www.java2s.com/Code/Jar/p/Downloadpdfbox131jar.htm(PDFobjectImage)
https://pdfbox.apache.org/download.cgi(pdfbox tools)
https://pdfbox.apache.org/download.cgi

Information to add this library to your code:
1. Right Click on your project Folder in Eclipse.
2. Select "Properties".
3. On the left pane select "Java Build Path"
4. Go to "Libraries" pane and select "Add External JARS.."
5. Locate the downloaded Library.
6. Click "Apply" and "OK" you are good to go.


We successfully extarcted text and image from the PDF file, but the output is text in bulk and images in bulk. Now we are trying to extarct the extract all the contents for a pdf file.
ConvertToByteArray class converts the Image extarcted into a byte array, further we will try to convert the whole pdf file into byte array.
