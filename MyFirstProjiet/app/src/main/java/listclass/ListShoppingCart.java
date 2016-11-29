package listclass;

/**
 * Created by Administrator on 2016/11/29.
 */
public class ListShoppingCart {
    boolean checked_img = true;
    String shopping_cart_show;
    String title_textView;
    int numb_textView;
    String content_textView;
    Float price_textView;

    public void ListShoppingCart() {

    }

    public boolean isChecked_img() {
        return checked_img;
    }

    public void setChecked_img(boolean checked_img) {
        this.checked_img = checked_img;
    }

    public String getShopping_cart_show() {
        return shopping_cart_show;
    }

    public void setShopping_cart_show(String shopping_cart_show) {
        this.shopping_cart_show = shopping_cart_show;
    }

    public String getTitle_textView() {
        return title_textView;
    }

    public void setTitle_textView(String title_textView) {
        this.title_textView = title_textView;
    }

    public int getNumb_textView() {
        return numb_textView;
    }

    public void setNumb_textView(int numb_textView) {
        this.numb_textView = numb_textView;
    }

    public String getContent_textView() {
        return content_textView;
    }

    public void setContent_textView(String content_textView) {
        this.content_textView = content_textView;
    }

    public Float getPrice_textView() {
        return price_textView;
    }

    public void setPrice_textView(Float price_textView) {
        this.price_textView = price_textView;
    }
}
