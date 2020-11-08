package edu.scut.yao.utils;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<View> getAllChildViews(View view) { // 传入的view为 this.getWindow().getDecorView()
        List<View> allchildren = new ArrayList<View>();
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                allchildren.add(viewchild);
                allchildren.addAll(getAllChildViews(viewchild));
            }
        }
        return allchildren;
    }
}
