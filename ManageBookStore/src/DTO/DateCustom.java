
package DTO;

public class DateCustom {
   private int day,month,year;
    
    public DateCustom(){}// to Easy for Scan
    public DateCustom(int d,int m,int y){
        day=d; 
         month=m;
           year=y;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    private int checkYear(int year) 
    { 
        if (year % 400 == 0) 
            return 1; 
        if (year % 4 == 0 && year % 100 != 0) 
            return 1;
        
        return 0; 
    }

    public void setDate(){
      
        if(month >=1 && month<=12 ) { this.month=month;
        } else System.out.println("Invalid month!");
            
       
        if(year>=1900 && year<=9999 ) {this.year=year;
        } else  System.out.println("Invalid year!");
        
    if(checkYear(year)==1)   
    {
        if(day==29 && month==2 )this.day=day;
        else System.out.println("Invalid day!");
    }
    else
    {
         if(month==2 && 1<=day && day<=28 )this.day=day;
        else System.out.println("Invalid day!");
    }
   
    if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
    {
        if(1<=day && day<=31) this.day=day;
        else System.out.println("Invalid day!");
    }
    if(month==4||month==6||month==9||month==11)
    {
        if(1<=day && day<=30)this.day=day;
        else System.out.println("Invalid day!");
    }
    
}   public int CompareTo(DateCustom d2){
        if(year > d2.year) return 1;
        else if (year==d2.year){
                if(month > d2.month) 
                    return 1;
                else if(month == d2.month ) {
                        if(day > d2.day  ) return 1;
                        else if( day == d2.day) return 0;
                        else return -1;
                }
                else return -1;           
        }
        else    return -1;
   
    }
public static int CompareTo(DateCustom d1,DateCustom d2){
        if(d1.year > d2.year) return 1;
        else if (d1.year==d2.year){
                if(d1.month > d2.month) 
                    return 1;
                else if(d1.month == d2.month ) {
                        if(d1.day > d2.day  ) return 1;
                        else if( d1.day == d2.day) return 0;
                        else return -1;
                }
                else return -1;           
        }
        else    return -1;
   
    }


      
        
      
    @Override
    public String toString()
    {
        return day+ "/" +month+"/"+year;    }
            
}
