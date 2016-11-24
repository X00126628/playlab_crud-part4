package models;

import javax.persistence.*;
import java.util.*;
import com.avaje.ebean.Model;
import play.data.validation.*;

@Entity
public class Category extends Model{



        @Id
        private Long id;

        @Constraints.Required
        private String name;

        @OneToMany
        private List<Product> products;

        @ManyToOne
        private Category category;

        @Constraints.Required
        private String description;

        public Category(){

        }

        public Category(Long id, String name, List<Product> products, Category category, String description){

            this.setId(id);
            this.setName(name);
            this.setProducts(products);
            this.setCategory(category);
            this.setDescription(description);

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }


        public static Finder<Long,Category> find = new Finder<Long,Category>(Category.class);

    public static List<Category> findAll(){

        return Category.find.where().orderBy("name asc").findList();
     }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Map<Long,String> options(){

        LinkedHashMap<Long,String> options = new LinkedHashMap<>();

        for(Category c: Category.findAll()){
            options.put(c.getId()).toString(), c.getName();

        }

        return options;
    }

}


