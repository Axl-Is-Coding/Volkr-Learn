package io.rong.imkit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class ProviderContainerView extends FrameLayout {
    Map<Class<? extends IContainerItemProvider>, View> mContentViewMap;
    View mInflateView;
    int mMaxContainSize;
    Map<Class<? extends IContainerItemProvider>, AtomicInteger> mViewCounterMap;

    public ProviderContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxContainSize = 3;
        if (isInEditMode()) {
            return;
        }
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.mViewCounterMap = new HashMap();
        this.mContentViewMap = new HashMap();
    }

    private void recycle() {
        if (this.mInflateView != null && getChildCount() >= this.mMaxContainSize) {
            Map.Entry<Class<? extends IContainerItemProvider>, AtomicInteger> entry = null;
            for (Map.Entry<Class<? extends IContainerItemProvider>, AtomicInteger> entry2 : this.mViewCounterMap.entrySet()) {
                if (entry == null) {
                    entry = entry2;
                }
                if (entry.getValue().get() > entry2.getValue().get()) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                return;
            }
            this.mViewCounterMap.remove(entry.getKey());
            removeView(this.mContentViewMap.remove(entry.getKey()));
        }
    }

    public void containerViewCenter() {
        View view = this.mInflateView;
        if (view == null) {
            return;
        }
        ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 17;
    }

    public void containerViewLeft() {
        View view = this.mInflateView;
        if (view == null) {
            return;
        }
        ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 19;
    }

    public void containerViewRight() {
        View view = this.mInflateView;
        if (view == null) {
            return;
        }
        ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 21;
    }

    public View getCurrentInflateView() {
        return this.mInflateView;
    }

    public <T extends IContainerItemProvider> View inflate(T t) {
        View view;
        View view2 = this.mInflateView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (this.mContentViewMap.containsKey(t.getClass())) {
            view = this.mContentViewMap.get(t.getClass());
            this.mInflateView = view;
            AtomicInteger atomicInteger = this.mViewCounterMap.get(t.getClass());
            if (atomicInteger != null) {
                atomicInteger.incrementAndGet();
            }
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getVisibility() == 8) {
                view.setVisibility(0);
            }
            return view;
        }
        recycle();
        View viewNewView = t.newView(getContext(), this);
        if (viewNewView != null) {
            super.addView(viewNewView);
            this.mContentViewMap.put((Class<? extends IContainerItemProvider>) t.getClass(), viewNewView);
            this.mViewCounterMap.put((Class<? extends IContainerItemProvider>) t.getClass(), new AtomicInteger());
        }
        this.mInflateView = viewNewView;
        return viewNewView;
    }
}
