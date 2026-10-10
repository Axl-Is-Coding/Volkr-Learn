package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.Observable;
import rx.Scheduler;

/* JADX INFO: loaded from: classes5.dex */
final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final Scheduler scheduler;

    RxJavaCallAdapter(Type type, Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = scheduler;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        Observable.OnSubscribe callEnqueueOnSubscribe = this.isAsync ? new CallEnqueueOnSubscribe(call) : new CallExecuteOnSubscribe(call);
        Observable observableCreate = Observable.create(this.isResult ? new ResultOnSubscribe(callEnqueueOnSubscribe) : this.isBody ? new BodyOnSubscribe(callEnqueueOnSubscribe) : callEnqueueOnSubscribe);
        Scheduler scheduler = this.scheduler;
        if (scheduler != null) {
            observableCreate = observableCreate.subscribeOn(scheduler);
        }
        return this.isSingle ? observableCreate.toSingle() : this.isCompletable ? observableCreate.toCompletable() : observableCreate;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
