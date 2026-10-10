package io.rong.imkit.emoticon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import io.rong.imkit.R;
import io.rong.imkit.utilities.ExtensionHistoryUtil;
import io.rong.imlib.RongIMClient;

/* JADX INFO: loaded from: classes5.dex */
public class EmojiTab implements IEmoticonTab {
    private int mEmojiCountPerPage;
    private LinearLayout mIndicator;
    private LayoutInflater mLayoutInflater;
    private IEmojiItemClickListener mOnItemClickListener;
    private String mUserId;
    private int selected = 0;

    private class EmojiAdapter extends BaseAdapter {
        int count;
        int index;

        public EmojiAdapter(int i, int i2) {
            this.count = Math.min(EmojiTab.this.mEmojiCountPerPage, i2 - i);
            this.index = i;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.count + 1;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = EmojiTab.this.mLayoutInflater.inflate(R.layout.rc_ext_emoji_item, (ViewGroup) null);
                viewHolder.emojiIV = (ImageView) viewInflate.findViewById(R.id.rc_ext_emoji_item);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            if (i == EmojiTab.this.mEmojiCountPerPage || this.index + i == AndroidEmoji.getEmojiSize()) {
                viewHolder2.emojiIV.setImageResource(R.drawable.rc_icon_emoji_delete);
            } else {
                viewHolder2.emojiIV.setImageDrawable(AndroidEmoji.getEmojiDrawable(viewGroup.getContext(), this.index + i));
            }
            return view;
        }
    }

    private class EmojiPagerAdapter extends a {
        int count;

        public EmojiPagerAdapter(int i) {
            this.count = i;
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.count;
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmojiTab.this.mLayoutInflater.inflate(R.layout.rc_ext_emoji_grid_view, (ViewGroup) null);
            EmojiTab emojiTab = EmojiTab.this;
            gridView.setAdapter((ListAdapter) emojiTab.new EmojiAdapter(i * emojiTab.mEmojiCountPerPage, AndroidEmoji.getEmojiSize()));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.emoticon.EmojiTab.EmojiPagerAdapter.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    if (EmojiTab.this.mOnItemClickListener != null) {
                        int i3 = (EmojiTab.this.selected * EmojiTab.this.mEmojiCountPerPage) + i2;
                        if (i2 == EmojiTab.this.mEmojiCountPerPage) {
                            EmojiTab.this.mOnItemClickListener.onDeleteClick();
                            return;
                        }
                        if (i3 >= AndroidEmoji.getEmojiSize()) {
                            EmojiTab.this.mOnItemClickListener.onDeleteClick();
                            return;
                        }
                        char[] chars = Character.toChars(AndroidEmoji.getEmojiCode(i3));
                        StringBuilder sb = new StringBuilder(Character.toString(chars[0]));
                        for (int i4 = 1; i4 < chars.length; i4++) {
                            sb.append(chars[i4]);
                        }
                        EmojiTab.this.mOnItemClickListener.onEmojiClick(sb.toString());
                    }
                }
            });
            viewGroup.addView(gridView);
            return gridView;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class ViewHolder {
        ImageView emojiIV;

        private ViewHolder() {
        }
    }

    private void initIndicator(int i, LinearLayout linearLayout) {
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageView = (ImageView) this.mLayoutInflater.inflate(R.layout.rc_ext_indicator, (ViewGroup) null);
            imageView.setImageResource(R.drawable.rc_ext_indicator);
            linearLayout.addView(imageView);
        }
    }

    private View initView(final Context context) {
        int emojiSize = AndroidEmoji.getEmojiSize();
        try {
            this.mEmojiCountPerPage = context.getResources().getInteger(context.getResources().getIdentifier("rc_extension_emoji_count_per_page", "integer", context.getPackageName()));
        } catch (Exception unused) {
            this.mEmojiCountPerPage = 20;
        }
        int i = this.mEmojiCountPerPage;
        int i2 = (emojiSize / i) + (emojiSize % i != 0 ? 1 : 0);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_ext_emoji_pager, (ViewGroup) null);
        ViewPager viewPager = (ViewPager) viewInflate.findViewById(R.id.rc_view_pager);
        this.mIndicator = (LinearLayout) viewInflate.findViewById(R.id.rc_indicator);
        this.mLayoutInflater = LayoutInflater.from(context);
        viewPager.setAdapter(new EmojiPagerAdapter(i2));
        viewPager.setOnPageChangeListener(new ViewPager.e() { // from class: io.rong.imkit.emoticon.EmojiTab.1
            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrolled(int i3, float f2, int i4) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageSelected(int i3) {
                ExtensionHistoryUtil.setEmojiPosition(context, EmojiTab.this.mUserId, i3);
                EmojiTab emojiTab = EmojiTab.this;
                emojiTab.onIndicatorChanged(emojiTab.selected, i3);
                EmojiTab.this.selected = i3;
            }
        });
        viewPager.setOffscreenPageLimit(1);
        initIndicator(i2, this.mIndicator);
        int emojiPosition = ExtensionHistoryUtil.getEmojiPosition(context, this.mUserId);
        viewPager.setCurrentItem(emojiPosition);
        onIndicatorChanged(-1, emojiPosition);
        return viewInflate;
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

    @Override // io.rong.imkit.emoticon.IEmoticonTab
    public Drawable obtainTabDrawable(Context context) {
        return context.getResources().getDrawable(R.drawable.rc_tab_emoji);
    }

    @Override // io.rong.imkit.emoticon.IEmoticonTab
    public View obtainTabPager(Context context) {
        this.mUserId = RongIMClient.getInstance().getCurrentUserId();
        return initView(context);
    }

    @Override // io.rong.imkit.emoticon.IEmoticonTab
    public void onTableSelected(int i) {
    }

    public void setOnItemClickListener(IEmojiItemClickListener iEmojiItemClickListener) {
        this.mOnItemClickListener = iEmojiItemClickListener;
    }
}
