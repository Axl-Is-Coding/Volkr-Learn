package com.twitter.sdk.android.tweetui.internal.a;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: IntHashMap.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a[] f20399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f20402d;

    /* JADX INFO: compiled from: IntHashMap.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f20405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f20406d;

        protected a(int i, int i2, Object obj, a aVar) {
            this.f20403a = i;
            this.f20404b = i2;
            this.f20405c = obj;
            this.f20406d = aVar;
        }
    }

    public b() {
        this(20, 0.75f);
    }

    protected void a() {
        a[] aVarArr = this.f20399a;
        int length = aVarArr.length;
        int i = (length * 2) + 1;
        a[] aVarArr2 = new a[i];
        this.f20401c = (int) (i * this.f20402d);
        this.f20399a = aVarArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            a aVar = aVarArr[i2];
            while (aVar != null) {
                a aVar2 = aVar.f20406d;
                int i3 = (aVar.f20403a & Integer.MAX_VALUE) % i;
                aVar.f20406d = aVarArr2[i3];
                aVarArr2[i3] = aVar;
                aVar = aVar2;
            }
            length = i2;
        }
    }

    public b(int i, float f2) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }
        if (f2 <= WheelView.DividerConfig.FILL) {
            throw new IllegalArgumentException("Illegal Load: " + f2);
        }
        i = i == 0 ? 1 : i;
        this.f20402d = f2;
        this.f20399a = new a[i];
        this.f20401c = (int) (i * f2);
    }

    public Object a(int i, Object obj) {
        a[] aVarArr = this.f20399a;
        int i2 = Integer.MAX_VALUE & i;
        int length = i2 % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.f20406d) {
            if (aVar.f20403a == i) {
                Object obj2 = aVar.f20405c;
                aVar.f20405c = obj;
                return obj2;
            }
        }
        if (this.f20400b >= this.f20401c) {
            a();
            aVarArr = this.f20399a;
            length = i2 % aVarArr.length;
        }
        aVarArr[length] = new a(i, i, obj, aVarArr[length]);
        this.f20400b++;
        return null;
    }
}
