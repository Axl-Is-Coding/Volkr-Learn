package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private AbstractC0336n mFragmentManager;
    private c mLastTab;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<c> mTabs;

    static class a implements TabHost.TabContentFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f1437a;

        public a(Context context) {
            this.f1437a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f1437a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new E();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1438a;

        b(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f1438a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f1438a);
        }

        b(Parcel parcel) {
            super(parcel);
            this.f1438a = parcel.readString();
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<?> f1440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Bundle f1441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Fragment f1442d;

        c(String str, Class<?> cls, Bundle bundle) {
            this.f1439a = str;
            this.f1440b = cls;
            this.f1441c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.mTabs = new ArrayList<>();
        initFragmentTabHost(context, null);
    }

    private F doTabChanged(String str, F f2) {
        Fragment fragment;
        c tabInfoForTag = getTabInfoForTag(str);
        if (this.mLastTab != tabInfoForTag) {
            if (f2 == null) {
                f2 = this.mFragmentManager.a();
            }
            c cVar = this.mLastTab;
            if (cVar != null && (fragment = cVar.f1442d) != null) {
                f2.b(fragment);
            }
            if (tabInfoForTag != null) {
                Fragment fragment2 = tabInfoForTag.f1442d;
                if (fragment2 == null) {
                    tabInfoForTag.f1442d = this.mFragmentManager.d().a(this.mContext.getClassLoader(), tabInfoForTag.f1440b.getName());
                    tabInfoForTag.f1442d.setArguments(tabInfoForTag.f1441c);
                    f2.a(this.mContainerId, tabInfoForTag.f1442d, tabInfoForTag.f1439a);
                } else {
                    f2.a(fragment2);
                }
            }
            this.mLastTab = tabInfoForTag;
        }
        return f2;
    }

    private void ensureContent() {
        if (this.mRealTabContent == null) {
            this.mRealTabContent = (FrameLayout) findViewById(this.mContainerId);
            if (this.mRealTabContent != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
        }
    }

    private void ensureHierarchy(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, WheelView.DividerConfig.FILL));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, WheelView.DividerConfig.FILL));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.mRealTabContent = frameLayout2;
            this.mRealTabContent.setId(this.mContainerId);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    private c getTabInfoForTag(String str) {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.mTabs.get(i);
            if (cVar.f1439a.equals(str)) {
                return cVar;
            }
        }
        return null;
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.mContainerId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new a(this.mContext));
        String tag = tabSpec.getTag();
        c cVar = new c(tag, cls, bundle);
        if (this.mAttached) {
            cVar.f1442d = this.mFragmentManager.a(tag);
            Fragment fragment = cVar.f1442d;
            if (fragment != null && !fragment.isDetached()) {
                F fA = this.mFragmentManager.a();
                fA.b(cVar.f1442d);
                fA.a();
            }
        }
        this.mTabs.add(cVar);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.mTabs.size();
        F fA = null;
        for (int i = 0; i < size; i++) {
            c cVar = this.mTabs.get(i);
            cVar.f1442d = this.mFragmentManager.a(cVar.f1439a);
            Fragment fragment = cVar.f1442d;
            if (fragment != null && !fragment.isDetached()) {
                if (cVar.f1439a.equals(currentTabTag)) {
                    this.mLastTab = cVar;
                } else {
                    if (fA == null) {
                        fA = this.mFragmentManager.a();
                    }
                    fA.b(cVar.f1442d);
                }
            }
        }
        this.mAttached = true;
        F fDoTabChanged = doTabChanged(currentTabTag, fA);
        if (fDoTabChanged != null) {
            fDoTabChanged.a();
            this.mFragmentManager.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCurrentTabByTag(bVar.f1438a);
    }

    @Override // android.view.View
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f1438a = getCurrentTabTag();
        return bVar;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        F fDoTabChanged;
        if (this.mAttached && (fDoTabChanged = doTabChanged(str, null)) != null) {
            fDoTabChanged.a();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, AbstractC0336n abstractC0336n) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = abstractC0336n;
        ensureContent();
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabs = new ArrayList<>();
        initFragmentTabHost(context, attributeSet);
    }

    @Deprecated
    public void setup(Context context, AbstractC0336n abstractC0336n, int i) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = abstractC0336n;
        this.mContainerId = i;
        ensureContent();
        this.mRealTabContent.setId(i);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
