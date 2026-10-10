package com.sandboxol.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.e;
import io.reactivex.b.o;
import io.reactivex.p;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.u;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RxPermissions2 {
    static final String TAG = "RxPermissions2";
    static final Object TRIGGER = new Object();
    Lazy<RxPermissionsFragment2> mRxPermissionsFragment;

    @FunctionalInterface
    public interface Lazy<V> {
        V get();
    }

    public RxPermissions2(FragmentActivity fragmentActivity) {
        this.mRxPermissionsFragment = getLazySingleton(fragmentActivity.getSupportFragmentManager());
    }

    private RxPermissionsFragment2 findRxPermissionsFragment(AbstractC0336n abstractC0336n) {
        return (RxPermissionsFragment2) abstractC0336n.a(TAG);
    }

    private Lazy<RxPermissionsFragment2> getLazySingleton(final AbstractC0336n abstractC0336n) {
        return new Lazy<RxPermissionsFragment2>() { // from class: com.sandboxol.common.utils.RxPermissions2.1
            private RxPermissionsFragment2 rxPermissionsFragment;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.sandboxol.common.utils.RxPermissions2.Lazy
            public synchronized RxPermissionsFragment2 get() {
                if (this.rxPermissionsFragment == null) {
                    this.rxPermissionsFragment = RxPermissions2.this.getRxPermissionsFragment(abstractC0336n);
                }
                return this.rxPermissionsFragment;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RxPermissionsFragment2 getRxPermissionsFragment(AbstractC0336n abstractC0336n) {
        RxPermissionsFragment2 rxPermissionsFragment2FindRxPermissionsFragment = findRxPermissionsFragment(abstractC0336n);
        if (!(rxPermissionsFragment2FindRxPermissionsFragment == null)) {
            return rxPermissionsFragment2FindRxPermissionsFragment;
        }
        RxPermissionsFragment2 rxPermissionsFragment2 = new RxPermissionsFragment2();
        F fA = abstractC0336n.a();
        fA.a(rxPermissionsFragment2, TAG);
        fA.d();
        return rxPermissionsFragment2;
    }

    private p<?> oneOf(p<?> pVar, p<?> pVar2) {
        return pVar == null ? p.just(TRIGGER) : p.merge(pVar, pVar2);
    }

    private p<?> pending(String... strArr) {
        for (String str : strArr) {
            if (!this.mRxPermissionsFragment.get().containsByPermission(str)) {
                return p.empty();
            }
        }
        return p.just(TRIGGER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public p<e> requestImplementation(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            this.mRxPermissionsFragment.get().log("Requesting permission " + str);
            if (isGranted(str)) {
                arrayList.add(p.just(new e(str, true, false)));
            } else if (isRevoked(str)) {
                arrayList.add(p.just(new e(str, false, false)));
            } else {
                PublishSubject<e> subjectByPermission = this.mRxPermissionsFragment.get().getSubjectByPermission(str);
                if (subjectByPermission == null) {
                    arrayList2.add(str);
                    subjectByPermission = PublishSubject.c();
                    this.mRxPermissionsFragment.get().setSubjectForPermission(str, subjectByPermission);
                }
                arrayList.add(subjectByPermission);
            }
        }
        if (!arrayList2.isEmpty()) {
            requestPermissionsFromFragment((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return p.concat(p.fromIterable(arrayList));
    }

    @TargetApi(23)
    private boolean shouldShowRequestPermissionRationaleImplementation(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (!isGranted(str) && !activity.shouldShowRequestPermissionRationale(str)) {
                return false;
            }
        }
        return true;
    }

    public <T> v<T, Boolean> ensure(final String... strArr) {
        return new v<T, Boolean>() { // from class: com.sandboxol.common.utils.RxPermissions2.2
            @Override // io.reactivex.v
            public u<Boolean> apply(p<T> pVar) {
                return RxPermissions2.this.request(pVar, strArr).buffer(strArr.length).flatMap(new o<List<e>, u<Boolean>>() { // from class: com.sandboxol.common.utils.RxPermissions2.2.1
                    @Override // io.reactivex.b.o
                    public u<Boolean> apply(List<e> list) {
                        if (list.isEmpty()) {
                            return p.empty();
                        }
                        Iterator<e> it = list.iterator();
                        while (it.hasNext()) {
                            if (!it.next().f19384b) {
                                return p.just(false);
                            }
                        }
                        return p.just(true);
                    }
                });
            }
        };
    }

    public <T> v<T, e> ensureEach(final String... strArr) {
        return new v<T, e>() { // from class: com.sandboxol.common.utils.RxPermissions2.3
            @Override // io.reactivex.v
            public u<e> apply(p<T> pVar) {
                return RxPermissions2.this.request(pVar, strArr);
            }
        };
    }

    public <T> v<T, e> ensureEachCombined(final String... strArr) {
        return new v<T, e>() { // from class: com.sandboxol.common.utils.RxPermissions2.4
            @Override // io.reactivex.v
            public u<e> apply(p<T> pVar) {
                return RxPermissions2.this.request(pVar, strArr).buffer(strArr.length).flatMap(new o<List<e>, u<e>>() { // from class: com.sandboxol.common.utils.RxPermissions2.4.1
                    @Override // io.reactivex.b.o
                    public u<e> apply(List<e> list) {
                        return list.isEmpty() ? p.empty() : p.just(new e(list));
                    }
                });
            }
        };
    }

    public boolean isGranted(String str) {
        return !isMarshmallow() || this.mRxPermissionsFragment.get().isGranted(str);
    }

    boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public boolean isRevoked(String str) {
        return isMarshmallow() && this.mRxPermissionsFragment.get().isRevoked(str);
    }

    void onRequestPermissionsResult(String[] strArr, int[] iArr) {
        this.mRxPermissionsFragment.get().onRequestPermissionsResult(strArr, iArr, new boolean[strArr.length]);
    }

    public p<Boolean> request(String... strArr) {
        return p.just(TRIGGER).compose(ensure(strArr));
    }

    public p<e> requestEach(String... strArr) {
        return p.just(TRIGGER).compose(ensureEach(strArr));
    }

    public p<e> requestEachCombined(String... strArr) {
        return p.just(TRIGGER).compose(ensureEachCombined(strArr));
    }

    @TargetApi(23)
    void requestPermissionsFromFragment(String[] strArr) {
        this.mRxPermissionsFragment.get().log("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.mRxPermissionsFragment.get().requestPermissions(strArr);
    }

    public void setLogging(boolean z) {
        this.mRxPermissionsFragment.get().setLogging(z);
    }

    public p<Boolean> shouldShowRequestPermissionRationale(Activity activity, String... strArr) {
        return p.just(Boolean.valueOf(!isMarshmallow() ? false : shouldShowRequestPermissionRationaleImplementation(activity, strArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p<e> request(p<?> pVar, final String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
        }
        return oneOf(pVar, pending(strArr)).flatMap(new o<Object, p<e>>() { // from class: com.sandboxol.common.utils.RxPermissions2.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.reactivex.b.o
            public p<e> apply(Object obj) {
                return RxPermissions2.this.requestImplementation(strArr);
            }
        });
    }

    public RxPermissions2(Fragment fragment) {
        this.mRxPermissionsFragment = getLazySingleton(fragment.getChildFragmentManager());
    }
}
