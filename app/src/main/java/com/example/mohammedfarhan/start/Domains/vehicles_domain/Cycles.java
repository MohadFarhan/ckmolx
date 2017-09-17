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
@DatabaseTable(tableName = "Cycles")
public class Cycles implements Serializable {


    @DatabaseField(columnName = "id", generatedId = true)
    private Long id;

    @DatabaseField(columnName = "cyclename")
    private String cyclename;

    @DatabaseField(columnName = "cycleprice")
    private String cycleprice;

    @DatabaseField(columnName = "cycleimageurl")
    private String cycleimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCyclename() {
        return cyclename;
    }

    public void setCyclename(String cyclename) {
        this.cyclename = cyclename;
    }

    public String getCycleprice() {
        return cycleprice;
    }

    public void setCycleprice(String cycleprice) {
        this.cycleprice = cycleprice;
    }

    public String getCycleimageurl() {
        return cycleimageurl;
    }

    public void setCycleimageurl(String cycleimageurl) {
        this.cycleimageurl = cycleimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cycles)) return false;

        Cycles that = (Cycles) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCyclename() != null ? !getCyclename().equals(that.getCyclename()) : that.getCyclename() != null)
            return false;
        if (getCycleprice() != null ? !getCycleprice().equals(that.getCycleprice()) : that.getCycleprice() != null)
            return false;
        return getCycleimageurl() != null ? getCycleimageurl().equals(that.getCycleimageurl()) : that.getCycleimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCyclename() != null ? getCyclename().hashCode() : 0);
        result = 31 * result + (getCycleprice() != null ? getCycleprice().hashCode() : 0);
        result = 31 * result + (getCycleimageurl() != null ? getCycleimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", cyclename='" + cyclename + '\'' +
                ", cycleprice='" + cycleprice + '\'' +
                ", cycleimageurl='" + cycleimageurl + '\'' +
                '}';
    }
}