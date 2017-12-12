package project.models.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import project.models.entities.Location;
import project.models.rowmappers.LocationRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class LocationRepository {

    @Autowired
        private NamedParameterJdbcTemplate template;

    public void createLocation(Location location) {
        String SQL = "INSERT INTO location (bookcase, shelf, box ) VALUES (:bookcase, :shelf, :box)";
        Map namedParameters = new HashMap();
        namedParameters.put("bookcase", location.getBookcase());
        namedParameters.put("shelf", location.getShelf());
        namedParameters.put("box", location.getBox());
        template.update(SQL, namedParameters);
    }

        public Location readLocation(int locationID) {
        String sql = "SELECT * FROM location WHERE locationID = :locationID";

        SqlParameterSource namedParameters = new MapSqlParameterSource("locationID", Integer.valueOf(locationID));
        Location location = (Location)template.queryForObject(sql, namedParameters, new LocationRowMapper());

        return location;
    }
    public void updateLocation(Location location, int locationID){
        String SQL = "UPDATE location SET bookcase = :bookcase, shelf = :shelf, box = :box WHERE locationID = :locationID";
        Map namedParameters = new HashMap();
        namedParameters.put("bookcase", location.getBookcase());
        namedParameters.put("shelf", location.getShelf());
        namedParameters.put("box", location.getBox());
        namedParameters.put("locationID", locationID);
        template.update(SQL, namedParameters);
    }

    public List listLocation(){
        String SQL = "SELECT * FROM location";
        List locations = this.template.query(SQL, new LocationRowMapper());
        return locations;
    }
}