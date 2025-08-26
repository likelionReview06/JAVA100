package day7.designPattern;

public class BuilderTest {
    private String name;
    private int age;
    private String address;

    private BuilderTest(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;
        private String address;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public BuilderTest build() {
            return new BuilderTest(this);
        }
    }

    @Override
    public String toString() {
        return "BuilderTest [name=" + name + ", age=" + age + ", address=" + address + "]";
    }
}

class BTest {
    public static void main(String[] args) {
        BuilderTest builderTest = BuilderTest.builder().name("백종현").age(25).address("경산").build();
        System.out.println(builderTest);
    }
}


