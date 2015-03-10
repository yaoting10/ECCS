import com.google.common.collect.Lists;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.net.SocketPermission;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with Test
 * User : Ting.Yao
 * Date : 2014/12/11.
 */
public class Test {
    public static void main(String[] args){
        String old = "hello world %n";
        String newStr = String.format(old, 1);
        System.out.println(newStr);

        List<String> list = Lists.newArrayList("yyy","hello");
/*
        List<String> l = Arrays.asList("1","2","3");
         l.stream()
                .map(e -> new Integer(e))
                .distinct()
                .reduce(0, (x,y) -> x+y); // equivalent to .sum()*/
        /*list.forEach(System.out::println);*/
       /* Map map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);*/
        List<String> list2 = new ArrayList<>();
        list.stream().filter(x -> x.equals("yyy"));
        list.forEach(System.out::println);

        String s = "MobileOrderResult [orderId=123213123213213, tradeNo=null, respCode=null, respMsg=系统出现异常]";
        String result = s.substring(s.indexOf("tradeNo"), s.indexOf(", respCode"));
        String [] tradeNo = result.split("=");
        if(tradeNo[1].equals("null"))
            System.out.println(tradeNo[1]);
        System.out.println("ok");
    }
}
