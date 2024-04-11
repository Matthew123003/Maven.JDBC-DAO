package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author matthew
 * Singleton
 */
public class FF7DAO implements InterfaceDAO<DTO> {
    private static final FF7DAO inst = new FF7DAO();

    private DTO extractInfoFromResultSet(ResultSet rs) throws SQLException {
        DTO ff7 = new DTO();

        ff7.setId( rs.getInt("ID") );
        ff7.setFirstName( rs.getString("First_Name") );
        ff7.setLastName( rs.getString("Last_Name") );
        ff7.setAge( rs.getInt("Age") );
        ff7.setHeight( rs.getInt("Height_Inches"));
        ff7.setWeight( rs.getInt("Weight_LBS"));
        ff7.setWeapon( rs.getString("Weapon"));
        ff7.setAbility( rs.getString("Ability"));

        return ff7;
    }

    public static FF7DAO getInstance() {
        return inst;
    }

    @Override
    public DTO findById(int id) {
        try {
            PreparedStatement stmt = Connection.getConnection().prepareStatement("SELECT * FROM ff7_characters WHERE ID=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                return extractInfoFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTO> findAll() {
        try {
            Statement stmt = Connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ff7_characters");

            List<DTO> info = new ArrayList<>();

            while(rs.next())
            {
                DTO obj = extractInfoFromResultSet(rs);
                info.add(obj);
            }

            return info;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public DTO update(DTO dto) {
        return null;
    }

    @Override
    public DTO create(DTO dto) {
        try {
            PreparedStatement ps = Connection.getConnection().prepareStatement("INSERT INTO ff7_characters (First_Name, Last_Name, Age, Height_Inches" +
                    ", Weight_LBS, Weapon, Ability) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, dto.getFirstName());
            ps.setString(2, dto.getLastName());
            ps.setInt(3, dto.getAge());
            ps.setInt(4, dto.getHeight());
            ps.setInt(5, dto.getWeight());
            ps.setString(6, dto.getWeapon());
            ps.setString(7, dto.getAbility());
            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println(dto);
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(int id) {

    }
}

