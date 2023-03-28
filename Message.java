import java.util.Queue;

public class Message {
    public Queue<Node> priorityQueue;
    public int clock;
    public int src;
    public int dest;
    public String messageType="";
    public String temp;
    public Message(int clock, int src, int dest, String messageType){
        this.clock=clock;
        this.src = src;
        this.dest = dest;
        this.messageType = messageType;
       
    }

    public int getSrc(){
        return this.src;
    }
    public int getDest(){
        return this.dest;
    }
    public String getMessageType(){
    
        return this.messageType;
    }

    public void sendRequest(Node a, Node b){

    }

    public void reply(Node a, Node b ){

    }

    public void release(Node a){

    }
    public int getClock(){
        return this.clock;
 
 
 
    }


    
    public static void main(String[] args) {
        Clock clock = new Clock();


        Message msg = new Message(2,3,4,"REQUEST");
        // clock.event(msg);

        System.out.println(msg.temp);
        
        // clock.msgEvent(msg);
        System.out.println(clock.clock+","+ msg.src+","+msg.dest+","+msg.messageType);
    }

}
