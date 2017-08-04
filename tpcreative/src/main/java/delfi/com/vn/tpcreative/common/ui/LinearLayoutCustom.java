package delfi.com.vn.tpcreative.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import dk.delfi.core.R;

/**
 * Created by PC on 8/1/2017.
 */

public class LinearLayoutCustom extends LinearLayout {

    Context context;
    public Animation inAnimation;
    public Animation outAnimation;

    public LinearLayoutCustom(Context context)
    {
        super(context);
        this.context = context;
        initAnimations();
    }

    public LinearLayoutCustom(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        initAnimations();
    }

    public LinearLayoutCustom(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        this.context = context;
        initAnimations();
    }

    private void initAnimations()
    {
        inAnimation = (AnimationSet) AnimationUtils.loadAnimation(context, R.anim.in_animation);
        outAnimation = (Animation) AnimationUtils.loadAnimation(context, R.anim.out_animation);
    }

    public void show()
    {
        if (isVisible()) return;
        show(true);
    }


    public void show(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(inAnimation);
        this.setVisibility(View.VISIBLE);
    }

    public void hide()
    {
        if (!isVisible()) return;
        hide(true);
    }

    public void hide(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(outAnimation);
        this.setVisibility(View.GONE);
    }

    public boolean isVisible()
    {
        return (this.getVisibility() == View.VISIBLE);
    }

    public void overrideDefaultInAnimation(Animation inAnimation)
    {
        this.inAnimation = inAnimation;
    }

    public void overrideDefaultOutAnimation(Animation outAnimation)
    {
        this.outAnimation = outAnimation;
    }
}
