package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.adnet.face.IHttpStack;

/* JADX INFO: loaded from: classes.dex */
public final class TTAdConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5599f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private IHttpStack l;
    private String[] m;
    private boolean n;
    private int o;
    private int p;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5601b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f5603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f5604e;
        private IHttpStack l;
        private String[] m;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5602c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5605f = 0;
        private boolean g = true;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private boolean k = false;
        private boolean n = false;
        private int o = 0;
        private int p = -1;

        public Builder allowShowNotify(boolean z) {
            this.g = z;
            return this;
        }

        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.i = z;
            return this;
        }

        public Builder appId(String str) {
            this.f5600a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f5601b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f5600a);
            tTAdConfig.setCoppa(this.o);
            tTAdConfig.setAppName(this.f5601b);
            tTAdConfig.setPaid(this.f5602c);
            tTAdConfig.setKeywords(this.f5603d);
            tTAdConfig.setData(this.f5604e);
            tTAdConfig.setTitleBarTheme(this.f5605f);
            tTAdConfig.setAllowShowNotify(this.g);
            tTAdConfig.setDebug(this.h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.i);
            tTAdConfig.setUseTextureView(this.j);
            tTAdConfig.setSupportMultiProcess(this.k);
            tTAdConfig.setHttpStack(this.l);
            tTAdConfig.setNeedClearTaskReset(this.m);
            tTAdConfig.setAsyncInit(this.n);
            tTAdConfig.setGDPR(this.p);
            return tTAdConfig;
        }

        public Builder coppa(int i) {
            this.o = i;
            return this;
        }

        public Builder data(String str) {
            this.f5604e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.h = z;
            return this;
        }

        public Builder httpStack(IHttpStack iHttpStack) {
            this.l = iHttpStack;
            return this;
        }

        public Builder keywords(String str) {
            this.f5603d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f5602c = z;
            return this;
        }

        public Builder setGDPR(int i) {
            this.p = i;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.k = z;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f5605f = i;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.j = z;
            return this;
        }
    }

    public String getAppId() {
        return this.f5594a;
    }

    public String getAppName() {
        return this.f5595b;
    }

    public int getCoppa() {
        return this.o;
    }

    public String getData() {
        return this.f5598e;
    }

    public int getGDPR() {
        return this.p;
    }

    public IHttpStack getHttpStack() {
        return this.l;
    }

    public String getKeywords() {
        return this.f5597d;
    }

    public String[] getNeedClearTaskReset() {
        return this.m;
    }

    public int getTitleBarTheme() {
        return this.f5599f;
    }

    public boolean isAllowShowNotify() {
        return this.g;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.i;
    }

    public boolean isAsyncInit() {
        return this.n;
    }

    public boolean isDebug() {
        return this.h;
    }

    public boolean isPaid() {
        return this.f5596c;
    }

    public boolean isSupportMultiProcess() {
        return this.k;
    }

    public boolean isUseTextureView() {
        return this.j;
    }

    public void setAllowShowNotify(boolean z) {
        this.g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.i = z;
    }

    public void setAppId(String str) {
        this.f5594a = str;
    }

    public void setAppName(String str) {
        this.f5595b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCoppa(int i) {
        this.o = i;
    }

    public void setData(String str) {
        this.f5598e = str;
    }

    public void setDebug(boolean z) {
        this.h = z;
    }

    public void setGDPR(int i) {
        this.p = i;
    }

    public void setHttpStack(IHttpStack iHttpStack) {
        this.l = iHttpStack;
    }

    public void setKeywords(String str) {
        this.f5597d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.f5596c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.k = z;
    }

    public void setTitleBarTheme(int i) {
        this.f5599f = i;
    }

    public void setUseTextureView(boolean z) {
        this.j = z;
    }

    private TTAdConfig() {
        this.f5596c = false;
        this.f5599f = 0;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = false;
        this.o = 0;
        this.p = -1;
    }
}
