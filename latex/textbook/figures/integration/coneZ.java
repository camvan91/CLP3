                  /*  File:  coneZ.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneZ extends Template {

     static {templateClass = new coneZ() ; }

     public void setup() {
          filePrefix = "coneZ" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      
          ysize = 2 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -30 ;
          ymax = 90 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double r = 30 ;
          double h = 50 ;
          double y = h ;
          double x = r*y/h ;
          double s2 = 2 ;
          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,h,x,x/3.0, CLOSED+FILLED) ;
          fEnv("lineWidth", 0.5) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fLine(0,h, 0,0) ;
          fTeXlabel(-1, h/2, "cr", "$h$") ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine(0,h, x, h) ; 
          fTeXlabel(x/2, h+1, "cb", "$a$") ;

          fLine(0,h, 0, 1.5*h) ; 
          fLine(0,0,1.5*x,0) ;
          fLine(0,0,-h/s2,-h/s2) ;

          fEnv("lineWidth", 1) ;
          y = h ; x = r*y/h ;
          fLine(0,0, -x,h) ;
          fLine(0,0, x,h) ;
          fTeXlabel(0, 1.5*h+0.6, "bc", "$z$") ;
          fTeXlabel(1.5*x+1, -0.8, "cl", "$y$") ;
          fTeXlabel(-h/s2-0.3, -h/s2-0.3, "tr", "$x$") ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(-1.5*x,0, 1.5*x,0) ;

     }
}
