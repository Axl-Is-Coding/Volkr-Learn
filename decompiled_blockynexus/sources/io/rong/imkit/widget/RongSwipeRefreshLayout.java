package io.rong.imkit.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class RongSwipeRefreshLayout extends SwipeRefreshLayout {
    private boolean autoLoading;
    private boolean condition4;
    private boolean condition5;
    public boolean isLoadMoreFinish;
    public boolean isRefreshFinish;
    private boolean loadMoreEnabled;
    private float mDownY;
    private OnFlushListener mFlushListener;
    private View mFooterView;
    private ListView mListView;
    private OnLoadListener mOnLoadListener;
    private int mScaledTouchSlop;
    private float mUpY;
    private boolean refreshEnabled;

    public interface OnFlushListener {
        void onFlush();
    }

    public interface OnLoadListener {
        void onLoad();
    }

    public RongSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canLoadMore() {
        return (((this.mDownY - this.mUpY) > ((float) this.mScaledTouchSlop) ? 1 : ((this.mDownY - this.mUpY) == ((float) this.mScaledTouchSlop) ? 0 : -1)) >= 0) && (this.isLoadMoreFinish ^ true) && (this.isRefreshFinish ^ true) && this.condition4 && this.condition5 && this.loadMoreEnabled;
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.mFooterView = View.inflate(context, R.layout.view_footer, null);
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        setLoadMoreFinish(true);
        if (this.mOnLoadListener != null) {
            new Handler().postDelayed(new Runnable() { // from class: io.rong.imkit.widget.RongSwipeRefreshLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    RongSwipeRefreshLayout.this.mOnLoadListener.onLoad();
                }
            }, 3000L);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: io.rong.imkit.widget.RongSwipeRefreshLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    RongSwipeRefreshLayout.this.setLoadMoreFinish(false);
                }
            }, 2000L);
        }
    }

    private void setListViewOnScroll() {
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: io.rong.imkit.widget.RongSwipeRefreshLayout.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                RongSwipeRefreshLayout.this.condition4 = false;
                RongSwipeRefreshLayout.this.condition5 = false;
                if (i + i2 == i3 && (childAt = RongSwipeRefreshLayout.this.mListView.getChildAt(RongSwipeRefreshLayout.this.mListView.getChildCount() - 1)) != null && childAt.getBottom() == RongSwipeRefreshLayout.this.mListView.getHeight()) {
                    RongSwipeRefreshLayout.this.condition4 = true;
                }
                if (i3 > i2) {
                    RongSwipeRefreshLayout.this.condition5 = true;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (RongSwipeRefreshLayout.this.canLoadMore() && RongSwipeRefreshLayout.this.autoLoading) {
                    RongSwipeRefreshLayout.this.loadData();
                }
            }
        });
    }

    private void setOnRefresh() {
        if (this.isLoadMoreFinish) {
            setRefreshing(false);
        } else {
            setOnRefreshListener(new SwipeRefreshLayout.b() { // from class: io.rong.imkit.widget.RongSwipeRefreshLayout.4
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.b
                public void onRefresh() {
                    RongSwipeRefreshLayout.this.setRefreshing(true);
                    if (RongSwipeRefreshLayout.this.mFlushListener != null) {
                        RongSwipeRefreshLayout.this.mFlushListener.onFlush();
                    } else {
                        new Handler().postDelayed(new Runnable() { // from class: io.rong.imkit.widget.RongSwipeRefreshLayout.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RongSwipeRefreshLayout.this.setRefreshing(false);
                            }
                        }, 2000L);
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownY = motionEvent.getY();
        } else if (action == 2) {
            this.mUpY = motionEvent.getY();
            if (canLoadMore() && !this.autoLoading) {
                loadData();
            }
        }
        if (this.refreshEnabled) {
            if (this.isLoadMoreFinish) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mListView == null) {
            if (getChildCount() > 0 && (getChildAt(0) instanceof ListView)) {
                this.mListView = (ListView) getChildAt(0);
                setListViewOnScroll();
            }
            setOnRefresh();
        }
    }

    public void setAutoLoading(boolean z) {
        this.autoLoading = z;
    }

    public void setCanLoading(boolean z) {
        this.loadMoreEnabled = z;
    }

    public void setCanRefresh(boolean z) {
        this.refreshEnabled = z;
        setEnabled(z);
    }

    public void setLoadMoreFinish(boolean z) {
        this.isLoadMoreFinish = z;
        if (!this.isLoadMoreFinish) {
            ListView listView = this.mListView;
            if (listView != null && listView.getFooterViewsCount() > 0) {
                this.mListView.removeFooterView(this.mFooterView);
            }
            this.mDownY = WheelView.DividerConfig.FILL;
            this.mUpY = WheelView.DividerConfig.FILL;
            return;
        }
        ListView listView2 = this.mListView;
        if (listView2 != null) {
            listView2.addFooterView(this.mFooterView);
            if (Build.VERSION.SDK_INT < 19) {
                ListView listView3 = this.mListView;
                listView3.setAdapter(listView3.getAdapter());
            }
            if (this.mListView.getAdapter() != null) {
                this.mListView.smoothScrollToPosition(r2.getAdapter().getCount() - 1);
            }
        }
    }

    public void setOnFlushListener(OnFlushListener onFlushListener) {
        this.mFlushListener = onFlushListener;
    }

    public void setOnLoadListener(OnLoadListener onLoadListener) {
        this.mOnLoadListener = onLoadListener;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public void setRefreshing(boolean z) {
        this.isRefreshFinish = z;
        super.setRefreshing(z);
    }

    public RongSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.condition4 = false;
        this.condition5 = false;
        this.loadMoreEnabled = true;
        this.refreshEnabled = true;
        initView(context, attributeSet);
    }
}
