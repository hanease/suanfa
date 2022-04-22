package suanfa.com.nio;

import java.io.IOException;
import java.io.PipedOutputStream;

public class OutputThread implements Runnable {
    private PipedOutputStream out;
    public OutputThread(PipedOutputStream out){
        this.out = out;
    }

    @Override
    public void run() {
        String str = "hello Piped!";
        try {
            out.write(str.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
