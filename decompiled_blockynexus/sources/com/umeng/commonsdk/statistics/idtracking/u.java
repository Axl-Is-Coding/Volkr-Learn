package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.os.Environment;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: UTDIdTrackerEx.java */
/* JADX INFO: loaded from: classes5.dex */
public class u extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21240a = "utdid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f21241b = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f21242c = Pattern.compile("UTDID\">([^<]+)");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f21243d;

    public u(Context context) {
        super(f21240a);
        this.f21243d = context;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f21242c.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String g() {
        File fileH = h();
        if (fileH != null && fileH.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileH);
                try {
                    return b(HelperUtils.readStreamToString(fileInputStream));
                } finally {
                    HelperUtils.safeClose(fileInputStream);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private File h() {
        if (DeviceConfig.checkPermission(this.f21243d, f21241b) && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.u)) {
                return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.f21243d);
            }
            return null;
        } catch (Exception unused) {
            if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.u)) {
                return g();
            }
            return null;
        }
    }
}
