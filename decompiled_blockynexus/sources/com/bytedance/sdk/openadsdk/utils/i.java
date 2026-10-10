package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: FileUtils.java */
    private static final class a implements Comparator<File> {
        private a() {
        }

        private int a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    public static File a(Context context, boolean z, String str, String str2) {
        String strA = a(context);
        if (z) {
            str = "/" + s.a(context) + "-" + str;
        }
        String str3 = strA + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static void b(File file) throws Throwable {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            e(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                o.d("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    public static void c(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isFile() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        c(file2);
                    } else {
                        try {
                            file2.delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    public static byte[] d(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long lValueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private static void e(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            f(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile.seek(j);
                byte b2 = randomAccessFile.readByte();
                randomAccessFile.seek(j);
                randomAccessFile.write(b2);
            } catch (Throwable unused) {
                if (randomAccessFile == null) {
                    return;
                }
            }
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        randomAccessFile.close();
    }

    private static void f(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    private static String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            Environment.isExternalStorageRemovable();
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static List<File> a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new a());
        return listAsList;
    }
}
