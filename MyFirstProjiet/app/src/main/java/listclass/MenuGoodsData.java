package listclass;

/**
 * Created by Administrator on 2016/12/7.
 * 这个类是caipu_shicai_listitem 菜谱食材的数据
 */
public class MenuGoodsData {
    int caipu_img;
    String  title_textView;
    String people_textView;
    String people_numb;

    public int getCaipu_img() {
        return caipu_img;
    }

    public void setCaipu_img(int caipu_img) {
        this.caipu_img = caipu_img;
    }

    public String getTitle_textView() {
        return title_textView;
    }

    public void setTitle_textView(String title_textView) {
        this.title_textView = title_textView;
    }

    public String getPeople_textView() {
        return people_textView;
    }

    public void setPeople_textView(String people_textView) {
        this.people_textView = people_textView;
    }

    public String getPeople_numb() {
        return people_numb;
    }

    public void setPeople_numb(String people_numb) {
        this.people_numb = people_numb;
    }
}
