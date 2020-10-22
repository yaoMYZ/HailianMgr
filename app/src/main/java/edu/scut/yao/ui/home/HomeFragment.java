package edu.scut.yao.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.scut.yao.R;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home, container, false);
        final TextView textView = root.findViewById(R.id.home_announcement);
        textView.setText(getAnnouncement());
        return root;
    }

    private String getAnnouncement(){
        Date date = new Date();
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        String tiem = sformat.format(date);
        return tiem+":本月累计生产186万元，目标产值300万元";
    }
}