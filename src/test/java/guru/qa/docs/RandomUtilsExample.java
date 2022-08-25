package guru.qa.docs;

import guru.qa.utils.RandomUtils;


public class RandomUtilsExample {
    public static void main(String[] args) {
        System.out.println("Random stirng: " + RandomUtils.getRandomString(10));
        System.out.println("Random int: " + RandomUtils.getRandomInt(10,200));
    }
}
