package com.example.mohammedfarhan.start.Domains.home_appliances;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Mohammed Farhan on 27-06-2017.
 */
@DatabaseTable(tableName = "Fridges")
public class Fridges implements Serializable {


    @DatabaseField(columnName = "id",generatedId = true)
    private Long id;

    @DatabaseField(columnName = "fridgename")
    private String fridgename;

    @DatabaseField(columnName = "fridgeprice")
    private String fridgeprice;

    @DatabaseField (columnName = "fridgeimageurl")
    private String fridgeimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFridgename() {
        return fridgename;
    }

    public void setFridgename(String fridgename) {
        this.fridgename = fridgename;
    }

    public String getFridgeprice() {
        return fridgeprice;
    }

    public void setFridgeprice(String fridgeprice) {
        this.fridgeprice = fridgeprice;
    }

    public String getFridgeimageurl() {
        return fridgeimageurl;
    }

    public void setFridgeimageurl(String fridgeimageurl) {
        this.fridgeimageurl = fridgeimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fridges)) return false;

        Fridges mobile = (Fridges) o;

        if (getId() != null ? !getId().equals(mobile.getId()) : mobile.getId() != null) return false;
        if (getFridgename() != null ? !getFridgename().equals(mobile.getFridgename()) : mobile.getFridgename() != null)
            return false;
        if (getFridgeprice() != null ? !getFridgeprice().equals(mobile.getFridgeprice()) : mobile.getFridgeprice() != null)
            return false;
        return getFridgeimageurl() != null ? getFridgeimageurl().equals(mobile.getFridgeimageurl()) : mobile.getFridgeimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFridgename() != null ? getFridgename().hashCode() : 0);
        result = 31 * result + (getFridgeprice() != null ? getFridgeprice().hashCode() : 0);
        result = 31 * result + (getFridgeimageurl() != null ? getFridgeimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", fridgename='" + fridgename + '\'' +
                ", fridgeprice='" + fridgeprice + '\'' +
                ", fridgeimageurl='" + fridgeimageurl + '\'' +
                '}';
    }
}

