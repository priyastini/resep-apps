package com.example.dessy.resepmamake;

/**
 * Created by Priyastini Dessy on 08/05/2018.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Priyastini Dessy on 08/05/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.hiresslider1, R.drawable.hiresslider2, R.drawable.hiresslider3, R.drawable.hiresslider4};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    Toast.makeText(context, "Resep Dapur Mamake", Toast.LENGTH_SHORT).show();
                } else if (position == 1){
                    Toast.makeText(context, "Nasi Goreng", Toast.LENGTH_SHORT).show();
                } else if (position == 2){
                    Toast.makeText(context, "Es Jeruk Nipis", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Kue Lapis", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}