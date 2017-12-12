package project.models.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import project.models.entities.Location;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class LocationRowMapper implements RowMapper {

        public Location mapRow(ResultSet rs, int numRow) throws SQLException {
            Location location = new Location();
            location.setLocationID(rs.getInt("locationID"));
            location.setBookcase(rs.getString("bookcase"));
            location.setShelf(rs.getString("shelf"));
            location.setBox(rs.getString("box"));

            return location;
        }
}
