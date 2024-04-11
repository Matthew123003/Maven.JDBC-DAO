package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FF7 implements InterfaceDAO{
    private Integer id;
    private String fName;
    private String lName;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String weapon;
    private String ability;

    public FF7() {
    }

    public FF7(String fName) {
        this.fName = fName;
    }

    public FF7(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public FF7(String fName, String lName, Integer age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public FF7(Integer id, String fName, String lName, Integer age) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public FF7(Integer id, String fName, String lName, Integer age, Integer height) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.height = height;
    }

    public FF7(Integer id, String fName, String lName, Integer age, Integer height, Integer weight) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public FF7(Integer id, String fName, String lName, Integer age, Integer height, Integer weight, String weapon) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.weapon = weapon;
    }

    public FF7(Integer id, String fName, String lName, Integer age, Integer height, Integer weight, String weapon, String ability) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.weapon = weapon;
        this.ability = ability;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String name) {
        this.fName = name;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String name) {
        this.lName = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public Object findById(int id) {
        java.sql.Connection connection = Connection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ff7 WHERE id=" + id);

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
    public List findAll() {
        java.sql.Connection connection = Connection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FF7");

            List<Object> FF7 = new ArrayList<>();

            while(rs.next())
            {
                FF7 info = extractInfoFromResultSet(rs);
                FF7.add(info);
            }

            return FF7;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Object create(Object dto) {
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?)");
            ps.setString(1, dto.getFirstName());
            ps.setString(2, user.getPass());
            ps.setInt(3, user.getAge());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public void delete(int id) {
        java.sql.Connection connection = Connection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private FF7 extractInfoFromResultSet(ResultSet rs) throws SQLException {
        FF7 ff7 = new FF7();

        ff7.setId( rs.getInt("id") );
        ff7.setFirstName( rs.getString("first_name") );
        ff7.setLastName( rs.getString("last_name") );
        ff7.setAge( rs.getInt("age") );
        ff7.setHeight( rs.getInt("height_inches"));
        ff7.setWeight( rs.getInt("weight_lbs"));
        ff7.setWeapon( rs.getString("weapon"));
        ff7.setAbility( rs.getString("ability"));

        return ff7;
    }
}

