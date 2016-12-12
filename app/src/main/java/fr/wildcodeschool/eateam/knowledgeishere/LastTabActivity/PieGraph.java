package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

import fr.wildcodeschool.eateam.knowledgeishere.R;

public class PieGraph extends View {

    private Paint piePaint;
    private RectF rectF;
    private float[] data;

    public PieGraph(Context context, AttributeSet attrs){
        super(context,attrs);

        piePaint = new Paint();
        piePaint.setAntiAlias(true);
        piePaint.setDither(true);
        piePaint.setStyle(Paint.Style.FILL);


    }

    private float[] pieSegment(){

        float[] segValues = new float[this.data.length];
        float Total = getTotal();

        for (int i = 0; i < this.data.length; i++){

            segValues[i] = (this.data[i]/Total) * 360;
        }

        return segValues;
    }


    private float getTotal(){

        float total = 0;

        for (float val : this.data){
            total +=val;
        }

        return total;
    }

    @Override
    protected void onDraw(Canvas canvas){

        if (data != null){

            int top = 0;
            int left = 0;
            int endBottom = 100;
            int endRight = 100;

            rectF = new RectF(left, top, endRight, endBottom);

            float[] segment = pieSegment();

            float segStartPoint = 0;

            boolean isDoneOnce = false;
            for (int i = 0; i < segment.length; i++){

               // Random rnd = new Random();
                //int color = Color.argb(255, (int)segment[i], rnd.nextInt(256), rnd.nextInt(256));
                if (!isDoneOnce) {
                    piePaint.setColor(Color.parseColor("#4a91d0"));

                    isDoneOnce =true;
                }else{
                    piePaint.setColor(Color.parseColor("#ccccff"));
                    isDoneOnce =false;
                }

                canvas.drawArc(rectF, segStartPoint, segment[i], true, piePaint);
                segStartPoint += segment[i];

            }
        }
    }

    public void setData(float[] data){

        this.data = data;
        invalidate();
    }
}
