package com.imnu.SchoolBus.controller;

import java.io.*;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {
	
	@GetMapping("/content")
    public String Index(Map <String, Object> map){
        // 获取访问量信息
        String txtFilePath = "D://count.txt";
        Long count = Get_Visit_Count(txtFilePath);
        System.out.println(count);
        map.put("count", count); // 后台参数传递给前端

        return "user/content";
    }

    /*
     * 获取txt文件中的数字，即之前的访问量
     * 传入参数为： 字符串: txtFilePath,文件的绝对路径
     */
    public static Long Get_Visit_Count(String txtFilePath) {

        try {
            //读取文件(字符流)
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(txtFilePath),"UTF-8"));
            //循环读取数据
            String str = null;
            StringBuffer content = new StringBuffer();
            while ((str = in.readLine()) != null) {
                content.append(str);
            }
            //关闭流
            in.close();

            //System.out.println(content);
            // 解析获取的数据
            Long count = Long.valueOf(content.toString());
            count ++; // 访问量加1
            //写入相应的文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFilePath),"UTF-8"));
            out.write(String.valueOf(count));

            //清楚缓存
            out.flush();
            //关闭流
            out.close();

            return count;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0L;
        }


    }

}
