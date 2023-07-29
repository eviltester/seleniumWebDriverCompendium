package uk.co.compendiumdev.todomvc.page.structural.pojo;

public enum Filter {

    ACTIVE{
        @Override
        public int index() {
            return 1;
        }
    },
    COMPLETED{
        @Override
        public int index() {
            return 2;
        }
    };

    public int index() {
        return 0;
    }
}
