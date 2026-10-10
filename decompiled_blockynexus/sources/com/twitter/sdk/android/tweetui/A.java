package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import com.twitter.sdk.android.core.models.f;

/* JADX INFO: compiled from: TimelineListAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class A<T extends com.twitter.sdk.android.core.models.f> extends BaseAdapter {
    protected final Context context;
    protected final z<T> delegate;

    A(Context context, x<T> xVar) {
        this(context, new z(xVar));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.delegate.a();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.delegate.b(i);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.delegate.b();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        this.delegate.c();
    }

    public void refresh(com.twitter.sdk.android.core.c<B<T>> cVar) {
        this.delegate.a(cVar);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.delegate.a(dataSetObserver);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.delegate.b(dataSetObserver);
    }

    A(Context context, z<T> zVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.context = context;
        this.delegate = zVar;
        zVar.a((com.twitter.sdk.android.core.c) null);
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return (T) this.delegate.a(i);
    }
}
