package fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import maniactivity.BaseFragment;
import maniactivity.DiscountPageActivity;
import maniactivity.EditDataPageActivity;
import maniactivity.MyCollectionPageActivity;
import maniactivity.MyConcernPageActivity;
import maniactivity.MyFansPageActivity;
import maniactivity.MyMenuPageActivity;
import maniactivity.MyOrderPageActivity;
import maniactivity.MyWorksPageActivity;
import maniactivity.SetPassWordPageActivity;
import maniactivity.StatisticsPageActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class MyHomepageFragment extends BaseFragment {
    LinearLayout myHomepageConcernLinear;
    LinearLayout myHomepageFansLinear;
    LinearLayout informationTextView;
    LinearLayout myHomepageOrderImg;
    LinearLayout myHomepageCollectionImg;
    LinearLayout myHomepageDiscountImg;
    LinearLayout myHomepageStatisticsImg;
    RelativeLayout myHomepageMyWorksRtl;
    RelativeLayout myHomepageMyMenuRtl;
    RelativeLayout myHomepageSetRtl;
    View view;
    TextView home;

    public MyHomepageFragment() {

    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.myhomepage_layout, container, false);
        itemFindViewById();
        itemSetOnClickListener();
        return view;
    }


    private void itemFindViewById() {
        //点击跳转到我的关注页面
        myHomepageConcernLinear = (LinearLayout) view.findViewById(R.id.myHomepage_concern_linear);
//      点击跳转到我的粉丝页面
        myHomepageFansLinear = (LinearLayout) view.findViewById(R.id.myHomepage_fans_linear);
//        点击跳转到编辑资料页面
        informationTextView = (LinearLayout) view.findViewById(R.id.myHomepage_information_textView);

//        点击跳转到我的订单页面
        myHomepageOrderImg = (LinearLayout) view.findViewById(R.id.myHomepage_order_img);

//        点击跳转到我的收藏页面
        myHomepageCollectionImg = (LinearLayout) view.findViewById(R.id.myHomepage_collection_img);

//        点击跳转到优惠页面
        myHomepageDiscountImg = (LinearLayout) view.findViewById(R.id.myHomepage_discount_img);

//        点击跳转到统计页面
        myHomepageStatisticsImg = (LinearLayout) view.findViewById(R.id.myHomepage_statistics_img);

//        点击跳转到我的作品
        myHomepageMyWorksRtl = (RelativeLayout) view.findViewById(R.id.myHomepage_myWorks_rtl);

//        点击跳转到我的菜谱
        myHomepageMyMenuRtl = (RelativeLayout) view.findViewById(R.id.myHomepage_myMenu_rtl);

//        点击跳转到设置页面
        myHomepageSetRtl = (RelativeLayout) view.findViewById(R.id.myHomepage_set_rtl);

    }

    private void itemSetOnClickListener() {
        myHomepageConcernLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyConcernPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageFansLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyFansPageActivity.class);
                startActivity(intent);
            }
        });
        informationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditDataPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageOrderImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyOrderPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageCollectionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyCollectionPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageDiscountImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DiscountPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageStatisticsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StatisticsPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageMyWorksRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyWorksPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageMyMenuRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyMenuPageActivity.class);
                startActivity(intent);
            }
        });
        myHomepageSetRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SetPassWordPageActivity.class);
                startActivity(intent);
            }
        });

    }
}
