package uk.co.compendiumdev.todomvc.site;


public class TodoMVCSite {

    public String getURL(){

        return "http://todomvc.com/examples/backbone/";
        //return "http://todomvc.com/examples/vanillajs/";
        //return "http://todomvc.com/examples/angularjs/";  // angular will require additional synchronisation
        // return "https://compendiumdev.co.uk/apps/todo/todo.html"; // custom version with list management
    }

    public String getName(){
        return "backbone";
        //return "vanillajs";
        //return "angularjs";
    }

    // TODO:
    //    EXERCISE:
    //      - try to run the tests on different implementations and make changes as required to get the tests working
    //      - most changes should only need to be made to the abstraction layers
    //      - and it should be possible to amend the abstraction layers for the new implementation,
    //        while keeping it running on the previous implementation
    //      This is the key component to amend to run the tests on different environments.
    //      Each of the different sites has slightly different issues that need addressing
    //      The tests have been written to run clean on backbone, and minor changes to the
    //      code are required for the other identified sites.

    // TODO:
    //    EXERCISE:
    //     - try some of the other implementations listed on http://todomvc.com/
    //     - run the tests and identify the changes required
    //     - implement the changes, and try to keep the existing implementations running

    // TODO:
    //     EXERCISE:
    //          - make switching the environment possible via System Properties or Environment Variables

    // TODO:
    //     EXERCISE:
    //          - automate the list management page of the implementation at compendiumdev.co.uk/apps (see url in comments above)
    //          - the existing test code should run against the compendiumdev page
    //          - you will also be able to experiment with navigation approaches that load different pages
}
