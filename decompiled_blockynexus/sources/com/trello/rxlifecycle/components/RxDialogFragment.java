package com.trello.rxlifecycle.components;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.b;
import rx.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes5.dex */
public class RxDialogFragment extends DialogFragment implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BehaviorSubject<FragmentEvent> f20082a = BehaviorSubject.create();

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f20082a.onNext(FragmentEvent.ATTACH);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20082a.onNext(FragmentEvent.CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.f20082a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        this.f20082a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        this.f20082a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // android.app.Fragment
    public void onPause() {
        this.f20082a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f20082a.onNext(FragmentEvent.RESUME);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f20082a.onNext(FragmentEvent.START);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        this.f20082a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f20082a.onNext(FragmentEvent.CREATE_VIEW);
    }
}
