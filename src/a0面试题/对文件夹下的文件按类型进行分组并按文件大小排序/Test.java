package a0面试题.对文件夹下的文件按类型进行分组并按文件大小排序;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统计一个不固定深度的文件夹下的所有文件类型，对文件夹下的文件按类型进行分组并按文件大小排序。比如文件夹下面有 txt，doc类型的文件，就先按txt，doc类型分组，每组再按文件大小降序排列
 *
 * @author ashutosh
 */
public class Test {

    static List<MyFile> myFileList = new ArrayList<>();

    public void readFile(File f) {

        // 文件名
        String name = f.getName();

        // 后缀
        int i = name.lastIndexOf(".");
        String suffix = name.substring(i + 1);

        // 目录名
        String path = f.getPath();

        // 文件大小
        long length = f.length();

        MyFile myFile = new MyFile();
        myFile.setName(name);
        myFile.setSuffix(suffix);
        myFile.setPath(path);
        myFile.setLength(length);

        myFileList.add(myFile);
    }

    public void readDir(File f) {
        File subdir[] = f.listFiles();
        for (File f_arr : subdir) {
            if (f_arr.isFile()) {
                this.readFile(f_arr);
            }
            if (f_arr.isDirectory()) {
                this.readDir(f_arr);
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        File mainDir = new File("/Users/gaohanghang/vant");
        test.readDir(mainDir);

        System.out.println(myFileList);

        // 按文件类型分组
        Map<String, List<MyFile>> collect = myFileList.stream().collect(Collectors.groupingBy(MyFile::getSuffix));

        for (Map.Entry<String, List<MyFile>> entry : collect.entrySet()) {
            // 按文件大小排序
            List<MyFile> collect1 = entry.getValue().stream().sorted(Comparator.comparing(MyFile::getLength).reversed()).collect(Collectors.toList());
            System.out.println(entry.getKey());
            System.out.println(collect1);
        }

    }

}
