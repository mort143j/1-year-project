package project.models.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import project.models.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductRowMapper implements RowMapper{

    public Product mapRow(ResultSet rs, int numRow) throws SQLException{
        Product product = new Product();
        product.setProductID(rs.getInt("productID"));
        product.setName(rs.getString("name"));
        product.setCostPrice(rs.getFloat("costPrice"));
        product.setSalesPrice(rs.getFloat("salesPrice"));
        product.setProductNumber(rs.getInt("productNumber"));

        return product;
    }
}
