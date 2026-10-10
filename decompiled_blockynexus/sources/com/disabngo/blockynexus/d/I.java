package com.disabngo.blockynexus.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.gson.JsonSyntaxException;
import com.sandboxol.blocky.entity.ResVersion;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.clothes.EchoesHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: ResCheck.java */
/* JADX INFO: loaded from: classes2.dex */
public class I extends Handler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f7195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f7196e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7192a = I.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7193b = EchoesHandler.ASSETS_NAME;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7194c = "updateRes.tar.gz";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7197f = 0;
    private int g = 0;

    /* JADX INFO: compiled from: ResCheck.java */
    public interface a {
        void a(boolean z, String str, String str2);
    }

    public I(Context context, a aVar) {
        this.f7195d = context;
        this.f7196e = aVar;
        a(a());
    }

    private String c() {
        return b() + "/version.json";
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f7196e == null || message.what == 1) {
        }
    }

    private int a() {
        File file = new File(c());
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                String str = new String(bArr);
                Log.e(this.f7192a, "version info :" + str);
                ResVersion resVersion = (ResVersion) new com.google.gson.j().a(str, ResVersion.class);
                if (resVersion != null) {
                    return resVersion.getVersion();
                }
                return 0;
            } catch (JsonSyntaxException e2) {
                e2.printStackTrace();
                return 0;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return 0;
            } catch (IOException e4) {
                e4.printStackTrace();
                return 0;
            }
        }
        Log.e(this.f7192a, "version file not exists");
        return 0;
    }

    @SuppressLint({"WorldWriteableFiles"})
    private String b() {
        return this.f7195d.getApplicationContext().getDir(EchoesHandler.ASSETS_NAME, 0).getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int i2 = this.f7197f;
        if (i2 > 2) {
            return;
        }
        this.f7197f = i2 + 1;
        GameApi.resCheck(i, new H(this, i));
    }
}
