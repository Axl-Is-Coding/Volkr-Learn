package com.trello.rxlifecycle.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.b;
import com.trello.rxlifecycle.l;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: RxFragment.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends Fragment implements b {
    private final BehaviorSubject<FragmentEvent> lifecycleSubject = BehaviorSubject.create();

    public final <T> Observable.Transformer<T, T> bindToLifecycle() {
        return l.b(this.lifecycleSubject);
    }

    public final <T> Observable.Transformer<T, T> bindUntilEvent(FragmentEvent fragmentEvent) {
        return l.a(this.lifecycleSubject, fragmentEvent);
    }

    public final Observable<FragmentEvent> lifecycle() {
        return this.lifecycleSubject.asObservable();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.lifecycleSubject.onNext(FragmentEvent.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lifecycleSubject.onNext(FragmentEvent.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.lifecycleSubject.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.lifecycleSubject.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.lifecycleSubject.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.lifecycleSubject.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.lifecycleSubject.onNext(FragmentEvent.RESUME);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycleSubject.onNext(FragmentEvent.START);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.lifecycleSubject.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.lifecycleSubject.onNext(FragmentEvent.CREATE_VIEW);
    }
}
