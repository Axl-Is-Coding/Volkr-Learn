package com.bytedance.sdk.openadsdk.core.d;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClickEventModel.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f6073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f6074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f6075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f6076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6078f;
    private final int g;
    private final int h;
    private final long i;
    private final long j;
    private final int k;
    private final int l;
    private final int m;

    /* JADX INFO: compiled from: ClickEventModel.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f6079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f6080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f6082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f6083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f6084f;
        private int[] g;
        private int[] h;
        private int[] i;
        private int[] j;
        private int k;
        private int l;
        private int m;

        public a a(long j) {
            this.f6079a = j;
            return this;
        }

        public a b(long j) {
            this.f6080b = j;
            return this;
        }

        public a c(int i) {
            this.f6083e = i;
            return this;
        }

        public a d(int i) {
            this.f6084f = i;
            return this;
        }

        public a e(int i) {
            this.k = i;
            return this;
        }

        public a f(int i) {
            this.l = i;
            return this;
        }

        public a g(int i) {
            this.m = i;
            return this;
        }

        public a a(int i) {
            this.f6081c = i;
            return this;
        }

        public a b(int i) {
            this.f6082d = i;
            return this;
        }

        public a c(int[] iArr) {
            this.i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.g = iArr;
            return this;
        }

        public a b(int[] iArr) {
            this.h = iArr;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f6073a != null && this.f6073a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f6073a[0])).putOpt("ad_y", Integer.valueOf(this.f6073a[1]));
            }
            if (this.f6074b != null && this.f6074b.length == 2) {
                jSONObject.putOpt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Integer.valueOf(this.f6074b[0])).putOpt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Integer.valueOf(this.f6074b[1]));
            }
            if (this.f6075c != null && this.f6075c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f6075c[0])).putOpt("button_y", Integer.valueOf(this.f6075c[1]));
            }
            if (this.f6076d != null && this.f6076d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f6076d[0])).putOpt("button_height", Integer.valueOf(this.f6076d[1]));
            }
            jSONObject.putOpt("down_x", Integer.valueOf(this.f6077e)).putOpt("down_y", Integer.valueOf(this.f6078f)).putOpt("up_x", Integer.valueOf(this.g)).putOpt("up_y", Integer.valueOf(this.h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private d(a aVar) {
        this.f6073a = aVar.h;
        this.f6074b = aVar.i;
        this.f6076d = aVar.j;
        this.f6075c = aVar.g;
        this.f6077e = aVar.f6084f;
        this.f6078f = aVar.f6083e;
        this.g = aVar.f6082d;
        this.h = aVar.f6081c;
        this.i = aVar.f6080b;
        this.j = aVar.f6079a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }
}
