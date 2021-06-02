/* 
||====================================================================================||
||                                                                                    ||
|| \\                // ||====== ||       ||======  ||=======|| |\\    //|  ||======  ||
||  \\              //  ||       ||       ||        ||       || ||\\  //||  ||        ||
||   \\    //\\    //   ||=====  ||       ||        ||       || || \\// ||  ||=====   ||
||    \\  //  \\  //    ||       ||       ||        ||       || ||      ||  ||        ||
||     \\//    \\//     ||====== |======  ||======  ||=======|| ||      ||  ||======  ||
||                                                                                    ||
||====================================================================================||
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void read() throws IOException{
        FastReader scin = new FastReader(); 
        String passcode = "admin";
        System.out.print("Please Enter The Password: ");
        String pass = scin.next();
        if(passcode.equals(pass)){
            BufferedReader reader = new BufferedReader(new FileReader("/home/krishna/VS Code Java Projects/JAVA DATABASE/src/db.txt"));
            String st;
            System.out.println();
            while ((st = reader.readLine()) != null){
                System.out.println(st);
            }
            reader.close();
            start();
        }
        else{
            start();
        }
    }
    public static void start() throws IOException {
        FastReader scin = new FastReader();
        System.out.println("[read/READ][input/INPUT][anything to exit]");
        String s = scin.next();
        if(s.equals("READ")||s.equals("read")){
            read();
        }
        else if(s.equals("INPUT")||s.equals("input")){
            System.out.print("Person Name: ");
            String name = scin.nextLine();
            System.out.print("Person Age: ");
            int age = scin.nextInt();
            new Person(name, age);
        }
        else{
            System.out.println("EXIT!!");
            System.exit(0);
        }
    }
    public static void main(String[] args) throws IOException {
        String home = "||====================================================================================||\n||                                                                                    ||\n|| \\\\                // ||====== ||       ||======  ||=======|| |\\\\    //|  ||======  ||\n||  \\\\              //  ||       ||       ||        ||       || ||\\\\  //||  ||        ||\n||   \\\\    //\\\\    //   ||=====  ||       ||        ||       || || \\\\// ||  ||=====   ||\n||    \\\\  //  \\\\  //    ||       ||       ||        ||       || ||      ||  ||        ||\n||     \\\\//    \\\\//     ||====== |======  ||======  ||=======|| ||      ||  ||======  ||\n||                                                                                    ||\n||====================================================================================||\n";
        System.out.println(home);
        start();
    }    
}
class Person{
    static int count;
    Person(){
        count++;
        System.out.println("Person Has No Name");
    }
    String name;
    int age;
    Person(String name, int age) throws IOException{
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("/home/krishna/VS Code Java Projects/JAVA DATABASE/src/db.txt", true)));
        Scanner scin = new Scanner(System.in);
        System.out.println("--------NOTE--------");
        System.out.println("Person Name: "+name);
        System.out.println("Person Age: "+age);
        System.out.println("Do You Want To Save?[Y/y][RE/re][anything to exit]");
        String s = scin.next();
        if(s.equals("y")||s.equals("Y")){
            this.name = name;
            this.age = age;
            writer.println("---------------------");
            writer.println("Name: "+this.name);
            writer.println("Age: "+this.age);
            writer.println("Hashed Name: "+this.name.hashCode());
            writer.println("Hashed Age: "+this.name.hashCode());
            writer.println("---------------------");
            writer.close();
            System.out.println("Data Successfully Entered");
            Main.start();
            String in = scin.next();
            if(in.equals("Y")||in.equals("y")){
                Main.read();
            }
            else{
                System.exit(0);
            }
        }
        else if(s.equals("re")||s.equals("RE")){
            System.out.print("Rewrite Person Name: ");
            String name_re1 = scin.nextLine();
            String name_re = scin.nextLine();
            System.out.print("Rewrite Person Age: ");
            int age_re = Integer.valueOf(scin.nextLine());
            this.name = name_re;
            this.age = age_re;
            writer.println("---------------------");
            writer.println("Name: "+this.name);
            writer.println("Age: "+this.age);
            writer.println("Hashed Name: "+this.name.hashCode());
            writer.println("Hashed Age: "+this.name.hashCode());
            writer.println("---------------------");
            writer.close();
            System.out.println("Data Successfully Entered");
            Main.start();
        }
        else{
            System.out.println("EXIT!!");
            System.exit(0);
        }
        scin.close();
    }
}