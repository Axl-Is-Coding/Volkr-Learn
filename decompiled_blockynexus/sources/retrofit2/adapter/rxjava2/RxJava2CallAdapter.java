package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.e.a;
import io.reactivex.p;
import io.reactivex.x;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes5.dex */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final x scheduler;

    RxJava2CallAdapter(Type type, x xVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.responseType = type;
        this.scheduler = xVar;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isFlowable = z4;
        this.isSingle = z5;
        this.isMaybe = z6;
        this.isCompletable = z7;
    }

    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        p callEnqueueObservable = this.isAsync ? new CallEnqueueObservable(call) : new CallExecuteObservable(call);
        p resultObservable = this.isResult ? new ResultObservable(callEnqueueObservable) : this.isBody ? new BodyObservable(callEnqueueObservable) : callEnqueueObservable;
        x xVar = this.scheduler;
        if (xVar != null) {
            resultObservable = resultObservable.subscribeOn(xVar);
        }
        return this.isFlowable ? resultObservable.toFlowable(BackpressureStrategy.LATEST) : this.isSingle ? resultObservable.singleOrError() : this.isMaybe ? resultObservable.singleElement() : this.isCompletable ? resultObservable.ignoreElements() : a.a(resultObservable);
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
