package io.rong.imkit.widget;

import android.os.SystemClock;
import android.view.View;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DebouncedOnClickListener implements View.OnClickListener {
    private static final long DEFAULT_MIN_INTERNAL = 500;
    private Map<View, Long> mClickMap;
    private final long mMinInterval;

    public DebouncedOnClickListener(long j) {
        this.mMinInterval = j;
        this.mClickMap = new WeakHashMap();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Long l = this.mClickMap.get(view);
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.mClickMap.put(view, Long.valueOf(jUptimeMillis));
        if (l == null || jUptimeMillis - l.longValue() > this.mMinInterval) {
            onDebouncedClick(view);
        }
    }

    public abstract void onDebouncedClick(View view);

    public DebouncedOnClickListener() {
        this(DEFAULT_MIN_INTERNAL);
    }
}
