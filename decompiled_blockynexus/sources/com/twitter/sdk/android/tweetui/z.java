package com.twitter.sdk.android.tweetui;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TimelineDelegate.java */
/* JADX INFO: loaded from: classes5.dex */
class z<T extends com.twitter.sdk.android.core.models.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final x<T> f20468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final DataSetObservable f20469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final C f20470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    List<T> f20471d;

    /* JADX INFO: compiled from: TimelineDelegate.java */
    class b extends z<T>.a {
        b(com.twitter.sdk.android.core.c<B<T>> cVar, C c2) {
            super(cVar, c2);
        }

        @Override // com.twitter.sdk.android.tweetui.z.a, com.twitter.sdk.android.core.c
        public void a(com.twitter.sdk.android.core.k<B<T>> kVar) {
            if (kVar.f20217a.f20319b.size() > 0) {
                ArrayList arrayList = new ArrayList(kVar.f20217a.f20319b);
                arrayList.addAll(z.this.f20471d);
                z zVar = z.this;
                zVar.f20471d = arrayList;
                zVar.b();
                this.f20473b.b(kVar.f20217a.f20318a);
            }
            super.a(kVar);
        }
    }

    /* JADX INFO: compiled from: TimelineDelegate.java */
    class c extends z<T>.a {
        c(C c2) {
            super(null, c2);
        }

        @Override // com.twitter.sdk.android.tweetui.z.a, com.twitter.sdk.android.core.c
        public void a(com.twitter.sdk.android.core.k<B<T>> kVar) {
            if (kVar.f20217a.f20319b.size() > 0) {
                z.this.f20471d.addAll(kVar.f20217a.f20319b);
                z.this.b();
                this.f20473b.c(kVar.f20217a.f20318a);
            }
            super.a(kVar);
        }
    }

    /* JADX INFO: compiled from: TimelineDelegate.java */
    class d extends z<T>.b {
        d(com.twitter.sdk.android.core.c<B<T>> cVar, C c2) {
            super(cVar, c2);
        }

        @Override // com.twitter.sdk.android.tweetui.z.b, com.twitter.sdk.android.tweetui.z.a, com.twitter.sdk.android.core.c
        public void a(com.twitter.sdk.android.core.k<B<T>> kVar) {
            if (kVar.f20217a.f20319b.size() > 0) {
                z.this.f20471d.clear();
            }
            super.a(kVar);
        }
    }

    z(x<T> xVar) {
        this(xVar, null, null);
    }

    public void a(com.twitter.sdk.android.core.c<B<T>> cVar) {
        this.f20470c.d();
        a(this.f20470c.b(), new d(cVar, this.f20470c));
    }

    public long b(int i) {
        return this.f20471d.get(i).getId();
    }

    boolean c(int i) {
        return i == this.f20471d.size() - 1;
    }

    public void d() {
        b(this.f20470c.c(), new c(this.f20470c));
    }

    boolean e() {
        return ((long) this.f20471d.size()) < 200;
    }

    z(x<T> xVar, DataSetObservable dataSetObservable, List<T> list) {
        if (xVar == null) {
            throw new IllegalArgumentException("Timeline must not be null");
        }
        this.f20468a = xVar;
        this.f20470c = new C();
        if (dataSetObservable == null) {
            this.f20469b = new DataSetObservable();
        } else {
            this.f20469b = dataSetObservable;
        }
        if (list == null) {
            this.f20471d = new ArrayList();
        } else {
            this.f20471d = list;
        }
    }

    public void c() {
        this.f20469b.notifyInvalidated();
    }

    /* JADX INFO: compiled from: TimelineDelegate.java */
    class a extends com.twitter.sdk.android.core.c<B<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.twitter.sdk.android.core.c<B<T>> f20472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final C f20473b;

        a(com.twitter.sdk.android.core.c<B<T>> cVar, C c2) {
            this.f20472a = cVar;
            this.f20473b = c2;
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(com.twitter.sdk.android.core.k<B<T>> kVar) {
            this.f20473b.a();
            com.twitter.sdk.android.core.c<B<T>> cVar = this.f20472a;
            if (cVar != null) {
                cVar.a(kVar);
            }
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(TwitterException twitterException) {
            this.f20473b.a();
            com.twitter.sdk.android.core.c<B<T>> cVar = this.f20472a;
            if (cVar != null) {
                cVar.a(twitterException);
            }
        }
    }

    public int a() {
        return this.f20471d.size();
    }

    void b(Long l, com.twitter.sdk.android.core.c<B<T>> cVar) {
        if (e()) {
            if (this.f20470c.e()) {
                this.f20468a.b(l, cVar);
                return;
            } else {
                cVar.a(new TwitterException("Request already in flight"));
                return;
            }
        }
        cVar.a(new TwitterException("Max capacity reached"));
    }

    public T a(int i) {
        if (c(i)) {
            d();
        }
        return this.f20471d.get(i);
    }

    public void a(T t) {
        for (int i = 0; i < this.f20471d.size(); i++) {
            if (t.getId() == this.f20471d.get(i).getId()) {
                this.f20471d.set(i, t);
            }
        }
        b();
    }

    public void b(DataSetObserver dataSetObserver) {
        this.f20469b.unregisterObserver(dataSetObserver);
    }

    public void b() {
        this.f20469b.notifyChanged();
    }

    void a(Long l, com.twitter.sdk.android.core.c<B<T>> cVar) {
        if (e()) {
            if (this.f20470c.e()) {
                this.f20468a.a(l, cVar);
                return;
            } else {
                cVar.a(new TwitterException("Request already in flight"));
                return;
            }
        }
        cVar.a(new TwitterException("Max capacity reached"));
    }

    public void a(DataSetObserver dataSetObserver) {
        this.f20469b.registerObserver(dataSetObserver);
    }
}
