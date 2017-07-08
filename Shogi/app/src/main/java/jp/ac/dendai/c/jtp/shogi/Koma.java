package jp.ac.dendai.c.jtp.shogi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.widget.AppCompatImageView;

/**
 * Created by PCUser on 2017/07/05.
 */

public class Koma extends AppCompatImageView {

    boolean sente = false;

    public Koma(Context context, String name, boolean nari, boolean sente)
    {
        super(context);

        this.sente = sente;
        selectImage(name,nari);
    }

    private void selectImage(String name,boolean nari)
    {
        switch(name)
        {
            case "ou":
                setImage(R.drawable.ousyou);
                break;

            case "gyoku":
                setImage(R.drawable.gyokusyou);
                break;

            case "hi":
                setImage((!nari) ? R.drawable.hisya : R.drawable.ryuuou);
                break;

            case "kaku":
                setImage((!nari) ? R.drawable.gakugyou : R.drawable.ryuuma);
                break;

            case "kin":
                setImage(R.drawable.kinsyou);
                break;

            case "gin":
                setImage((!nari)?R.drawable.ginsyou : R.drawable.narigin);
                break;

            case "kei":
                setImage((!nari)?R.drawable.keima:R.drawable.narikei);
                break;

            case "kyo":
                setImage((!nari)?R.drawable.kyousya:R.drawable.narikyou);
                break;

            case "fu":
                setImage((!nari)?R.drawable.fuhyou:R.drawable.tokin);
                break;
        }
    }

    private void setImage(int resID)
    {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),resID);
        if(!sente) bitmap = flip(bitmap);
        setImageBitmap(bitmap);
    }

    private Bitmap flip(Bitmap bitmap)
    {
        int imageWidth = bitmap.getWidth();
        int imageHeight = bitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.setRotate(180, bitmap.getWidth()/2, bitmap.getHeight()/2);
        return Bitmap.createBitmap(bitmap, 0, 0, imageWidth, imageHeight, matrix, true);
    }
}
