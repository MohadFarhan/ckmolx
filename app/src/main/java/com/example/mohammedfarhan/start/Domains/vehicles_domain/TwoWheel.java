package com.example.mohammedfarhan.start.Domains.vehicles_domain;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Mohammed Farhan on 27-06-2017.
 */
@DatabaseTable(tableName = "TwoWheel")
public class TwoWheel implements Serializable {


    @DatabaseField(columnName = "id", generatedId = true)
    private Long id;

    @DatabaseField(columnName = "twoWheelname")
    private String twoWheelname;

    @DatabaseField(columnName = "twoWheelprice")
    private String twoWheelprice;

    @DatabaseField(columnName = "twoWheelimageurl")
    private String twoWheelimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTwoWheelname() {
        return twoWheelname;
    }

    public void setTwoWheelname(String twoWheelname) {
        this.twoWheelname = twoWheelname;
    }

    public String getTwoWheelprice() {
        return twoWheelprice;
    }

    public void setTwoWheelprice(String twoWheelprice) {
        this.twoWheelprice = twoWheelprice;
    }

    public String getTwoWheelimageurl() {
        return twoWheelimageurl;
    }

    public void setTwoWheelimageurl(String twoWheelimageurl) {
        this.twoWheelimageurl = twoWheelimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwoWheel)) return false;

        TwoWheel twoWheel = (TwoWheel) o;

        if (getId() != null ? !getId().equals(twoWheel.getId()) : twoWheel.getId() != null)
            return false;
        if (getTwoWheelname() != null ? !getTwoWheelname().equals(twoWheel.getTwoWheelname()) : twoWheel.getTwoWheelname() != null)
            return false;
        if (getTwoWheelprice() != null ? !getTwoWheelprice().equals(twoWheel.getTwoWheelprice()) : twoWheel.getTwoWheelprice() != null)
            return false;
        return getTwoWheelimageurl() != null ? getTwoWheelimageurl().equals(twoWheel.getTwoWheelimageurl()) : twoWheel.getTwoWheelimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTwoWheelname() != null ? getTwoWheelname().hashCode() : 0);
        result = 31 * result + (getTwoWheelprice() != null ? getTwoWheelprice().hashCode() : 0);
        result = 31 * result + (getTwoWheelimageurl() != null ? getTwoWheelimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TwoWheel{" +
                "id=" + id +
                ", twoWheelname='" + twoWheelname + '\'' +
                ", twoWheelprice='" + twoWheelprice + '\'' +
                ", twoWheelimageurl='" + twoWheelimageurl + '\'' +
                '}';
    }
}