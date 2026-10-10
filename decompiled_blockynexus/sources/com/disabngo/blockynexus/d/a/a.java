package com.disabngo.blockynexus.d.a;

import android.content.Context;
import android.util.Log;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.common.base.app.BaseApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: CopyDownloadToResources.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7200a = EngineEnv.v1().getResRootPath();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7201b = EngineEnv.v2().getResRootPath();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7202c = EngineEnv.v3().getResRootPath();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7203d = BaseApplication.getContext().getDir("download", 0).getPath() + "/";

    private void b(String str, String str2, boolean z) throws IOException {
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists()) {
            if (!z) {
                return;
            } else {
                file2.delete();
            }
        }
        file2.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[2097152];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    private void c(String str, String str2, boolean z) throws IOException {
        a(str, str2, z);
    }

    public void a(Context context, long j, com.disabngo.blockynexus.interfaces.a aVar) {
        try {
            c(this.f7203d + "/resources/Media", this.f7200a + "Media", true);
            c(this.f7203d + "/resources/Media", this.f7201b + "Media", true);
            c(this.f7203d + "/resources/Media", this.f7202c + "Media", true);
            if (aVar != null) {
                aVar.a(j);
                Log.d("DressDownload&Unzip", "Move dress success");
            }
        } catch (Exception unused) {
            if (aVar != null) {
                aVar.a(j);
                Log.d("DressDownload&Unzip", "Move dress success");
            }
        }
    }

    private void a(String str, String str2, boolean z) throws IOException {
        String[] list = new File(str).list();
        if (!new File(str2).exists()) {
            new File(str2).mkdir();
        }
        if (list == null || list.length == 0) {
            return;
        }
        for (String str3 : list) {
            if (new File(str + File.separator + str3).isDirectory()) {
                a(str + File.separator + str3, str2 + File.separator + str3, z);
            }
            if (new File(str + File.separator + str3).isFile()) {
                b(str + File.separator + str3, str2 + File.separator + str3, z);
            }
        }
    }
}
