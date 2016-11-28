package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ListViewAdapter;
import maniactivity.BaseFragment;
import maniactivity.ListInformation;
import maniactivity.MenuClassFicationPageActivity;
import maniactivity.RankingListPageActivity;
import maniactivity.SearchLayoutActivity;
import maniactivity.SearchPageActivity;
import maniactivity.VegetableBasketPageActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class HomepageFragment extends BaseFragment {
    ImageView homepage_search_img;
    TextView homepage_buy;
    ImageView homepage_basket_img;
    TextView homepage_kitchen_tv;
    TextView homepage_ranking_tv;
    TextView homepage_menuclassification_tv;
    View view;
    ListView listView;
    ListViewAdapter listViewAdapter;
    List<ListInformation> list;
    public HomepageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_homepage, container, false);
        itemFindViewById();
        itemSetOnClickListener();
        setData();

        {
            listViewAdapter = new ListViewAdapter(getActivity(),list,4);
            listView.setAdapter(listViewAdapter);
        }
        //限制ListView的高度
        {
            View view = listViewAdapter.getView(0, null, listView);
            view.measure(0, 0);
            int MeasuredHeight = view.getMeasuredHeight();
            int DividerHeight = listView.getDividerHeight();
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = (MeasuredHeight + DividerHeight) * list.size();
            listView.setLayoutParams(params);
        }

        return view;
    }

    private void setData(){
        list = new ArrayList<>();
        ListInformation listInformation;
        for (int t =0 ;t<5;t++){
            listInformation = new ListInformation();
            listInformation.setTitle("营养早餐");
            listInformation.setLike(0);
            listInformation.setMessage(0);
            listInformation.setImg(R.mipmap.icon_bg_kitchen);
            list.add(listInformation);
        }
    }

    private void itemFindViewById(){
        homepage_search_img = (ImageView) view.findViewById(R.id.homepage_search_img);
        homepage_buy = (TextView) view.findViewById(R.id.homepage_buy);
        homepage_basket_img = (ImageView) view.findViewById(R.id.homepage_basket_img);
        homepage_kitchen_tv = (TextView) view.findViewById(R.id.homepage_kitchen_tv);
        homepage_ranking_tv = (TextView) view.findViewById(R.id.homepage_ranking_tv);
        homepage_menuclassification_tv = (TextView) view.findViewById(R.id.homepage_menuclassification_tv);
        listView = (ListView)view.findViewById(R.id.listView);
        }

    private void itemSetOnClickListener(){
        // 搜索界面
        homepage_search_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchPageActivity.class);
                startActivity(intent);
            }
        });
        //买烘培
        homepage_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchLayoutActivity.class);
                startActivity(intent);
            }
        });
        //菜篮子
        homepage_basket_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VegetableBasketPageActivity.class);
                startActivity(intent);
            }
        });
        //厨房问答
        homepage_kitchen_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KitchenPageFragment.class);
                startActivity(intent);
            }
        });
        //排行榜
        homepage_ranking_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RankingListPageActivity.class);
                startActivity(intent);
            }
        });
        //菜谱分类
        homepage_menuclassification_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuClassFicationPageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }
}
