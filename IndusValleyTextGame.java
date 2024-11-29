import java.util.Scanner;

abstract class TimePeriod {
    String name;
    String description;

    public TimePeriod(String name, String description) {
        this.name = name;
        this.description = description;
    }

    abstract void interact(Player player);

    public void displayInfo() {
        System.out.println("You are now in the " + name + ": " + description);
    }
}

class IndusValley extends TimePeriod {
    public IndusValley() {
        super("Indus Valley Civilization", "An ancient civilization with cities like Mohenjo-Daro and Harappa.");
    }

    @Override
    void interact(Player player) {
        System.out.println("You arrive at the city of Mohenjo-Daro. The streets are busy with people trading goods.");
        System.out.println("A merchant invites you to see the marketplace filled with pottery, beads, and food.");
        System.out.println("What will you do?");
        System.out.println("1. Visit the marketplace.");
        System.out.println("2. Walk around the city.");
        System.out.println("3. Leave the city.");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                visitMarketplace(player);
                break;
            case 2:
                walkAroundCity(player);
                break;
            case 3:
                System.out.println("You decide to leave the city and go back home.");
                break;
            default:
                System.out.println("Invalid choice. You stand still and do nothing.");
        }
    }

    private void visitMarketplace(Player player) {
        System.out.println("Welcome to the marketplace!");
        System.out.println("Food costs 10 money per unit.");
        System.out.println("You have " + player.getMoney() + " money.");
        System.out.println("Do you want to buy food?");
        System.out.println("1. Buy food.");
        System.out.println("2. Don't buy anything.");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            if (player.getMoney() >= 10) {
                System.out.println("You bought food!");
                player.addFood(1);
                player.subtractMoney(10);
                System.out.println("You now have " + player.getMoney() + " money.");
            } else {
                System.out.println("You don't have enough money to buy food.");
            }
        } else {
            System.out.println("You decide not to buy anything.");
        }
    }

    private void walkAroundCity(Player player) {
        System.out.println("You walk around the city, observing its ancient beauty.");
        System.out.println("There are three places to visit:");
        System.out.println("1. Visit the Great Bath (Cost: 15 money).");
        System.out.println("2. Visit the Grand Marketplace (Cost: 10 money).");
        System.out.println("3. Visit the Ancient Library (Cost: 20 money).");

        System.out.println("You have " + player.getMoney() + " money.");
        System.out.println("Where would you like to go?");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                visitGreatBath(player);
                break;
            case 2:
                visitGrandMarketplace(player);
                break;
            case 3:
                visitAncientLibrary(player);
                break;
            default:
                System.out.println("Invalid choice. You decide to stay where you are.");
        }
    }

    private void visitGreatBath(Player player) {
        if (player.getMoney() >= 15) {
            System.out.println("You visit the Great Bath, an ancient marvel of the Indus Valley Civilization!");
            player.subtractMoney(15);
            System.out.println("You now have " + player.getMoney() + " money.");
        } else {
            System.out.println("You don't have enough money to visit the Great Bath.");
        }
    }

    private void visitGrandMarketplace(Player player) {
        if (player.getMoney() >= 10) {
            System.out.println("You visit the Grand Marketplace, filled with traders and goods from all over the land!");
            player.subtractMoney(10);
            System.out.println("You now have " + player.getMoney() + " money.");
        } else {
            System.out.println("You don't have enough money to visit the Grand Marketplace.");
        }
    }

    private void visitAncientLibrary(Player player) {
        if (player.getMoney() >= 20) {
            System.out.println("You visit the Ancient Library, where people are copying ancient texts.");
            player.subtractMoney(20);
            System.out.println("You now have " + player.getMoney() + " money.");
        } else {
            System.out.println("You don't have enough money to visit the Ancient Library.");
        }
    }
}

class MathQuestion {
    public static int generateMathQuestion() {
        int a = (int) (Math.random() * 10) + 1;
        int b = (int) (Math.random() * 10) + 1;
        System.out.println("Solve: " + a + " + " + b + " = ?");
        return a + b;
    }
}

class Player {
    String name;
    int money;
    int food;

    public Player(String name) {
        this.name = name;
        this.money = 20; // Player starts with 20 money
        this.food = 0; // Player starts with no food
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void subtractMoney(int amount) {
        money -= amount;
    }

    public void addFood(int amount) {
        food += amount;
    }

    public void showInventory() {
        System.out.println("Inventory: " + food + " food, " + money + " money.");
    }
}

public class IndusValleyTextGame {
    public static void main(String[] args) {
        Player player = new Player("Sahil");
        IndusValley indusValley = new IndusValley();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Indus Valley Civilization Game!");
        System.out.println("You start with 20 money.");

        while (true) {
            player.showInventory();
            System.out.println("\nWhere would you like to go?");
            System.out.println("1. Explore the Indus Valley.");
            System.out.println("2. Solve a math question to earn money.");
            System.out.println("3. Exit the game.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    indusValley.interact(player);
                    break;
                case 2:
                    solveMathQuestion(player);
                    break;
                case 3:
                    System.out.println("Thanks for playing! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void solveMathQuestion(Player player) {
        int correctAnswer = MathQuestion.generateMathQuestion();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        int playerAnswer = scanner.nextInt();

        if (playerAnswer == correctAnswer) {
            System.out.println("Correct! You earned 10 money.");
            player.addMoney(10);
        } else {
            System.out.println("Wrong answer. Try again next time!");
        }

        System.out.println("Your current money: " + player.getMoney());
    }
}
