package jp.ac.dendai.c.jtp.shogi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.widget.AppCompatImageView;

public class Koma extends AppCompatImageView {

    private String name;
    private boolean isNari = false;
    private boolean isSente = false;

    public Koma(Context context)
    {
        super(context);
    }

    public Koma(Context context,String name, boolean nari, boolean sente)
    {
        super(context);

        isSente = sente;
        isNari = nari;
        this.name = name;

        selectImage();
    }

    private void selectImage()
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
                setImage((!isNari) ? R.drawable.hisya : R.drawable.ryuuou);
                break;

            case "kaku":
                setImage((!isNari) ? R.drawable.gakugyou : R.drawable.ryuuma);
                break;

            case "kin":
                setImage(R.drawable.kinsyou);
                break;

            case "gin":
                setImage((!isNari)?R.drawable.ginsyou : R.drawable.narigin);
                break;

            case "kei":
                setImage((!isNari)?R.drawable.keima:R.drawable.narikei);
                break;

            case "kyo":
                setImage((!isNari)?R.drawable.kyousya:R.drawable.narikyou);
                break;

            case "fu":
                setImage((!isNari)?R.drawable.fuhyou:R.drawable.tokin);
                break;
        }
    }

    private void setImage(int resID)
    {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),resID);
        if(!isSente) bitmap = flip(bitmap);
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

    public boolean isSente()
    {
        return isSente;
    }
}
