import java.util.Date;

public class Sales_Data {

    private String Employee_name;
    private int Employee_id;
    private int Sales;
    private Date date = new Date();

    public Sales_Data(int employee_id, String employee_name, int sales, Date date) {
        this.Employee_name = employee_name;
        this.Employee_id = employee_id;
        this.Sales = sales;
        this.date = date;
    }

    public Sales_Data() {
        this.Employee_id = 0;
        this.Employee_name = "";
        this.Sales = 0;
        this.date = getDate();
    }

    public String getEmployee_name() {
        return Employee_name;
    }

    public void setEmployee_name(String employee_name) {
        Employee_name = employee_name;
    }

    public int getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(int employee_id) {
        Employee_id = employee_id;
    }

    public int getSales() {
        return Sales;
    }

    public void setSales(int sales) {
        Sales = sales;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
