package com.tendcloud.tenddata;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f19760a = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19764e = "UTF-8";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f19765f = "ge";
    private static final String g = "tp";
    private static final String h = "rop";
    private static final byte j = 61;
    private static final String k = "US-ASCII";
    private static final String o = "00:00:00:00:00:00";
    private static final String p = "02:00:00:00:00:00";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f19763d = !af.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f19761b = ab.u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f19762c = false;
    private static final ExecutorService i = Executors.newSingleThreadExecutor();
    private static final byte[] l = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static byte[] m = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final SecureRandom n = new SecureRandom();
    private static final Pattern q = Pattern.compile("^([0-9A-F]{2}:){5}([0-9A-F]{2})$");

    /* JADX WARN: Removed duplicated region for block: B:32:0x002d A[EXC_TOP_SPLITTER, PHI: r2
      0x002d: PHI (r2v5 java.io.InputStream) = (r2v3 java.io.InputStream), (r2v7 java.io.InputStream) binds: [B:22:0x003e, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r2, java.lang.String r3) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L3d
            java.io.InputStream r2 = r2.open(r3)     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L3d
            int r3 = r2.available()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            int r1 = r2.read(r3)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            if (r1 <= 0) goto L2b
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            java.lang.String r1 = "td_channel_id"
            java.lang.String r3 = r3.getString(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L33
            if (r2 == 0) goto L2a
            r2.close()     // Catch: java.lang.Throwable -> L2a
        L2a:
            return r3
        L2b:
            if (r2 == 0) goto L41
        L2d:
            r2.close()     // Catch: java.lang.Throwable -> L41
            goto L41
        L31:
            r3 = move-exception
            goto L37
        L33:
            goto L3e
        L35:
            r3 = move-exception
            r2 = r0
        L37:
            if (r2 == 0) goto L3c
            r2.close()     // Catch: java.lang.Throwable -> L3c
        L3c:
            throw r3
        L3d:
            r2 = r0
        L3e:
            if (r2 == 0) goto L41
            goto L2d
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.af.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean b(Context context) {
        return false;
    }

    public static final boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String c(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes(f19764e)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] d(String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i2 = 0; i2 < length; i2 += 2) {
                bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
            }
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(str.getBytes(f19764e)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void execute(Runnable runnable) {
        ExecutorService executorService = i;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    public static byte[] f(String str) throws Throwable {
        DeflaterOutputStream deflaterOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(9, true);
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(str.getBytes(f19764e));
            } catch (Throwable unused) {
                if (deflaterOutputStream != null) {
                }
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            }
        } catch (Throwable th) {
            th = th;
            deflaterOutputStream = null;
        }
        try {
            deflaterOutputStream.close();
        } catch (Throwable unused2) {
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static Long g(String str) {
        long j2 = -1L;
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (Throwable th) {
            bp.postSDKError(th);
            return j2;
        }
    }

    public static Integer h(String str) {
        int i2 = -1;
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Throwable th) {
            bp.postSDKError(th);
            return i2;
        }
    }

    public static boolean i(String str) {
        return !b(str) && v.h.matcher(str).matches();
    }

    public static boolean j(String str) {
        try {
            if (b(str) || !q.matcher(str).matches() || p.equals(str)) {
                return true;
            }
            return o.equals(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z = false;
        try {
            if (a(23)) {
                if (context.checkSelfPermission(str) == 0) {
                    z = true;
                }
            } else if (context.checkCallingOrSelfPermission(str) == 0) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static boolean b(int i2) {
        return Build.VERSION.SDK_INT < i2;
    }

    public static String b(byte[] bArr) {
        String strA;
        try {
            strA = a(bArr, 0, bArr.length);
        } catch (Throwable th) {
            if (!f19763d) {
                throw new AssertionError(th.getMessage());
            }
            strA = null;
        }
        if (f19763d || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String c(Context context, String str) {
        try {
            return a(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData, str);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static FileChannel d(Context context, String str) {
        RandomAccessFile randomAccessFile;
        try {
            File file = new File(context.getFilesDir(), str + "td.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                return randomAccessFile.getChannel();
            } catch (Throwable unused) {
                if (randomAccessFile == null) {
                    return null;
                }
                try {
                    randomAccessFile.close();
                    return null;
                } catch (Throwable unused2) {
                    return null;
                }
            }
        } catch (Throwable unused3) {
            randomAccessFile = null;
        }
    }

    public static boolean a(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).processName;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Process.myPid() == runningAppProcessInfo.pid && runningAppProcessInfo.processName.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return false;
    }

    public static byte[] b(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 >= 0) {
            if (i2 + i3 <= bArr.length) {
                byte[] bArr2 = new byte[((i3 / 3) * 4) + (i3 % 3 <= 0 ? 0 : 4)];
                int i4 = i3 - 2;
                int i5 = 0;
                int i6 = 0;
                while (i5 < i4) {
                    a(bArr, i5 + i2, 3, bArr2, i6);
                    i5 += 3;
                    i6 += 4;
                }
                if (i5 < i3) {
                    a(bArr, i2 + i5, i3 - i5, bArr2, i6);
                    i6 += 4;
                }
                if (i6 > bArr2.length - 1) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i6];
                System.arraycopy(bArr2, 0, bArr3, 0, i6);
                return bArr3;
            }
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
        }
        throw new IllegalArgumentException("Cannot have length offset: " + i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(byte[] r6) throws java.lang.Throwable {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r6)
            r6 = 0
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L50
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L50
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            r2.<init>()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
        L14:
            int r3 = r0.length     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L38
            r4 = 0
            int r3 = r1.read(r0, r4, r3)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L38
            r5 = -1
            if (r3 == r5) goto L21
            r2.write(r0, r4, r3)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L38
            goto L14
        L21:
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L38
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L38
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L38
            r2.flush()     // Catch: java.lang.Throwable -> L34 java.lang.Throwable -> L36
            r2.close()     // Catch: java.lang.Throwable -> L30
        L30:
            r1.close()     // Catch: java.lang.Throwable -> L5d
            goto L5d
        L34:
            goto L53
        L36:
            r6 = move-exception
            goto L43
        L38:
            r3 = r6
            goto L53
        L3a:
            r0 = move-exception
            r2 = r6
            goto L42
        L3d:
            r2 = r6
            goto L52
        L3f:
            r0 = move-exception
            r1 = r6
            r2 = r1
        L42:
            r6 = r0
        L43:
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Throwable -> L49
            goto L4a
        L49:
        L4a:
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.lang.Throwable -> L4f
        L4f:
            throw r6
        L50:
            r1 = r6
            r2 = r1
        L52:
            r3 = r2
        L53:
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.lang.Throwable -> L59
            goto L5a
        L59:
        L5a:
            if (r1 == 0) goto L5d
            goto L30
        L5d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.af.c(byte[]):java.lang.String");
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            byte[] bArr3 = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr3, 0, inflater.inflate(bArr3));
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable unused2) {
        }
        inflater.end();
        return bArr;
    }

    public static void a(Object obj, final z zVar, String str, String str2) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            final Object obj2 = declaredField.get(obj);
            Class<?> cls = Class.forName(str2);
            declaredField.set(obj, Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.tendcloud.tenddata.af.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj3, Method method, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
                    zVar.beforeMethodInvoke(obj3, method, objArr);
                    Object objInvoke = method.invoke(obj2, objArr);
                    zVar.afterMethodInvoked(obj3, method, objArr, objInvoke);
                    return objInvoke;
                }
            }));
        } catch (Throwable unused) {
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret, new IvParameterSpec(m));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Class<?> cls, final z zVar, String str, String str2) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        final Object obj = declaredField.get(null);
        Class<?> cls2 = Class.forName(str2);
        declaredField.set(null, Proxy.newProxyInstance(cls.getClass().getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.tendcloud.tenddata.af.2
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
                zVar.beforeMethodInvoke(obj2, method, objArr);
                Object objInvoke = method.invoke(obj, objArr);
                zVar.afterMethodInvoked(obj2, method, objArr, objInvoke);
                return objInvoke;
            }
        }));
    }

    public static int c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null) {
                return applicationInfo.targetSdkVersion;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String b(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int i2 = byteArrayInputStream.read(bArr2);
                            if (i2 != -1) {
                                fileOutputStream.write(bArr2, 0, i2);
                                messageDigest.update(bArr2, 0, i2);
                            } else {
                                try {
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        fileOutputStream.close();
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable unused2) {
                        }
                        return a(messageDigest.digest());
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                                throw th;
                            } catch (Throwable unused4) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                byteArrayInputStream = null;
            }
        } catch (Throwable unused5) {
            return null;
        }
    }

    public static final String a(String str) {
        if (str == null) {
            return null;
        }
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        TreeMap treeMap = new TreeMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                treeMap.put(next, jSONObject.get(next));
            }
        } catch (Throwable unused) {
        }
        return treeMap;
    }

    public static boolean a(int i2) {
        return Build.VERSION.SDK_INT >= i2;
    }

    public static String a(byte[] bArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static SecureRandom b() {
        return n;
    }

    public static Map<String, Object> b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next));
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        try {
            byte[] bArr3 = l;
            int i5 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
            if (i3 == 1) {
                bArr2[i4] = bArr3[i5 >>> 18];
                bArr2[i4 + 1] = bArr3[(i5 >>> 12) & 63];
                bArr2[i4 + 2] = j;
                bArr2[i4 + 3] = j;
                return bArr2;
            }
            if (i3 == 2) {
                bArr2[i4] = bArr3[i5 >>> 18];
                bArr2[i4 + 1] = bArr3[(i5 >>> 12) & 63];
                bArr2[i4 + 2] = bArr3[(i5 >>> 6) & 63];
                bArr2[i4 + 3] = j;
                return bArr2;
            }
            if (i3 != 3) {
                return bArr2;
            }
            bArr2[i4] = bArr3[i5 >>> 18];
            bArr2[i4 + 1] = bArr3[(i5 >>> 12) & 63];
            bArr2[i4 + 2] = bArr3[(i5 >>> 6) & 63];
            bArr2[i4 + 3] = bArr3[i5 & 63];
            return bArr2;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static String a(byte[] bArr, int i2, int i3) {
        byte[] bArrB = b(bArr, i2, i3);
        try {
            return new String(bArrB, k);
        } catch (Throwable unused) {
            return new String(bArrB);
        }
    }

    public static String a(Bundle bundle, String str) {
        Iterator<String> it;
        if (bundle == null) {
            return null;
        }
        try {
            it = bundle.keySet().iterator();
        } catch (Throwable unused) {
        }
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return String.valueOf(bundle.get(str));
            }
            return null;
        }
        return null;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, secretKeyGenerateSecret, new IvParameterSpec(m));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream(), f19764e));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    do {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                sb.append(line);
                                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                            }
                        } catch (Throwable unused) {
                        }
                        String string = sb.toString();
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                        return string;
                    } while (sb.length() <= 104857600);
                    throw new RuntimeException("Input stream more than 100 MB size limit");
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable unused4) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused5) {
                    }
                }
                return null;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static void a(File file, byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int i2 = byteArrayInputStream.read(bArr2);
                    if (i2 != -1) {
                        fileOutputStream.write(bArr2, 0, i2);
                    } else {
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
        } catch (Throwable unused) {
        }
    }

    public static int a(Context context, int i2) {
        try {
            return (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
