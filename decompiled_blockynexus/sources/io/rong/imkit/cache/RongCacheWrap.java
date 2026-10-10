package io.rong.imkit.cache;

import io.rong.imkit.RongContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RongCacheWrap<K, V> extends RongCache<K, V> {
    private RongContext mContext;
    private boolean mIsSync;

    public RongCacheWrap(RongContext rongContext, int i) {
        super(i);
        this.mIsSync = false;
        this.mContext = rongContext;
    }

    @Override // io.rong.imkit.cache.RongCache
    protected V create(K k) {
        if (k == null) {
            return null;
        }
        if (this.mIsSync) {
            return obtainValue(k);
        }
        executeCacheProvider(k);
        return (V) super.create(k);
    }

    public void executeCacheProvider(final K k) {
        this.mContext.executorBackground(new Runnable() { // from class: io.rong.imkit.cache.RongCacheWrap.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                RongCacheWrap.this.obtainValue(k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RongContext getContext() {
        return this.mContext;
    }

    public boolean isIsSync() {
        return this.mIsSync;
    }

    public abstract V obtainValue(K k);

    public void setIsSync(boolean z) {
        this.mIsSync = z;
    }
}
