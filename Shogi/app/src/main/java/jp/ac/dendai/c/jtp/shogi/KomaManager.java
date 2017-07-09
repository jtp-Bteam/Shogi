package jp.ac.dendai.c.jtp.shogi;

import android.app.Activity;
import java.util.HashMap;

public class KomaManager {

    HashMap<String,Integer> map = new HashMap<>();

    private LayoutControl gc;
    private boolean isRestAll,isSente;
    private Activity activity;

    KomaManager(Activity activity)
    {
        this.activity = activity;
        gc = new LayoutControl(activity);
        initMap();
        initGrid();
    }

    private void initMap()
    {
        map.put("fu",18);
        map.put("kei",4);
        map.put("kyo",4);
        map.put("kaku",2);
        map.put("kin",4);
        map.put("gin",4);
        map.put("ou",1);
        map.put("gyoku",1);
        map.put("hi",2);
    }

    private void initGrid()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                gc.insertToGrid(i,j,new Koma(activity));
            }
        }
    }

    private void removeKoma(String name)
    {
        if(map.get(name) != null)
        {
            int i = map.get(name).intValue()-1;
            map.put(name,i);
        }
    }

    public void restAll()
    {
        for (HashMap.Entry<String,Integer> entry : map.entrySet()) {
            for(int i=entry.getValue();i>0;i--)
            {
                gc.insertToMochigoma(new Koma(activity,entry.getKey(),false,isSente));
            }
        }
    }

    public void setResAll(boolean sente)
    {
        isRestAll = true;
        isSente = sente;
    }

    public void addKoma(int x,int y,String name, boolean nari, boolean sente,boolean isMochigoma)
    {
        if(!isMochigoma) gc.insertToGrid(x,y,new Koma(activity,name,nari,sente));
        else gc.insertToMochigoma(new Koma(activity,name,nari,sente));
        removeKoma(name);
    }
}
