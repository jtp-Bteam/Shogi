package jp.ac.dendai.c.jtp.shogi;

import android.app.Activity;
import android.widget.GridLayout;

/**
 * Created by PCUser on 2017/07/05.
 */

public class GridControl{

    Activity activity;

    public GridControl(Activity activity)
    {
        this.activity = activity;

        init();
    }

    public void init()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                insertToGrid(i,j,"",false,false);
            }
        }
    }

    public void insertToGrid(int x,int y,String name,boolean nari,boolean sente)
    {
        GridLayout layout = (GridLayout)activity.findViewById(R.id.gridlayout);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        Koma imageView = new Koma(activity,name,nari,sente);
        params.width = 50;
        params.height = 50;
        params.columnSpec = GridLayout.spec(x,1);
        params.rowSpec = GridLayout.spec(y,1);
        imageView.setLayoutParams(params);
        layout.addView(imageView);
    }
}
