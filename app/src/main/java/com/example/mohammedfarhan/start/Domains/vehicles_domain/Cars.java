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
@DatabaseTable(tableName = "Car")
public class Cars implements Serializable {


    @DatabaseField(columnName = "id", generatedId = true)
    private Long id;

    @DatabaseField(columnName = "carname")
    private String carName;

    @DatabaseField(columnName = "carprice")
    private String carPrice;

    @DatabaseField(columnName = "carimageurl")
    private String carImageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarImageUrl() {
        return carImageUrl;
    }

    public void setCarImageUrl(String carImageUrl) {
        this.carImageUrl = carImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;

        Cars that = (Cars) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCarName() != null ? !getCarName().equals(that.getCarName()) : that.getCarName() != null)
            return false;
        if (getCarPrice() != null ? !getCarPrice().equals(that.getCarPrice()) : that.getCarPrice() != null)
            return false;
        return getCarImageUrl() != null ? getCarImageUrl().equals(that.getCarImageUrl()) : that.getCarImageUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCarName() != null ? getCarName().hashCode() : 0);
        result = 31 * result + (getCarPrice() != null ? getCarPrice().hashCode() : 0);
        result = 31 * result + (getCarImageUrl() != null ? getCarImageUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carPrice='" + carPrice + '\'' +
                ", carImageUrl='" + carImageUrl + '\'' +
                '}';
    }
}