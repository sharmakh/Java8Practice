import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class UnderStandFlatMap {

    public static void main(String[] args) {

        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);


        List<List<Integer>> list = Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        List<Integer> al = list.stream().flatMap(val -> val.stream()).collect(Collectors.toList());

        System.out.println(al);

        //findany
        Optional<Integer> i = PrimeNumbers.stream().filter(d->Integer.compare(d*d,121)==0).findAny();
        System.out.print(i.get());

        //find first square divisible by 3
        Optional<Integer>ls = al.stream().map(x->x*x).filter(d->d%3==0).findFirst();
        System.out.print(ls.get());
    }


}
