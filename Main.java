import java.util.Scanner;
import java.io.*;


class Main{
    public static void main(String[] args) {
        Tree t = new Tree();

        try{
            String key = args[0];
            Scanner s = new Scanner(new File(args[1]));
            int trees = Integer.parseInt(args[2]);

            String[] ord = new String[s.nextInt()];
            s.nextLine();
            int antallOrd = ord.length;
            int teller = 0;
            while(s.hasNext()){
                ord[teller++] = s.nextLine();
            }
            int a = 0;
            int b = antallOrd / trees;

            int c = b;

            for(int i = 1; i <= trees; i++){
                if(i == trees){b = antallOrd -1;}
                t.tre(a,b);
                a = b+1;
                b= b+c;
            }


            System.out.println("Key: " +key+"  treees: "+trees+" Numer of lines:  " +antallOrd);

        }catch (FileNotFoundException e){System.out.println("File Not Found");}



    }
}
class Tree{

    public void tre(int a, int b){
        System.out.println("Read from;  "+a+" to : " +b);

    }
}