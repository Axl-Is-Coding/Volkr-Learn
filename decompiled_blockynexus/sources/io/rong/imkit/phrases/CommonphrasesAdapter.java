package io.rong.imkit.phrases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.rong.imkit.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CommonphrasesAdapter {
    private static final String TAG = "CommonphrasesAdapter";
    private boolean mInitialized;
    private IPhrasesClickListener mPhrasesClickListener;
    private ViewGroup mPhrasesPager;
    private List<String> phrasesList = new ArrayList();

    private class PhrasesAdapter extends BaseAdapter {
        private PhrasesAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CommonphrasesAdapter.this.phrasesList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return CommonphrasesAdapter.this.phrasesList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_ext_phrases_list_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.rc_phrases_tv)).setText((CharSequence) CommonphrasesAdapter.this.phrasesList.get(i));
            return view;
        }
    }

    private void initView(Context context, ViewGroup viewGroup) {
        this.mPhrasesPager = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.rc_ext_phrases_pager, (ViewGroup) null);
        this.mPhrasesPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.rc_extension_board_height)));
        viewGroup.addView(this.mPhrasesPager);
        ListView listView = (ListView) this.mPhrasesPager.findViewById(R.id.rc_list);
        listView.setAdapter((ListAdapter) new PhrasesAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.phrases.CommonphrasesAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CommonphrasesAdapter.this.mPhrasesClickListener.onClick((String) CommonphrasesAdapter.this.phrasesList.get(i), i);
            }
        });
    }

    public void addPhrases(List<String> list) {
        this.phrasesList.addAll(list);
    }

    public void bindView(ViewGroup viewGroup) {
        this.mInitialized = true;
        initView(viewGroup.getContext(), viewGroup);
    }

    public int getVisibility() {
        ViewGroup viewGroup = this.mPhrasesPager;
        if (viewGroup != null) {
            return viewGroup.getVisibility();
        }
        return 8;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void setOnPhrasesClickListener(IPhrasesClickListener iPhrasesClickListener) {
        this.mPhrasesClickListener = iPhrasesClickListener;
    }

    public void setVisibility(int i) {
        ViewGroup viewGroup = this.mPhrasesPager;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
    }
}
