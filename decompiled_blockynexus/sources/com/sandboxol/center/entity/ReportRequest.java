package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ReportRequest {
    private long beReportedId;
    private List<String> imgUrls;
    private String reportContent;
    private String reportReason;

    public ReportRequest(long j, String str, String str2, List<String> list) {
        this.beReportedId = j;
        this.reportContent = str;
        this.reportReason = str2;
        this.imgUrls = list;
    }

    public long getBeReportedId() {
        return this.beReportedId;
    }

    public List<String> getImgUrls() {
        return this.imgUrls;
    }

    public String getReportContent() {
        return this.reportContent;
    }

    public String getReportReason() {
        return this.reportReason;
    }

    public void setBeReportedId(long j) {
        this.beReportedId = j;
    }

    public void setImgUrls(List<String> list) {
        this.imgUrls = list;
    }

    public void setReportContent(String str) {
        this.reportContent = str;
    }

    public void setReportReason(String str) {
        this.reportReason = str;
    }
}
