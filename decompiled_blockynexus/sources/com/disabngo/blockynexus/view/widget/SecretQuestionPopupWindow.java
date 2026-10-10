package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SecretQuestionPopupWindow extends PopupWindow implements AdapterView.OnItemClickListener {
    private Context context;
    private AppCompatImageView imageView;
    public ObservableField<Boolean> isShow;
    private List<String> listItemText;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onClick(int i, long j);
    }

    public SecretQuestionPopupWindow(Context context, List<String> list, AppCompatImageView appCompatImageView) {
        super(context);
        this.isShow = new ObservableField<>(false);
        this.context = context;
        this.listItemText = list;
        this.imageView = appCompatImageView;
        initView();
    }

    private void initView() {
        View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.view_secret_question_window, (ViewGroup) null);
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(1711276032));
        ListView listView = (ListView) viewInflate.findViewById(R.id.lv_secret_question);
        listView.setAdapter((ListAdapter) new ArrayAdapter(this.context, R.layout.list_secret_question_item, this.listItemText));
        listView.setOnItemClickListener(this);
    }

    private void onAnimate(View view, int i) {
        if (i != 0) {
            try {
                view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), i));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        onAnimate(this.imageView, R.anim.help_detail_rotate_up);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onClick(i, j);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void showLocation(View view) {
        showAsDropDown(view);
        onAnimate(this.imageView, R.anim.help_detail_rotate_close);
    }
}
