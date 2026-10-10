package com.trello.rxlifecycle.components;

import android.app.Activity;
import android.os.Bundle;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.a;
import com.trello.rxlifecycle.l;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes5.dex */
public class RxActivity extends Activity implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BehaviorSubject<ActivityEvent> f20081a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle.a
    public final <T> Observable.Transformer<T, T> bindUntilEvent(ActivityEvent activityEvent) {
        return l.a(this.f20081a, activityEvent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20081a.onNext(ActivityEvent.CREATE);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f20081a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f20081a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f20081a.onNext(ActivityEvent.RESUME);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f20081a.onNext(ActivityEvent.START);
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.f20081a.onNext(ActivityEvent.STOP);
        super.onStop();
    }
}
