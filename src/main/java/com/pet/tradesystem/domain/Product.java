package com.pet.tradesystem.domain;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.beans.Transient;
import java.util.Arrays;

public class Product implements AppEntity {

    private int id;

    @NotNull(message = "Name must by at least 1 character.")
    @Size(min = 1, max = 20)
    private String name;

    @NotNull(message = "Please insert file.")
    private byte[] image;

    private String base64;

    private boolean deliveryStatus;

    public Product() {
    }

    public Product(int id, @NotNull(message = "Name must by at least 1 character.") @Size(min = 1, max = 20) String name,
                   @NotNull(message = "Please insert file.") byte[] image, String base64, boolean deliveryStatus) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.base64 = base64;
        this.deliveryStatus = deliveryStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Transient
    public String getBase64() {
        return this.base64 = Base64.encode(this.image);
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public boolean getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (deliveryStatus != product.deliveryStatus) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (!Arrays.equals(image, product.image)) return false;
        return base64 != null ? base64.equals(product.base64) : product.base64 == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (base64 != null ? base64.hashCode() : 0);
        result = 31 * result + (deliveryStatus ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", image=");
        if (image == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < image.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(image[i]);
            sb.append(']');
        }
        sb.append(", base64='").append(base64).append('\'');
        sb.append(", deliveryStatus=").append(deliveryStatus);
        sb.append('}');
        return sb.toString();
    }
}
