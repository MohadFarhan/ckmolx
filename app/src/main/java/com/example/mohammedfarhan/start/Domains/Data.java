package com.example.mohammedfarhan.start.Domains;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Mohammed Farhan on 27-06-2017.
 */
@DatabaseTable(tableName = "Data_Table")
public class Data implements Serializable {


    @DatabaseField(columnName = "id",generatedId = true)
    private Long id;

    @DatabaseField(columnName = "mobilename")
    private String mobilename;

    @DatabaseField(columnName = "mobileprice")
    private String mobileprice;

    @DatabaseField (columnName = "mobileimageurl")
    private String mobileimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobilename() {
        return mobilename;
    }

    public void setMobilename(String mobilename) {
        this.mobilename = mobilename;
    }

    public String getMobileprice() {
        return mobileprice;
    }

    public void setMobileprice(String mobileprice) {
        this.mobileprice = mobileprice;
    }

    public String getMobileimageurl() {
        return mobileimageurl;
    }

    public void setMobileimageurl(String mobileimageurl) {
        this.mobileimageurl = mobileimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;

        Data data = (Data) o;

        if (getId() != null ? !getId().equals(data.getId()) : data.getId() != null) return false;
        if (getMobilename() != null ? !getMobilename().equals(data.getMobilename()) : data.getMobilename() != null)
            return false;
        if (getMobileprice() != null ? !getMobileprice().equals(data.getMobileprice()) : data.getMobileprice() != null)
            return false;
        return getMobileimageurl() != null ? getMobileimageurl().equals(data.getMobileimageurl()) : data.getMobileimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMobilename() != null ? getMobilename().hashCode() : 0);
        result = 31 * result + (getMobileprice() != null ? getMobileprice().hashCode() : 0);
        result = 31 * result + (getMobileimageurl() != null ? getMobileimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", mobilename='" + mobilename + '\'' +
                ", mobileprice='" + mobileprice + '\'' +
                ", mobileimageurl='" + mobileimageurl + '\'' +
                '}';
    }
}

