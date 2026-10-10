package com.sandboxol.file.entity;

import android.text.TextUtils;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadInfo<T> {
    private String cdns;
    private long size;
    private T t;
    private String saveName = "";
    private String savePath = CommonHelper.getApkOrSoDownloadPath(BaseApplication.getContext());
    private Boolean rangeFlag = null;
    private String url = "";
    private Boolean overwrite = false;
    private Boolean enableNotification = false;
    private Boolean autoStart = false;

    public Boolean getAutoStart() {
        return this.autoStart;
    }

    public List<CdnConfigDetail> getCdns() {
        try {
            if (TextUtils.isEmpty(this.cdns)) {
                return null;
            }
            return (List) new j().a(this.cdns, new TypeToken<List<CdnConfigDetail>>() { // from class: com.sandboxol.file.entity.DownloadInfo.1
            }.getType());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Boolean getEnableNotification() {
        return this.enableNotification;
    }

    public Boolean getOverwrite() {
        return this.overwrite;
    }

    public Boolean getRangeFlag() {
        return this.rangeFlag;
    }

    public String getSaveName() {
        return this.saveName;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public long getSize() {
        return this.size;
    }

    public T getT() {
        return this.t;
    }

    public String getUrl() {
        return this.url;
    }

    public DownloadInfo setAutoStart(Boolean bool) {
        this.autoStart = bool;
        return this;
    }

    public void setCdns(List<CdnConfigDetail> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.cdns = new j().a(list);
    }

    public DownloadInfo setEnableNotification(Boolean bool) {
        this.enableNotification = bool;
        return this;
    }

    public DownloadInfo setOverwrite(Boolean bool) {
        this.overwrite = bool;
        return this;
    }

    public DownloadInfo setRangeFlag(Boolean bool) {
        this.rangeFlag = bool;
        return this;
    }

    public DownloadInfo setSaveName(String str) {
        this.saveName = str;
        return this;
    }

    public DownloadInfo setSavePath(String str) {
        this.savePath = str;
        return this;
    }

    public DownloadInfo setSize(long j) {
        this.size = j;
        return this;
    }

    public DownloadInfo setT(T t) {
        this.t = t;
        return this;
    }

    public DownloadInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
