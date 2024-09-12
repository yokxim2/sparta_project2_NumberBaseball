package grade;

import generate.Generator;
import generate.GeneratorLv1;

public class GraderLv1 implements Grader {

    Generator generator = new GeneratorLv1();

    @Override
    public int grade(int number) {
        int answer = generator.generate();
    }
}
