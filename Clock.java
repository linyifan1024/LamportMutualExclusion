

public class Clock {
    public int clock;
    public int duration=1;

    public Clock(int duration){
        this.duration = duration;
        clock = 0;
        
    }

    public Clock(){
        clock=0;
    }
    public int getClock(){
        return clock;
    }

    public void increment(){
        clock+=duration;
    }

    public void event(Message message){

        increment();

        if (message.getClock()+duration>clock){
            clock = message.getClock()+duration;
        }
    }



    public static void main(String[] args) {
        Clock clock = new Clock();


        Message msg = new Message(2,3,4,"REQUEST");
        clock.event(msg);

        
        // clock.msgEvent(msg);
        System.out.println(clock.clock+","+ msg.src+","+msg.dest+","+msg.messageType);
    }



}
