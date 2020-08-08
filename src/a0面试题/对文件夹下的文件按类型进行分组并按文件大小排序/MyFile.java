package a0面试题.对文件夹下的文件按类型进行分组并按文件大小排序;

import java.util.Objects;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-08 15:36
 **/
public class MyFile {

    private String name;
    private String suffix;
    private String path;
    private long length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFile myFile = (MyFile) o;
        return length == myFile.length &&
                Objects.equals(name, myFile.name) &&
                Objects.equals(suffix, myFile.suffix) &&
                Objects.equals(path, myFile.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, suffix, path, length);
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "name='" + name + '\'' +
                ", suffix='" + suffix + '\'' +
                ", path='" + path + '\'' +
                ", length=" + length +
                '}';
    }

}
