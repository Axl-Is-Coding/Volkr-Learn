package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {
    protected final DataBuffer<T> zalk;
    protected int zall;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        Preconditions.checkNotNull(dataBuffer);
        this.zalk = dataBuffer;
        this.zall = -1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.zall < this.zalk.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.zalk;
            int i = this.zall + 1;
            this.zall = i;
            return dataBuffer.get(i);
        }
        int i2 = this.zall;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
