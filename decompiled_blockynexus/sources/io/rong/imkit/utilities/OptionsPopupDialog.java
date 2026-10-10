package io.rong.imkit.utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class OptionsPopupDialog extends AlertDialog {
    private String[] arrays;
    private Context mContext;
    private OnOptionsItemClickedListener mItemClickedListener;

    public interface OnOptionsItemClickedListener {
        void onOptionsItemClicked(int i);
    }

    public OptionsPopupDialog(Context context, String[] strArr) {
        super(context);
        this.mContext = context;
        this.arrays = strArr;
    }

    private int getPopupWidth() {
        return getScreenWidth() - (((int) this.mContext.getResources().getDimension(R.dimen.rc_popup_dialog_distance_to_edge)) * 2);
    }

    private int getScreenWidth() {
        return ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static OptionsPopupDialog newInstance(Context context, String[] strArr) {
        return new OptionsPopupDialog(context, strArr);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        View viewInflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.rc_dialog_popup_options, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.rc_list_dialog_popup_options);
        listView.setAdapter((ListAdapter) new ArrayAdapter(this.mContext, R.layout.rc_dialog_popup_options_item, R.id.rc_dialog_popup_item_name, this.arrays));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.utilities.OptionsPopupDialog.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (OptionsPopupDialog.this.mItemClickedListener != null) {
                    OptionsPopupDialog.this.mItemClickedListener.onOptionsItemClicked(i);
                    OptionsPopupDialog.this.dismiss();
                }
            }
        });
        setContentView(viewInflate);
        if (getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = getPopupWidth();
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }

    public OptionsPopupDialog setOptionsPopupDialogListener(OnOptionsItemClickedListener onOptionsItemClickedListener) {
        this.mItemClickedListener = onOptionsItemClickedListener;
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        super.show();
    }
}
