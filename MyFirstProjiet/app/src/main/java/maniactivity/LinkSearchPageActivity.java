package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MenuGoodsAdapter;
import adapter.MyDiscountAdapter;
import listclass.MenuGoodsData;
import listclass.MyCollectionOrderData;
import listclass.MyDiscountData;

/**
 * Created by Administrator on 2016/11/27.
 */
public class LinkSearchPageActivity extends Activity {
    private RelativeLayout dismissEelative;
    private View dismissCiew;
    private ImageView searchBackImg;

    private ImageView checkVisibleImg;
    private LinearLayout linkLinearLayout;
    private TextView dismissTextView;

    private ImageView checkOne;
    private ImageView checkTwo;
    private ImageView checkThree;
    private ImageView checkFour;
    private ImageView checkFive;
    private ImageView checkSix;

    private RelativeLayout checkRlOne;
    private RelativeLayout checkRlTwo;
    private RelativeLayout checkRlThree;
    private RelativeLayout checkRlFour;
    private RelativeLayout checkRlFive;
    private RelativeLayout checkRlSix;

    private ViewGroup mContainerView;

    /*适配器*/
    View view;
    ListView listView;
    //List<MenuGoodsData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_visible);

        bindView();
        itemById();
        //setData((ArrayList<MenuGoodsData>) list);
    }

    private void addItem() {
        View newView = null;
        mContainerView.addView(newView, 0);
    }

    private void bindView() {
        searchBackImg = (ImageView) findViewById(R.id.search_back_img);
        searchBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dismissCiew = findViewById(R.id.dismiss_view);
        dismissCiew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linkLinearLayout.getVisibility() == View.VISIBLE) {
                    linkLinearLayout.setVisibility(View.INVISIBLE);
                } else if (linkLinearLayout.getVisibility() == View.INVISIBLE) {
                    linkLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    linkLinearLayout.setVisibility(View.INVISIBLE);
                }
            }
        });

        dismissEelative = (RelativeLayout) findViewById(R.id.dismiss_relative);
        dismissEelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //linkLinearLayout.setVisibility(View.GONE);
            }
        });

        checkVisibleImg = (ImageView) findViewById(R.id.check_visible_img);
        checkVisibleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });

        linkLinearLayout = (LinearLayout) findViewById(R.id.link_linearLayout);
        dismissTextView = (TextView) findViewById(R.id.dismiss_textView);
        dismissTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();  是结束当前activity
                linkLinearLayout.setVisibility(View.GONE);
            }
        });

        checkRlOne = (RelativeLayout) findViewById(R.id.check_rl_one);
        checkRlTwo = (RelativeLayout) findViewById(R.id.check_rl_two);
        checkRlThree = (RelativeLayout) findViewById(R.id.check_rl_three);
        checkRlFour = (RelativeLayout) findViewById(R.id.check_rl_four);
        checkRlFive = (RelativeLayout) findViewById(R.id.check_rl_five);
        checkRlSix = (RelativeLayout) findViewById(R.id.check_rl_six);

        checkOne = (ImageView) findViewById(R.id.check_one);
        checkTwo = (ImageView) findViewById(R.id.check_two);
        checkThree = (ImageView) findViewById(R.id.check_three);
        checkFour = (ImageView) findViewById(R.id.check_four);
        checkFive = (ImageView) findViewById(R.id.check_five);
        checkSix = (ImageView) findViewById(R.id.check_six);

        checkVisibleImg.setOnClickListener(onClickListener);

        checkRlOne.setOnClickListener(onClickListener);
        checkRlTwo.setOnClickListener(onClickListener);
        checkRlThree.setOnClickListener(onClickListener);
        checkRlFour.setOnClickListener(onClickListener);
        checkRlFive.setOnClickListener(onClickListener);
        checkRlSix.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.check_visible_img:  //点击 check_visible_img 显示隐藏的搜索布局
                    if (linkLinearLayout.getVisibility() == View.GONE) {
                        linkLinearLayout.setVisibility(View.VISIBLE);
                    } else if (linkLinearLayout.getVisibility() == View.VISIBLE) {
                        linkLinearLayout.setVisibility(View.INVISIBLE);
                    } else {
                        linkLinearLayout.setVisibility(View.VISIBLE);
                    }
                    break;

                case R.id.check_rl_one:
                    if (checkOne.getVisibility() == View.INVISIBLE) {
                        checkOne.setVisibility(View.VISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    } else {
                        checkOne.setVisibility(View.VISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.check_rl_two:
                    if (checkTwo.getVisibility() == View.INVISIBLE) {
                        checkTwo.setVisibility(View.VISIBLE);
                        checkOne.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    } else {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.VISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.check_rl_three:
                    if (checkThree.getVisibility() == View.INVISIBLE) {
                        checkThree.setVisibility(View.VISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkOne.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    } else {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.VISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.check_rl_four:
                    if (checkFour.getVisibility() == View.INVISIBLE) {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.VISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    } else {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.VISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.check_rl_five:
                    if (checkFive.getVisibility() == View.INVISIBLE) {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.VISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    } else {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.VISIBLE);
                        checkSix.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.check_rl_six:
                    if (checkSix.getVisibility() == View.INVISIBLE) {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.VISIBLE);
                    } else {
                        checkOne.setVisibility(View.INVISIBLE);
                        checkTwo.setVisibility(View.INVISIBLE);
                        checkThree.setVisibility(View.INVISIBLE);
                        checkFour.setVisibility(View.INVISIBLE);
                        checkFive.setVisibility(View.INVISIBLE);
                        checkSix.setVisibility(View.VISIBLE);
                    }
                    break;
            }
        }
    };

    public void itemById() {
        listView = (ListView) findViewById(R.id.listView);
        ArrayList<MenuGoodsData> list = new ArrayList<MenuGoodsData>();
        setData(list);
        listView.setAdapter(new MenuGoodsAdapter(this, list));
    }

    public void setData(ArrayList<MenuGoodsData> list) {
        // list = new ArrayList<>();
        MenuGoodsData menuGoodsData;
        for (int i = 0; i < 20; i++) {
            menuGoodsData = new MenuGoodsData();
            menuGoodsData.setCaipu_img(R.mipmap.icon_luan);
            menuGoodsData.setPeople_textView("我做的");
            menuGoodsData.setPeople_numb("50");
            menuGoodsData.setTitle_textView("西式炒面");

            list.add(menuGoodsData);
        }
    }
}
