package com.ta.utdid2.a;

import android.content.Context;
import android.util.Log;
import com.sandboxol.center.config.IntConstant;
import com.ta.utdid2.b.a.f;
import com.ta.utdid2.b.a.i;
import com.ta.utdid2.b.a.j;

/* JADX INFO: compiled from: AidManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    private static final String TAG = "com.ta.utdid2.a.a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f19331a;
    private Context mContext;

    private a(Context context) {
        this.mContext = context;
    }

    public static synchronized a a(Context context) {
        if (f19331a == null) {
            f19331a = new a(context);
        }
        return f19331a;
    }

    private synchronized String b(String str, String str2, String str3) {
        if (this.mContext == null) {
            Log.e(TAG, "no context!");
            return "";
        }
        String strA = f.m94a(this.mContext) ? b.a(this.mContext).a(str, str2, str3, c.m92a(this.mContext, str, str2)) : "";
        c.a(this.mContext, str, strA, str2);
        return strA;
    }

    public void a(String str, String str2, String str3, com.ut.device.a aVar) {
        if (aVar == null) {
            Log.e(TAG, "callback is null!");
            return;
        }
        if (this.mContext != null && !i.m95a(str) && !i.m95a(str2)) {
            String strM92a = c.m92a(this.mContext, str, str2);
            if (!i.m95a(strM92a) && j.a(c.a(this.mContext, str, str2), 1)) {
                aVar.a(1001, strM92a);
                return;
            } else if (f.m94a(this.mContext)) {
                b.a(this.mContext).a(str, str2, str3, strM92a, aVar);
                return;
            } else {
                aVar.a(IntConstant.PERMISSION_STORAGE_DOWNLOAD, strM92a);
                return;
            }
        }
        String str4 = TAG;
        StringBuilder sb = new StringBuilder("mContext:");
        sb.append(this.mContext);
        sb.append("; callback:");
        sb.append(aVar);
        sb.append("; has appName:");
        sb.append(!i.m95a(str));
        sb.append("; has token:");
        sb.append(!i.m95a(str2));
        Log.e(str4, sb.toString());
        aVar.a(1002, "");
    }

    public String a(String str, String str2, String str3) {
        if (this.mContext != null && !i.m95a(str) && !i.m95a(str2)) {
            String strM92a = c.m92a(this.mContext, str, str2);
            return ((i.m95a(strM92a) || !j.a(c.a(this.mContext, str, str2), 1)) && f.m94a(this.mContext)) ? b(str, str2, str3) : strM92a;
        }
        String str4 = TAG;
        StringBuilder sb = new StringBuilder("mContext:");
        sb.append(this.mContext);
        sb.append("; has appName:");
        sb.append(!i.m95a(str));
        sb.append("; has token:");
        sb.append(!i.m95a(str2));
        Log.e(str4, sb.toString());
        return "";
    }
}
