package top.lenconda.java.experiment.exp4;

class Role {

    public String name = "";
    public int life;
    public int experience;
    public int count;
    public int experienceStep;
    public int lifeStep;

    public Role (String name, int experienceStep, int lifeStep) {
        this.life = 1000;
        this.experience = 0;
        this.count = 0;
        this.experienceStep = experienceStep;
        this.lifeStep = lifeStep;
        this.name = name;
    }

    public void fight () {
        this.life -= this.lifeStep;
        this.experience += this.experienceStep;
        this.count += 1;
    }

}

public class RoleTest {

    public static void main (String[] args) {
        Role role1 = new Role("Role1", 2, 1);
        Role role2 = new Role("Role2", 3, 2);
        while (role1.life > 0 && role2.life > 0) {
            role1.fight();
            role2.fight();
        }
        System.out.println("Winner: " + (role1.life > 0 ? role1.name : role2.name));
        System.out.println(role1.name + " fight count: " + role1.count);
        System.out.println(role2.name + " fight count: " + role2.count);
    }

}
