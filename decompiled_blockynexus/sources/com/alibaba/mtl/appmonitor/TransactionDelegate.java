package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.log.d.i;

/* JADX INFO: loaded from: classes.dex */
public class TransactionDelegate {
    private static void a(Transaction transaction) {
        if (transaction == null || transaction.f3553b == null) {
            return;
        }
        e.a().a(transaction.r, transaction.f3552a, transaction.o, transaction.p, DimensionValueSet.create().addValues(transaction.f3553b));
    }

    public static void begin(Transaction transaction, String str) {
        try {
            if (AppMonitorDelegate.i && transaction != null) {
                i.a("TransactionDelegate", "statEvent begin. module: ", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                if (!f.STAT.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(f.STAT, transaction.o, transaction.p))) {
                    i.a("TransactionDelegate", "log discard", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                } else {
                    e.a().a(transaction.r, transaction.f3552a, transaction.o, transaction.p, str);
                    a(transaction);
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m17a(th);
        }
    }

    public static void end(Transaction transaction, String str) {
        try {
            if (AppMonitorDelegate.i && transaction != null) {
                i.a("TransactionDelegate", "statEvent end. module: ", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                if (!f.STAT.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(f.STAT, transaction.o, transaction.p))) {
                    i.a("TransactionDelegate", "log discard", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                } else {
                    a(transaction);
                    e.a().a(transaction.r, str, false, transaction.f3554e);
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m17a(th);
        }
    }
}
