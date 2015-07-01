/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bharath
 */
public class msgsender extends Thread{
    String ipaddr,msg;
    int port;
    Socket s;
    public msgsender(String m,String x,int p) throws IOException
    {
        msg=m;
        ipaddr=x;
        port=p;
       
    }
    @Override
    public void run()
    {
        try 
        { 
            s=new Socket(ipaddr,port);
            s.getOutputStream().write(msg.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(msgsender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
