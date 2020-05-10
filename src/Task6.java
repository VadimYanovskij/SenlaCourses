// Имеется набор вещей, которые необходимо поместить в рюкзак.
// Рюкзак обладает заданной грузоподъемностью.
// Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
// Цель задачи заполнить рюкзак не превысив его грузоподъемность и
// максимизировать суммарную ценность груза.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество предметов: ");
        int n = in.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Введите название " + i + "-й вещи: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.println("Введите вес " + i + "-й вещи: ");
            int weight = in.nextInt();
            System.out.println("Введите стоимость " + i + "-й вещи: ");
            int price = in.nextInt();
            items.add(new Item(name, weight, price));
        }
        System.out.print("Введите грузоподъемность рюкзака: ");
        int maxWeight = in.nextInt();
        Backpack backpack = new Backpack(maxWeight);
        backpack.makeAllSets(items);
        System.out.println("Список всех вещей:");
        System.out.println(items);
        System.out.println("\nСписок вещей с максимальной суммарной стоимостью, которые поместятся в рюкзаке и не превысят его вместимость");
        System.out.println(backpack.getBestItems());
        System.out.println("Суммарный вес: " + backpack.getBestWeight());
        System.out.println("Суммарная стоимость: " + backpack.getBestPrice());

    }
}

class Item {

    private String name;
    private double weight;
    private double price;

    public Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Вещь {" +
                "название = \"" + name + "\"" +
                ", вес = " + weight +
                ", стоимость = " + price +
                "}";
    }
}

class Backpack {

    List<Item> bestItems = null;

    private final double maxWeight;
    private double bestPrice;
    private double bestWeight;

    public double getBestPrice() {
        return bestPrice;
    }

    public double getBestWeight() {
        return bestWeight;
    }

    //общий вес набора предметов
    private double calcWeight(List<Item> items) {
        double result = 0;
        for (Item item : items) {
            result += item.getWeight();
        }
        return result;
    }

    //общая стоимость набора предметов
    private double calcPrice(List<Item> items) {
        double result = 0;
        for (Item item : items) {
            result += item.getPrice();
        }
        return result;
    }

    //проверка - является ли данный набор лучшим решением задачи
    private void checkSet(List<Item> items) {
        if (this.bestItems == null) {
            if (this.calcWeight(items) <= this.maxWeight) {
                this.bestItems = items;
                this.bestPrice = this.calcPrice(items);
                this.bestWeight = this.calcWeight(items);
            }
        } else {
            if (this.calcWeight(items) <= this.maxWeight && this.calcPrice(items) > this.bestPrice) {
                this.bestItems = items;
                this.bestPrice = this.calcPrice(items);
                this.bestWeight = this.calcWeight(items);
            }
        }
    }

    //создание всех наборов перестановок значений
    public void makeAllSets(List<Item> items) {
        if (items.size() > 0) {
            this.checkSet(items);
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }

    public Backpack(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Item> getBestItems() {
        return this.bestItems;
    }
}