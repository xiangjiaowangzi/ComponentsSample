package com.example.android.persistence.databinding;
import com.example.android.persistence.R;
import com.example.android.persistence.BR;
import android.view.View;
public class CommentItemBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    private final android.support.v7.widget.CardView mboundView0;
    private final android.widget.TextView mboundView1;
    // variables
    private com.example.android.persistence.ui.CommentClickCallback mCallback;
    private com.example.android.persistence.model.Comment mComment;
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CommentItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.callback :
                setCallback((com.example.android.persistence.ui.CommentClickCallback) variable);
                return true;
            case BR.comment :
                setComment((com.example.android.persistence.model.Comment) variable);
                return true;
        }
        return false;
    }

    public void setCallback(com.example.android.persistence.ui.CommentClickCallback callback) {
        this.mCallback = callback;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.callback);
        super.requestRebind();
    }
    public com.example.android.persistence.ui.CommentClickCallback getCallback() {
        return mCallback;
    }
    public void setComment(com.example.android.persistence.model.Comment comment) {
        this.mComment = comment;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.comment);
        super.requestRebind();
    }
    public com.example.android.persistence.model.Comment getComment() {
        return mComment;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.android.persistence.ui.CommentClickCallback callback = mCallback;
        java.lang.String textComment = null;
        com.example.android.persistence.model.Comment comment = mComment;

        if ((dirtyFlags & 0x6L) != 0) {



                if (comment != null) {
                    // read comment.text
                    textComment = comment.getText();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, textComment);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // callback != null
        boolean callbackObjectnull = false;
        // comment
        com.example.android.persistence.model.Comment comment = mComment;
        // callback
        com.example.android.persistence.ui.CommentClickCallback callback = mCallback;



        callbackObjectnull = (callback) != (null);
        if (callbackObjectnull) {



            callback.onClick(comment);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static CommentItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static CommentItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<CommentItemBinding>inflate(inflater, com.example.android.persistence.R.layout.comment_item, root, attachToRoot, bindingComponent);
    }
    public static CommentItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static CommentItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.persistence.R.layout.comment_item, null, false), bindingComponent);
    }
    public static CommentItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static CommentItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/comment_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new CommentItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): callback
        flag 1 (0x2L): comment
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}