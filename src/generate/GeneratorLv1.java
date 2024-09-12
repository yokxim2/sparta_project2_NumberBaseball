package generate;

import java.util.*;

public class GeneratorLv1 implements Generator {

    @Override
    public int generate() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int nextNumber = (int)(Math.random() * 9) + 1;
            if (!numberList.contains(nextNumber)) {
                numberList.add(nextNumber);
            }
        }
        return concatAll(numberList);
    }

    private int concatAll(List<Integer> numberList) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : numberList) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }
}
