package edu.scut.yao.product;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SeriesViewModel extends ViewModel {

    private MutableLiveData<String> announcement;

    public SeriesViewModel() {
        announcement = new MutableLiveData<>();
    }

    public LiveData<String> getAnnouncement(){
        Date date = new Date();
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        String tiem = sformat.format(date);
        announcement.setValue(tiem+":本月累计生产186万元，目标产值300万元");
        return announcement;
    }
}