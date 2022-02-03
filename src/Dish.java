import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Dish {
    private final String name;
    private final boolean vegtarian;
    private final int calories;
    private final Type type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return vegtarian == dish.vegtarian && calories == dish.calories && Objects.equals(name, dish.name) && type == dish.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vegtarian, calories, type);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }

    public Dish(String name, boolean vegtarian, int calories, Type type) {
        this.name = name;
        this.vegtarian = vegtarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegtarian() {
        return vegtarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
    public static void main(String[] args){
        List<Dish>menu = Arrays.asList(
                new Dish("pork",false,800,Type.MEAT),
                new Dish("beef",false,700,Type.MEAT),
                new Dish("chicken",false,400,Type.MEAT),
                new Dish("french fries",true,530,Type.OTHER),
                new Dish("rice",true,350,Type.OTHER),
                new Dish("rice",true,350,Type.OTHER),
                new Dish("fruit",true,120,Type.OTHER),
                new Dish("pizza",true,550,Type.OTHER),
                new Dish("prawn",false,300,Type.FISH),
                new Dish("salmon",false,450,Type.FISH)
        );
        //dish having caloried less than 400
        List<String>lessCaloriesDishes = menu.stream().
                filter(d->d.getCalories()<400).map(Dish::getName).collect(toList());
        System.out.println(lessCaloriesDishes);

        //dish having caloried more than 400 and vegetarian and sorted in calories
        List<Dish>sortedDishes = menu.stream().filter(dish -> dish.isVegtarian() && dish.getCalories()<400).sorted(comparing(Dish::getCalories)).collect(toList());
        System.out.println(sortedDishes);

        //map group by Dish type
        Map<Type,List<Dish>>typeDishMap = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(typeDishMap);

        //three high calory dishes
        List<Dish>highcalorydish = menu.stream().filter(d->d.getCalories()>400).limit(3).collect(toList());
        System.out.println(highcalorydish);

        //printing the intermediate steps in stream
        menu.stream().filter(dish -> {
            System.out.print("Hello this is filer");
            return dish.getCalories()>400;
        }).map(dish -> {
            System.out.println("Mapping with dishes name");
            return dish.getName();
        }).limit(3).forEach(System.out::println);

        //count how many vegetarian dishes are there
        long cout =  menu.stream().filter(dish -> dish.isVegtarian()).count();
        System.out.println(cout);

        //count how many distinct vegetarians are there
        menu.stream().filter(dish -> dish.isVegtarian()).distinct().forEach(System.out::println);
        //System.out.println(c);

        //find out distinct dishes by name

        //check if all dishes which are vegetarian
       boolean al=menu.stream().allMatch(Dish::isVegtarian);

       //check if anydish is meat
        boolean anymeat = menu.stream().anyMatch(d->d.getType().toString().equalsIgnoreCase("Meat"));
        System.out.println(anymeat);

        System.out.print("Testing Github new branch creation");
    }
}
