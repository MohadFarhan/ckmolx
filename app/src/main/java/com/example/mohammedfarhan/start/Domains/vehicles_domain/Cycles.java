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
@DatabaseTable(tableName = "Two_Wheeler")
public class Cycles implements Serializable {


    @DatabaseField(columnName = "id", generatedId = true)
    private Long id;

    @DatabaseField(columnName = "vehiclename")
    private String vehiclename;

    @DatabaseField(columnName = "vehicleprice")
    private String vehicleprice;

    @DatabaseField(columnName = "vehicleimageurl")
    private String vehicleimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename;
    }

    public String getVehicleprice() {
        return vehicleprice;
    }

    public void setVehicleprice(String vehicleprice) {
        this.vehicleprice = vehicleprice;
    }

    public String getVehicleimageurl() {
        return vehicleimageurl;
    }

    public void setVehicleimageurl(String vehicleimageurl) {
        this.vehicleimageurl = vehicleimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cycles)) return false;

        Cycles that = (Cycles) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getVehiclename() != null ? !getVehiclename().equals(that.getVehiclename()) : that.getVehiclename() != null)
            return false;
        if (getVehicleprice() != null ? !getVehicleprice().equals(that.getVehicleprice()) : that.getVehicleprice() != null)
            return false;
        return getVehicleimageurl() != null ? getVehicleimageurl().equals(that.getVehicleimageurl()) : that.getVehicleimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getVehiclename() != null ? getVehiclename().hashCode() : 0);
        result = 31 * result + (getVehicleprice() != null ? getVehicleprice().hashCode() : 0);
        result = 31 * result + (getVehicleimageurl() != null ? getVehicleimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", vehiclename='" + vehiclename + '\'' +
                ", vehicleprice='" + vehicleprice + '\'' +
                ", vehicleimageurl='" + vehicleimageurl + '\'' +
                '}';
    }
}