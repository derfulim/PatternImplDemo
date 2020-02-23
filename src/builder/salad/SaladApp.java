package builder.salad;

import java.util.EnumSet;
import java.util.List;

public class SaladApp {
    public static void main(String[] args) throws NotPossibleMakeSaladException {
        CustomerSalad salad = new CustomerSalad.CustomerSaladBuilder().
//                setBaseIngredient(Ingredients.CHEESE).
//                setBaseIngredient(Ingredients.CHICKEN).
        setSauce(Ingredients.MAYONNAISE).
                        setOptionIngredient(Ingredients.SUNFLOWEROIL).
                        makeSalad();
        System.out.println(salad.getCalories());
        System.out.println(salad.getIngredients());
    }
}

interface Salad {
}

interface Builder {
}

class CustomerSalad implements Salad {
    private SaladType type;
    private EnumSet<Ingredients> ingredients;
    private int calories;

    public CustomerSalad(CustomerSaladBuilder builder) {
        this.ingredients = builder.ingredients;
        this.calories = builder.calories;
    }

    public SaladType getType() {
        return type;
    }

    public void setType(SaladType type) {
        this.type = type;
    }

    public EnumSet<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(EnumSet<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


    static class CustomerSaladBuilder implements Builder {
        //requirements
        // salad should have one or more base ingredients

        EnumSet<Ingredients> ingredients;
        int calories;

        public CustomerSaladBuilder() {
            ingredients = EnumSet.noneOf(Ingredients.class);

        }

        public CustomerSaladBuilder setBaseIngredient(Ingredients ingredient) {
            if (ingredient.getType().equals(IngredientType.BASE)) {
                ingredients.add(ingredient);
            }
            return this;
        }

        public CustomerSaladBuilder setOptionIngredient(Ingredients ingredient) {
            if (ingredient.getType().equals(IngredientType.OPTION)) {
                ingredients.add(ingredient);
            }
            return this;
        }

        public CustomerSaladBuilder setSauce(Ingredients ingredient) {
            if (ingredient.getType().equals(IngredientType.SAUCE)) {
                ingredients.add(ingredient);
            }
            return this;
        }

        public CustomerSaladBuilder setSpecies(Ingredients ingredient) {
            if (ingredient.getType().equals(IngredientType.SPICE)) {
                ingredients.add(ingredient);
            }
            return this;
        }


        public CustomerSalad makeSalad() throws NotPossibleMakeSaladException {
            boolean isMakingSaladPossible = false;
            for (Ingredients i : ingredients) {
                if (i.getType().equals(IngredientType.BASE)) {
                    isMakingSaladPossible = true;
                }
            }

            if (isMakingSaladPossible) {
                calories = calculateCalories(ingredients);
                return new CustomerSalad(this);
            } else throw new NotPossibleMakeSaladException("Salad should have at least one base ingredient");
        }

        private int calculateCalories(EnumSet<Ingredients> ingredients) {
            int calories = 0;
            for (Ingredients i : ingredients) {
                calories += i.getCalories();
            }
            return calories;
        }
    }

}

class NotPossibleMakeSaladException extends Exception {

    public NotPossibleMakeSaladException(String message) {
        super(message);
    }
}

enum SaladType {
    //enum for advanced checking
    //trueman should have a lot of calories, dietary contains small amount of it, vegan shouldn't contain meat
    VEGAN, DIETARY, TRUEMAN
}

enum IngredientType {
    BASE, OPTION, SAUCE, SPICE
}

enum Ingredients {
    CHEESE(500, IngredientType.BASE, false), CHICKEN(350, IngredientType.BASE, false),
    CUCUMBER(70, IngredientType.BASE, true), TOMATO(90, IngredientType.BASE, true),
    SUNFLOWEROIL(20, IngredientType.OPTION, true), DILL(10, IngredientType.SPICE, true),
    MAYONNAISE(300, IngredientType.SAUCE, false);

    private int calories;
    private IngredientType type;
    boolean isVegan;

    public int getCalories() {
        return calories;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public IngredientType getType() {
        return type;
    }

    Ingredients(int calories, IngredientType type, boolean isVegan) {
        this.calories = calories;
        this.type = type;
        this.isVegan = isVegan;
    }
}









