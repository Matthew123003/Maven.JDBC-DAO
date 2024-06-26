package daos;

public class DTO implements DataTransferObject{
    private Integer id;
    private String fName;
    private String lName;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String weapon;
    private String ability;

    public DTO() {
    }

    public DTO(Integer age, Integer height, Integer weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public DTO(String fName, String lName, Integer age, Integer height, Integer weight, String weapon, String ability) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.weapon = weapon;
        this.ability = ability;
    }

    public DTO(Integer id, String fName, String lName, Integer age, Integer height, Integer weight, String weapon, String ability) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.weapon = weapon;
        this.ability = ability;
    }

    @Override
    public int getId() {
        return id;
    }//From DataTransferObject Interface

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String toString(){
        return "FF7 Character [id=" + id + ", First Name =" + fName + ", Last Name =" + lName
                + ", Age =" + age + ", Height =" + height + "Weight =" + weight + "Weapon =" + weapon +
                "Ability =" + ability +"]";
    }
}
