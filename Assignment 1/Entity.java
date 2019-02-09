public class Entity {
    private String name;
    private Date born;

    public Entity() {
        name = null;
        born = new Date(1,1,1980);
    }

    public Entity(String entityName, String strBorn) {
        name = entityName;
        born = new Date(strBorn);
    }

    public Entity(String entityName, int month, int day, int year) {
        name = entityName;
        born = new Date(month, day, year);
    }

    public Entity(String entityName, String month, int day, int year) {
        name = entityName;
        born = new Date(month, day, year);
    }

    public Entity(String entityName, int year) {
        name = entityName;
        born = new Date(year);
    }

    public Entity(String entityName, Date birthDate) {
        name = entityName;
        born = new Date(birthDate);
    }

}
