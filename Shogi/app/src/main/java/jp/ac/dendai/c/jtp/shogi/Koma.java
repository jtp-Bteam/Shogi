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
                setImage(R.drawable.syougi01_ousyou);
                break;

            case "gyoku":
                setImage(R.drawable.syougi02_gyokusyou);
                break;

            case "hi":
                if(!nari)setImage(R.drawable.syougi03_hisya);
                else setImage(R.drawable.syougi04_ryuuou);
                break;

            case "kaku":
                if(!nari)setImage(R.drawable.syougi05_gakugyou);
                else setImage(R.drawable.syougi06_ryuuma);
                break;

            case "kin":
                setImage(R.drawable.syougi07_kinsyou);
                break;

            case "gin":
                if(!nari) setImage(R.drawable.syougi08_ginsyou);
                else setImage(R.drawable.syougi09_narigin);
                break;

            case "kei":
                if(!nari) setImage(R.drawable.syougi10_keima);
                else setImage(R.drawable.syougi11_narikei);
                break;

            case "kyou":
                if(!nari) setImage(R.drawable.syougi12_kyousya);
                else setImage(R.drawable.syougi13_narikyou);
                break;

            case "fu":
                if(!nari) setImage(R.drawable.syougi14_fuhyou);
                else setImage(R.drawable.syougi15_tokin);
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
