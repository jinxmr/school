package com.school.framework.config;

/**
 * Created by Administrator on 2019/4/24.
 */
public class FastDFSFile {
    private String fileName;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;
    //省略getter、setter


    public FastDFSFile(String fileName, byte[] content, String ext) {
        this.fileName = fileName;
        this.content = content;
        this.ext = ext;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}