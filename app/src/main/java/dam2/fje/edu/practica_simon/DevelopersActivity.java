package dam2.fje.edu.practica_simon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DevelopersActivity extends AppCompatActivity {

    int initX = 40, initY = 50, radius = 100, rectWidth = 500, rectHeight = 400, footY = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CanvasView demoview = new CanvasView(this);
        setContentView(demoview);
    }

    private class CanvasView extends View {
        public CanvasView(Context context) {
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
            // paint.setAntiAlias(true);
            //  paint.setColor(Color.BLUE);
            //  canvas.drawCircle(initX, initY, radius, paint);

            // draw red rectangle with anti aliasing turned off
            // paint.setAntiAlias(true);
            //paint.setColor(Color.RED);
            // canvas.drawRect(initX, initY + 300, rectWidth + radius, initY + rectHeight , paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);
            paint.setTextSize(55);
            canvas.drawText("Crèdits Simon", initX + 20, initY + 100, paint);
            paint.setTextSize(45);
            canvas.drawText("Guillem Martinez", initX + 150, initY + 300 + footY, paint);
            paint.setTextSize(30);
            canvas.drawText("i", initX + 300, initY + 400 + footY, paint);
            paint.setTextSize(45);
            canvas.drawText("Joan Baró", initX + 220, initY + 500 + footY, paint);

        }
    }
}
