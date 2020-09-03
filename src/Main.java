import java.util.Scanner;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-09-01 12:51
 **/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            //String  str = "/a/b/../c/./d";
            // 处理 ../
            String replace1 = str.replace("", "");

            // 处理 ./
            String replace2 = replace1.replace("./", "");
            System.out.println(replace2);
        }

    }

}
