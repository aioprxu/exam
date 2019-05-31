//package com.xiaour.spring.boot.utils;
//
//import freemarker.template.Configuration;
//import freemarker.template.TemplateException;
//
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class WordTest {
//    private Configuration configuration = null;
//
//    public WordTest() {
//        configuration = new Configuration();
//        configuration.setDefaultEncoding("UTF-8");
//    }
//
//    public static void main(String[] args) {
//        WordTest test = new WordTest();
//        test.createWord();
//    }
//
//    public void createWord() {
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        getData(dataMap);
//        //模板文件所在路径
////        configuration.setClassForTemplateLoading(this.getClass(), "");
//        try {
//            configuration.setDirectoryForTemplateLoading(new File("D:\\workspace\\exam\\src\\main\\resources\\template"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        freemarker.template.Template t = null;
//        try {
//            //获取模板文件
//            t = configuration.getTemplate("test.ftl");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //导出文件
//        File outFile = new File("D:/outFile" + Math.random() * 10000 + ".doc");
//        Writer out = null;
//        try {
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        }
//
//        try {
//            //将填充数据填入模板文件并输出到目标文件
//            t.process(dataMap, out);
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void getData(Map<String, Object> dataMap) {
//        dataMap.put("examName", "期中考试");
//
//
//        List<Map<String, Object>> userlist = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < 50; i++) {
//            Map<String, Object> map = new HashMap<String, Object>();
////            map.put("bianhao", i);
////            map.put("name", "刘慧文"+i);
////            map.put("sex", "男"+i);
////            map.put("phone", "15122693135"+i);
////            map.put("email", "1305156911@qq.com"+i);
////            map.put("zhiwei", "开发工程师"+i);
//            userlist.add(map);
//        }
//        List<Map<String, Object>> deptlist = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < 50; i++) {
//            Map<String, Object> map = new HashMap<String, Object>();
////            map.put("BIANHAO", i);
////            map.put("NAME", "刘慧文"+i);
////            map.put("JINGLI", "张经理"+i);
////            map.put("PHONE", "15122693135"+i);
////            map.put("EMAIL", "1305156911@qq.com"+i);
//            deptlist.add(map);
//        }
//
//        dataMap.put("userlist", userlist);
//        dataMap.put("deptlist", deptlist);
//    }
//}
