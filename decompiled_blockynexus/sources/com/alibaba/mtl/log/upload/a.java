package com.alibaba.mtl.log.upload;

import com.alibaba.mtl.log.d.a;
import com.alibaba.mtl.log.d.e;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.l;
import com.alibaba.mtl.log.d.n;
import com.tencent.map.geolocation.TencentLocationListener;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: UploadTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {
    static int B;
    private static volatile boolean G;
    private static boolean H;
    int C = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f3657a = 200.0f;
    int D = 0;

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ea, code lost:
    
        com.alibaba.mtl.log.upload.a.G = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01ed, code lost:
    
        com.alibaba.mtl.log.upload.a.G = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void I() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.upload.a.I():void");
    }

    private a.C0046a a(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = e.a(2, str, map, false).data;
            i.a("UploadTask", "url:", str);
            if (bArr != null) {
                String str2 = null;
                try {
                    str2 = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (str2 != null) {
                    i.a("UploadTask", "result:", str2);
                    return com.alibaba.mtl.log.d.a.a(str2);
                }
            }
        }
        return a.C0046a.f3626a;
    }

    private int b(List<com.alibaba.mtl.log.model.a> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2).X;
            if (str != null && "6005".equalsIgnoreCase(str.toString())) {
                i++;
            }
        }
        return i;
    }

    private int h() {
        if (this.C == -1) {
            String strU = l.u();
            if (TencentLocationListener.WIFI.equalsIgnoreCase(strU)) {
                this.C = 20;
            } else if ("4G".equalsIgnoreCase(strU)) {
                this.C = 16;
            } else if ("3G".equalsIgnoreCase(strU)) {
                this.C = 12;
            } else {
                this.C = 8;
            }
        }
        return this.C;
    }

    public static boolean isRunning() {
        return G;
    }

    public abstract void G();

    public abstract void H();

    @Override // java.lang.Runnable
    public void run() {
        try {
            I();
            G();
        } catch (Throwable unused) {
        }
    }

    private int a(Boolean bool, long j) {
        if (j < 0) {
            return this.C;
        }
        float f2 = this.D / j;
        if (!bool.booleanValue()) {
            this.C /= 2;
            B++;
        } else {
            if (j > 45000) {
                return this.C;
            }
            double d2 = f2 * 45000.0f;
            double d3 = this.f3657a;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = d2 / d3;
            double d5 = B;
            Double.isNaN(d5);
            this.C = (int) (d4 - d5);
        }
        int i = this.C;
        if (i < 1) {
            this.C = 1;
            B = 0;
        } else if (i > 350) {
            this.C = 350;
        }
        i.a("UploadTask", "winsize:", Integer.valueOf(this.C));
        return this.C;
    }

    private Map<String, Object> a(List<com.alibaba.mtl.log.model.a> list) throws Throwable {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            List<String> listA = a(list.get(i));
            if (listA != null) {
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    StringBuilder sb = (StringBuilder) map.get(listA.get(i2));
                    if (sb == null) {
                        sb = new StringBuilder();
                        map.put(listA.get(i2), sb);
                    } else {
                        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                    }
                    sb.append(list.get(i).i());
                }
            }
        }
        HashMap map2 = new HashMap();
        this.D = 0;
        for (String str : map.keySet()) {
            byte[] bArrA = a(((StringBuilder) map.get(str)).toString());
            map2.put(str, bArrA);
            this.D += bArrA.length;
        }
        this.f3657a = this.D / list.size();
        i.a("UploadTask", "averagePackageSize:", Float.valueOf(this.f3657a));
        return map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.GZIPOutputStream] */
    private byte[] a(String str) throws Throwable {
        ?? gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r1 = 0;
        ?? r12 = 0;
        try {
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = r1;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                String str2 = "UTF-8";
                gZIPOutputStream.write(str.getBytes("UTF-8"));
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                r1 = str2;
            } catch (IOException e3) {
                e = e3;
                r12 = gZIPOutputStream;
                e.printStackTrace();
                r1 = r12;
                if (r12 != 0) {
                    r12.close();
                    r1 = r12;
                }
            } catch (Throwable th2) {
                th = th2;
                if (gZIPOutputStream != 0) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
        byte[] bArrA = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused3) {
        }
        return bArrA;
    }

    private List<String> a(com.alibaba.mtl.log.model.a aVar) {
        return com.alibaba.mtl.log.a.a.m18a(aVar.X);
    }
}
