package project.models.repositories;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.models.entities.ProductLocation;
import project.models.rowmappers.ProductLocationRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductLocationRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public void createProductLocation(ProductLocation productLocation){
        String SQL = "INSERT INTO product_location (stock, locationFK, productFK) VALUES (:stock, :productFK, :locationFK)";
        Map namedParameters = new HashMap();
        namedParameters.put("stock", productLocation.getStock());
        namedParameters.put("locationFK", productLocation.getLocationFK());
        namedParameters.put("productFK", productLocation.getProductFK());
        template.update(SQL, namedParameters);

    }
    public void updateProductLocation(ProductLocation productLocation, int pLocationID){
        String SQL = "UPDATE product_location SET stock = :stock, locationFK = :locationFK, productFK = :productFK WHERE pLocationID = :pLocationID";
        Map namedParameters = new HashMap();
        namedParameters.put("stock", productLocation.getStock());
        namedParameters.put("LocationFK", productLocation.getLocationFK());
        namedParameters.put("productFK", productLocation.getProductFK());
        namedParameters.put("pLocationID", productLocation.getpLocationID());
        template.update(SQL, namedParameters);
    }
    public ProductLocation readProductLocation(int pLocationID){
        String sql = "SELECT * FROM product_location WHERE pLocationID = :pLocationID";

        SqlParameterSource namedParameters = new MapSqlParameterSource("pLocationID", Integer.valueOf(pLocationID));
        ProductLocation productLocation = (ProductLocation)template.queryForObject(sql, namedParameters, new ProductLocationRowMapper());


        return productLocation;
    }
    public List listProductLocations(){
        String SQL = "SELECT * FROM product_location";
        List productLocations = this.template.query(SQL, new ProductLocationRowMapper());
        return productLocations;
    }
    //Re
}