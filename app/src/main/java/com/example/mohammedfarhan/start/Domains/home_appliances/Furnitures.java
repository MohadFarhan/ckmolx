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
@DatabaseTable(tableName = "Furnitures")
public class Furnitures implements Serializable {


    @DatabaseField(columnName = "id",generatedId = true)
    private Long id;

    @DatabaseField(columnName = "furniturename")
    private String furniturename;

    @DatabaseField(columnName = "furnitureprice")
    private String furnitureprice;

    @DatabaseField (columnName = "furnitureimageurl")
    private String furnitureimageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFurniturename() {
        return furniturename;
    }

    public void setFurniturename(String furniturename) {
        this.furniturename = furniturename;
    }

    public String getFurnitureprice() {
        return furnitureprice;
    }

    public void setFurnitureprice(String furnitureprice) {
        this.furnitureprice = furnitureprice;
    }

    public String getFurnitureimageurl() {
        return furnitureimageurl;
    }

    public void setFurnitureimageurl(String furnitureimageurl) {
        this.furnitureimageurl = furnitureimageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Furnitures)) return false;

        Furnitures mobile = (Furnitures) o;

        if (getId() != null ? !getId().equals(mobile.getId()) : mobile.getId() != null) return false;
        if (getFurniturename() != null ? !getFurniturename().equals(mobile.getFurniturename()) : mobile.getFurniturename() != null)
            return false;
        if (getFurnitureprice() != null ? !getFurnitureprice().equals(mobile.getFurnitureprice()) : mobile.getFurnitureprice() != null)
            return false;
        return getFurnitureimageurl() != null ? getFurnitureimageurl().equals(mobile.getFurnitureimageurl()) : mobile.getFurnitureimageurl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFurniturename() != null ? getFurniturename().hashCode() : 0);
        result = 31 * result + (getFurnitureprice() != null ? getFurnitureprice().hashCode() : 0);
        result = 31 * result + (getFurnitureimageurl() != null ? getFurnitureimageurl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", furniturename='" + furniturename + '\'' +
                ", furnitureprice='" + furnitureprice + '\'' +
                ", furnitureimageurl='" + furnitureimageurl + '\'' +
                '}';
    }
}

