package test;

import test.WalkFiles;
import test.InOutLocalFile;

import java.io.IOException;

/**
 * @ email: 1467288927@qq.com
 * @ Created by akufire on 2019/11/20.
 * @ Abstract:
 */
public class FileToLocal {


    public void toLocal(String src_root, String dst_root)
    {
        WalkFiles walkFiles = new WalkFiles();
        InOutLocalFile inOutLocalFile = new InOutLocalFile();

        walkFiles.traverseFolder(src_root);
        for(String item : walkFiles.fileNameList)
        {
            if (item != null) {
                try {
                    inOutLocalFile.saveImg(src_root, dst_root, item);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        String src_root = "D:/d/test1/img";
        String dst_root = "D:/d/html/photowall/img";
        FileToLocal fileToLocal = new FileToLocal();
        fileToLocal.toLocal(src_root, dst_root);
    }
}
