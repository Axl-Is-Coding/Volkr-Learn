package com.disabngo.blockynexus.view.widget.gameRank;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.discover.n;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes.dex */
public class GameTypeRankingPupupWindow extends PopupWindow {
    private Context context;
    private n discoverViewModel;
    private ReplyCommand dismissCommand;
    private d gameTypeRankingViewModel;

    public GameTypeRankingPupupWindow(n nVar, Context context, String str, ReplyCommand replyCommand) {
        super(context);
        this.context = context;
        this.discoverViewModel = nVar;
        this.dismissCommand = replyCommand;
        this.gameTypeRankingViewModel = new d(context, nVar, this, str, -1L);
        initView(str, -1L);
    }

    private void initView(String str, long j) {
        ViewDataBinding viewDataBindingA = j >= 0 ? e.a(LayoutInflater.from(this.context), R.layout.window_discover_type_ranking, (ViewGroup) null, false) : e.a(LayoutInflater.from(this.context), R.layout.window_discover_complex_ranking, (ViewGroup) null, false);
        viewDataBindingA.setVariable(412, this.gameTypeRankingViewModel);
        setContentView(viewDataBindingA.getRoot());
        setHeight(-2);
        setWidth(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        ReplyCommand replyCommand = this.dismissCommand;
        if (replyCommand != null) {
            replyCommand.execute();
        }
        this.gameTypeRankingViewModel.onDestroy();
    }

    public void showLocation(View view) {
        showAsDropDown(view);
    }

    public GameTypeRankingPupupWindow(n nVar, Context context, long j, ReplyCommand replyCommand) {
        super(context);
        this.context = context;
        this.discoverViewModel = nVar;
        this.dismissCommand = replyCommand;
        this.gameTypeRankingViewModel = new d(context, nVar, this, null, j);
        initView(null, j);
    }
}
