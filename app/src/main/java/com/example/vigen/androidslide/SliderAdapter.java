package com.example.vigen.androidslide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    //Arrays

    public  int[]slide_images={

            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon
    };

    public String[]slide_headings={
            "EAT",
            "SLEEP",
            "CODE"
    };

    public  String[]slide_desks={
            //Eat
            "We lovingly create, make and serve hot and cold food; sandwiches, soups, hot pots, pies," +
                    " salads, wraps, desserts, pastries, breakfast, cold drinks, coffee.",
            //Sleep
            "Sleep is a naturally recurring state of mind and body, characterized by altered consciousness," +
                    " relatively inhibited sensory activity, inhibition of nearly all voluntary muscles, " +
                    "and reduced interactions with surroundings.",
            //Code
            "In communications and information processing, code is a system of rules to convert information—such" +
                    " as a letter, word, sound, image, or gesture"


    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView)view.findViewById(R.id.slide_image);
        TextView slideHeading=(TextView)view.findViewById(R.id.slide_heading);
        TextView slideDescription=(TextView)view.findViewById(R.id.slide_desk);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desks[position]);

        container.addView(view);

        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
