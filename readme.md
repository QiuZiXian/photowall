#瀑布流照片墙
##1. thought
- java
- html
- css

html/css 构建一个html模板；java读取图片填充模板

##project description
### HtmlModel.java 为主程序入口
输入：src_root = "D:/d/test1/img";为图片源路径
输出：data/photowall.html

### 2. other

1. WalkFiles.java 为遍历文件夹
2. FileToLocal.java 将图片源路径下的所有img拷贝到当前路径img中
3. InOutLocalFile.java 文件读写
4. data/HtmlModel.html 为瀑布流照片墙模板文件

## 3. extend

1. 模板大小为动态
2. 