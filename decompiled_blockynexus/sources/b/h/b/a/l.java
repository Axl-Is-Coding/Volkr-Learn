package b.h.b.a;

import android.content.Context;
import com.google.android.gms.gcm.Task;
import com.sandboxol.blockmango.config.GameEventConstant;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: GameResCopyImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f2805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2806f = 0;
    private String g;

    public l(Context context, String str, int i, h hVar) {
        this.f2801a = context;
        this.g = str;
        this.f2802b = i;
        this.f2803c = EngineEnv.getInstance(i).getResAssertName();
        this.f2804d = EngineEnv.getInstance(i).getResRootPath();
        this.f2805e = hVar;
    }

    private boolean b() {
        File file = new File(this.f2804d, "res.version");
        if (file.exists()) {
            String[] strArr = new String[10];
            String[] strArr2 = new String[10];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                InputStream inputStreamOpen = this.f2801a.getAssets().open(this.f2803c + "/res.version");
                byte[] bArr2 = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr2);
                inputStreamOpen.close();
                String str = new String(bArr, "UTF-8");
                String str2 = new String(bArr2, "UTF-8");
                JSONTokener jSONTokener = new JSONTokener(str);
                JSONTokener jSONTokener2 = new JSONTokener(str2);
                try {
                    String[] strArrSplit = ((JSONObject) jSONTokener.nextValue()).getString("version").split("\\.");
                    String[] strArrSplit2 = ((JSONObject) jSONTokener2.nextValue()).getString("version").split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    int i2 = Integer.parseInt(strArrSplit2[0]);
                    int i3 = Integer.parseInt(strArrSplit[1]);
                    int i4 = Integer.parseInt(strArrSplit2[1]);
                    if (i2 > i) {
                        return true;
                    }
                    return i2 == i && i4 > i3;
                } catch (ClassCastException | JSONException unused) {
                    return true;
                } catch (Exception unused2) {
                    ReportDataAdapter.onEvent(this.f2801a, GameEventConstant.LOAD_ASSETS_RES_FAILED);
                    return true;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
                return true;
            } catch (Exception unused3) {
                ReportDataAdapter.onEvent(this.f2801a, GameEventConstant.LOAD_ASSETS_RES_FAILED);
                return true;
            }
        }
        return true;
    }

    private String c() {
        return this.f2801a.getDir(this.f2803c, 0).getPath() + "/";
    }

    public int a() {
        if (!b()) {
            return 0;
        }
        this.f2806f = m.a(this.f2801a, this.f2803c);
        boolean zBooleanValue = (BaseModuleApp.getBaseModuleApp().getMetaDataIsPackNewEngineRes() || this.f2802b != 1) ? false : BaseModuleApp.getBaseModuleApp().getIsCopyV1ToV2().booleanValue();
        Context context = this.f2801a;
        String str = context.getApplicationInfo().sourceDir;
        String strC = c();
        StringBuilder sb = new StringBuilder();
        sb.append("assets/");
        sb.append(this.f2803c);
        sb.append("/");
        return (new f(context, str, strC, sb.toString(), this.f2802b, this.f2806f, zBooleanValue, this.f2805e).a() && a(this.f2803c, c(), "res.version")) ? 1 : -1;
    }

    private boolean a(String str, String str2, String str3) {
        InputStream inputStreamOpen;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        boolean z = false;
        try {
            File file = new File(str2, str3);
            if (file.exists()) {
                file.delete();
            }
            inputStreamOpen = this.f2801a.getAssets().open(str + "/" + str3);
            fileOutputStream = new FileOutputStream(file, false);
            bArr = new byte[Task.EXTRAS_LIMIT_BYTES];
        } catch (Exception e2) {
            ReportDataAdapter.onEvent(this.f2801a, GameEventConstant.LOAD_ASSETS_RES_FAILED);
            e2.printStackTrace();
        }
        while (true) {
            int i = inputStreamOpen.read(bArr);
            if (i <= 0) {
                break;
            }
            fileOutputStream.write(bArr, 0, i);
            h hVar = this.f2805e;
            int i2 = this.f2806f;
            hVar.a(i2, i2, this.f2802b);
            return z;
        }
        inputStreamOpen.close();
        fileOutputStream.close();
        z = true;
        h hVar2 = this.f2805e;
        int i22 = this.f2806f;
        hVar2.a(i22, i22, this.f2802b);
        return z;
    }
}
