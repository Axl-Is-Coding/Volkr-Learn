package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<a> f13468a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f13469b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ValueAnimator f13470c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f13471d = new m(this);

    /* JADX INFO: compiled from: StateListAnimator.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f13472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f13473b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f13472a = iArr;
            this.f13473b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f13470c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f13470c = null;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.f13471d);
        this.f13468a.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f13468a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f13468a.get(i);
            if (StateSet.stateSetMatches(aVar.f13472a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        a aVar2 = this.f13469b;
        if (aVar == aVar2) {
            return;
        }
        if (aVar2 != null) {
            b();
        }
        this.f13469b = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    private void a(a aVar) {
        this.f13470c = aVar.f13473b;
        this.f13470c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f13470c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f13470c = null;
        }
    }
}
