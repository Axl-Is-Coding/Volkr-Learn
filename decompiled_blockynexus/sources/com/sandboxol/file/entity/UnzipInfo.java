package com.sandboxol.file.entity;

import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes3.dex */
public class UnzipInfo<T> {
    private long fileSize;
    private boolean isReplace;
    private String resultDir;
    private T t;
    private String toDir;
    private String zipName;
    private String url = "";
    private String fromDir = CommonHelper.getApkOrSoDownloadPath(BaseApplication.getContext());
    private String baseDir = BaseApplication.getContext().getFilesDir().getAbsolutePath().replace("/files", "") + "/";
    private boolean isCheckMd5 = true;

    public String getBaseDir() {
        return this.baseDir;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFromDir() {
        return this.fromDir;
    }

    public String getResultDir() {
        return this.resultDir;
    }

    public T getT() {
        return this.t;
    }

    public String getToDir() {
        return this.toDir;
    }

    public String getUrl() {
        return this.url;
    }

    public String getZipName() {
        return this.zipName;
    }

    public boolean isCheckMd5() {
        return this.isCheckMd5;
    }

    public boolean isReplace() {
        return this.isReplace;
    }

    public UnzipInfo setBaseDir(String str) {
        this.baseDir = str;
        return this;
    }

    public void setCheckMd5(boolean z) {
        this.isCheckMd5 = z;
    }

    public UnzipInfo setFileSize(long j) {
        this.fileSize = j;
        return this;
    }

    public UnzipInfo setFromDir(String str) {
        this.fromDir = str;
        return this;
    }

    public UnzipInfo setIsReplace(boolean z) {
        this.isReplace = z;
        return this;
    }

    public void setReplace(boolean z) {
        this.isReplace = z;
    }

    public UnzipInfo setResultDir(String str) {
        this.resultDir = str;
        return this;
    }

    public UnzipInfo setT(T t) {
        this.t = t;
        return this;
    }

    public UnzipInfo setToDir(String str) {
        this.toDir = str;
        return this;
    }

    public UnzipInfo setUrl(String str) {
        this.url = str;
        return this;
    }

    public UnzipInfo setZipName(String str) {
        this.zipName = str;
        return this;
    }
}
