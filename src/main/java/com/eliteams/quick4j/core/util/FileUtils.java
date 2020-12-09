package com.eliteams.quick4j.core.util;

import java.io.*;

/**
 * @author wyx
 * @date 2020/12/5
 * @Time 22:56
 */
public class FileUtils {

    public static void readFile(File readFile,File writeFile){
        FileInputStream fileInputStream = null;
        BufferedReader br =null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bw = null;
        String line = null;
        StringBuilder sb ;
        int startIndex = 0;
        int endIndex = 0;
        try  {
            fileInputStream = new FileInputStream(readFile);
            fileOutputStream = new FileOutputStream(writeFile);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream,"UTF-8"));
            br = new BufferedReader(new InputStreamReader(fileInputStream));
            int i = 0;
            while((line = br.readLine()) != null){
                i = i+1;
                line = line.replace("( SEQ_ID,","( ");
                startIndex = line.indexOf("VALUES (");
                endIndex = line.indexOf(",",startIndex);//第26个
                sb = new StringBuilder(line);
                sb.delete(startIndex+8,endIndex+1);
                //System.out.println("写入:"+sb.toString());
                writer.append(sb.toString());
                sb = null;
                writer.append("\r\n");
                sb = null;
            }
            writer.close();
            br.close();
            fileInputStream.close();
        } catch (Exception e){
                e.printStackTrace();
        } finally {

        }
    }


    public static void main(String[] args) {
//        readFile(new File("C:\\Users\\Administrator\\Desktop\\sql\\ZJ_BANK_VOUCHER_PUSH_LOG.sql"));
        readFile(new File("C:\\Users\\Administrator\\Desktop\\sql\\ZJJH_ZJ_ORG_PAID_IN_DAILY2020-12-08.sql"),
                new File("C:\\Users\\Administrator\\Desktop\\sql\\ZJJH_ZJ_ORG_PAID_IN_DAILY2020-12-08.new.sql"));
    }
}
