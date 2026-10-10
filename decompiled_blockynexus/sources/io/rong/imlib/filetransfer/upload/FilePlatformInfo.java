package io.rong.imlib.filetransfer.upload;

import io.rong.imlib.filetransfer.FtConst;

/* JADX INFO: loaded from: classes5.dex */
public class FilePlatformInfo implements Comparable<FilePlatformInfo> {
    private String host;
    private String priority;
    private FtConst.ServiceType type;

    public FilePlatformInfo(String str, String str2, FtConst.ServiceType serviceType) {
        this.type = serviceType;
        this.host = str;
        this.priority = str2;
    }

    public String getHost() {
        return this.host;
    }

    public String getPriority() {
        return this.priority;
    }

    public FtConst.ServiceType getType() {
        return this.type;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public void setType(FtConst.ServiceType serviceType) {
        this.type = serviceType;
    }

    @Override // java.lang.Comparable
    public int compareTo(FilePlatformInfo filePlatformInfo) {
        return this.priority.compareTo(filePlatformInfo.priority);
    }
}
