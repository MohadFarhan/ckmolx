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
@DatabaseTable(tableName = "Television")
public class Television implements Serializable {


    @DatabaseField(columnName = "id",generatedId = true)
    private Long id;

    @DatabaseField(columnName = "televisionname")
    private String televisionname;

    @DatabaseField(columnName = "televisionprice")
    private String televisionprice;

    @DatabaseField (columnName = "televisionimageurl")
    private String televisionimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelevisionname() {
        return televisionname;
    }

    public void setTelevisionname(String televisionname) {
        this.televisionname = televisionname;
    }

    public String getTelevisionprice() {
        return televisionprice;
    }

    public void setTelevisionprice(String televisionprice) {
        this.televisionprice = televisionprice;
    }

    public String getTelevisionimageurl() {
        return televisionimageurl;
    }

    public void setTelevisionimageurl(String televisionimageurl) {
        this.televisionimageurl = televisionimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television)) return false;

        Television mobile = (Television) o;

        if (getId() != null ? !getId().equals(mobile.getId()) : mobile.getId() != null) return false;
        if (getTelevisionname() != null ? !getTelevisionname().equals(mobile.getTelevisionname()) : mobile.getTelevisionname() != null)
            return false;
        if (getTelevisionprice() != null ? !getTelevisionprice().equals(mobile.getTelevisionprice()) : mobile.getTelevisionprice() != null)
            return false;
        return getTelevisionimageurl() != null ? getTelevisionimageurl().equals(mobile.getTelevisionimageurl()) : mobile.getTelevisionimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTelevisionname() != null ? getTelevisionname().hashCode() : 0);
        result = 31 * result + (getTelevisionprice() != null ? getTelevisionprice().hashCode() : 0);
        result = 31 * result + (getTelevisionimageurl() != null ? getTelevisionimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", televisionname='" + televisionname + '\'' +
                ", televisionprice='" + televisionprice + '\'' +
                ", televisionimageurl='" + televisionimageurl + '\'' +
                '}';
    }
}

