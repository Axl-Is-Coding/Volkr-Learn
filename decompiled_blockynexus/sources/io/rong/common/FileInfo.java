package io.rong.common;

/* JADX INFO: loaded from: classes5.dex */
public class FileInfo {
    private String name;
    private long size;
    private String type;

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public long getSize() {
        return this.size;
    }

    public String getType() {
        String str = this.type;
        return str == null ? "" : str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setType(String str) {
        this.type = str;
    }
}
