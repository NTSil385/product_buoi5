package product.com.example.product.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;

public class product {
    private int id;

    @NotBlank(message = "trường này không được phép bỏ trống")
    private String name;

    @Length(min =0, max = 50, message = "tên hình ảnh không được phép quá 50 ký tự")
    private String image;

    @NotNull(message = "giá sản phẩm không được phép để trống")
    @Min(value = 1, message = "giá sản phẩm không được nhỏ hơn 1")
    @Max(value = 9999999, message = "giá sản phẩm không được lớn hơn 9999999")
    private long price;

    public product(){}

    public product(int id, String name, String image, long price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
