package listclass;

/**
 * Created by Administrator on 2016/11/25.
 */
public class ListInformation {
    //使用数据库后需要将icon_head和img类型修改为String，解析来自于数据库的地址
    private int icon_head;//头像图片
    private String author;//作者
    private String time_y_m_d;//日期-年月日
    private String time_f_a;//日期-AM/PM
    private String time_m_s;//日期-小时 分钟
    private int img;//示例背景图
    private String numb_f;//喜欢人数
    private String numb_m;//留言数
    private String details;//详细做法
    private int concern=0;//是否被关注
    private int media=0;//是否有视频(默认不显示)
    private String title_bottom;//底部菜谱名字
    private int like=1;//是否显示喜欢图标(默认显示)
    private int message=1;//是否显示留言图标(默认显示)
    private String title;//标题

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getTitle_bottom() {
        return title_bottom;
    }

    public void setTitle_bottom(String title_bottom) {
        this.title_bottom = title_bottom;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public String getTitle_buttom() {
        return title_buttom;
    }

    public void setTitle_buttom(String title_buttom) {
        this.title_buttom = title_buttom;
    }

    private String title_buttom;//底部标题

    public int getConcern() {
        return concern;
    }

    public void setConcern(int concern) {
        this.concern = concern;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String detail) {
        this.details = detail;
    }

    public int getIcon_head() {
        return icon_head;
    }

    public void setIcon_head(int icon_head) {
        this.icon_head = icon_head;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime_y_m_d() {
        return time_y_m_d;
    }

    public void setTime_y_m_d(String time_y_m_d) {
        this.time_y_m_d = time_y_m_d;
    }

    public String getTime_f_a() {
        return time_f_a;
    }

    public void setTime_f_a(String time_f_a) {
        this.time_f_a = time_f_a;
    }

    public String getTime_m_s() {
        return time_m_s;
    }

    public void setTime_m_s(String time_m_s) {
        this.time_m_s = time_m_s;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNumb_f() {
        return numb_f;
    }

    public void setNumb_f(String numb_f) {
        this.numb_f = numb_f;
    }

    public String getNumb_m() {
        return numb_m;
    }

    public void setNumb_m(String numb_m) {
        this.numb_m = numb_m;
    }
}
