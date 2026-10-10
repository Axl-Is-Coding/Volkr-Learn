package io.grpc.stub;

import com.google.common.base.m;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> it, final CallStreamObserver<V> callStreamObserver) {
        m.a(it);
        m.a(callStreamObserver);
        callStreamObserver.setOnReadyHandler(new Runnable() { // from class: io.grpc.stub.StreamObservers.1
            @Override // java.lang.Runnable
            public void run() {
                while (callStreamObserver.isReady() && it.hasNext()) {
                    callStreamObserver.onNext(it.next());
                }
                if (it.hasNext()) {
                    return;
                }
                callStreamObserver.onCompleted();
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> iterable, CallStreamObserver<V> callStreamObserver) {
        m.a(iterable);
        copyWithFlowControl(iterable.iterator(), callStreamObserver);
    }
}
