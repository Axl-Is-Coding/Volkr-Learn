package io.rong.common.dlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class LogZipper {
    public static boolean gzipFile(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists() && file.length() != 0) {
                byte[] bArr = new byte[1024];
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(str2));
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        fileInputStream.close();
                        gZIPOutputStream.finish();
                        gZIPOutputStream.close();
                        return true;
                    }
                    gZIPOutputStream.write(bArr, 0, i);
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
