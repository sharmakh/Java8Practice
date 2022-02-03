import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {

    public static void main(String[] args){
        List<Integer>list = Arrays.asList(1,2,3,4,5,6,4,3,2,5,6,7,8,9,0).stream().filter(i->i%2==0).distinct().collect(Collectors.toList());
        System.out.println(list);

        List<String>words = Arrays.asList("Hello","My","Name","is","","Khueshboo");
        //count no of chars in each string and return the lis
        List<Integer>noOfChars = words.stream().map(String::length).collect(Collectors.toList());
        //System.out.println(noOfChars);

       //We are getting Stream<Sting[]>but we need Stream<String> instead of that so we will be using
        List<String>uniqueChars = words.stream().map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(uniqueChars);
    }

}
