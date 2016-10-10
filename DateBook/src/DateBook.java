import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by control on 2016/10/8.
 */
public class DateBook {
    public static String weekdays[] = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    final static int september = 30;
    final static int october = 31;

    Random ran = new Random();
    public String generateRamdonStartTime(){
        String flag[]={"AM","PM"};//represent am or pm
        int hour = ran.nextInt(12)+1;
        int minute = ran.nextInt(59)+1;
        int f = ran.nextInt(2);
        return String.valueOf(hour)+":"+String.valueOf(minute)+" "+flag[f];
    }
    public String generateRamdonEventName(){
        String eventName[]={"play","sleep","eat","drink","work","fuck","rest","talk"};
        return eventName[ran.nextInt(8)];
    }
    public Event[] generateEvents(int days){
        int eventsnum = 10;//generate 10 events
        int day,prio;
        Event events [] =new Event[days];
        for (int i = 0; i < eventsnum; i++) {
            day = ran.nextInt(days);
            while (events[day]!=null){
                day = ran.nextInt(days);
            }
            prio=ran.nextInt(3)+1;
            events[day] = new Event(day+1,generateRamdonStartTime(),generateRamdonEventName(),prio);
        }
        return events;
    }



    public static void outputCalenderView(Event e[],int firstDayofMonth,int days){

        for(String s:weekdays){
            System.out.print(s+"\t");
        }
        System.out.println();
        int i=0;
        int count=0;
        while (i<days){
            while (firstDayofMonth>1){
                System.out.print("\t");
                firstDayofMonth--;
                count++;
            }
            if (count%7==0&&count!=0){
                System.out.println();
            }
            if (e[i] == null)
                System.out.print(i+1+"\t");
            else
                System.out.print(i+1+"*"+"\t");
            i++;
            count++;
        }

    }
    public static void outputEventView(Event e[]){
        System.out.println("Events:");
        for (int i = 0; i < e.length; i++) {
            if (e[i]!=null){
                System.out.println(e[i].toString());
            }
        }
    }
    public static void outputPriorityView(Event e[]){
        System.out.println("High-priority events:");
        for (int i = 0; i < e.length; i++) {
            if (e[i]!=null){
                if (e[i].getPriority() == 3){
                    System.out.println(e[i].getDay()+": Event "+e[i].getEventName());
                }
            }
        }
    }

    public static void main(String[] args) {
        int ran = (int)(Math.random()*6)+1;
        Event sep[];
        DateBook dateBook = new DateBook();
        sep = dateBook.generateEvents(september);
        System.out.println("----------------SEP-------------------");
        DateBook.outputCalenderView(sep,ran,september);
        System.out.println();
        DateBook.outputEventView(sep);
        DateBook.outputPriorityView(sep);

        System.out.println("----------------OCT-------------------");
        Event oct[];
        oct = dateBook.generateEvents(october);
        int firstday = (30+ran)%7;
        DateBook.outputCalenderView(oct,firstday,october);
        System.out.println();
        DateBook.outputEventView(oct);
        DateBook.outputPriorityView(oct);
    }
}
