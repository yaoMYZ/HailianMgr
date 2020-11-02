package edu.scut.yao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.scut.yao.pojo.Product;
import edu.scut.yao.R;

public class ProductAdapter extends ArrayAdapter<Product> {
    private int resourceId;

    // 适配器的构造函数，把要适配的数据传入这里
    public ProductAdapter(Context context, int textViewResourceId, List<Product> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Product product=getItem(position); //获取当前项的product实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.productImage=view.findViewById(R.id.product_image);
            viewHolder.productName=view.findViewById(R.id.product_name);
            viewHolder.productIntro=view.findViewById(R.id.product_intro);

            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }

        // 获取控件实例，并调用set...方法使其显示出来
        assert product != null;
        viewHolder.productImage.setImageResource(product.getImage());
        viewHolder.productName.setText(product.getName());
        viewHolder.productIntro.setText(product.getDescription());
        return view;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        ImageView productImage;
        TextView productName;
        TextView productIntro;
    }
}