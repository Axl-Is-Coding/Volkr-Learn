package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: FragmentPagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class A extends androidx.viewpager.widget.a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private F mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final AbstractC0336n mFragmentManager;

    @Deprecated
    public A(AbstractC0336n abstractC0336n) {
        this(abstractC0336n, 0);
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.a();
        }
        this.mCurTransaction.b(fragment);
        if (fragment == this.mCurrentPrimaryItem) {
            this.mCurrentPrimaryItem = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup) {
        F f2 = this.mCurTransaction;
        if (f2 != null) {
            f2.d();
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.a();
        }
        long itemId = getItemId(i);
        Fragment fragmentA = this.mFragmentManager.a(makeFragmentName(viewGroup.getId(), itemId));
        if (fragmentA != null) {
            this.mCurTransaction.a(fragmentA);
        } else {
            fragmentA = getItem(i);
            this.mCurTransaction.a(viewGroup.getId(), fragmentA, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (fragmentA != this.mCurrentPrimaryItem) {
            fragmentA.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.a(fragmentA, Lifecycle.State.STARTED);
            } else {
                fragmentA.setUserVisibleHint(false);
            }
        }
        return fragmentA;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.a();
                    }
                    this.mCurTransaction.a(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.a();
                }
                this.mCurTransaction.a(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public A(AbstractC0336n abstractC0336n, int i) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = abstractC0336n;
        this.mBehavior = i;
    }
}
