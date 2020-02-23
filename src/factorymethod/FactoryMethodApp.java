package factorymethod;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class FactoryMethodApp {
    public static void main(String[] args) {
        PizzaMaker pizzaMaker = new MargaritaMaker();
        Pizza pizza = pizzaMaker.makePizza();
        System.out.println(pizza.price);
    }
}

abstract class Pizza{

    protected int profit;
    protected EnumSet<Ingredient> ingredients;
    protected int price;

    public Pizza(int profit) {
        this.profit = profit;
        this.ingredients = EnumSet.noneOf(Ingredient.class);
        collectIngredients();
        this.price = calculatePrice();
    }

    public int getPrice() {
        return price;
    }

    protected abstract void collectIngredients();

    protected int calculatePrice() {
        int price = profit;
        for (Ingredient i:ingredients) {
            price+=i.getPrice();
        }
        return price;
    }
}

enum Ingredient{
    CHEESE(10), TOMATO(5), CHICKEN(7), PINEAPPLE(9),MUSHROOMS(7),HAM(11);
    private int price;

    Ingredient( int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

interface PizzaMaker{
    Pizza makePizza();
}

class PepperoniMaker implements PizzaMaker{
    private int profit = 50;
    @Override
    public Pizza makePizza() {
        return new Pepperoni(profit);
    }
}

class Pepperoni extends Pizza{

    Pepperoni(int profit){
        super(profit);
    }

    @Override
    protected void collectIngredients() {
     ingredients.add(Ingredient.CHEESE);
     ingredients.add(Ingredient.HAM);
     ingredients.add(Ingredient.MUSHROOMS);
    }
}

class MargaritaMaker implements PizzaMaker{
    private int profit = 40;
    @Override
    public Pizza makePizza() {
        return new Margarita(profit);
    }
}

class Margarita extends Pizza{

    Margarita(int profit){
        super(profit);
    }

    @Override
    protected void collectIngredients() {
     ingredients.add(Ingredient.CHEESE);
     ingredients.add(Ingredient.CHICKEN);
     ingredients.add(Ingredient.TOMATO);
    }
}




