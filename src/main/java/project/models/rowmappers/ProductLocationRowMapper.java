package project.models.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import project.models.entities.ProductLocation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductLocationRowMapper implements RowMapper {

    public ProductLocation mapRow(ResultSet rs, int numRow) throws SQLException {
        ProductLocation productLocation = new ProductLocation();
        productLocation.setpLocationID(rs.getInt("pLocationID"));
        productLocation.setStock(rs.getInt("stock"));
        productLocation.setLocationFK(rs.getInt("locationFK"));
        productLocation.setProductFK(rs.getInt("productFK"));

        return productLocation;
    }
}
