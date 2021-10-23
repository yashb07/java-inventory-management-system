import java.util.Date;

public class Inventory_Data {

    private String item_id;
    private String item_type;
    private String item_name;
    private int item_quantity;
    private double item_price;
    private Date date;

    public Inventory_Data(String item_id, String item_type, String item_name, int item_quantity, double item_price, Date date) {
        this.item_id = item_id;
        this.item_type = item_type;
        this.item_name = item_name;
        this.item_quantity = item_quantity;
        this.item_price = item_price;
        this.date = date;
    }

    public Inventory_Data()
    {
        this.item_id = "";
        this.item_type = "";
        this.item_name = "";
        this.item_quantity = 0;
        this.item_price= 0.0;
        this.date = getDate();
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
