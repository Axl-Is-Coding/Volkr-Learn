package io.rong.imkit.emoticon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import io.rong.imkit.R;
import io.rong.imkit.utilities.RongUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class EmoticonTabAdapter {
    private View extraTabBarItem;
    private TabPagerAdapter mAdapter;
    private View mContainer;
    private IEmoticonTab mCurrentTab;
    private IEmoticonClickListener mEmoticonClickListener;
    private IEmoticonSettingClickListener mEmoticonSettingClickListener;
    private boolean mInitialized;
    private ViewGroup mScrollTab;
    private View mTabAdd;
    private View mTabSetting;
    private ViewPager mViewPager;
    private int selected = 0;
    private boolean mTabBarEnabled = true;
    private boolean mAddEnabled = false;
    private boolean mSettingEnabled = false;
    private View.OnClickListener tabClickListener = new View.OnClickListener() { // from class: io.rong.imkit.emoticon.EmoticonTabAdapter.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int childCount = EmoticonTabAdapter.this.mScrollTab.getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    if (view.equals(EmoticonTabAdapter.this.mScrollTab.getChildAt(i))) {
                        EmoticonTabAdapter.this.mViewPager.setCurrentItem(i);
                        return;
                    }
                }
            }
        }
    };
    private LinkedHashMap<String, List<IEmoticonTab>> mEmotionTabs = new LinkedHashMap<>();

    private class TabPagerAdapter extends a {
        private TabPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return EmoticonTabAdapter.this.getAllTabs().size();
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.a
        public View instantiateItem(ViewGroup viewGroup, int i) {
            View viewObtainTabPager = EmoticonTabAdapter.this.getTab(i).obtainTabPager(viewGroup.getContext());
            if (viewObtainTabPager.getParent() == null) {
                viewGroup.addView(viewObtainTabPager);
            }
            return viewObtainTabPager;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<IEmoticonTab> getAllTabs() {
        Collection<List<IEmoticonTab>> collectionValues = this.mEmotionTabs.values();
        ArrayList arrayList = new ArrayList();
        for (List<IEmoticonTab> list : collectionValues) {
            for (int i = 0; list != null && i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    private int getIndex(IEmoticonTab iEmoticonTab) {
        return getAllTabs().indexOf(iEmoticonTab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IEmoticonTab getTab(int i) {
        return getAllTabs().get(i);
    }

    private View getTabIcon(Context context, IEmoticonTab iEmoticonTab) {
        return getTabIcon(context, iEmoticonTab.obtainTabDrawable(context));
    }

    private View initView(Context context, ViewGroup viewGroup) {
        int index;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_ext_emoticon_tab_container, (ViewGroup) null);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.rc_extension_board_height)));
        this.mViewPager = (ViewPager) viewInflate.findViewById(R.id.rc_view_pager);
        this.mScrollTab = (ViewGroup) viewInflate.findViewById(R.id.rc_emotion_scroll_tab);
        this.mTabAdd = viewInflate.findViewById(R.id.rc_emoticon_tab_add);
        this.mTabAdd.setVisibility(this.mAddEnabled ? 0 : 8);
        this.mTabAdd.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.emoticon.EmoticonTabAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmoticonTabAdapter.this.mEmoticonClickListener != null) {
                    EmoticonTabAdapter.this.mEmoticonClickListener.onAddClick(view);
                }
            }
        });
        this.mTabSetting = viewInflate.findViewById(R.id.rc_emoticon_tab_setting);
        this.mTabSetting.setVisibility(this.mSettingEnabled ? 0 : 8);
        this.mTabSetting.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.emoticon.EmoticonTabAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmoticonTabAdapter.this.mEmoticonSettingClickListener != null) {
                    EmoticonTabAdapter.this.mEmoticonSettingClickListener.onSettingClick(view);
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.rc_emotion_tab_bar);
        if (this.mTabBarEnabled) {
            linearLayout.setVisibility(0);
            View view = this.extraTabBarItem;
            if (view != null && this.mAddEnabled) {
                linearLayout.addView(view, 1);
            }
        } else {
            linearLayout.setVisibility(8);
        }
        Iterator<IEmoticonTab> it = getAllTabs().iterator();
        while (it.hasNext()) {
            this.mScrollTab.addView(getTabIcon(context, it.next()));
        }
        this.mAdapter = new TabPagerAdapter();
        this.mViewPager.setAdapter(this.mAdapter);
        this.mViewPager.setOffscreenPageLimit(6);
        this.mViewPager.addOnPageChangeListener(new ViewPager.e() { // from class: io.rong.imkit.emoticon.EmoticonTabAdapter.3
            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrolled(int i, float f2, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageSelected(int i) {
                EmoticonTabAdapter emoticonTabAdapter = EmoticonTabAdapter.this;
                emoticonTabAdapter.onPageChanged(emoticonTabAdapter.selected, i);
                EmoticonTabAdapter.this.selected = i;
            }
        });
        IEmoticonTab iEmoticonTab = this.mCurrentTab;
        if (iEmoticonTab == null || (index = getIndex(iEmoticonTab)) < 0) {
            onPageChanged(-1, 0);
        } else {
            this.mCurrentTab = null;
            onPageChanged(-1, index);
            this.mViewPager.setCurrentItem(index);
        }
        viewGroup.addView(viewInflate);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageChanged(int i, int i2) {
        IEmoticonTab tab;
        int childCount = this.mScrollTab.getChildCount();
        if (childCount > 0 && i2 < childCount) {
            if (i >= 0 && i < childCount) {
                ((ViewGroup) this.mScrollTab.getChildAt(i)).setBackgroundColor(0);
            }
            if (i2 >= 0) {
                ViewGroup viewGroup = (ViewGroup) this.mScrollTab.getChildAt(i2);
                viewGroup.setBackgroundColor(viewGroup.getContext().getResources().getColor(R.color.rc_EmoticonTab_bg_select_color));
                int measuredWidth = viewGroup.getMeasuredWidth();
                if (measuredWidth != 0) {
                    int screenWidth = RongUtils.getScreenWidth();
                    if (this.mAddEnabled) {
                        screenWidth -= this.mTabAdd.getMeasuredWidth();
                    }
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) this.mScrollTab.getParent();
                    int scrollX = horizontalScrollView.getScrollX();
                    int i3 = scrollX - ((scrollX / measuredWidth) * measuredWidth);
                    int i4 = i2 * measuredWidth;
                    if (i4 < scrollX) {
                        horizontalScrollView.smoothScrollBy(i3 == 0 ? -measuredWidth : -i3, 0);
                    } else if (i4 - scrollX > screenWidth - measuredWidth) {
                        horizontalScrollView.smoothScrollBy(measuredWidth - i3, 0);
                    }
                }
            }
        }
        if (i2 < 0 || i2 >= childCount || (tab = getTab(i2)) == null) {
            return;
        }
        tab.onTableSelected(i2);
    }

    public void addExtraTab(Context context, Drawable drawable, View.OnClickListener onClickListener) {
        this.extraTabBarItem = getTabIcon(context, drawable);
        this.extraTabBarItem.setOnClickListener(onClickListener);
    }

    public boolean addTab(int i, IEmoticonTab iEmoticonTab, String str) {
        ViewPager viewPager;
        List<IEmoticonTab> list = this.mEmotionTabs.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iEmoticonTab);
            this.mEmotionTabs.put(str, arrayList);
        } else {
            if (i > list.size()) {
                return false;
            }
            list.add(i, iEmoticonTab);
        }
        int index = getIndex(iEmoticonTab);
        if (this.mAdapter == null || (viewPager = this.mViewPager) == null) {
            return true;
        }
        this.mScrollTab.addView(getTabIcon(viewPager.getContext(), iEmoticonTab), index);
        this.mAdapter.notifyDataSetChanged();
        ViewPager viewPager2 = this.mViewPager;
        int i2 = this.selected;
        if (index <= i2) {
            i2++;
        }
        viewPager2.setCurrentItem(i2);
        return true;
    }

    public void bindView(ViewGroup viewGroup) {
        this.mInitialized = true;
        this.mContainer = initView(viewGroup.getContext(), viewGroup);
    }

    public LinkedHashMap<String, List<IEmoticonTab>> getTabList() {
        return this.mEmotionTabs;
    }

    public int getTagTabIndex(String str) {
        return new ArrayList(this.mEmotionTabs.keySet()).indexOf(str);
    }

    public List<IEmoticonTab> getTagTabs(String str) {
        return this.mEmotionTabs.get(str);
    }

    public int getVisibility() {
        View view = this.mContainer;
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public void initTabs(List<IEmoticonTab> list, String str) {
        if (list != null) {
            this.mEmotionTabs.put(str, list);
        }
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void refreshTabIcon(IEmoticonTab iEmoticonTab, Drawable drawable) {
        int index = getIndex(iEmoticonTab);
        if (index >= 0) {
            ((ImageView) this.mScrollTab.getChildAt(index).findViewById(R.id.rc_emoticon_tab_iv)).setImageDrawable(drawable);
        }
    }

    public boolean removeTab(IEmoticonTab iEmoticonTab, String str) {
        boolean z = false;
        if (!this.mEmotionTabs.containsKey(str)) {
            return false;
        }
        List<IEmoticonTab> list = this.mEmotionTabs.get(str);
        int index = getIndex(iEmoticonTab);
        if (list != null && list.remove(iEmoticonTab)) {
            this.mScrollTab.removeViewAt(index);
            this.mAdapter.notifyDataSetChanged();
            z = true;
            int i = this.selected;
            if (i == index) {
                this.mViewPager.setCurrentItem(i);
                onPageChanged(-1, this.selected);
            }
        }
        return z;
    }

    public void setAddEnable(boolean z) {
        this.mAddEnabled = z;
        View view = this.mTabAdd;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setCurrentTab(IEmoticonTab iEmoticonTab, String str) {
        int index;
        if (this.mEmotionTabs.containsKey(str)) {
            this.mCurrentTab = iEmoticonTab;
            if (this.mAdapter == null || this.mViewPager == null || (index = getIndex(iEmoticonTab)) < 0) {
                return;
            }
            this.mViewPager.setCurrentItem(index);
            this.mCurrentTab = null;
        }
    }

    public void setOnEmoticonClickListener(IEmoticonClickListener iEmoticonClickListener) {
        this.mEmoticonClickListener = iEmoticonClickListener;
    }

    public void setOnEmoticonSettingClickListener(IEmoticonSettingClickListener iEmoticonSettingClickListener) {
        this.mEmoticonSettingClickListener = iEmoticonSettingClickListener;
    }

    public void setSettingEnable(boolean z) {
        this.mSettingEnabled = z;
        View view = this.mTabSetting;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTabViewEnable(boolean z) {
        this.mTabBarEnabled = z;
    }

    public void setVisibility(int i) {
        View view = this.mContainer;
        if (view != null) {
            if (i == 0) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    private View getTabIcon(Context context, Drawable drawable) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_ext_emoticon_tab_item, (ViewGroup) null);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(RongUtils.dip2px(60.0f), RongUtils.dip2px(36.0f)));
        ((ImageView) viewInflate.findViewById(R.id.rc_emoticon_tab_iv)).setImageDrawable(drawable);
        viewInflate.setOnClickListener(this.tabClickListener);
        return viewInflate;
    }

    public void addTab(IEmoticonTab iEmoticonTab, String str) {
        ViewPager viewPager;
        List<IEmoticonTab> list = this.mEmotionTabs.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iEmoticonTab);
            this.mEmotionTabs.put(str, arrayList);
        } else {
            list.add(iEmoticonTab);
        }
        int index = getIndex(iEmoticonTab);
        if (this.mAdapter == null || (viewPager = this.mViewPager) == null) {
            return;
        }
        this.mScrollTab.addView(getTabIcon(viewPager.getContext(), iEmoticonTab), index);
        this.mAdapter.notifyDataSetChanged();
        ViewPager viewPager2 = this.mViewPager;
        int i = this.selected;
        if (index <= i) {
            i++;
        }
        viewPager2.setCurrentItem(i);
    }
}
