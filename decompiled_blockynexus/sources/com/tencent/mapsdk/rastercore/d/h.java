package com.tencent.mapsdk.rastercore.d;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f19541a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f19542b = com.tencent.mapsdk.rastercore.b.f19432a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f19543c = com.tencent.mapsdk.rastercore.b.f19433b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f19544d = com.tencent.mapsdk.rastercore.b.f19434c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19545e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f19546f = 1000;
    private static int g = com.tencent.mapsdk.rastercore.b.f19436e;
    private static int h = 0;
    private static volatile boolean i = false;
    private static int j = 0;
    private static String k = null;
    private static byte[] l = new byte[0];
    private static byte[] m = new byte[0];

    public static int a() {
        int i2;
        synchronized (l) {
            i2 = f19541a;
        }
        return i2;
    }

    public static void a(int i2, int i3, int i4, int i5) {
        synchronized (l) {
            f19541a = i2;
            f19542b = i3;
            f19543c = i4;
            f19544d = i5;
        }
    }

    public static void a(int i2, int i3, int i4, int i5, String str, String str2) {
        synchronized (m) {
            f19545e = i2;
            f19546f = i3;
            g = i4;
            h = i5;
            k = str2;
        }
    }

    public static void a(String str) {
        synchronized (m) {
            k = str;
        }
    }

    public static void a(boolean z) {
        synchronized (m) {
            i = z;
        }
    }

    public static int b() {
        int i2;
        synchronized (l) {
            i2 = f19542b;
        }
        return i2;
    }

    public static int c() {
        int i2;
        synchronized (l) {
            i2 = f19543c;
        }
        return i2;
    }

    public static int d() {
        int i2;
        synchronized (l) {
            i2 = f19544d;
        }
        return i2;
    }

    public static int e() {
        int i2;
        synchronized (m) {
            i2 = f19546f;
        }
        return i2;
    }

    public static int f() {
        int i2;
        synchronized (m) {
            i2 = f19545e;
        }
        return i2;
    }

    public static int g() {
        int i2;
        synchronized (m) {
            i2 = g;
        }
        return i2;
    }

    public static boolean h() {
        boolean z;
        synchronized (m) {
            z = i;
        }
        return z;
    }

    public static int i() {
        int i2;
        synchronized (m) {
            i2 = h;
        }
        return i2;
    }

    public static String j() {
        String str;
        synchronized (m) {
            str = k;
        }
        return str;
    }

    public static int k() {
        int i2;
        synchronized (m) {
            i2 = j;
        }
        return i2;
    }

    public static void l() {
        com.tencent.mapsdk.rastercore.f.a aVarA = com.tencent.mapsdk.rastercore.f.a.a();
        int iB = aVarA.b("tencent_version");
        int iB2 = aVarA.b("tencent_style");
        int iB3 = aVarA.b("sat_version");
        int iB4 = aVarA.b("tencent_clean_cache_version");
        synchronized (l) {
            if (iB2 != -1 && iB != -1 && iB3 != -1 && iB4 != -1) {
                f19542b = iB;
                f19541a = iB2;
                f19544d = iB3;
                f19543c = iB4;
            }
        }
        int iB5 = aVarA.b("");
        int iB6 = aVarA.b("world_map_style");
        int iB7 = aVarA.b("world_map_scene");
        int iB8 = aVarA.b("world_map_version");
        int iB9 = aVarA.b("world_map_protocol_version");
        boolean zC = aVarA.c("world_map_enable");
        aVarA.a("world_map_tile_url_regex");
        String strA = aVarA.a("world_map_logo_change_rule_json");
        synchronized (m) {
            f19546f = iB6;
            f19545e = iB7;
            g = iB8;
            h = iB9;
            i = zC;
            k = strA;
            j = iB5;
        }
    }

    public static boolean m() {
        boolean zA;
        synchronized (m) {
            zA = com.tencent.mapsdk.rastercore.f.a.a().a(new String[]{"", "world_map_scene", "world_map_style", "world_map_version", "world_map_tile_url_regex", "world_map_logo_change_rule_json", "world_map_protocol_version"});
        }
        return zA;
    }
}
