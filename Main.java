import java.util.Scanner;
import java.io.*;

class Main{
    public static void main(String[] args) {

        Read r = new Read();
        String key = args[0];
        String[] ord = r.readFile(args[1]);
        int trees = Integer.parseInt(args[2]);
        int antallOrd = r.antOrd();

        int a = 0;
        int b = antallOrd / trees;
        int c = b;
        int antF=0;
        Traad[] th = new Traad[trees];

        for(int i = 0; i < trees; i++){
            if(i == trees){b = antallOrd -1;}
            th[i] = new Traad(a,b,antallOrd,ord,key,Thread.currentThread());
            th[i].start();
            a = b+1;
            b = b+c;
        }
        try{
            for(int i = 0; i < trees; i++){
                th[i].join();
                antF = antF + th[i].ant();
            }
        }catch(InterruptedException e){System.out.println("Wait error");}

        System.out.println("\t Key: " +key+"\n\t Threads: "+trees+"\n\t Numer of lines: " +antallOrd+
			   "\n\t\t Found key " +antF+" times");
    }
}

class Traad extends Thread{
    private int a,b,max,tell;
    private String key;
    String[] o;
    Thread t;
    public Traad(int a, int b, int m, String[] o, String key, Thread t){
        this.a = a;
        this.b = b;
        this.max = m-1;
        this.o = o;
        this.key = key;
        this.t = t;
    }
    public void run(){
        for(int i = a; i <= b; i++){
            if(key.equals(o[i])){
                tell = tell + 1;
            }
        }
    }
    public int ant(){
        return tell;
    }
}
class Read{
    private int lines,teller = 0;
    public String[] readFile(String fileName){
        try{
            Scanner s = new Scanner(new File(fileName));

            lines = s.nextInt();
            String[] ord = new String[lines];
            s.nextLine();

            while(s.hasNext()){
                ord[teller++] = s.nextLine();
            }
            return ord;
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
	    System.exit(1);
            return null;
        }
    }
    public int antOrd(){
        return lines;
    }
}
