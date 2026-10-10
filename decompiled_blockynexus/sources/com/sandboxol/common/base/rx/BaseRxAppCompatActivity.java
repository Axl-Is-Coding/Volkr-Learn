package com.sandboxol.common.base.rx;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.a;
import com.trello.rxlifecycle.l;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes3.dex */
public class BaseRxAppCompatActivity extends AppCompatActivity implements a {
    private BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();

    public final <T> Observable.Transformer<T, T> bindToLifecycle() {
        return l.a(this.lifecycleSubject);
    }

    @Override // com.trello.rxlifecycle.a
    public final <T> Observable.Transformer<T, T> bindUntilEvent(ActivityEvent activityEvent) {
        return l.a(this.lifecycleSubject, activityEvent);
    }

    public final Observable<ActivityEvent> lifecycle() {
        return this.lifecycleSubject.asObservable();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lifecycleSubject.onNext(ActivityEvent.CREATE);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.lifecycleSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
            this.lifecycleSubject.onNext(ActivityEvent.RESUME);
        } catch (RuntimeException unused) {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    public void sendLifecycleEvent(ActivityEvent activityEvent) {
        this.lifecycleSubject.onNext(activityEvent);
    }
}
