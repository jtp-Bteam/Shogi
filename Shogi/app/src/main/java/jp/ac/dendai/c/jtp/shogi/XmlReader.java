package jp.ac.dendai.c.jtp.shogi;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlReader {

    private Activity activity;
    private KomaManager km;

    XmlReader(Activity activity, String fileName) {
        this.activity = activity;
        km = new KomaManager(activity);
        parseXML(fileName);
    }

    private void parseXML(String fileName){
        AssetManager am = activity.getAssets();
        XmlPullParser xpp = Xml.newPullParser();
        try {
            InputStream is = am.open(fileName + ".xml");
            xpp.setInput(is, "UTF-8");
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        String komaName = "";
                        boolean isSente = false;
                        String isMochigoma = "not";
                        boolean isNari = false;
                        int x=0,y=0;
                        for (int i = 0; i < xpp.getAttributeCount(); i++) {
                            String value = xpp.getAttributeValue(i);
                            switch (xpp.getAttributeName(i)) {
                                case "tejun":
                                    isSente = value.equals("sente");
                                    break;

                                case "mochigoma":
                                    isMochigoma = value;
                                    break;

                                case "nari":
                                    isNari = value.equals("true");
                                    break;

                                case "name":
                                    komaName = value;
                                    break;

                                case "x":
                                    x = Integer.parseInt(value)-1;
                                    break;

                                case "y":
                                    y = Integer.parseInt(value)-1;
                                    break;
                            }
                        }
                        if(isMochigoma.equals("restall")) km.setResAll(isSente);
                        else km.addKoma(x,y,komaName,isNari,isSente,isMochigoma.equals("true"));
                }
                eventType = xpp.next();
            }
            km.restAll();
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }
}