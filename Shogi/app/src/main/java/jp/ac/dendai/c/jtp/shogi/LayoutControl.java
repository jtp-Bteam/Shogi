package jp.ac.dendai.c.jtp.shogi;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;


public class LayoutControl {

    private Activity activity;

    public LayoutControl(Activity activity)
    {
        this.activity = activity;
    }

    public void insertToGrid(int x,int y,Koma koma)
    {
        int grid_x = 8-x;
        int grid_y = y;

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 50;
        params.height = 50;
        params.columnSpec = GridLayout.spec(grid_x);
        params.rowSpec = GridLayout.spec(grid_y);
        koma.setLayoutParams(params);

        GridLayout layout = (GridLayout)activity.findViewById(R.id.gridlayout);
        layout.addView(koma);
    }

    public void insertToMochigoma(Koma koma)
    {
        LinearLayout linearLayout;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        koma.setLayoutParams(params);

        if(koma.isSente()) linearLayout= (LinearLayout)activity.findViewById(R.id.linearLayout2);
        else linearLayout = (LinearLayout)activity.findViewById(R.id.linearLayout);

        linearLayout.addView(koma);
    }

}
