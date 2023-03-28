import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Lamport {
    public int clock;
    int node_id;
    int Num_node;
    boolean in_CS;
    boolean request_sent_to_all=false;
    boolean reply_received_from_all=false;
    int request_delay;
    int cs_excute_time;
    int max_request;
    int [] timestamp;
    boolean active;
    String config_file = "";
    HashMap<Integer, Node> node_list = new HashMap<>();
    HashMap<Node, ArrayList<Node>> neighbor_list = new HashMap<>();
    public Lamport(int node_id, String config_filename){
        this.node_id= node_id;
        active = false;
        // config_file = config_filename.split(".txt")[0];

        readConfig(config_filename);
    }

    private void readConfig(String configFilename){
        try{
            File config = new File(configFilename);
            Scanner scanner = new Scanner(config);
            int valid_line_counter = 0;
            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                
                
                if(line.length()>0 && Character.isDigit(line.charAt(0))){
                    // this is a valid line
                    // System.out.println(line);
                    valid_line_counter++;
                    line = line.split("#")[0].trim();
                    if(valid_line_counter==1){
                        // read global variable
                        String[] global_var = line.split(" ");
                        this.Num_node = Integer.parseInt(global_var[0]);
                        this.request_delay = Integer.parseInt(global_var[1]);
                        this.cs_excute_time = Integer.parseInt(global_var[2]);
                        this.max_request = Integer.parseInt(global_var[3]);
                    }
                    else if(valid_line_counter>1 && valid_line_counter<=Num_node+1){
                        // read node information
                        System.out.println(line);
                         String[] node_info = line.split(" ");
                         int id = Integer.parseInt(node_info[0]);
                         String host = node_info[1];
                         int port = Integer.parseInt(node_info[2]);
                         node_list.put(id, new Node(id,host,port));
                         neighbor_list.put(node_list.get(id), new ArrayList<Node>());
                        //  System.out.println(neighbor_list);
                    }   
                }
            }
            scanner.close();
        }catch(Exception e){
            System.out.println("Something went wrong when reading config file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Lamport lamport = new Lamport(0, "config.txt");
        // lamport.readConfig("config.txt");
    }


}
