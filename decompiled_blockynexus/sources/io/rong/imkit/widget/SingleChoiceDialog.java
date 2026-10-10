package io.rong.imkit.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import io.rong.imkit.R;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SingleChoiceDialog extends Dialog {
    protected TextView mButtonCancel;
    protected TextView mButtonOK;
    protected DialogInterface.OnClickListener mCancelClickListener;
    protected Context mContext;
    protected List<String> mList;
    protected ListView mListView;
    protected DialogInterface.OnClickListener mOkClickListener;
    protected View mRootView;
    private SingleChoiceAdapter<String> mSingleChoiceAdapter;
    protected TextView mTVTitle;

    public SingleChoiceDialog(Context context, List<String> list) {
        super(context);
        this.mContext = context;
        this.mList = list;
        initView(this.mContext);
        initData();
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int measuredHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View view = adapter.getView(i, null, listView);
            view.measure(0, 0);
            measuredHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = measuredHeight + 10 + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
    }

    public int getSelectItem() {
        return this.mSingleChoiceAdapter.getSelectItem();
    }

    protected void initData() {
        this.mSingleChoiceAdapter = new SingleChoiceAdapter<>(this.mContext, this.mList, R.drawable.rc_cs_group_checkbox_selector);
        this.mListView.setAdapter((ListAdapter) this.mSingleChoiceAdapter);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.widget.SingleChoiceDialog.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i != SingleChoiceDialog.this.mSingleChoiceAdapter.getSelectItem()) {
                    if (!SingleChoiceDialog.this.mButtonOK.isEnabled()) {
                        SingleChoiceDialog.this.mButtonOK.setEnabled(true);
                    }
                    SingleChoiceDialog.this.mSingleChoiceAdapter.setSelectItem(i);
                    SingleChoiceDialog.this.mSingleChoiceAdapter.notifyDataSetChanged();
                }
            }
        });
        setListViewHeightBasedOnChildren(this.mListView);
    }

    protected void initView(Context context) {
        requestWindowFeature(1);
        setContentView(R.layout.rc_cs_single_choice_layout);
        this.mRootView = findViewById(R.id.rc_cs_rootView);
        this.mRootView.setBackgroundDrawable(new ColorDrawable(0));
        this.mTVTitle = (TextView) findViewById(R.id.rc_cs_tv_title);
        this.mButtonOK = (TextView) findViewById(R.id.rc_cs_btn_ok);
        this.mButtonOK.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.SingleChoiceDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SingleChoiceDialog.this.onButtonOK();
            }
        });
        this.mButtonCancel = (TextView) findViewById(R.id.rc_cs_btn_cancel);
        this.mButtonCancel.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.SingleChoiceDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SingleChoiceDialog.this.onButtonCancel();
            }
        });
        this.mListView = (ListView) findViewById(R.id.rc_cs_group_dialog_listView);
        Window window = getWindow();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (window != null) {
            window.setBackgroundDrawable(colorDrawable);
        }
    }

    protected void onButtonCancel() {
        dismiss();
        DialogInterface.OnClickListener onClickListener = this.mCancelClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this, 0);
        }
    }

    protected void onButtonOK() {
        dismiss();
        DialogInterface.OnClickListener onClickListener = this.mOkClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this, 0);
        }
    }

    public void setOnCancelButtonListener(DialogInterface.OnClickListener onClickListener) {
        this.mCancelClickListener = onClickListener;
    }

    public void setOnOKButtonListener(DialogInterface.OnClickListener onClickListener) {
        this.mOkClickListener = onClickListener;
    }

    public void setTitle(String str) {
        this.mTVTitle.setText(str);
    }
}
