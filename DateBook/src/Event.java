/**
 * Created by control on 2016/10/8.
 */
public class Event {
    private int day;
    private String beginTime;
    private String eventName;
    private int priority;
    public Event(int day,String beginTime,String eventName,int priority){
        this.day = day;
        this.beginTime = beginTime;
        this.eventName = eventName;
        this.priority = priority;

    }
    public int getDay(){
        return day;
    }
    public String getBeginTime(){
        return beginTime;
    }
    public String getEventName(){
        return eventName;
    }
    public int getPriority(){
        return priority;
    }
    @Override
    public String toString(){
        return day+": "+beginTime+":"+" Event "+eventName+" (priority "+priority+")";
    }
}
