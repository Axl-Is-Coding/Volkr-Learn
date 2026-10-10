package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.b.a.i;

/* JADX INFO: loaded from: classes5.dex */
public class UTDevice {
    public static String getUtdid(Context context) {
        a aVarB = b.b(context);
        return (aVarB == null || i.m95a(aVarB.f())) ? "ffffffffffffffffffffffff" : aVarB.f();
    }

    public static String getUtdidForUpdate(Context context) {
        String strH = c.a(context).h();
        return (strH == null || i.m95a(strH)) ? "ffffffffffffffffffffffff" : strH;
    }
}
