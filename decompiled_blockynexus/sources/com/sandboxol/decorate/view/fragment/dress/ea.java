package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: DressItemModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class ea {

    /* JADX INFO: compiled from: DressItemModel.java */
    public interface a {
        void a();
    }

    public static void a(Context context, long j) {
        com.sandboxol.decorate.web.t.h(context, j, new aa(context));
    }

    public static void a(Context context, long j, long j2) {
        com.sandboxol.decorate.web.t.g(context, j, new ba(j2, context));
    }

    public static void a(Context context, List<Long> list) {
        com.sandboxol.decorate.web.t.c(context, list, new ca(context));
    }

    public static void a(Context context, List<Long> list, a aVar) {
        com.sandboxol.decorate.web.t.d(context, list, new da(aVar, context));
    }
}
