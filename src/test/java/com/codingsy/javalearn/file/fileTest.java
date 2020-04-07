package com.codingsy.javalearn.file;

import java.io.*;

public class fileTest {

    public static void main(String[] args) throws Exception {

//        File file = new File("F:\\test.txt");
//        readtFile();
//        writeInFile(file, "test");   //写入文件
        test14();
    }

    private static void writeInFile(File file, String content) throws Exception {
        Writer writer = null;
        StringBuilder outputString = new StringBuilder();
        try {
            outputString.append(content + "\r\n");
            writer = new FileWriter(file, true); // true表示追加
            writer.write(outputString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        //append 默认写true 表示写入内容追加到文件末尾。
        OutputStream fps1 = new FileOutputStream("c:\\new", true);
        fps1.write(content.getBytes());
        fps1.close();//关闭文件句柄 释放资源.
    }

    /**
     * 读取数据，存入集合中
     */
    public static String readtFile(File file) throws IOException {
        InputStreamReader read = null;// 考虑到编码格式
        try {
            read = new InputStreamReader(new FileInputStream(file), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt;
        StringBuilder sb = new StringBuilder();
        while ((lineTxt = bufferedReader.readLine()) != null) {
            sb.append(lineTxt).append("\n");
        }
        read.close();
        return sb.toString();
    }


    public static void test14() {
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try {
            String fileName = "/data/pay_config/wxpay/" + 1535549491 + ".p12";
            fis = new FileInputStream(fileName); // 内容是：abc
            int temp = 0;
            //当temp等于-1时，表示已经到了文件结尾，停止读取
            while ((temp = fis.read()) != -1) {
                sb.append((char) temp);
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //这种写法，保证了即使遇到异常情况，也会关闭流对象。
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String newString = "";
        try {
            byte[] bytes = sb.toString().getBytes();
            newString = new String(bytes, "latin1");
            System.out.println(newString);

        } catch (Exception e) {
            e.printStackTrace();
        }


        String encode = getEncoding(sb.toString());

        System.out.println(encode);
        if (encode == null) {
            return;
        }


        FileOutputStream fos = null;
        String string = sb.toString();
        try {
            // true表示内容会追加到文件末尾；false表示重写整个文件内容。

            String fileName = "/data/pay_config/wxpay/" + 111 + ".p12";
            File file = new File(fileName);
            PrintWriter out = new PrintWriter(new BufferedWriter(new
                    OutputStreamWriter(new FileOutputStream(file), "latin1")));
            out.write(newString);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GB2312
                String s = encode;
                return s; //是的话，返回“GB2312“，以下代码同理
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是ISO-8859-1
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是UTF-8
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GBK
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return ""; //如果都不是，说明输入的内容不属于常见的编码格式。
    }
}

