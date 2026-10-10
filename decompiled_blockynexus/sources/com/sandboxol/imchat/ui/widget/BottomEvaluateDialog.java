package com.sandboxol.imchat.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.model.SealCSEvaluateItem;
import io.rong.imlib.CustomServiceConfig;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BottomEvaluateDialog extends Dialog {
    private EditText editTextSuggestion;
    private List<SealCSEvaluateItem> evaluateList;
    private CSEvaluateScrollView evaluateScrollView;
    private boolean isInputMust;
    private boolean isTagMust;
    private ImageView iv_cancel;
    private RelativeLayout layout_problem_labels;
    private RelativeLayout layout_problems;
    private RelativeLayout layout_resolve_feedback;
    private Context mContext;
    private int mStars;
    private OnEvaluateDialogBehaviorListener onEvaluateDialogBehaviorListener;
    private TextView problems_title;
    private boolean showSolveStatus;
    private TextView tv_resolved;
    private TextView tv_submit;
    private TextView tv_unresolved;

    public interface OnEvaluateDialogBehaviorListener {
        void onCancel();

        void onSubmit(int i, String str, CustomServiceConfig.CSEvaSolveStatus cSEvaSolveStatus, String str2);
    }

    public BottomEvaluateDialog(Context context, List<SealCSEvaluateItem> list) {
        super(context, R.style.dialogFullscreen);
        this.isTagMust = false;
        this.isInputMust = false;
        this.showSolveStatus = false;
        this.evaluateList = list;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hintKbTwo() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (!inputMethodManager.isActive() || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    private void initProblemLabels() {
        this.layout_problems = (RelativeLayout) findViewById(R.id.ll_problems);
        this.layout_problems.setVisibility(8);
        this.problems_title = (TextView) findViewById(R.id.tv_problem_title);
        this.layout_problem_labels = (RelativeLayout) findViewById(R.id.ll_problem_tables);
        for (int i = 0; i < this.layout_problem_labels.getChildCount(); i++) {
            this.layout_problem_labels.getChildAt(i).setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.isSelected()) {
                        view.setSelected(false);
                    } else {
                        view.setSelected(true);
                    }
                }
            });
        }
    }

    private void initResolveFeedback() {
        this.layout_resolve_feedback = (RelativeLayout) findViewById(R.id.ll_resolve_feedback);
        List<SealCSEvaluateItem> list = this.evaluateList;
        if (list != null) {
            this.showSolveStatus = list.get(0).getQuestionFlag();
        }
        if (this.showSolveStatus) {
            this.layout_resolve_feedback.setVisibility(0);
        } else {
            this.layout_resolve_feedback.setVisibility(8);
        }
        this.tv_resolved = (TextView) findViewById(R.id.tv_resolved);
        this.tv_resolved.setSelected(true);
        this.tv_resolved.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BottomEvaluateDialog.this.tv_resolved.setSelected(true);
                BottomEvaluateDialog.this.tv_unresolved.setSelected(false);
            }
        });
        this.tv_unresolved = (TextView) findViewById(R.id.tv_unresolved);
        this.tv_unresolved.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BottomEvaluateDialog.this.tv_resolved.setSelected(false);
                BottomEvaluateDialog.this.tv_unresolved.setSelected(true);
            }
        });
    }

    private void initScrollView() {
        this.evaluateScrollView = (CSEvaluateScrollView) findViewById(R.id.scrollview_evaluate);
    }

    private void initStarts() {
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cs_stars);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (i < 5) {
                childAt.setSelected(true);
            }
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int iIndexOfChild = linearLayout.indexOfChild(view);
                    int childCount = linearLayout.getChildCount();
                    int i2 = iIndexOfChild + 1;
                    BottomEvaluateDialog.this.mStars = i2;
                    if (view.isSelected()) {
                        while (i2 < childCount) {
                            linearLayout.getChildAt(i2).setSelected(false);
                            i2++;
                        }
                    } else {
                        while (iIndexOfChild >= 0) {
                            linearLayout.getChildAt(iIndexOfChild).setSelected(true);
                            iIndexOfChild--;
                        }
                    }
                    if (BottomEvaluateDialog.this.mStars >= 5 || BottomEvaluateDialog.this.evaluateList == null || BottomEvaluateDialog.this.evaluateList.size() <= 0) {
                        BottomEvaluateDialog.this.layout_problems.setVisibility(8);
                        BottomEvaluateDialog.this.hintKbTwo();
                        BottomEvaluateDialog.this.editTextSuggestion.setVisibility(8);
                        BottomEvaluateDialog.this.isTagMust = false;
                        BottomEvaluateDialog.this.isInputMust = false;
                        return;
                    }
                    BottomEvaluateDialog.this.editTextSuggestion.setVisibility(0);
                    BottomEvaluateDialog.this.editTextSuggestion.setHint(((SealCSEvaluateItem) BottomEvaluateDialog.this.evaluateList.get(BottomEvaluateDialog.this.mStars - 1)).getInputLanguage());
                    BottomEvaluateDialog bottomEvaluateDialog = BottomEvaluateDialog.this;
                    bottomEvaluateDialog.isTagMust = ((SealCSEvaluateItem) bottomEvaluateDialog.evaluateList.get(BottomEvaluateDialog.this.mStars - 1)).getTagMust();
                    BottomEvaluateDialog bottomEvaluateDialog2 = BottomEvaluateDialog.this;
                    bottomEvaluateDialog2.setProblemTitle(bottomEvaluateDialog2.isTagMust);
                    BottomEvaluateDialog bottomEvaluateDialog3 = BottomEvaluateDialog.this;
                    bottomEvaluateDialog3.setProblemLabels(((SealCSEvaluateItem) bottomEvaluateDialog3.evaluateList.get(BottomEvaluateDialog.this.mStars - 1)).getLabelNameList());
                    BottomEvaluateDialog bottomEvaluateDialog4 = BottomEvaluateDialog.this;
                    bottomEvaluateDialog4.isInputMust = ((SealCSEvaluateItem) bottomEvaluateDialog4.evaluateList.get(BottomEvaluateDialog.this.mStars - 1)).getInputMust();
                }
            });
        }
    }

    private void initSubmitView() {
        this.tv_submit = (TextView) findViewById(R.id.tv_submit);
        this.tv_submit.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomServiceConfig.CSEvaSolveStatus cSEvaSolveStatus = (BottomEvaluateDialog.this.tv_resolved.isSelected() && BottomEvaluateDialog.this.showSolveStatus) ? CustomServiceConfig.CSEvaSolveStatus.RESOLVED : CustomServiceConfig.CSEvaSolveStatus.UNRESOLVED;
                String str = "";
                for (int i = 0; i < BottomEvaluateDialog.this.layout_problem_labels.getChildCount(); i++) {
                    View childAt = BottomEvaluateDialog.this.layout_problem_labels.getChildAt(i);
                    if (childAt.isSelected()) {
                        str = TextUtils.isEmpty(str) ? str + ((TextView) childAt).getText().toString() : str + "," + ((TextView) childAt).getText().toString();
                    }
                }
                if (BottomEvaluateDialog.this.isTagMust && TextUtils.isEmpty(str)) {
                    Toast.makeText(BottomEvaluateDialog.this.mContext, BottomEvaluateDialog.this.mContext.getResources().getString(R.string.cs_evaluate_tag_must), 0).show();
                    return;
                }
                if (BottomEvaluateDialog.this.isInputMust && TextUtils.isEmpty(BottomEvaluateDialog.this.editTextSuggestion.getText().toString())) {
                    Toast.makeText(BottomEvaluateDialog.this.mContext, BottomEvaluateDialog.this.mContext.getResources().getString(R.string.cs_evaluate_input_must), 0).show();
                } else if (BottomEvaluateDialog.this.onEvaluateDialogBehaviorListener != null) {
                    BottomEvaluateDialog.this.onEvaluateDialogBehaviorListener.onSubmit(BottomEvaluateDialog.this.mStars, str, cSEvaSolveStatus, BottomEvaluateDialog.this.editTextSuggestion.getText().toString());
                }
            }
        });
    }

    private void initSuggestionView() {
        this.editTextSuggestion = (EditText) findViewById(R.id.edit_suggestion);
        this.editTextSuggestion.setVisibility(8);
        this.editTextSuggestion.setOnTouchListener(new View.OnTouchListener() { // from class: com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    BottomEvaluateDialog.this.evaluateScrollView.requestDisallowInterceptTouchEvent(false);
                } else {
                    BottomEvaluateDialog.this.evaluateScrollView.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
    }

    private void initTitle() {
        this.iv_cancel = (ImageView) findViewById(R.id.iv_cancel);
        this.iv_cancel.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BottomEvaluateDialog.this.dismiss();
                if (BottomEvaluateDialog.this.onEvaluateDialogBehaviorListener != null) {
                    BottomEvaluateDialog.this.onEvaluateDialogBehaviorListener.onCancel();
                }
            }
        });
    }

    private void initViews() {
        initTitle();
        initScrollView();
        initResolveFeedback();
        initStarts();
        initProblemLabels();
        initSuggestionView();
        initSubmitView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProblemLabels(List<String> list) {
        if (list == null || list.size() <= 0 || list.size() > this.layout_problem_labels.getChildCount()) {
            return;
        }
        this.layout_problems.setVisibility(0);
        for (int i = 0; i < this.layout_problem_labels.getChildCount(); i++) {
            View childAt = this.layout_problem_labels.getChildAt(i);
            if (i < list.size()) {
                childAt.setVisibility(0);
                childAt.setSelected(false);
                ((TextView) childAt).setText(list.get(i));
            } else {
                childAt.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProblemTitle(boolean z) {
        String string = this.mContext.getResources().getString(R.string.cs_evaluate_problem_title);
        if (!z) {
            this.problems_title.setText(string);
            return;
        }
        this.problems_title.setText(string + "(" + this.mContext.getResources().getString(R.string.cs_evaluate_select_must) + ")");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        OnEvaluateDialogBehaviorListener onEvaluateDialogBehaviorListener = this.onEvaluateDialogBehaviorListener;
        if (onEvaluateDialogBehaviorListener != null) {
            onEvaluateDialogBehaviorListener.onCancel();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bottom_evaluate_dialog);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.5f;
        window.setGravity(80);
        window.setAttributes(attributes);
        window.setLayout(-1, -2);
        initViews();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setEvaluateDialogBehaviorListener(OnEvaluateDialogBehaviorListener onEvaluateDialogBehaviorListener) {
        this.onEvaluateDialogBehaviorListener = onEvaluateDialogBehaviorListener;
    }

    public BottomEvaluateDialog(Context context, int i) {
        super(context, i);
        this.isTagMust = false;
        this.isInputMust = false;
        this.showSolveStatus = false;
    }

    public BottomEvaluateDialog(Context context, String str, String str2) {
        super(context, R.style.dialogFullscreen);
        this.isTagMust = false;
        this.isInputMust = false;
        this.showSolveStatus = false;
    }

    public BottomEvaluateDialog(Context context, String str, String str2, String str3) {
        super(context, R.style.dialogFullscreen);
        this.isTagMust = false;
        this.isInputMust = false;
        this.showSolveStatus = false;
    }
}
