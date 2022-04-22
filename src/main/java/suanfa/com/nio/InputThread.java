package suanfa.com.nio;

import java.io.IOException;
import java.io.PipedInputStream;

public class InputThread implements Runnable{

    private PipedInputStream in;
    public InputThread(PipedInputStream in){
        this.in = in;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            byte[] buff = new byte[1024];
            int len = in.read(buff);
            String s = new String(buff,0,len);
            System.out.println(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
