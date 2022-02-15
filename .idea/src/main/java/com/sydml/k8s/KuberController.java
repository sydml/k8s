package com.sydml.k8s;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.time.LocalDateTime;
import java.util.Enumeration;

/**
 * @author liuyuming
 * @date 2021-10-13 9:51:43
 */
@RestController
public class KuberController {
    @GetMapping
    public String helloK8s(){
        return getLocalIp() + " hello k8s =====> " + LocalDateTime.now().toString();
    }
    public static String getLocalIp() {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if("lo".equals(netInterface.getName())){
                    continue;
                }
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements())
                {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address)
                    {
                        return ip.getHostAddress();
                    }
                }
            }

            return  null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }
}
