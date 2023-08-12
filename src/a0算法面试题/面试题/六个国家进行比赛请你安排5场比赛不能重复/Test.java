package a0算法面试题.面试题.六个国家进行比赛请你安排5场比赛不能重复;

/*
 https://www.yuque.com/gaohanghang/sgrbwh/mgpxxq
 */
public class Test {
    public static void main(String[] args) {
        String[] team={"日本","韩国","英国","巴西","法国","中国"};
        for(int i=0;i<team.length-1;i++){
            System.out.println("第"+(i+1)+"场比赛：");
            System.out.println(team[0]+"=========="+team[5]);
            System.out.println(team[1]+"=========="+team[4]);
            System.out.println(team[2]+"=========="+team[3]);
            String last=team[5];
            for(int j=5;j>0;j--){
                team[j]=team[j-1];
            }
            team[1]=last;
        }
    }

}
