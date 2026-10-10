package com.sandboxol.common.base.web;

import java.util.concurrent.TimeUnit;
import retrofit2.HttpException;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public class RetryWithDelay implements Func1<Observable<? extends Throwable>, Observable<?>> {
    private final int maxRetries;
    private final int retryDelayMillis;
    private final int retryTotalTime = 30000;
    private int retryCount = 0;

    public RetryWithDelay(int i, int i2) {
        this.maxRetries = i;
        this.retryDelayMillis = i2;
    }

    private boolean checkCode(HttpException httpException) {
        int iCode = httpException.code();
        return iCode == 429 || iCode == 500 || iCode == 504;
    }

    public /* synthetic */ Observable a(Throwable th) {
        int i = this.retryCount + 1;
        this.retryCount = i;
        if (i > this.maxRetries) {
            return Observable.error(th);
        }
        if ((th instanceof HttpException) && checkCode((HttpException) th)) {
            return Observable.error(th);
        }
        int i2 = this.retryDelayMillis;
        int i3 = this.maxRetries;
        if ((((i3 + 1) * i3) / 2) * i2 < 30000) {
            i2 *= this.retryCount;
        }
        return Observable.timer(i2, TimeUnit.MILLISECONDS);
    }

    @Override // rx.functions.Func1
    public Observable<?> call(Observable<? extends Throwable> observable) {
        return observable.flatMap(new Func1() { // from class: com.sandboxol.common.base.web.a
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return this.f16877a.a((Throwable) obj);
            }
        });
    }
}
