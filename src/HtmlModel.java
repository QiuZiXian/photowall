package src;

/**
 * @ email: 1467288927@qq.com
 * @ Created by akufire on 2019/11/20.
 * @ Abstract:
 */
public class HtmlModel {
    String src_root = "D:/d/test1/img";
    String dst_root = "./src/data/img";

    public void createHtml()
    {
        InOutLocalFile inOutLocalFile = new InOutLocalFile();
        WalkFiles walkFiles = new WalkFiles();
        FileToLocal fileToLocal = new FileToLocal();

        fileToLocal.toLocal(src_root, dst_root);

        System.out.println();
        inOutLocalFile.setPath("./src/data"); //src/com/nebulabd/aku/photowall/src
        inOutLocalFile.setFileName("htmlModel.html");

        String htmlModel = inOutLocalFile.outLocalFile();
//        System.out.println(htmlModel);

        String htmlImg = "";
        walkFiles.traverseFolder(dst_root);
        for(String item : walkFiles.fileNameList)
        {
            if(item != null)
            {
                String sub = String.format("<img src='./img/%s' alt='' />", item);
                htmlImg = htmlImg + sub + "\r\n";
            }
        }

        inOutLocalFile.setFileName("photowall.html");
        inOutLocalFile.inLocalFile(String.format(htmlModel, htmlImg));

    }

    public static void main(String[] args) {
        HtmlModel demo = new HtmlModel();
        demo.createHtml();
    }
}
