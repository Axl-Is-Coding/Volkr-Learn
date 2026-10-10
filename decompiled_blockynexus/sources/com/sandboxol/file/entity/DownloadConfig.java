package com.sandboxol.file.entity;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadConfig {
    private static DownloadConfig downloadConfig;
    private int reconnectCount = 3;
    private int rateMultiple = 4;
    private int slowPeriod = Integer.MAX_VALUE;
    private int startCountingTime = 1000;
    private double allowedRate = 100.0d;

    public static DownloadConfig newInstance() {
        if (downloadConfig == null) {
            downloadConfig = new DownloadConfig();
        }
        return downloadConfig;
    }

    public double getAllowedRate() {
        return this.allowedRate;
    }

    public int getRateMultiple() {
        return this.rateMultiple;
    }

    public int getReconnectCount() {
        return this.reconnectCount;
    }

    public int getSlowPeriod() {
        return this.slowPeriod;
    }

    public int getStartCountingTime() {
        return this.startCountingTime;
    }

    public void setAllowedRate(double d2) {
        this.allowedRate = d2;
    }

    public void setDownloadConfig(DownloadConfig downloadConfig2) {
        if (downloadConfig2 != null) {
            downloadConfig = downloadConfig2;
        }
    }

    public void setRateMultiple(int i) {
        this.rateMultiple = i;
    }

    public void setReconnectCount(int i) {
        this.reconnectCount = i;
    }

    public void setSlowPeriod(int i) {
        this.slowPeriod = i;
    }

    public void setStartCountingTime(int i) {
        this.startCountingTime = i;
    }
}
