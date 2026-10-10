package com.disabngo.blockynexus.d;

import android.content.Context;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.utils.SharedUtils;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static long b(File file) {
        long jB = 0;
        if (file == null) {
            return 0L;
        }
        try {
            if (!file.exists()) {
                return 0L;
            }
            if (!file.isDirectory()) {
                return 0 + file.length();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return 0L;
            }
            for (int i = 0; i < fileArrListFiles.length; i++) {
                jB += fileArrListFiles[i].isDirectory() ? b(fileArrListFiles[i]) : fileArrListFiles[i].length();
            }
            return jB;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void a(Context context) {
        int i = SharedUtils.getInt(context, SharedConstant.SENSITIVE_WORD_VERSION);
        int sensitiveWordVersion = AppInfoCenter.newInstance().getAppConfig().getSensitiveWordVersion();
        if (i >= sensitiveWordVersion) {
            return;
        }
        UserApi.loadSensitiveWordConfig(context, new C0515l(context, sensitiveWordVersion));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<String> list, String str, String str2, String str3) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            boolean zCreateNewFile = true;
            File file2 = new File(str, str2);
            if (!file2.exists()) {
                try {
                    zCreateNewFile = file2.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    zCreateNewFile = false;
                }
            }
            if (zCreateNewFile) {
                try {
                    FileWriter fileWriter = new FileWriter(file2, false);
                    try {
                        for (String str4 : list) {
                            fileWriter.append((CharSequence) str4);
                            if (!str4.endsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                                fileWriter.append((CharSequence) UMCustomLogInfoBuilder.LINE_SEP);
                            }
                        }
                        fileWriter.close();
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                fileWriter.close();
                            } catch (Throwable unused) {
                            }
                        } else {
                            fileWriter.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                File file3 = new File(str, str3);
                if (file3.exists()) {
                    file3.delete();
                }
                file2.renameTo(file3);
            }
        }
    }
}
