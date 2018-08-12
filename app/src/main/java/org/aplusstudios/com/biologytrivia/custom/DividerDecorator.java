package org.aplusstudios.com.biologytrivia.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.aplusstudios.com.biologytrivia.R;

public class DividerDecorator extends RecyclerView.ItemDecoration {

    private final Drawable mDrawableDivider;

    public DividerDecorator(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDrawableDivider = context.getResources().getDrawable(R.drawable.divider_greyline, null);
        } else {
            mDrawableDivider = context.getResources().getDrawable(R.drawable.divider_greyline);
        }
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(canvas, parent, state);

        int left = parent.getPaddingLeft() + 4;
        int right = parent.getWidth() - parent.getPaddingRight() - 4;
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();

            int top = childView.getBottom() + layoutParams.bottomMargin;
            int bottom = top + mDrawableDivider.getIntrinsicHeight();

            mDrawableDivider.setBounds(left, top, right, bottom);
            mDrawableDivider.draw(canvas);

        }
    }
}
