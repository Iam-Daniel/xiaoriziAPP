package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import ListItemInfor.ListInformation;

/**
 * Created by Administrator on 2016/11/25.
 */
public class ListViewAdapter extends BaseAdapter {
    ViewHolder viewHolder;
    Context context;
    ListInformation information;
    List<ListInformation> list;
    Bitmap bitmap = null;
    int time;
    int style;//由于多个页面复用该适配器，需要传入参数来决定加载哪些内容

    public ListViewAdapter(Context context, List<ListInformation> list, int style) {
        this.context = context;
        this.list = list;
        //1 是SearchLayoutListView界面调用
        //2 是KitchenPageActivity界面调用
        //3 是WorldPageFragment界面调用
        //4 是HomepageFragment界面调用
        this.style = style;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        time = position;
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        LinearLayout layout_meddil;
        ImageView icon_head;//头像图片
        TextView author;//作者
        TextView time_y_m_d;//日期-年月日
        TextView time_f_a;//日期-AM/PM
        TextView time_m_s;//日期-小时 分钟
        ImageView img;//示例背景图
        TextView numb_f;//喜欢人数
        TextView numb_m;//留言数
        TextView details;//食谱做法
        LinearLayout changeLayout;//有的List中不需要该布局
        TextView concern;//是否被关注
        ImageView media;//是否有视频
        TextView title_bottom;//底部标题栏
        ImageView like;//喜欢图标
        ImageView message;//留言图标
        TextView title;//标题
        boolean state = false;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if (view == null) {
            viewHolder = new ViewHolder();
            //布局为通用listView布局
            view = layoutInflater.inflate(R.layout.general_list_item, null);
            viewHolder.icon_head = (ImageView) view.findViewById(R.id.icon_head);
            viewHolder.img = (ImageView) view.findViewById(R.id.img);
            viewHolder.author = (TextView) view.findViewById(R.id.author);
            viewHolder.time_y_m_d = (TextView) view.findViewById(R.id.time_y_m_d);
            viewHolder.time_f_a = (TextView) view.findViewById(R.id.time_f_a);
            viewHolder.time_m_s = (TextView) view.findViewById(R.id.time_m_s);
            viewHolder.numb_f = (TextView) view.findViewById(R.id.numb_f);
            viewHolder.numb_m = (TextView) view.findViewById(R.id.numb_m);
            viewHolder.details = (TextView) view.findViewById(R.id.details);
            viewHolder.changeLayout = (LinearLayout) view.findViewById(R.id.changeLayout);
            viewHolder.concern = (TextView) view.findViewById(R.id.concern);
            viewHolder.title_bottom = (TextView) view.findViewById(R.id.title_bottom);
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.media = (ImageView) view.findViewById(R.id.media);
            viewHolder.like = (ImageView) view.findViewById(R.id.like);
            viewHolder.message = (ImageView) view.findViewById(R.id.message);
            viewHolder.layout_meddil = (LinearLayout) view.findViewById(R.id.layout_middle);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        information = list.get(position);
        //根据要加载的listView格式不同，分别加载对应对应内容
        //此处是SearchLayoutListView界面调用
        if (style == 1 && !viewHolder.state) {
            viewHolder.author.setText(information.getAuthor());
            viewHolder.time_y_m_d.setText(information.getTime_y_m_d());
            viewHolder.time_f_a.setText(information.getTime_f_a());
            viewHolder.time_m_s.setText(information.getTime_m_s());
            viewHolder.numb_f.setText("" + information.getNumb_f());
            viewHolder.numb_m.setText("" + information.getNumb_m());
            viewHolder.state = true;
            setIcon();
            //此处是KitchenPageActivity界面调用
        } else if (style == 2 && viewHolder.author.getText().equals("author")) {
            //设置菜谱成果图
            String path = information.getImg();
            getImage(2, path);
            //设置用户小头像
            path = information.getIcon_head();
            getImage(1, path);
            viewHolder.author.setText(information.getAuthor());
            viewHolder.numb_f.setText("" + information.getNumb_f());
            viewHolder.numb_m.setText("" + information.getNumb_m());
            viewHolder.changeLayout.setVisibility(View.GONE);
            viewHolder.details.setText(information.getDetails());
            setIcon();
        } else if (style == 3 && viewHolder.author.getText().equals("author")) {
            viewHolder.author.setText(information.getAuthor());
            viewHolder.time_y_m_d.setText(information.getTime_y_m_d());
            viewHolder.time_f_a.setVisibility(View.GONE);
            viewHolder.time_m_s.setVisibility(View.GONE);
            viewHolder.numb_f.setText(information.getNumb_f() + "");
            viewHolder.numb_m.setText(information.getNumb_m() + "");
            //设置菜谱成果图
            String path = information.getImg();
            getImage(2,path);
            //设置用户小头像
            path = information.getIcon_head();
            getImage(1, path);
            setIcon();
            viewHolder.title_bottom.setText(information.getTitle_bottom());
        } else if (style == 4 && viewHolder.author.getText().equals("author")) {
            setIcon();
            //设置菜谱成果图
            String path = information.getImg();
            getImage(2, path);
            viewHolder.title.setText(information.getTitle());
            viewHolder.layout_meddil.setVisibility(View.GONE);
        }
        return view;
    }

    //控制各个图标是否显示
    private void setIcon() {
        if (information.getMedia() == 1) {
            viewHolder.media.setVisibility(View.VISIBLE);
        } else {
            viewHolder.media.setVisibility(View.GONE);
        }
        if (information.getLike() == 1) {
            viewHolder.like.setVisibility(View.VISIBLE);
        } else {
            viewHolder.like.setVisibility(View.GONE);
        }
        if (information.getMessage() == 1) {
            viewHolder.message.setVisibility(View.VISIBLE);
        } else {
            viewHolder.message.setVisibility(View.GONE);
        }

        //设置不用的控件隐藏
        {
            if (information.getIcon_head() == null) {
                viewHolder.icon_head.setVisibility(View.GONE);
            }
            if (information.getAuthor() == null) {
                viewHolder.author.setVisibility(View.GONE);
            }
            if (information.getTime_y_m_d() == null) {
                viewHolder.time_y_m_d.setVisibility(View.GONE);
            }
            if (information.getTime_f_a() == null) {
                viewHolder.time_f_a.setVisibility(View.GONE);
            }
            if (information.getTime_m_s() == null) {
                viewHolder.time_m_s.setVisibility(View.GONE);
            }
            if (information.getImg() == null) {
                viewHolder.img.setVisibility(View.GONE);
            }
            if (information.getNumb_f() == 0) {
                viewHolder.numb_f.setVisibility(View.GONE);
            }
            if (information.getNumb_m() == 0) {
                viewHolder.numb_m.setVisibility(View.GONE);
            }
            if (information.getDetails() == null) {
                viewHolder.details.setVisibility(View.GONE);
            }
            if (information.getConcern() == 0) {
                viewHolder.concern.setVisibility(View.GONE);
            }
            if (information.getTitle_bottom() == null) {
                viewHolder.title_bottom.setVisibility(View.GONE);
            }
            if (information.getTitle() == null) {
                viewHolder.title.setVisibility(View.GONE);
            }
        }
    }

    private void getImage(final int t, final String path) {
        bitmap = null;
        new Thread() {
            @Override
            public void run() {
                try {
                    if (path!=null){
                        URL url = new URL(path);
                        URLConnection connection = url.openConnection();
                        connection.connect();
                        InputStream inputStream = connection.getInputStream();
                        bitmap = BitmapFactory.decodeStream(inputStream);
                        Message message = new Message();
                        message.what = t;
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                    //设置头像
            if (msg.what == 1) {
                viewHolder.icon_head.setImageBitmap(bitmap);
                    //设置成果图
            }else if (msg.what==2){
                viewHolder.img.setImageBitmap(bitmap);
            }
        }
    };
}
