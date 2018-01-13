import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Scanner;


public class CalGraph  extends JPanel{
    public static final int BOX_WIDTH = 1400;
    public static final int BOX_HEIGHT = 800;
    
  
    
    public CalGraph(){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }
    
   
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);            
        
	//this makes the color behind the skeleton of the calendar     
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

	
	//also, I need to edit the paintMonth(String s) method to be a paintDay(String s) method so that I call it for each individual day as I go through and make the Strings for the day of the  week with the date and month and such 

	    
	

	String startDow = ScheduleDates.getStartDow();
        int startD = ScheduleDates.getStartD();
        int startM = ScheduleDates.getStartM();
        int startY = ScheduleDates.getStartY();
	    
	String endDow = ScheduleDates.getEndDow();
        int endD = ScheduleDates.getEndD();
        int endM = ScheduleDates.getEndM();
        int endY = ScheduleDates.getEndY();
	    
	//startDow means 1 = sun, 2=mon, 3=tues, etc.
        int startDowInt = getDowInt(startDow); 
	String startMstring = getMstring(startM);
	String endMstring = getMstring(endM);
	int changeAt = getDaysInM(startM, startY);
	

	
       	paintMonth(g, endMstring);

	paintCalSkeleton(g);
	
	paintDateStrings(g, startDowInt, startM, startMstring, changeAt, startD, startDow, startY, endM, endD, endY);


	    
	//These lines give us an array list of shifts by using the getSortedShifts method in algorithmACEMS for each rank
	AlgorithmACEMS.defineAllPointedMembers();
	ArrayList<Member> sortedShifts10= new ArrayList<Member>();
	ArrayList<Member> sortedShifts12= new ArrayList<Member>();
	ArrayList<Member> sortedShifts13= new ArrayList<Member>();
	ArrayList<Shift> allShifts1 = new ArrayList<Shift>();
	Shift temp;
	
        sortedShifts10 = AlgorithmACEMS.getSortedShifts(startDow,"10");
	sortedShifts12 = AlgorithmACEMS.getSortedShifts(startDow,"12");
	sortedShifts13 = AlgorithmACEMS.getSortedShifts(startDow,"13");
	for(int i = 0; i < sortedShifts10.size(); i++) {
		temp = new Shift(sortedShifts10.get(i),sortedShifts12.get(i),sortedShifts13.get(i));
		allShifts1.add(temp);
	}
	    
	
	

	printShifts(g, allShifts1, startDowInt);
    
    }
   

    public static void paintMonth(Graphics g, String month){

	//I used this website to learn how to make new colors (so cool!!) http://www.otherwise.com/Lessons/ColorsInJava.html
		
       	if(month.equals("September")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.YELLOW);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.YELLOW);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
         }
	    
      	if(month.equals("October")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.ORANGE);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.ORANGE);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.ORANGE);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.ORANGE);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	}
	
	if(month.equals("November")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.RED);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.RED);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.ORANGE);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	}

	if(month.equals("December")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.WHITE);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.WHITE);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.WHITE);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.BLUE);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.BLUE);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	 }

	  if(month.equals("February")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.PINK);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.PINK);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.PINK);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.RED);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.RED);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.RED);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	  }
	
	  if(month.equals("March")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.GREEN);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.GREEN);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.GREEN);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.GREEN);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	  }
 
	  if(month.equals("April")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.GREEN);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.YELLOW);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.PINK);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.GREEN);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.PINK);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	 }

      }

    public static void paintCalSkeleton(Graphics g){

	//draw skeleton for the calendar
	for(int i = 0; i < 41; i++){
	    g.setColor(Color.GRAY);
	    g.drawLine(0, 40+19*i, 1150, 40+19*i);	    
	}	
	for(int j = 0; j < 8; j++){
		g.setColor(Color.GRAY);
		g.drawLine(100+150*j , 40, 100+150*j , 800);
	}

	//draw  Med 10,12,13 labels on the left side
	for(int i = 0; i < 5; i++){
	    g.setColor(Color.BLACK);
	    g.drawString("Med-10 AM", 20, 76 + 152*i);
	    g.drawString("Med-12 AM", 20, 95 + 152*i);
	    g.drawString("Med-13 AM", 20, 114 + 152*i);

	    g.drawString("Med-10 PM", 20, 133 + 152*i);
	    g.drawString("Med-12 PM", 20, 152 + 152*i);
	    g.drawString("Med-13 PM", 20, 171 + 152*i);    
	}

	//draw black rectangle rows seperating weeks
	for(int i = 0; i < 5; i++){
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 173 +152*i, 1150, 19);
	}

    }

    public static void paintDateStrings(Graphics g, int startDowInt, int startM, String startMstring, int changeAt, int startD, String startDow, int startY, int endM, int endD, int endY){

	   int daysInSched = 0;
	   daysInSched = (changeAt - startD) + endD;        
	
	   int j = 0;
	   int currentDom = startD;
	   for(int i = 0; i < (daysInSched+1); i++){
	       
	       
	       if( (i + startDowInt)%7== 1){
	       g.setColor(Color.BLACK);
	       g.drawString("Sun. "+startMstring + " "+currentDom, 110, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 2){
	       g.setColor(Color.BLACK);
	       g.drawString("Mon. "+startMstring + " "+currentDom, 260, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 3){
	       g.setColor(Color.BLACK);
	       g.drawString("Tue. "+startMstring + " "+currentDom, 410, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 4){
	       g.setColor(Color.BLACK);
	       g.drawString("Wed. "+startMstring + " "+currentDom, 560, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 5){
	       g.setColor(Color.BLACK);
	       g.drawString("Thu. "+startMstring + " "+currentDom, 710, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 6){
	       g.setColor(Color.BLACK);
	       g.drawString("Fri. "+startMstring + " "+currentDom, 860, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 0){
	       g.setColor(Color.BLACK);
	       g.drawString("Sat. "+startMstring + " "+currentDom, 1010, 57+152*j);
	       currentDom++;
	       j+=1;
	       }

	       if(currentDom ==(changeAt+1) ){
		   currentDom = 1;
		   
		   //This boolean makes it so that the month does not hcange from December to January to Frebruary, instead it just changes from December to January and that is all
		   boolean alreadyChanged = false;
		       
		   if(startMstring.equals("December")){
		       startMstring = "January";
		       alreadyChanged = true;
		   }
		   if(startMstring.equals("November"))
		       startMstring = "December";
		   if(startMstring.equals("October"))
		       startMstring = "November";
		   if(startMstring.equals("September"))
		       startMstring = "October";
		   if(startMstring.equals("August"))
		       startMstring = "September";
		   if(startMstring.equals("July"))
		       startMstring = "August";
		   if(startMstring.equals("June"))
		       startMstring = "July";
		   if(startMstring.equals("May"))
		       startMstring = "June";
		   if(startMstring.equals("April"))
		       startMstring = "May";
		   if(startMstring.equals("March"))
		       startMstring = "April";
		   if(startMstring.equals("February"))
		       startMstring = "March";		
		   if(startMstring.equals("January") && !alreadyChanged)
		       startMstring = "February";		  		 
		   
	       }


	   }

	
	   

    }
    
    public static void printShifts(Graphics g, ArrayList<Shift> joshList, int startDowInt){

	//for this program, this works assuming that the schedule start on an AM shift every time
	int j = 0;
	int ampm = 2;
	for(int i = 0; i < joshList.size(); i++){



	    if( (ampm % 2) == 0){
	       g.setColor(Color.BLACK);
	       g.drawString( joshList.get(i).getMed10() , 120+ (150* (startDowInt-1) ) , 76+152*j);

	       g.setColor(Color.BLACK);
	        g.drawString( joshList.get(i).getMed12() , 120+ (150* (startDowInt-1) ) , 95+152*j);

	       g.setColor(Color.BLACK);
	        g.drawString( joshList.get(i).getMed13() , 120+ (150* (startDowInt-1) ) , 114+152*j);
	      
			      
	       ampm++;
	    }

	   else{
	       g.setColor(Color.BLACK);
	       g.drawString( joshList.get(i).getMed10() , 120+ (150* (startDowInt-1) ) , 133+152*j);

	       g.setColor(Color.BLACK);
	        g.drawString( joshList.get(i).getMed12() , 120+ (150* (startDowInt-1) ) ,152+152*j);

	       g.setColor(Color.BLACK);
	       g.drawString( joshList.get(i).getMed13() , 120+ (150* (startDowInt-1) ) , 171+152*j);

	       
	       ampm++;
	       startDowInt++;
		
	    }


	       

	      
	       
	       if(startDowInt==8){
		   j++;
		   startDowInt = 1;
	       }
	}

    }
    
   public static int getDowInt(String stringDow){
	  int dow = 0;
	   if(stringDow.equals("Sunday") ){
		   dow = 1;
	   }
	   if(stringDow.equals("Monday") ){
		   dow = 2;
	   }
	   if(stringDow.equals("Tuesday") ){
		   dow = 3;
	   }
	   if(stringDow.equals("Wednesday") ){
		   dow = 4;
	   }
	   if(stringDow.equals("Thursday") ){
		   dow = 5;
	   }
	   if(stringDow.equals("Friday") ){
		   dow = 6;
	   }
	   if(stringDow.equals("Saturday") ){
		   dow = 7;
	   }
	   
	   return dow;
   }

	
	
	public static String getMstring(int startM){
		String startMstring = "";
		
		if(startM==1){
	   	startMstring = "January";
		}
		if(startM==2){
          	 startMstring = "February";
		}
		if(startM==3){
           	startMstring = "March";
		}
     	 	if(startM==4){
	 	startMstring = "April";
		}
        	if(startM==5){
	   	startMstring = "May";	
		}
        	if(startM==6){
	   	startMstring = "June";	
		}
		if(startM==7){
	        startMstring = "July";	
		}
      	        if(startM==8){
	        startMstring = "August";	
		}
		if(startM==9){
	   	startMstring = "September";	
		}
        	if(startM==10){
	        startMstring = "October";	
		}
        	if(startM==11){
	 	startMstring = "November";	
		}
		if(startM==12){
	  	startMstring = "December";	
		}
	return startMstring;	
		
	}
	
	public static int getDaysInM(int startM, int y){
		int changeAt = 0;
		
		if(startM==1){
	   	changeAt = 31;
		}
		if(startM==2){
          	changeAt = 31;
			if( (y + 2016)%4 ==0 ){
	        	changeAt = 29;
			}
		}
		if(startM==3){
           	changeAt = 31;
		}
     	 	if(startM==4){
	 	changeAt = 30;
		}
        	if(startM==5){
	   	changeAt = 31;	
		}
        	if(startM==6){
	   	changeAt = 30;	
		}
		if(startM==7){
	        changeAt = 31;	
		}
      	        if(startM==8){
	        changeAt = 31;	
		}
		if(startM==9){
	   	changeAt = 30;	
		}
        	if(startM==10){
	        changeAt = 31;	
		}
        	if(startM==11){
	 	changeAt = 30;	
		}
		if(startM==12){
	  	changeAt = 31;	
		}
			
		return changeAt;
	}
	
	
	
    

     public static void main(String args[]){
        JFrame frame = new JFrame("DrawToScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CalGraph());
        frame.pack();
        frame.setVisible(true);
    }

    
}
