package io.reactivex.internal.util;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: EndConsumerHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f {
    public static boolean a(io.reactivex.disposables.b bVar, io.reactivex.disposables.b bVar2, Class<?> cls) {
        io.reactivex.internal.functions.a.a(bVar2, "next is null");
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        if (bVar == DisposableHelper.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static boolean a(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar, Class<?> cls) {
        io.reactivex.internal.functions.a.a(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> cls) {
        io.reactivex.e.a.b(new ProtocolViolationException(a(cls.getName())));
    }
}
