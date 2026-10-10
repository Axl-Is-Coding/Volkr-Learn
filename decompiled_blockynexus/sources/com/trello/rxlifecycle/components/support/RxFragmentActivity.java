package com.trello.rxlifecycle.components.support;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.l;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes5.dex */
public class RxFragmentActivity extends FragmentActivity implements com.trello.rxlifecycle.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BehaviorSubject<ActivityEvent> f20085a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle.a
    public final <T> Observable.Transformer<T, T> bindUntilEvent(ActivityEvent activityEvent) {
        return l.a(this.f20085a, activityEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20085a.onNext(ActivityEvent.CREATE);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f20085a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f20085a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f20085a.onNext(ActivityEvent.RESUME);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f20085a.onNext(ActivityEvent.START);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.f20085a.onNext(ActivityEvent.STOP);
        super.onStop();
    }
}
