package edu.scut.yao.home_page.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import edu.scut.yao.R;
import edu.scut.yao.product.Series;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.home, container, false);
        final TextView textView = root.findViewById(R.id.home_announcement);
        homeViewModel.getAnnouncement().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        toSeries(root);
        toProduct(root);
        return root;
    }

    public void toSeries(View view){
        Button series =view.findViewById(R.id.home_series);//所以你的id都是基于你这个布局找的

        series.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(),Series.class);//你的fragment是

                startActivity(intent);
            }
        });
    }

    public void toProduct(View view){
        Button series =view.findViewById(R.id.home_product);//所以你的id都是基于你这个布局找的

        series.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(),Series.class);//你的fragment是

                startActivity(intent);
            }
        });
    }
}