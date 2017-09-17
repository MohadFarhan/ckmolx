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
@DatabaseTable(tableName = "WashingMachine")
public class WashingMachine implements Serializable {


    @DatabaseField(columnName = "id",generatedId = true)
    private Long id;

    @DatabaseField(columnName = "washingMachinename")
    private String washingMachinename;

    @DatabaseField(columnName = "washingMachineprice")
    private String washingMachineprice;

    @DatabaseField (columnName = "washingMachineimageurl")
    private String washingMachineimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWashingMachinename() {
        return washingMachinename;
    }

    public void setWashingMachinename(String washingMachinename) {
        this.washingMachinename = washingMachinename;
    }

    public String getWashingMachineprice() {
        return washingMachineprice;
    }

    public void setWashingMachineprice(String washingMachineprice) {
        this.washingMachineprice = washingMachineprice;
    }

    public String getWashingMachineimageurl() {
        return washingMachineimageurl;
    }

    public void setWashingMachineimageurl(String washingMachineimageurl) {
        this.washingMachineimageurl = washingMachineimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WashingMachine)) return false;

        WashingMachine mobile = (WashingMachine) o;

        if (getId() != null ? !getId().equals(mobile.getId()) : mobile.getId() != null) return false;
        if (getWashingMachinename() != null ? !getWashingMachinename().equals(mobile.getWashingMachinename()) : mobile.getWashingMachinename() != null)
            return false;
        if (getWashingMachineprice() != null ? !getWashingMachineprice().equals(mobile.getWashingMachineprice()) : mobile.getWashingMachineprice() != null)
            return false;
        return getWashingMachineimageurl() != null ? getWashingMachineimageurl().equals(mobile.getWashingMachineimageurl()) : mobile.getWashingMachineimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getWashingMachinename() != null ? getWashingMachinename().hashCode() : 0);
        result = 31 * result + (getWashingMachineprice() != null ? getWashingMachineprice().hashCode() : 0);
        result = 31 * result + (getWashingMachineimageurl() != null ? getWashingMachineimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", washingMachinename='" + washingMachinename + '\'' +
                ", washingMachineprice='" + washingMachineprice + '\'' +
                ", washingMachineimageurl='" + washingMachineimageurl + '\'' +
                '}';
    }
}

