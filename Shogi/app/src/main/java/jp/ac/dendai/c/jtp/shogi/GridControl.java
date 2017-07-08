package jp.ac.dendai.c.jtp.shogi;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

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
        int grid_x = 8-x;
        int grid_y = y;
        params.columnSpec = GridLayout.spec(grid_x,1f);
        params.rowSpec = GridLayout.spec(grid_y,1f);
        imageView.setLayoutParams(params);
        layout.addView(imageView);
    }

    public void insertToMochigoma(String name,boolean sente)
    {
        LinearLayout linearLayout;
        Koma koma = new Koma(activity,name,false,sente);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50,50);
        koma.setLayoutParams(params);
        if(sente) linearLayout= (LinearLayout)activity.findViewById(R.id.linearLayout2);
        else linearLayout = (LinearLayout)activity.findViewById(R.id.linearLayout);
        linearLayout.addView(koma);

    }
}
