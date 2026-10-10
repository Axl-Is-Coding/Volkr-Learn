package com.sandboxol.imchat.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.adapter.GroupNoticeAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class GroupNoticeDialog extends FullScreenDialog implements View.OnClickListener {
    private GroupNoticeAdapter adapter;
    private Button btnSure;
    private View line;
    private ArrayList<String> pics;
    private RecyclerView rvPics;
    private TextView tvContent;

    public GroupNoticeDialog(Context context) {
        super(context);
    }

    private void initRecyclerView(Context context) {
        this.adapter = new GroupNoticeAdapter(context, this.pics);
        this.rvPics.setLayoutManager(new GridLayoutManager(context, 3));
        this.rvPics.setAdapter(this.adapter);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        this.context = context;
        setContentView(R.layout.dialog_notice_group);
        this.pics = new ArrayList<>();
        this.tvContent = (TextView) findViewById(R.id.tv_content);
        this.rvPics = (RecyclerView) findViewById(R.id.rv_pics);
        this.btnSure = (Button) findViewById(R.id.btn_sure);
        this.line = findViewById(R.id.line2);
        this.btnSure.setOnClickListener(this);
        initRecyclerView(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
    }

    public GroupNoticeDialog setNotice(String str) {
        this.tvContent.setText(str);
        return this;
    }

    public GroupNoticeDialog setPics(ArrayList<String> arrayList) {
        this.pics.addAll(arrayList);
        this.adapter.notifyDataSetChanged();
        return this;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog
    public void show() {
        if (this.pics.isEmpty()) {
            this.rvPics.setVisibility(8);
            this.line.setVisibility(8);
        }
        super.show();
    }
}
