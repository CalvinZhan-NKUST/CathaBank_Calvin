package com.test.cathabank.databinding;
import com.test.cathabank.R;
import com.test.cathabank.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class StockLayoutBindingImpl extends StockLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvStockCode, 1);
        sViewsWithIds.put(R.id.tvStockName, 2);
        sViewsWithIds.put(R.id.tvOpenPrice, 3);
        sViewsWithIds.put(R.id.tvClosePrice, 4);
        sViewsWithIds.put(R.id.tvHighPrice, 5);
        sViewsWithIds.put(R.id.tvLowPrice, 6);
        sViewsWithIds.put(R.id.tvPriceDifference, 7);
        sViewsWithIds.put(R.id.tvMonthlyAverage, 8);
        sViewsWithIds.put(R.id.tvTransactionCount, 9);
        sViewsWithIds.put(R.id.tvTransactionVolume, 10);
        sViewsWithIds.put(R.id.tvTradeValue, 11);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public StockLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private StockLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.stockInfo == variableId) {
            setStockInfo((com.test.cathabank.data.model.StockInfo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setStockInfo(@Nullable com.test.cathabank.data.model.StockInfo StockInfo) {
        this.mStockInfo = StockInfo;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): stockInfo
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}