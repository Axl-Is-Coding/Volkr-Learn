package com.sandboxol.decorate.manager.a;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.decorate.c.AbstractC2597w;

/* JADX INFO: compiled from: ExecutionParam.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ObservableMap<Long, String> f17155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f17156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ObservableList<ViewModel> f17157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    AbstractC2597w f17158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ObservableField<Boolean> f17159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ObservableField<Boolean> f17160f;

    /* JADX INFO: compiled from: ExecutionParam.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ObservableMap<Long, String> f17161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ObservableList<ViewModel> f17163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        AbstractC2597w f17164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ObservableField<Boolean> f17165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ObservableField<Boolean> f17166f;

        public a a(ObservableList<ViewModel> observableList) {
            this.f17163c = observableList;
            return this;
        }

        public a b(ObservableField<Boolean> observableField) {
            this.f17165e = observableField;
            return this;
        }

        public a a(AbstractC2597w abstractC2597w) {
            this.f17164d = abstractC2597w;
            return this;
        }

        public a a(ObservableField<Boolean> observableField) {
            this.f17166f = observableField;
            return this;
        }

        void a(c cVar) {
            cVar.f17155a = this.f17161a;
            cVar.f17156b = this.f17162b;
            cVar.f17157c = this.f17163c;
            cVar.f17158d = this.f17164d;
            cVar.f17159e = this.f17165e;
            cVar.f17160f = this.f17166f;
        }

        public c a() {
            c cVar = new c();
            a(cVar);
            return cVar;
        }
    }

    public AbstractC2597w a() {
        return this.f17158d;
    }

    public int b() {
        return this.f17156b;
    }

    public ObservableList<ViewModel> c() {
        return this.f17157c;
    }
}
