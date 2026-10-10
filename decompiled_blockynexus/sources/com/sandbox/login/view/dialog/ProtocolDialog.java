package com.sandbox.login.view.dialog;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.sandbox.login.R;
import com.sandboxol.blockmango.config.GameEventConstant;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class ProtocolDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f15971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f15972b;
    private Context context;

    public ProtocolDialog(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public void initView() {
        setContentView(R.layout.dialog_protocol);
        this.f15971a = (TextView) findViewById(R.id.tvDetails);
        this.f15972b = findViewById(R.id.btnSure);
        this.f15972b.setOnClickListener(this);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnSure) {
            dismiss();
        }
    }

    private void a() {
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandbox.login.view.dialog.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15976a.a((Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
    }

    public /* synthetic */ void a(Subscriber subscriber) {
        String line = "";
        try {
            InputStream inputStreamOpen = this.context.getResources().getAssets().open("blockman_online_protocol.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpen, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStreamOpen.close();
                    subscriber.onNext(sb.toString());
                    subscriber.onCompleted();
                    return;
                }
            }
        } catch (IOException e2) {
            Log.e("NexFragment", "读取数据失败。。。" + e2.toString());
            subscriber.onNext(line);
            subscriber.onCompleted();
        } catch (Exception e3) {
            ReportDataAdapter.onEvent(this.context, GameEventConstant.LOAD_ASSETS_RES_FAILED);
            e3.printStackTrace();
        }
    }
}
