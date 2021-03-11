package ntua.hci.mynnequin;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExampleItem {
    private int imageResource;
    private String text1;
    private String text2;
    private String product_id;
    public ExampleItem(int imageResource, String text1, String text2, String product_id) {
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
        this.product_id = product_id;
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
