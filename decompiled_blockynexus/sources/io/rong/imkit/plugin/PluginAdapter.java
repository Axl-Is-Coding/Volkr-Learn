package io.rong.imkit.plugin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import io.rong.imkit.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PluginAdapter {
    private static final String TAG = "PluginAdapter";
    private View mCustomPager;
    private LinearLayout mIndicator;
    private boolean mInitialized;
    private LayoutInflater mLayoutInflater;
    private PluginPagerAdapter mPagerAdapter;
    private IPluginClickListener mPluginClickListener;
    private int mPluginCountPerPage;
    private ViewGroup mPluginPager;
    private ViewPager mViewPager;
    private int currentPage = 0;
    private List<IPluginModule> mPluginModules = new ArrayList();

    private class PluginItemAdapter extends BaseAdapter {
        int count;
        int index;

        class ViewHolder {
            ImageView imageView;
            TextView textView;

            ViewHolder() {
            }
        }

        public PluginItemAdapter(int i, int i2) {
            this.count = Math.min(PluginAdapter.this.mPluginCountPerPage, i2 - i);
            this.index = i;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.count;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            Context context = viewGroup.getContext();
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = PluginAdapter.this.mLayoutInflater.inflate(R.layout.rc_ext_plugin_item, (ViewGroup) null);
                viewHolder.imageView = (ImageView) viewInflate.findViewById(R.id.rc_ext_plugin_icon);
                viewHolder.textView = (TextView) viewInflate.findViewById(R.id.rc_ext_plugin_title);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.PluginAdapter.PluginItemAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PluginAdapter.this.mPluginClickListener.onClick((IPluginModule) PluginAdapter.this.mPluginModules.get((PluginAdapter.this.currentPage * PluginAdapter.this.mPluginCountPerPage) + i), (PluginAdapter.this.currentPage * PluginAdapter.this.mPluginCountPerPage) + i);
                }
            });
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            IPluginModule iPluginModule = (IPluginModule) PluginAdapter.this.mPluginModules.get(i + this.index);
            viewHolder2.imageView.setImageDrawable(iPluginModule.obtainDrawable(context));
            viewHolder2.textView.setText(iPluginModule.obtainTitle(context));
            return view;
        }
    }

    private class PluginPagerAdapter extends a {
        int items;
        int pages;

        public PluginPagerAdapter(int i, int i2) {
            this.pages = i;
            this.items = i2;
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.pages;
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) PluginAdapter.this.mLayoutInflater.inflate(R.layout.rc_ext_plugin_grid_view, (ViewGroup) null);
            PluginAdapter pluginAdapter = PluginAdapter.this;
            gridView.setAdapter((ListAdapter) pluginAdapter.new PluginItemAdapter(i * pluginAdapter.mPluginCountPerPage, this.items));
            viewGroup.addView(gridView);
            return gridView;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void setItems(int i) {
            this.items = i;
        }

        public void setPages(int i) {
            this.pages = i;
        }
    }

    private void initIndicator(int i, LinearLayout linearLayout) {
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageView = (ImageView) this.mLayoutInflater.inflate(R.layout.rc_ext_indicator, (ViewGroup) null);
            imageView.setImageResource(R.drawable.rc_ext_indicator);
            linearLayout.addView(imageView);
            if (i <= 1) {
                linearLayout.setVisibility(4);
            } else {
                linearLayout.setVisibility(0);
            }
        }
    }

    private void initView(Context context, ViewGroup viewGroup) {
        int i;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mPluginPager = (ViewGroup) this.mLayoutInflater.inflate(R.layout.rc_ext_plugin_pager, (ViewGroup) null);
        this.mPluginPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.rc_extension_board_height)));
        try {
            this.mPluginCountPerPage = context.getResources().getInteger(context.getResources().getIdentifier("rc_extension_plugin_count_per_page", "integer", context.getPackageName()));
        } catch (Exception unused) {
            this.mPluginCountPerPage = 8;
        }
        viewGroup.addView(this.mPluginPager);
        this.mViewPager = (ViewPager) this.mPluginPager.findViewById(R.id.rc_view_pager);
        this.mIndicator = (LinearLayout) this.mPluginPager.findViewById(R.id.rc_indicator);
        this.mViewPager.setOnPageChangeListener(new ViewPager.e() { // from class: io.rong.imkit.plugin.PluginAdapter.1
            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageSelected(int i2) {
                PluginAdapter pluginAdapter = PluginAdapter.this;
                pluginAdapter.onIndicatorChanged(pluginAdapter.currentPage, i2);
                PluginAdapter.this.currentPage = i2;
            }
        });
        int size = this.mPluginModules.size();
        if (size > 0) {
            int i2 = size % this.mPluginCountPerPage;
            if (i2 > 0) {
                i2 = 1;
            }
            i = i2 + (size / this.mPluginCountPerPage);
        } else {
            i = 0;
        }
        this.mPagerAdapter = new PluginPagerAdapter(i, size);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOffscreenPageLimit(1);
        initIndicator(i, this.mIndicator);
        onIndicatorChanged(-1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onIndicatorChanged(int i, int i2) {
        int childCount = this.mIndicator.getChildCount();
        if (childCount <= 0 || i >= childCount || i2 >= childCount) {
            return;
        }
        if (i >= 0) {
            ((ImageView) this.mIndicator.getChildAt(i)).setImageResource(R.drawable.rc_ext_indicator);
        }
        if (i2 >= 0) {
            ((ImageView) this.mIndicator.getChildAt(i2)).setImageResource(R.drawable.rc_ext_indicator_hover);
        }
    }

    private void removeIndicator(int i, LinearLayout linearLayout) {
        int i2;
        int childCount = linearLayout.getChildCount();
        if (childCount <= i || childCount - 1 < 0) {
            return;
        }
        linearLayout.removeViewAt(i2);
        onIndicatorChanged(childCount, i2);
        if (i <= 1) {
            linearLayout.setVisibility(4);
        }
    }

    public void addPager(View view) {
        this.mCustomPager = view;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        this.mPluginPager.addView(view, layoutParams);
    }

    public void addPlugin(IPluginModule iPluginModule) {
        this.mPluginModules.add(iPluginModule);
        int size = this.mPluginModules.size();
        if (this.mPagerAdapter == null || size <= 0 || this.mIndicator == null) {
            return;
        }
        int i = size % this.mPluginCountPerPage;
        if (i > 0) {
            i = 1;
        }
        int i2 = (size / this.mPluginCountPerPage) + i;
        this.mPagerAdapter.setPages(i2);
        this.mPagerAdapter.setItems(size);
        this.mPagerAdapter.notifyDataSetChanged();
        this.mIndicator.removeAllViews();
        initIndicator(i2, this.mIndicator);
    }

    public void addPlugins(List<IPluginModule> list) {
        for (int i = 0; list != null && i < list.size(); i++) {
            IPluginModule iPluginModule = list.get(i);
            if (!"com.jrmf360.rylib.rp.extend.TransferAccountPlugin".equals(iPluginModule.getClass().getName())) {
                this.mPluginModules.add(iPluginModule);
            }
        }
    }

    public void bindView(ViewGroup viewGroup) {
        this.mInitialized = true;
        initView(viewGroup.getContext(), viewGroup);
    }

    public View getPager() {
        return this.mCustomPager;
    }

    public IPluginModule getPluginModule(int i) {
        if (i < 0 || i >= this.mPluginModules.size()) {
            return null;
        }
        return this.mPluginModules.get(i);
    }

    public List<IPluginModule> getPluginModules() {
        return this.mPluginModules;
    }

    public int getPluginPosition(IPluginModule iPluginModule) {
        return this.mPluginModules.indexOf(iPluginModule);
    }

    public int getVisibility() {
        ViewGroup viewGroup = this.mPluginPager;
        if (viewGroup != null) {
            return viewGroup.getVisibility();
        }
        return 8;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void removePager(View view) {
        View view2 = this.mCustomPager;
        if (view2 == null || view2 != view) {
            return;
        }
        this.mPluginPager.removeView(view);
        this.mCustomPager = null;
    }

    public void removePlugin(IPluginModule iPluginModule) {
        int size;
        this.mPluginModules.remove(iPluginModule);
        if (this.mPagerAdapter == null || this.mViewPager == null || (size = this.mPluginModules.size()) <= 0) {
            return;
        }
        int i = size % this.mPluginCountPerPage;
        if (i > 0) {
            i = 1;
        }
        int i2 = (size / this.mPluginCountPerPage) + i;
        this.mPagerAdapter.setPages(i2);
        this.mPagerAdapter.setItems(size);
        this.mPagerAdapter.notifyDataSetChanged();
        removeIndicator(i2, this.mIndicator);
    }

    public void setOnPluginClickListener(IPluginClickListener iPluginClickListener) {
        this.mPluginClickListener = iPluginClickListener;
    }

    public void setVisibility(int i) {
        ViewGroup viewGroup = this.mPluginPager;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
            View view = this.mCustomPager;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }
}
