package com.bytedance.sdk.openadsdk.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ZipUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ae {
    public static List<File> a(String str, String str2) throws IOException {
        return a(str, str2, (String) null);
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static List<File> a(String str, String str2, String str3) throws IOException {
        return a(a(str), a(str2), str3);
    }

    public static List<File> a(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        try {
            if (b(str)) {
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String name = zipEntryNextElement.getName();
                    if (name.contains("../")) {
                        o.d("ZipUtils", "entryName: " + name + " is dangerous!");
                    } else if (!a(file2, arrayList, zipFile, zipEntryNextElement, name)) {
                        return arrayList;
                    }
                }
            } else {
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement2 = enumerationEntries.nextElement();
                    String name2 = zipEntryNextElement2.getName();
                    if (name2.contains("../")) {
                        o.d("ZipUtils", "entryName: " + name2 + " is dangerous!");
                    } else if (name2.contains(str) && !a(file2, arrayList, zipFile, zipEntryNextElement2, name2)) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        } finally {
            zipFile.close();
        }
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return a(file2);
        }
        if (!b(file2)) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = bufferedInputStream2.read(bArr);
                            if (i != -1) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                bufferedInputStream2.close();
                                bufferedOutputStream.close();
                                fileOutputStream.close();
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static File a(String str) {
        if (b(str)) {
            return null;
        }
        return new File(str);
    }
}
