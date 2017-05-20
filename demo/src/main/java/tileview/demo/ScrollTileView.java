package tileview.demo;

import android.content.Context;
import android.util.AttributeSet;

import com.qozix.tileview.TileView;

public class ScrollTileView extends TileView {
    public ScrollTileView(Context context) {
        super(context);
    }

    public ScrollTileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollTileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int extraScroll = 100;

    @Override
    protected int getScrollLimitX() {
        return super.getScrollLimitX() + extraScroll;
    }

    @Override
    protected int getScrollLimitY() {
        return super.getScrollLimitY() + extraScroll;
    }

    @Override
    protected int getScrollMinX() {
        return super.getScrollMinX() - extraScroll;
    }

    @Override
    protected int getScrollMinY() {
        return super.getScrollMinX() - extraScroll;
    }
}
