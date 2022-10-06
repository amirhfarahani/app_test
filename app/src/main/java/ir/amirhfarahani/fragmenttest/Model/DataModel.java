package ir.amirhfarahani.fragmenttest.Model;

public class DataModel
{
    String id,registered_stocks;


    public DataModel(String id, String registered_stocks) {
        this.id = id;
        this.registered_stocks = registered_stocks;
    }

    public DataModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistered_stocks() {
        return registered_stocks;
    }

    public void setRegistered_stocks(String registered_stocks) {
        this.registered_stocks = registered_stocks;
    }
}
