package io.rong.imkit.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class FileInfo implements Serializable {
    private static final long serialVersionUID = -4830812821556630987L;
    private String fileName;
    private String filePath;
    private long fileSize;
    private boolean isDirectory;
    private String suffix;

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }
}
