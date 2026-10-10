package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SizeConfigStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config[] f4496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Bitmap.Config[] f4497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Bitmap.Config[] f4498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f4499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f4500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f4501f = new b();
    private final h<a, Bitmap> g = new h<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> h = new HashMap();

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f4502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f4504c;

        public a(b bVar) {
            this.f4502a = bVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.f4503b = i;
            this.f4504c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4503b == aVar.f4503b && com.bumptech.glide.e.n.b(this.f4504c, aVar.f4504c);
        }

        public int hashCode() {
            int i = this.f4503b * 31;
            Bitmap.Config config = this.f4504c;
            return i + (config != null ? config.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void offer() {
            this.f4502a.a(this);
        }

        public String toString() {
            return o.a(this.f4503b, this.f4504c);
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static class b extends d<a> {
        b() {
        }

        public a a(int i, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i, config);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.a.d
        public a a() {
            return new a(this);
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f4496a = configArr;
        f4497b = f4496a;
        f4498c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f4499d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f4500e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private a b(int i, Bitmap.Config config) {
        a aVarA = this.f4501f.a(i, config);
        for (Bitmap.Config config2 : a(config)) {
            Integer numCeilingKey = b(config2).ceilingKey(Integer.valueOf(i));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i * 8) {
                if (numCeilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return aVarA;
                        }
                    } else if (config2.equals(config)) {
                        return aVarA;
                    }
                }
                this.f4501f.a(aVarA);
                return this.f4501f.a(numCeilingKey.intValue(), config2);
            }
        }
        return aVarA;
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public void a(Bitmap bitmap) {
        a aVarA = this.f4501f.a(com.bumptech.glide.e.n.a(bitmap), bitmap.getConfig());
        this.g.a(aVarA, bitmap);
        NavigableMap<Integer, Integer> navigableMapB = b(bitmap.getConfig());
        Integer num = (Integer) navigableMapB.get(Integer.valueOf(aVarA.f4503b));
        navigableMapB.put(Integer.valueOf(aVarA.f4503b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.e.n.a(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap removeLast() {
        Bitmap bitmapA = this.g.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.bumptech.glide.e.n.a(bitmapA)), bitmapA);
        }
        return bitmapA;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        a aVarB = b(com.bumptech.glide.e.n.a(i, i2, config), config);
        Bitmap bitmapA = this.g.a(aVarB);
        if (bitmapA != null) {
            a(Integer.valueOf(aVarB.f4503b), bitmapA);
            bitmapA.reconfigure(i, i2, config);
        }
        return bitmapA;
    }

    private NavigableMap<Integer, Integer> b(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.h.put(config, treeMap);
        return treeMap;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapB = b(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapB.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapB.remove(num);
                return;
            } else {
                navigableMapB.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(Bitmap bitmap) {
        return a(com.bumptech.glide.e.n.a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(int i, int i2, Bitmap.Config config) {
        return a(com.bumptech.glide.e.n.a(i, i2, config), config);
    }

    static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f4497b;
        }
        int i = n.f4495a[config.ordinal()];
        if (i == 1) {
            return f4496a;
        }
        if (i == 2) {
            return f4498c;
        }
        if (i == 3) {
            return f4499d;
        }
        if (i != 4) {
            return new Bitmap.Config[]{config};
        }
        return f4500e;
    }
}
