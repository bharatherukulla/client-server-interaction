/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bharath
 */
public class msgreceiver extends Thread{
    int port;
    ServerSocket ss;
    Socket s;
    gui g;
    String msg;
    windowinterface wi;
    public msgreceiver(windowinterface wi1,int p) throws IOException
    {
        port=p;
        ss=new ServerSocket(port);
        wi=wi1;
    }
    @Override
    public void run()
    {
        try {
            while((s=ss.accept())!=null)
            {
                InputStream is=s.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(is));
                msg=br.readLine();
                if((msg)!=null)
                {
                    wi.write(msg);
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(msgreceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException npe)
        {
            System.out.println("Port In Use....Try Using Other Ports\n");
        }
    }
    
}
