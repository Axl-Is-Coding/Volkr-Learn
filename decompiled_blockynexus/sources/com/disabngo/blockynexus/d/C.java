package com.disabngo.blockynexus.d;

import android.os.Environment;
import android.text.TextUtils;
import com.sandboxol.center.config.StringConstant;
import java.io.File;

/* JADX INFO: compiled from: IgnoreMediaFileUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class C {
    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str, StringConstant.BLOCKY_MODS_RONG_CLOUD_MEDIA_FILE);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(Environment.getExternalStorageDirectory(), str);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            a(file.getPath());
        }
    }

    public static void a() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), StringConstant.BLOCKY_MODS_RONG_CLOUD_MEDIA_DIR);
            if (!file.isDirectory()) {
                file.mkdir();
            }
            a(file.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
