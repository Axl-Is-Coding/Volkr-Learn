package com.sandboxol.decorate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.a.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DressViewPageFilter extends FrameLayout {
    private View bgShadow;
    private Context context;
    private com.sandboxol.decorate.a.f leftAdapter;
    private f.a leftListener;
    private TextView leftNow;
    private boolean leftOpen;
    private CheckBox leftStatus;
    private com.sandboxol.decorate.a.f rightAdapter;
    private f.a rightListener;
    private TextView rightNow;
    private boolean rightOpen;
    private CheckBox rightStatus;
    private RelativeLayout rlLeft;
    private RelativeLayout rlRight;
    private RecyclerView rvLeft;
    private RecyclerView rvRight;

    public DressViewPageFilter(Context context) {
        this(context, null);
    }

    private void closeLeft() {
        this.leftOpen = false;
        this.rvLeft.setVisibility(8);
        this.leftStatus.setChecked(false);
        this.bgShadow.setVisibility(8);
    }

    private void closeRight() {
        this.rightOpen = false;
        this.rvRight.setVisibility(8);
        this.rightStatus.setChecked(false);
        this.bgShadow.setVisibility(8);
    }

    private void initEvent() {
        this.rlLeft.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.decorate.widget.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17531a.a(view);
            }
        });
        this.rlRight.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.decorate.widget.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17529a.b(view);
            }
        });
        this.leftAdapter.a(new f.a() { // from class: com.sandboxol.decorate.widget.h
            @Override // com.sandboxol.decorate.a.f.a
            public final void a(String str) {
                this.f17530a.a(str);
            }
        });
        this.rightAdapter.a(new f.a() { // from class: com.sandboxol.decorate.widget.e
            @Override // com.sandboxol.decorate.a.f.a
            public final void a(String str) {
                this.f17527a.b(str);
            }
        });
        this.bgShadow.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.decorate.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17528a.c(view);
            }
        });
    }

    private void initView() {
        this.leftNow = (TextView) findViewById(R.id.tvSort);
        this.rightNow = (TextView) findViewById(R.id.tvFilter);
        this.leftStatus = (CheckBox) findViewById(R.id.cbSort);
        this.rightStatus = (CheckBox) findViewById(R.id.cbFilter);
        this.rlLeft = (RelativeLayout) findViewById(R.id.rlSort);
        this.rlRight = (RelativeLayout) findViewById(R.id.rlFilter);
        this.bgShadow = findViewById(R.id.bgShadow);
        this.rvLeft = (RecyclerView) findViewById(R.id.rvSort);
        this.rvLeft.setLayoutManager(new LinearLayoutManager(this.context));
        this.leftAdapter = new com.sandboxol.decorate.a.f(this.context, new ArrayList());
        this.rvLeft.setAdapter(this.leftAdapter);
        this.rvRight = (RecyclerView) findViewById(R.id.rvFilter);
        this.rvRight.setLayoutManager(new LinearLayoutManager(this.context));
        this.rightAdapter = new com.sandboxol.decorate.a.f(this.context, new ArrayList());
        this.rvRight.setAdapter(this.rightAdapter);
    }

    private void openLeft() {
        this.leftOpen = true;
        this.rvLeft.setVisibility(0);
        this.leftStatus.setChecked(true);
        this.bgShadow.setVisibility(0);
    }

    private void openRight() {
        this.rightOpen = true;
        this.rvRight.setVisibility(0);
        this.rightStatus.setChecked(true);
        this.bgShadow.setVisibility(0);
    }

    public /* synthetic */ void a(View view) {
        if (this.rightOpen) {
            closeRight();
            openLeft();
        } else if (this.leftOpen) {
            closeLeft();
        } else {
            openLeft();
        }
    }

    public /* synthetic */ void b(View view) {
        if (this.leftOpen) {
            closeLeft();
            openRight();
        } else if (this.rightOpen) {
            closeRight();
        } else {
            openRight();
        }
    }

    public /* synthetic */ void c(View view) {
        if (this.leftOpen) {
            closeLeft();
        }
        if (this.rightOpen) {
            closeRight();
        }
    }

    public void closeAll() {
        if (this.leftOpen) {
            closeLeft();
        }
        if (this.rightOpen) {
            closeRight();
        }
    }

    public void resetData() {
        this.leftAdapter.b();
        this.rightAdapter.b();
    }

    public void setLeftListData(List<String> list) {
        this.leftAdapter.a(list);
    }

    public void setLeftListener(f.a aVar) {
        this.leftListener = aVar;
    }

    public void setLeftText(String str) {
        this.leftNow.setText(str);
    }

    public void setRightListData(List<String> list) {
        this.rightAdapter.a(list);
    }

    public void setRightListener(f.a aVar) {
        this.rightListener = aVar;
    }

    public void setRightText(String str) {
        this.rightNow.setText(str);
    }

    public DressViewPageFilter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DressViewPageFilter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        FrameLayout.inflate(context, R.layout.layout_dress_filter, this);
        initView();
        initEvent();
    }

    public /* synthetic */ void a(String str) {
        this.leftNow.setText(str);
        closeLeft();
        this.leftListener.a(str);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_SHOP_SORT);
    }

    public /* synthetic */ void b(String str) {
        this.rightNow.setText(str);
        closeRight();
        this.rightListener.a(str);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_SHOP_FILTER);
    }
}
