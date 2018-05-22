package dam2.fje.edu.practica_simon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;


public class MyView extends View {
    int initX = 200, initY = 200, radius = 100, rectWidth = 500, rectHeight = 400;

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // custom drawing code here
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // make the entire canvas white
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        // draw blue circle with anti aliasing turned on
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(initX, initY, radius, paint);

        // draw red rectangle with anti aliasing turned off
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawRect(initX, initY + 300, rectWidth + radius, initY + rectHeight, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setTextSize(40);
        canvas.drawText("CoderzHeaven, Heaven of all working codes", initX, initY + 600, paint);

        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.M)
            canvas.restore();
    }
}

