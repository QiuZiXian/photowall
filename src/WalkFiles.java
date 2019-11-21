package src;



import java.io.File;

public class WalkFiles {

    String[] fileNameList = new String[30];
    int i = 0;

    public void traverseFolder(String path)
    {
        File file = new File(path);
        if(file.exists())
        {
            // list 返回的是目录下所有文件和文件夹的name，为String数组，listFiles返回的是所有文件和文件夹的绝对路径，为、File数组
            File[] files = file.listFiles();
            if(files == null || files.length == 0)
            {
                System.out.println(String.format("%s 目录是空的", path));
                return;
            }else {
                for(File f : files)
                {
                    if(f.isDirectory())
                    {
//                        System.out.println("文件夹：" + f.getAbsolutePath());
//                        traverseFolder(f.getAbsolutePath());
                    }else{
                        fileNameList[i] = f.getName();
                        i ++;
//                        System.out.println("文件：" + f.getAbsolutePath());
//                        System.out.println("文件：" + f.getName());
                    }
                }
            }
        }else {
            System.out.println("文件不存在！！");
        }
    }


    public static void main(String[] args) {
        WalkFiles walkFiles = new WalkFiles();
        walkFiles.traverseFolder("D:/d/test1");
        for(String item: walkFiles.fileNameList)
        {
            System.out.println(item);
        }
    }
}
