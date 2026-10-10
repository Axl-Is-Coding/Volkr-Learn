package io.rong.imkit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AutoRefreshListView extends ListView {
    private static final String TAG = "AutoRefreshListView";
    private Mode currentMode;
    private boolean isBeingDragged;
    private Iterator<AbsListView.OnScrollListener> iterator;
    private Mode mode;
    private int offsetY;
    private ViewGroup refreshFooter;
    private ViewGroup refreshHeader;
    private OnRefreshListener refreshListener;
    private boolean refreshableEnd;
    private boolean refreshableStart;
    private List<AbsListView.OnScrollListener> scrollListeners;
    private int startY;
    private State state;

    /* JADX INFO: renamed from: io.rong.imkit.widget.AutoRefreshListView$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$imkit$widget$AutoRefreshListView$Mode = new int[Mode.values().length];
        static final /* synthetic */ int[] $SwitchMap$io$rong$imkit$widget$AutoRefreshListView$State;

        static {
            try {
                $SwitchMap$io$rong$imkit$widget$AutoRefreshListView$Mode[Mode.END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$imkit$widget$AutoRefreshListView$Mode[Mode.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $SwitchMap$io$rong$imkit$widget$AutoRefreshListView$State = new int[State.values().length];
            try {
                $SwitchMap$io$rong$imkit$widget$AutoRefreshListView$State[State.REFRESHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$rong$imkit$widget$AutoRefreshListView$State[State.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum Mode {
        START,
        END,
        BOTH
    }

    public interface OnRefreshListener {
        void onRefreshFromEnd();

        void onRefreshFromStart();
    }

    public enum State {
        REFRESHING,
        RESET
    }

    public AutoRefreshListView(Context context) {
        super(context);
        this.scrollListeners = new ArrayList();
        this.state = State.RESET;
        Mode mode = Mode.START;
        this.mode = mode;
        this.currentMode = mode;
        this.refreshableStart = true;
        this.refreshableEnd = true;
        this.isBeingDragged = false;
        this.startY = 0;
        init(context);
    }

    private void addRefreshView(Context context) {
        this.refreshHeader = (ViewGroup) View.inflate(context, R.layout.rc_refresh_list_view, null);
        addHeaderView(this.refreshHeader, null, false);
        this.refreshFooter = (ViewGroup) View.inflate(context, R.layout.rc_refresh_list_view, null);
        addFooterView(this.refreshFooter, null, false);
    }

    private ViewGroup getRefreshView() {
        return AnonymousClass3.$SwitchMap$io$rong$imkit$widget$AutoRefreshListView$Mode[this.currentMode.ordinal()] != 1 ? this.refreshHeader : this.refreshFooter;
    }

    private void init(Context context) {
        addRefreshView(context);
        super.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: io.rong.imkit.widget.AutoRefreshListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AutoRefreshListView autoRefreshListView = AutoRefreshListView.this;
                autoRefreshListView.iterator = autoRefreshListView.scrollListeners.iterator();
                while (AutoRefreshListView.this.iterator.hasNext()) {
                    ((AbsListView.OnScrollListener) AutoRefreshListView.this.iterator.next()).onScroll(absListView, i, i2, i3);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                Iterator it = AutoRefreshListView.this.scrollListeners.iterator();
                while (it.hasNext()) {
                    ((AbsListView.OnScrollListener) it.next()).onScrollStateChanged(absListView, i);
                }
            }
        });
        initRefreshListener();
        this.state = State.RESET;
    }

    private void initRefreshListener() {
        addOnScrollListener(new AbsListView.OnScrollListener() { // from class: io.rong.imkit.widget.AutoRefreshListView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && AutoRefreshListView.this.state == State.RESET) {
                    if (AutoRefreshListView.this.getFirstVisiblePosition() < AutoRefreshListView.this.getHeaderViewsCount() && AutoRefreshListView.this.getCount() > AutoRefreshListView.this.getHeaderViewsCount()) {
                        AutoRefreshListView.this.onRefresh(true, false);
                        return;
                    }
                    if (AutoRefreshListView.this.getLastVisiblePosition() >= AutoRefreshListView.this.getCount() - 1) {
                        AutoRefreshListView.this.onRefresh(false, true);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefresh(boolean z, boolean z2) {
        if (this.refreshListener != null) {
            View childAt = getChildAt(getHeaderViewsCount());
            if (childAt != null) {
                this.offsetY = childAt.getTop();
            }
            if (z && this.refreshableStart && this.mode != Mode.END) {
                this.currentMode = Mode.START;
                this.state = State.REFRESHING;
                this.refreshListener.onRefreshFromStart();
            } else if (z2 && this.refreshableEnd && this.mode != Mode.START) {
                this.currentMode = Mode.END;
                this.state = State.REFRESHING;
                this.refreshListener.onRefreshFromEnd();
            }
            updateRefreshView();
        }
    }

    private void onTouchBegin(MotionEvent motionEvent) {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.refreshableStart || firstVisiblePosition > getHeaderViewsCount() || this.isBeingDragged) {
            return;
        }
        this.isBeingDragged = true;
        this.startY = (int) motionEvent.getY();
    }

    private void onTouchEnd() {
        if (this.isBeingDragged) {
            this.refreshHeader.setPadding(0, 0, 0, 0);
        }
        this.isBeingDragged = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean onTouchEventInternal(android.view.MotionEvent r3) {
        /*
            r2 = this;
            int r0 = r3.getAction()
            if (r0 == 0) goto L18
            r1 = 1
            if (r0 == r1) goto L14
            r1 = 2
            if (r0 == r1) goto L10
            r1 = 3
            if (r0 == r1) goto L14
            goto L1b
        L10:
            r2.onTouchMove(r3)
            goto L1b
        L14:
            r2.onTouchEnd()
            goto L1b
        L18:
            r2.onTouchBegin(r3)
        L1b:
            boolean r3 = super.onTouchEvent(r3)     // Catch: java.lang.Exception -> L20
            return r3
        L20:
            r3 = move-exception
            java.lang.String r0 = io.rong.imkit.widget.AutoRefreshListView.TAG
            java.lang.String r1 = "onTouchEventInternal catch"
            io.rong.common.RLog.e(r0, r1, r3)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.widget.AutoRefreshListView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void onTouchMove(MotionEvent motionEvent) {
        onTouchBegin(motionEvent);
        if (this.isBeingDragged) {
            this.refreshHeader.setPadding(0, Math.max((int) (motionEvent.getY() - this.startY), 0) / 2, 0, 0);
        }
    }

    private void resetRefreshView(int i, int i2) {
        if (this.currentMode != Mode.START) {
            this.refreshableEnd = i > 0;
        } else if (getCount() == getHeaderViewsCount() + i + getFooterViewsCount()) {
            this.refreshableStart = i == i2;
        } else {
            this.refreshableStart = i > 0;
        }
        updateRefreshView();
    }

    private void updateRefreshView() {
        int i = AnonymousClass3.$SwitchMap$io$rong$imkit$widget$AutoRefreshListView$State[this.state.ordinal()];
        if (i == 1) {
            getRefreshView().getChildAt(0).setVisibility(0);
        } else {
            if (i != 2) {
                return;
            }
            if (this.currentMode == Mode.START) {
                this.refreshHeader.getChildAt(0).setVisibility(8);
            } else {
                this.refreshFooter.getChildAt(0).setVisibility(8);
            }
        }
    }

    public void addOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.scrollListeners.add(onScrollListener);
    }

    public State getRefreshState() {
        return this.state;
    }

    public boolean isLastItemVisible(int i) {
        int count = (getAdapter().getCount() - getHeaderViewsCount()) - 1;
        int lastVisiblePosition = getLastVisiblePosition();
        if (lastVisiblePosition > count) {
            lastVisiblePosition = count;
        }
        return lastVisiblePosition >= (count - i) + 1;
    }

    public void onRefreshComplete(int i, int i2, boolean z) {
        this.state = State.RESET;
        resetRefreshView(i, i2);
        if (z && this.currentMode == Mode.START) {
            setSelectionFromTop(i + getHeaderViewsCount(), this.refreshableStart ? this.offsetY : 0);
        }
    }

    public void onRefreshStart(Mode mode) {
        this.state = State.REFRESHING;
        this.currentMode = mode;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return onTouchEventInternal(motionEvent);
        } catch (Exception e2) {
            RLog.e(TAG, "onTouchEvent", e2);
            return false;
        }
    }

    public void removeCurrentOnScrollListener() {
        this.iterator.remove();
    }

    public void removeOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.scrollListeners.remove(onScrollListener);
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.refreshListener = onRefreshListener;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        throw new UnsupportedOperationException("Use addOnScrollListener instead!");
    }

    public void onRefreshComplete() {
        this.state = State.RESET;
        updateRefreshView();
    }

    public AutoRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollListeners = new ArrayList();
        this.state = State.RESET;
        Mode mode = Mode.START;
        this.mode = mode;
        this.currentMode = mode;
        this.refreshableStart = true;
        this.refreshableEnd = true;
        this.isBeingDragged = false;
        this.startY = 0;
        init(context);
    }

    public AutoRefreshListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scrollListeners = new ArrayList();
        this.state = State.RESET;
        Mode mode = Mode.START;
        this.mode = mode;
        this.currentMode = mode;
        this.refreshableStart = true;
        this.refreshableEnd = true;
        this.isBeingDragged = false;
        this.startY = 0;
        init(context);
    }
}
