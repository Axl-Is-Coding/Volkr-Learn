package com.sandboxol.common.utils;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.compress.archivers.a.b;

/* JADX INFO: loaded from: classes3.dex */
public class TarUtils {
    private static final String TAG = "TarUtils";

    public static void unCompressArchiveGz(String str, String str2) throws Exception {
        File file = new File(str);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        String str3 = file.getParent() + File.separator + file.getName().substring(0, file.getName().lastIndexOf(Consts.DOT));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
        org.apache.commons.compress.compressors.a.a aVar = new org.apache.commons.compress.compressors.a.a(bufferedInputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = aVar.read(bArr);
            if (i == -1) {
                aVar.close();
                bufferedOutputStream.close();
                unCompressTar(str3, str2);
                return;
            }
            bufferedOutputStream.write(bArr, 0, i);
        }
    }

    private static void unCompressTar(String str, String str2) throws Exception {
        File file = new File(str);
        try {
            try {
                File file2 = new File(str2);
                if (!file2.isDirectory()) {
                    file2.mkdirs();
                }
                b bVar = new b(new FileInputStream(file));
                while (true) {
                    org.apache.commons.compress.archivers.a.a aVarN = bVar.n();
                    if (aVarN == null) {
                        break;
                    }
                    File file3 = new File(str2, aVarN.a());
                    Log.e(TAG, file3.getPath());
                    if (!aVarN.c()) {
                        if (!file3.getParentFile().exists()) {
                            file3.getParentFile().mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = bVar.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                bufferedOutputStream.write(bArr, 0, i);
                            }
                        }
                        bufferedOutputStream.close();
                    } else if (!file3.isDirectory()) {
                        file3.mkdirs();
                    }
                }
                bVar.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                throw e2;
            }
        } finally {
            if (file.isFile()) {
                file.delete();
            }
        }
    }
}
