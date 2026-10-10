package io.reactivex.internal.operators.observable;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableBlockingSubscribe.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2913i {
    public static <T> void a(io.reactivex.u<? extends T> uVar, io.reactivex.w<? super T> wVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        wVar.onSubscribe(blockingObserver);
        uVar.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object objPoll = linkedBlockingQueue.poll();
            if (objPoll == null) {
                try {
                    objPoll = linkedBlockingQueue.take();
                } catch (InterruptedException e2) {
                    blockingObserver.dispose();
                    wVar.onError(e2);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || uVar == BlockingObserver.TERMINATED || NotificationLite.acceptFull(objPoll, wVar)) {
                return;
            }
        }
    }

    public static <T> void a(io.reactivex.u<? extends T> uVar) {
        io.reactivex.internal.util.d dVar = new io.reactivex.internal.util.d();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.d(), dVar, dVar, Functions.d());
        uVar.subscribe(lambdaObserver);
        io.reactivex.internal.util.c.a(dVar, lambdaObserver);
        Throwable th = dVar.f22728a;
        if (th != null) {
            throw ExceptionHelper.b(th);
        }
    }

    public static <T> void a(io.reactivex.u<? extends T> uVar, io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(gVar, "onNext is null");
        io.reactivex.internal.functions.a.a(gVar2, "onError is null");
        io.reactivex.internal.functions.a.a(aVar, "onComplete is null");
        a(uVar, new LambdaObserver(gVar, gVar2, aVar, Functions.d()));
    }
}
