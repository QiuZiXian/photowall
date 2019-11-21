package src;
/**
 * 将weed上传数据后返回的json数据进行读取保存
 * [{"fileName":"test3.log","fileUrl":"localhost:8080/7,3c1680744f","fid":"7,3c1680744f","size":2863}]
 * 可能会有缺失key的情况
 */

import java.io.*;

public class InOutLocalFile {

    String path = "D:/d";    // 文件存取路径

    String fileName = "test.json";  // json数据保存文件名"test.json"

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    /*数据输出到磁盘，即保存到本地*/
    public  void inLocalFile(String s){

        File f = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            f = new File(path);
            if(f.isDirectory()) {
                fw = new FileWriter(String.format("%s/%s", this.path, this.fileName));
                bw = new BufferedWriter(fw);
                bw.write(s);
                System.out.println("save successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    /*读取本地数据*/
    public String  outLocalFile()
    {
        String alls = "";
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        String filePath = String.format("%s/%s", this.path, this.fileName); // this好还是get好？？？？，如果实例化后set，则this.var不是初始化的值，所以两者应该一样
        System.out.println("filePath" + filePath);
        f = new File(filePath);
        System.out.println(f.exists());
        if(f.isFile())
        {
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                String s = "";
                while ((s = br.readLine()) != null)
                {
//                    System.out.println(s);
                    alls += s + "\r\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return alls;
    }

    public void saveImg(String src_root, String dst_root, String imgName) throws IOException {
        File f1 = null;
        File f2 = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        f1 = new File(String.format("%s/%s", src_root, imgName));
        f2 = new File(String.format("%s/%s", dst_root, imgName));
        try {
            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);
            byte[] s = new byte[1024];
            int len = 0;
            while ((len = fis.read(s)) != -1)
            {
                fos.write(s, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fis.close();
            fos.flush();
            fos.close();
        }
    }
}
