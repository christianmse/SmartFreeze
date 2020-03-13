package com.smartfreeze.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.smartfreeze.R;
import com.smartfreeze.domain.LandingPages;

import java.util.List;

public class LandingAdapter extends PagerAdapter {

    private Context mContext;
    private List<LandingPages> paginas;


    public LandingAdapter(Context context, List<LandingPages> paginasList) {
        mContext = context;
        paginas = paginasList;

    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        //   PagesOnBoarding pages = PagesOnBoarding.values()[position];
      /*  OcultarMenu ocultarMenu = new OcultarMenu();
        if(ocultarMenu.getItemVisibles().get("Mis Prestaciones")== false){
            PagesOnBoarding.values()[1].
        }*/

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(paginas.get(position).getLayoutResId(), collection, false);
        if (position != 0) {
            ImageView imageView = layout.findViewById(R.id.ivIconOnboard);
            imageView.setImageDrawable(mContext.getResources().getDrawable(paginas.get(position).getmIvResId()));
        }
        TextView titleOnboard = layout.findViewById(R.id.tvTitleOnboard);
        titleOnboard.setText(paginas.get(position).getTitleResId());

        TextView firstString = layout.findViewById(R.id.tvBodyOnBoard);
        firstString.setText(paginas.get(position).getmBodyResId());
        Button btnSaltar = ((Activity) mContext).findViewById(R.id.btnSaltar);


        if (position == (paginas.size() - 1))
            btnSaltar.setText(R.string.entrar);
        else
            btnSaltar.setText(R.string.saltar);
        collection.addView(layout);
        return layout;

    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return paginas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        LandingPages customPagerEnum = paginas.get(position);
        return mContext.getString(customPagerEnum.getTitleResId());
    }

}
