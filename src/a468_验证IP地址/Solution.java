package a468_验证IP地址;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-11-04 02:10
 **/
public class Solution {

    public String validIPAddress(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (UnknownHostException e) {
        }
        return "Neither";
    }

}
