package br.com.felix.horizontalbargraph;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BarView extends LinearLayout {

    private static final int TRANSPARENT = 0x00000000;

    public final TextView txtValue;
    private final TextView txtValue2;
    private float percent;
    private int textColor;
    private int barTotalWidth = 0;

    public BarView (Context context, @Nullable AttributeSet attrs) {
        super (context, attrs);
        View view = View.inflate (context, R.layout.layout_bar_view, this);


        txtValue = view.findViewById (R.id.txtValorDespesa);
        txtValue2 = view.findViewById (R.id.txtValorDespesa2);
    }

    public void setPercentage (float percent) {
        this.percent = percent;

        if ( barTotalWidth > 0 ) {
            setUpView ();
        }
    }

    public void setColors (@ColorInt int textColor, @ColorInt int backgroundColor) {
        this.textColor = textColor;
        txtValue.setTextColor (textColor);
        txtValue.setBackgroundColor (backgroundColor);
    }

    @Override
    protected void onSizeChanged (int w, int h, int oldw, int oldh) {
        super.onSizeChanged (w, h, oldw, oldh);
        barTotalWidth = w;

        setUpView ();
    }

    private void setUpView () {
        final int txtValueWidth = (int) (barTotalWidth * percent);

        txtValue.post (new Runnable () {
            @Override
            public void run () {
                txtValue.setLayoutParams (new LayoutParams (txtValueWidth,
                        ViewGroup.LayoutParams.MATCH_PARENT));
            }
        });

        int textWidth = calculateTextWidth ();

        if ( textWidth > txtValueWidth ) {
            txtValue2.setVisibility (VISIBLE);
            txtValue.setTextColor (TRANSPARENT);
        } else {
            txtValue2.setVisibility (INVISIBLE);
            txtValue.setTextColor (textColor);
        }
    }

    public void setText (String text) {
        txtValue.setText (Html.fromHtml (text));
        txtValue2.setText (Html.fromHtml (text));
    }

    private int calculateTextWidth () {
        Resources r = getResources ();
        float padding = TypedValue.applyDimension (TypedValue.COMPLEX_UNIT_DIP, 16, r
                .getDisplayMetrics ());

        String text = txtValue.getText ().toString ();
        Rect bounds = new Rect ();
        Paint textPaint = txtValue.getPaint ();
        textPaint.getTextBounds (text, 0, text.length (), bounds);
        return (int) (bounds.width () + padding);
    }
}