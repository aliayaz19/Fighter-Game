import java.util.Scanner;

class Fighter {
    private String name;
    private int HP;
    private int attack;

    public Fighter(String name, int HP, int attack) {
        this.name = name;
        this.HP = HP;
        this.attack = attack;
    }

    public void attack(Fighter opponent) {
        opponent.reduceHP(attack);
        System.out.println(name + " attacks " + opponent.getName() + " for " + attack + " damage!");
        System.out.println(opponent.getName() + "'s HP is " + opponent.getHP());
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public void reduceHP(int damage) {
        HP -= damage;
        if (HP < 0) {
            HP = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Fighter 1's name:");
        String name1 = scanner.nextLine();
        System.out.println("Enter Fighter 1's HP:");
        int hp1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Fighter 1's attack power:");
        int attack1 = Integer.parseInt(scanner.nextLine());
        Fighter fighter1 = new Fighter(name1, hp1, attack1);

        System.out.println("Enter Fighter 2's name:");
        String name2 = scanner.nextLine();
        System.out.println("Enter Fighter 2's HP:");
        int hp2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Fighter 2's attack power:");
        int attack2 = Integer.parseInt(scanner.nextLine());
        Fighter fighter2 = new Fighter(name2, hp2, attack2);

        while (fighter1.isAlive() && fighter2.isAlive()) {
            fighter1.attack(fighter2);
            if (!fighter2.isAlive()) {
                System.out.println(fighter1.getName() + " wins!");
                break;
            }
            fighter2.attack(fighter1);
            if (!fighter1.isAlive()) {
                System.out.println(fighter2.getName() + " wins!");
                break;
            }
        }
    }
}
