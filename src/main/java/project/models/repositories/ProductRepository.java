package project.models.repositories;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import project.models.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.models.rowmappers.ProductRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public void createProduct(Product product){
        String SQL = "INSERT INTO product (name, costPrice, salesPrice, productNumber) VALUES (:name, :costPrice, :salesPrice, :productNumber)";
        Map namedParameters = new HashMap();
        namedParameters.put("name", product.getName());
        namedParameters.put("costPrice", product.getCostPrice());
        namedParameters.put("salesPrice", product.getSalesPrice());
        namedParameters.put("productNumber", product.getProductNumber());
        template.update(SQL, namedParameters);

    }
    public void updateProduct(Product product, int productID){
        String SQL = "UPDATE product SET name = :name, costPrice = :costPrice, salesPrice = :salesPrice, productNumber = :productNumber WHERE productID = :productID";
        Map namedParameters = new HashMap();
        namedParameters.put("name", product.getName());
        namedParameters.put("costPrice", product.getCostPrice());
        namedParameters.put("salesPrice", product.getSalesPrice());
        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("productID", productID);
        template.update(SQL, namedParameters);
    }
    public Product readProduct(int productID){
        String sql = "SELECT * FROM product WHERE productID = :productID";

        SqlParameterSource namedParameters = new MapSqlParameterSource("productID", Integer.valueOf(productID));
        Product product = (Product)template.queryForObject(sql, namedParameters, new ProductRowMapper());


        return product;
    }
    public List listProducts(){
        String SQL = "SELECT * FROM product";
        List products = this.template.query(SQL, new ProductRowMapper());
        return products;
    }
}