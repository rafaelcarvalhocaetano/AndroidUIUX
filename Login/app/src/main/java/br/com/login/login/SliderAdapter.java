package br.com.login.login;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by rafael on 08/03/18.
 */

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    public SliderAdapter(Context c){

        this.context = c;
    }

    //array das imagens
    public int[] slider_image = {
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12
    };

    //array de String dos title
    public String[] slider_header = { "EAT","SLEEP", "CODE" };

    //array para as informações
    public String[] slider_desc = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer scelerisque et ex at aliquet. Maecenas convallis sed metus in rutrum.",
            "Curabitur aliquam orci eu sem lobortis gravida. Nullam ante augue, euismod sed odio vel, faucibus pretium augue. Ut venenatis egestas risus.",
            "Proin sem risus, sagittis nec egestas id, commodo vitae nulla. Fusce lectus purus, blandit sit amet viverra quis, pulvinar nec magna."
    };

    @Override
    public int getCount() {
        return slider_header.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider_layout, container, false);

        ImageView sliderImageView = (ImageView) view.findViewById(R.id.slider_image);
        TextView sliderHeading = (TextView) view.findViewById(R.id.slider_heading);
        TextView sliderDesc = (TextView) view.findViewById(R.id.slider_desc);

        //busca a posição
        sliderImageView.setImageResource(slider_image[position]);
        sliderHeading.setText(slider_header[position]);
        sliderDesc.setText(slider_desc[position]);

        //adicionando ao container
        container.addView( view );

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView( (RelativeLayout) object );
    }
}
