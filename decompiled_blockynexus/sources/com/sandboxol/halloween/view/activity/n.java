package com.sandboxol.halloween.view.activity;

import android.content.Context;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;

/* JADX INFO: compiled from: HalloweenModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class n {

    /* JADX INFO: compiled from: HalloweenModel.java */
    interface a {
        void a(HalloweenInfoResponse halloweenInfoResponse);
    }

    public static void a(Context context, a aVar) {
        com.sandboxol.halloween.web.g.a(context, new m(aVar, context));
    }

    public static int b(long j) {
        long j2 = 86400000;
        return (int) ((j - ((j / j2) * j2)) / ((long) 3600000));
    }

    public static int a(long j) {
        return (int) (j / ((long) 86400000));
    }
}
