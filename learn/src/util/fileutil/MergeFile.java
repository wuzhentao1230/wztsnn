package util.fileutil;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MergeFile {
    public boolean unionFile(String outfile, String dictionary) throws IOException {
        boolean result = false;
        List<File> fileList = getFiles(dictionary);
        File fout = new File(outfile);
        FileWriter fw = new FileWriter(fout);
        for (File f : fileList) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                fw.append(line + "\n");
                line = br.readLine();
            }
            fr.close();
        }
        fw.close();
        result = true;
        return result;
    }

    public static List<File> getFiles(String path) {
        File root = new File(path);
        List<File> files = new ArrayList<File>();
        if (!root.isDirectory()) {
            files.add(root);
        } else {
            File[] subFiles = root.listFiles();
            for (File f : subFiles) {
                files.addAll(getFiles(f.getAbsolutePath()));
            }
        }
        return files;
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 1; i < 21; i++) {
//            String tmp = "";
//            if (i<10){
//                tmp="0"+i;
//            }else {
//                tmp=""+i;
//            }
//
//            MergeFile t = new MergeFile();
//            t.unionFile("C:\\Users\\wb-wzt446163\\Desktop\\script_20_paragragh\\"+i+"outputFileName.txt"
//                    , "C:\\Users\\wb-wzt446163\\Desktop\\script_20_paragragh\\00"+i);
//
//            t.unionFile("C:\\Users\\wb-wzt446163\\Desktop\\script_20_paragragh\\"+i+"outputFileName.txt"
//                    , "C:\\Users\\wb-wzt446163\\Desktop\\script_20_paragragh\\00"+i);
//        }
//        MergeFile t = new MergeFile();
//        t.unionFile("C:\\Users\\wb-wzt446163\\Desktop\\script_20_paragragh(1)\\outputFileName.txt"
//                , "C:\\Users\\wb-wzt446163\\Desktop\\script_20_paragragh(1)");
        Integer i = new Integer(100);
//        Integer i2 = new Integer(100);
//        if(i == i2){
//            System.out.println("AAAAAAAAAA");
//        }
//        if(i.intValue() == i2.intValue()){
//            System.out.println("BBBBBBBBBB");
//        }

//        String i3 = "100";
//        String i4 = "100";
//        if(i3.equals(i.toString())){
//            System.out.println("CCCCCCCCCC");
//        }
//
//        if(i3 == i.toString()){
//            System.out.println("DDDDDDDDDD");
//        }
//        if(i3 == i4){
//            System.out.println("EEEEEEEEEE");
//        }
//
//        String i5 = new String("100");
//        String i6 = new String("100");
//        if(i5 == i6){
//            System.out.println("FFFFFFFFFF");
//        }
//
//        System.out.println(new StringBuilder("abs").reverse().toString());
//        String aa = "振涛.*As__-";
//        aa = aa.replaceAll("[^a-zA-Z0-9_-]", "");
//        System.out.println(aa);



//        String[] strs = {"1","2","31","4","1"};
//        List<String> strings = Arrays.asList(strs);
//        System.out.println(strings.stream().map(x -> Integer.parseInt(x)).max(Integer::compare).get());
//        File file = new File("d://ttt/a.txt");
//        FileUtils.writeLines(file,strings);

//        File forRefineFile = new File("D://test/a.txt");
//        List<String> list = FileUtils.readLines(forRefineFile,"utf-8");
//
//        List<Map> result = list.stream().map(x -> {
//            Map<String,String> map = new HashMap<>();
//            String[] xs = x.split("\\s+");
//            if (xs.length == 3) {
//                map.put("originL", xs[0]);
//                map.put("msg", xs[1]);
//                map.put("L", xs[2]);
//            }
//            return map;
//        }).collect(Collectors.toList());
//
//
//        System.out.println(result);


//        long lastTimeFileSize = 0;
//        long lastNum = 300;
//        String path = "d://test.log";
//        File file = new File(path);
//        if (!file.exists()){
//            System.out.println("没有这个文件");
//        }
//        //指定文件可读可写
//        final RandomAccessFile randomFile = new RandomAccessFile(file,"rw");
//        while(true){
//            Thread.sleep(Long.parseLong("2000"));
//
//            lastTimeFileSize = file.length()>300?file.length()-300:file.length();
//            System.out.println("location:"+lastTimeFileSize);
//            //获得变化部分的
//            randomFile.seek(lastTimeFileSize);
//
//            String tmp = "";
//            System.out.println(randomFile.readLine());
//            while( (tmp = randomFile.readLine())!= null) {
//                System.out.println(new String(tmp.getBytes("utf-8")));
//            }
//
//            lastTimeFileSize = randomFile.length();
//        }
//        File file = new File("d://test/a.txt");
//        File file1 = new File("d://test/a1.txt");
//        FileUtils.copyFile(file,file1);


    }
    public static <E> List<E> asList(E... elements) {
        if (elements != null && elements.length != 0) {
            int capacity = computeListCapacity(elements.length);
            ArrayList<E> list = new ArrayList(capacity);
            Collections.addAll(list, elements);
            return list;
        } else {
            return Collections.emptyList();
        }
    }

    static int computeListCapacity(int arraySize) {
        return (int)Math.min(5L + (long)arraySize + (long)(arraySize / 10), 2147483647L);
    }
}
