package listclass;

/**
 * Created by Administrator on 2016/11/29.
 */
public class ShopListData {
    /**
     * 这个Data数据是有购物车页面的 shop_listview_item页面
     */
    int shopping_cart_show_three;
    private String shopping_name;//商品名
    private String shopping_info;//商品详情
    private String shopping_price;//价格
    private String jiaru_gouwuche;
    private String goods_id;//商品ID
    private String img;//商品图

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getShopping_cart_show_three() {
        return shopping_cart_show_three;
    }

    public void setShopping_cart_show_three(int shopping_cart_show_three) {
        this.shopping_cart_show_three = shopping_cart_show_three;
    }

    public String getShopping_name() {
        return shopping_name;
    }

    public void setShopping_name(String shopping_name) {
        this.shopping_name = shopping_name;
    }

    public String getShopping_info() {
        return shopping_info;
    }

    public void setShopping_info(String shopping_info) {
        this.shopping_info = shopping_info;
    }

    public String getShopping_price() {
        return shopping_price;
    }

    public void setShopping_price(String shopping_price) {
        this.shopping_price = shopping_price;
    }

    public String getJiaru_gouwuche() {
        return jiaru_gouwuche;
    }

    public void setJiaru_gouwuche(String jiaru_gouwuche) {
        this.jiaru_gouwuche = jiaru_gouwuche;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }
}
