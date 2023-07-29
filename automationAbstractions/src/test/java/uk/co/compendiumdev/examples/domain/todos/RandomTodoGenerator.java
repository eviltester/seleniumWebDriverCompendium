package uk.co.compendiumdev.examples.domain.todos;

import com.github.javafaker.Faker;

public class RandomTodoGenerator {

    Faker faker;

    public RandomTodoGenerator(){

        faker = new Faker();
        // TODO:
        //    EXERCISE:
        //       - seed the faker with a seeded Random and log the seed value
        //         e.g. new Random(System.currentTimeMillis());

        // TODO:
        //    EXERCISE:
        //       - create a constructor which allows seeding the RandomTodoGenerator
        //         with a long during construction and use to create
        //         a random but repeatable test data generation

    }

    // TODO:
    //     EXERCISE:
    //         - users have reported that when the hamlet quote has a ' in it, that
    //           the test fails to assert correctly. re-enable the ' and investigate
    //           the cause of this defect and fix it if possible
    public String getRandomTodoName() {
        String todo = faker.shakespeare().hamletQuote();
        todo = todo.replace(":","").
                    replace(".","").
                    replace("'","").
                    replace("!","").
                    replace("?","").
                    replace(",","").
                    replace(";","");
        if(todo.length()>50)
            todo = todo.substring(1, 50);

        return todo.trim();
    }

//     TODO:
//        EXERCISE:
//            - return a random TodoItem object
//              also randomising the 'completed' state
//            - implement a createTodoItem method which adds the to do and sets the
//              completed state correctly.
//            - Initially make this local to the @Test,
//              and then refactor it so that it belongs to an object

}
