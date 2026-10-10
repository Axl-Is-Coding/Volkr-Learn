package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;

/* JADX INFO: compiled from: OldUMIDTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class o extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21224a = "oldumid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f21226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f21227d;

    public o(Context context) {
        super(f21224a);
        this.f21226c = null;
        this.f21227d = null;
        this.f21225b = context;
    }

    private void b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void j() {
        try {
            b("/data/local/tmp/.um");
            HelperUtils.writeFile(new File("/data/local/tmp/.um/sysid.dat"), this.f21227d);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            b("/sdcard/Android/obj/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/obj/.um/sysid.dat"), this.f21227d);
        } catch (Throwable unused) {
        }
    }

    private void l() {
        try {
            b("/sdcard/Android/data/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/data/.um/sysid.dat"), this.f21227d);
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return this.f21226c;
    }

    public boolean g() {
        return h();
    }

    public boolean h() throws Throwable {
        this.f21227d = UMEnvelopeBuild.imprintProperty(this.f21225b, au.f20663f, null);
        if (TextUtils.isEmpty(this.f21227d)) {
            return false;
        }
        this.f21227d = DataHelper.encryptBySHA1(this.f21227d);
        String file = HelperUtils.readFile(new File("/sdcard/Android/data/.um/sysid.dat"));
        String file2 = HelperUtils.readFile(new File("/sdcard/Android/obj/.um/sysid.dat"));
        String file3 = HelperUtils.readFile(new File("/data/local/tmp/.um/sysid.dat"));
        if (TextUtils.isEmpty(file)) {
            l();
        } else if (!this.f21227d.equals(file)) {
            this.f21226c = file;
            return true;
        }
        if (TextUtils.isEmpty(file2)) {
            k();
        } else if (!this.f21227d.equals(file2)) {
            this.f21226c = file2;
            return true;
        }
        if (TextUtils.isEmpty(file3)) {
            j();
            return false;
        }
        if (this.f21227d.equals(file3)) {
            return false;
        }
        this.f21226c = file3;
        return true;
    }

    public void i() {
        try {
            l();
            k();
            j();
        } catch (Exception unused) {
        }
    }
}
