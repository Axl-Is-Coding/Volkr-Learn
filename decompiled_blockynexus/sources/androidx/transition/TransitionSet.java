package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {
    private ArrayList<Transition> K;
    private boolean L;
    int M;
    boolean N;
    private int O;

    static class a extends C0379ba {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TransitionSet f2200a;

        a(TransitionSet transitionSet) {
            this.f2200a = transitionSet;
        }

        @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
        public void b(Transition transition) {
            TransitionSet transitionSet = this.f2200a;
            if (transitionSet.N) {
                return;
            }
            transitionSet.p();
            this.f2200a.N = true;
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            TransitionSet transitionSet = this.f2200a;
            transitionSet.M--;
            if (transitionSet.M == 0) {
                transitionSet.N = false;
                transitionSet.b();
            }
            transition.b(this);
        }
    }

    public TransitionSet() {
        this.K = new ArrayList<>();
        this.L = true;
        this.N = false;
        this.O = 0;
    }

    private void r() {
        a aVar = new a(this);
        Iterator<Transition> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.M = this.K.size();
    }

    @Override // androidx.transition.Transition
    public void c(ha haVar) {
        if (b(haVar.f2247b)) {
            for (Transition transition : this.K) {
                if (transition.b(haVar.f2247b)) {
                    transition.c(haVar);
                    haVar.f2248c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).e(view);
        }
    }

    @Override // androidx.transition.Transition
    protected void o() {
        if (this.K.isEmpty()) {
            p();
            b();
            return;
        }
        r();
        if (this.L) {
            Iterator<Transition> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().o();
            }
            return;
        }
        for (int i = 1; i < this.K.size(); i++) {
            this.K.get(i - 1).a(new C0387fa(this, this.K.get(i)));
        }
        Transition transition = this.K.get(0);
        if (transition != null) {
            transition.o();
        }
    }

    public int q() {
        return this.K.size();
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.b bVar) {
        super.setEpicenterCallback(bVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).setEpicenterCallback(bVar);
        }
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public Transition mo4clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo4clone();
        transitionSet.K = new ArrayList<>();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            transitionSet.b(this.K.get(i).mo4clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public TransitionSet d(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).d(view);
        }
        super.d(view);
        return this;
    }

    public TransitionSet b(int i) {
        if (i == 0) {
            this.L = true;
        } else if (i == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public TransitionSet a(Transition transition) {
        b(transition);
        long j = this.f2194f;
        if (j >= 0) {
            transition.a(j);
        }
        if ((this.O & 1) != 0) {
            transition.a(e());
        }
        if ((this.O & 2) != 0) {
            transition.a(h());
        }
        if ((this.O & 4) != 0) {
            transition.a(g());
        }
        if ((this.O & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = new ArrayList<>();
        this.L = true;
        this.N = false;
        this.O = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.i);
        b(androidx.core.content.a.i.b(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void b(Transition transition) {
        this.K.add(transition);
        transition.u = this;
    }

    @Override // androidx.transition.Transition
    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).c(view);
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet b(long j) {
        super.b(j);
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet b(Transition.c cVar) {
        super.b(cVar);
        return this;
    }

    @Override // androidx.transition.Transition
    void b(ha haVar) {
        super.b(haVar);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).b(haVar);
        }
    }

    public Transition a(int i) {
        if (i < 0 || i >= this.K.size()) {
            return null;
        }
        return this.K.get(i);
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(long j) {
        ArrayList<Transition> arrayList;
        super.a(j);
        if (this.f2194f >= 0 && (arrayList = this.K) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<Transition> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(view);
        }
        super.a(view);
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(Transition.c cVar) {
        super.a(cVar);
        return this;
    }

    @Override // androidx.transition.Transition
    public void a(PathMotion pathMotion) {
        super.a(pathMotion);
        this.O |= 4;
        if (this.K != null) {
            for (int i = 0; i < this.K.size(); i++) {
                this.K.get(i).a(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    protected void a(ViewGroup viewGroup, ia iaVar, ia iaVar2, ArrayList<ha> arrayList, ArrayList<ha> arrayList2) {
        long jI = i();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.K.get(i);
            if (jI > 0 && (this.L || i == 0)) {
                long jI2 = transition.i();
                if (jI2 > 0) {
                    transition.b(jI2 + jI);
                } else {
                    transition.b(jI);
                }
            }
            transition.a(viewGroup, iaVar, iaVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    public void a(ha haVar) {
        if (b(haVar.f2247b)) {
            for (Transition transition : this.K) {
                if (transition.b(haVar.f2247b)) {
                    transition.a(haVar);
                    haVar.f2248c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void a(AbstractC0385ea abstractC0385ea) {
        super.a(abstractC0385ea);
        this.O |= 2;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(abstractC0385ea);
        }
    }

    @Override // androidx.transition.Transition
    String a(String str) {
        String strA = super.a(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strA);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append(this.K.get(i).a(str + "  "));
            strA = sb.toString();
        }
        return strA;
    }
}
