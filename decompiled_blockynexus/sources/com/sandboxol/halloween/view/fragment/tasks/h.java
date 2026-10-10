package com.sandboxol.halloween.view.fragment.tasks;

import android.content.Context;
import com.sandboxol.halloween.entity.HalloweenTaskResponse;

/* JADX INFO: compiled from: TasksModel.java */
/* JADX INFO: loaded from: classes4.dex */
class h {

    /* JADX INFO: compiled from: TasksModel.java */
    interface a {
        void a(HalloweenTaskResponse halloweenTaskResponse);
    }

    public static void a(Context context, String str, a aVar) {
        com.sandboxol.halloween.web.g.b(context, str, new g(aVar, context));
    }
}
