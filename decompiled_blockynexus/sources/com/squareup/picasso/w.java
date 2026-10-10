package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

/* JADX INFO: compiled from: Picasso.java */
/* JADX INFO: loaded from: classes5.dex */
class w extends Handler {
    w(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 3) {
            AbstractC2746a abstractC2746a = (AbstractC2746a) message.obj;
            if (abstractC2746a.f().p) {
                P.a("Main", "canceled", abstractC2746a.f19275b.d(), "target got garbage collected");
            }
            abstractC2746a.f19274a.a(abstractC2746a.j());
            return;
        }
        int i2 = 0;
        if (i == 8) {
            List list = (List) message.obj;
            int size = list.size();
            while (i2 < size) {
                RunnableC2754i runnableC2754i = (RunnableC2754i) list.get(i2);
                runnableC2754i.f19293f.a(runnableC2754i);
                i2++;
            }
            return;
        }
        if (i != 13) {
            throw new AssertionError("Unknown handler message received: " + message.what);
        }
        List list2 = (List) message.obj;
        int size2 = list2.size();
        while (i2 < size2) {
            AbstractC2746a abstractC2746a2 = (AbstractC2746a) list2.get(i2);
            abstractC2746a2.f19274a.b(abstractC2746a2);
            i2++;
        }
    }
}
