package at.htl;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
//    @Test
//    void getClass_instanceOfTest() {
//        Person person = new Person("Bertl", LocalDate.now());
//        Object o = new Object();
//
//        assertThat(person instanceof Object).isTrue();
//        assertThat(person.getClass() == o.getClass()).isFalse();
//
//    }
//
//    @Test
//    void hash_withNullValues() {
//        Person p = new Person(null, null);
//        System.out.println(p.hashCode());
//    }


    @Test
    void simpleEqualsTest() {
        int id = 1;
        String name = "Original";
        String city = "Leonding";
        Location locationA = new Location(city, "Limesstraße", 12);
        Location locationB = new Location(city, "Limesstraße", 12);
        LocalDate dob = LocalDate.now().minusYears(18);
        Person original = new Person(id, name, dob, locationA);
        Person copy = new Person(id, name, dob, locationA);

        assertThat(original.equals(copy)).describedAs("Gleiche Attribute und idente Location").isTrue();
        assertThat(original == original).describedAs("Idente Person").isTrue();
        assertThat(original == copy).describedAs("Nur gleiche Personen").isFalse();
        copy.setLocation(locationB);
        assertThat(original.equals(copy)).describedAs("Gleiche Attribute und gleiche Location").isTrue();
        copy.getLocation().setHouseNo(100);
        assertThat(original.equals(copy)).describedAs("Hausnummer bei Kopie wurde geändert").isFalse();
        copy = original;
        assertThat(original == copy).describedAs("Referenz wurde kopiert").isTrue();
    }

    @Test
    void cloneTest() throws CloneNotSupportedException {
        int id = 1;
        String name = "Original";
        String city = "Leonding";
        Location location = new Location(city, "Limesstraße", 12);
        LocalDate dob = LocalDate.now().minusYears(18);
        Person original = new Person(id, name, dob, location);
        Person clone = (Person) original.clone();
        clone.getLocation().setCity("Linz");
        assertThat(city).isEqualTo(original.getLocation().getCity());
    }

    @Test
    void simpleCloneTest() throws CloneNotSupportedException {
        int id = 1;
        String name = "Original";
        String city = "Leonding";
        Location location = new Location(city, "Limesstraße", 12);
        LocalDate dob = LocalDate.now().minusYears(18);

        Person original = new Person(id, name, dob, location);
        Person clone = (Person) original.clone();
        assertThat(original).describedAs("Gleiche Attribute und idente Location")
                .isEqualTo(clone);

        clone.getLocation().setCity("Linz");
        assertThat(city).describedAs("Original darf nicht verändert werden")
                .isEqualTo(original.getLocation().getCity());
        assertThat("Linz").describedAs("Clone muss neue Stadt haben")
                .isEqualTo(clone.getLocation().getCity());

        clone = (Person) original.clone();
        assertThat(original).describedAs("Gleiche Anzahl und gleiche Location")
                .isEqualTo(clone);

        clone.setName("Clone");
        assertThat(original).describedAs("Original darf nicht mehr gleich dem Clone sein")
                .isNotEqualTo(clone);
    }

    @Test
    void boxingTest1() {
        int i = 1;
        Integer j = new Integer("1");
        int l = Integer.valueOf("1");
        int m = Integer.parseInt("1");
        int n = j.intValue();  // explizites Unboxing
        assertThat(i).isSameAs(n);
        assertThat(i == n).isTrue();
        Integer o = new Integer(n);
        assertThat(o).isNotSameAs(n);
        assertThat(i).isEqualTo((int) j);
        assertThat(i).isNotSameAs(j);
        assertThat(i == j).isTrue();
        assertThat((Integer) i == j).isFalse();
        Integer x = Integer.valueOf(1);
        Integer y = Integer.valueOf(1);
        assertThat((Integer) i == (Integer) j).isFalse();
        System.out.println();
    }

    @Test
    void boxingTest() {
        int i = 1;
        Integer j = Integer.valueOf("1");
        int l = Integer.parseInt("1");
        int m = j.intValue();  // explizites Unboxing
        assertThat(i).isSameAs(m);
        assertThat(i == m).isTrue();
        Integer o = Integer.valueOf(m);
        assertThat(o).isNotSameAs(m);
        assertThat(i).isEqualTo((int) j);
        assertThat(i).isNotSameAs(j);
        assertThat(i == j).isTrue();
        assertThat((Integer) i == j).isFalse();
        Integer x = Integer.valueOf(1);
        Integer y = Integer.valueOf(1);
        assertThat((Integer) i == (Integer) j).isFalse();
        System.out.println();
    }
}