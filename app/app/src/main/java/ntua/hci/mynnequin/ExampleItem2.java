package ntua.hci.mynnequin;

public class ExampleItem2 {
    private int imageResource;
    private String text1;
    private String text2;
    private String product_id;
    public String product_name_favorites;
    public String product_name_cart;
    public String product_name_cart_price;
    public int quantity;
    public ExampleItem2(int imageResource, String text1, String text2, String product_id, String product_name_favorites, String product_name_cart, String product_name_cart_price, int quantity) {
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
        this.product_id = product_id;
        this.product_name_favorites = product_name_favorites;
        this.product_name_cart = product_name_cart;
        this.product_name_cart_price = product_name_cart_price;
        this.quantity = quantity;
    }
    public int getImageResource() {
        return imageResource;
    }
    public String getText1() {
        return text1;
    }
    public String getText2() {
        return text2;
    }

}
