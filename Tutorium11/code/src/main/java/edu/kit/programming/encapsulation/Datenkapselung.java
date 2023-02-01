package edu.kit.programming.encapsulation;

import edu.kit.programming.encapsulation.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Datenkapselung {
  private final int[] numbers = {3, 31, 33, 42};
  private final List<String> list = new ArrayList<String>();
  private Person owner = new Person("Anna", 42, 99);
  private final List<Person> employees = new LinkedList<Person>();

  public int[] getNumbers() {
    return Arrays.copyOf(this.numbers, numbers.length); // Achtung Elemente des Arrays nicht kopiert (shallow copy)
    // bei elementaren Datentypen oder immutables egal
  }

  /*
   * Oft kann das Herausgeben von Datenstruktur-Referenzen durch geeignete Schnittstellen ersetzt werden.
   * z.B. add(obj/index)/remove(obj/index)/contains(obj)/get(obj)/addAll(collections) ersetzt werden
   */

  public int getNumber(int index) {
    return numbers[index];
  }

  public void addString(String string) {
    list.add(string); // String ist immutable kann sowieso nicht verändert werden
  }

  /*
   * Shallow Copy hier ausreichend, da String immutable.
   */
  public Collection<String> getList() {
    List<String> tempList = new ArrayList<>();
    Collections.copy(this.list, tempList); // shallow copy
    return tempList;
  }

  /*
   * Bei gettern kann es manchmal auch sinnvoll sein nur Kopien herauszugeben.
   * Sollte man im JavaDoc erwähnen!
   */
  public Person getOwner() {
    return new Person(this.owner);
  }

  /*
   * In diesem setter wird die Objektinstanz kopiert,
   * damit von außen keine Referenz auf intern genutze Objekte existiert.
   */
  public void setOwner(Person owner) {
    this.owner = new Person(owner);
  }

  /*
   * Falls doch die ganze Collection zurückgegeben werden muss, kann eine deep copy nötig sein.
   * https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#unmodifiableCollection(java.util.Collection)
   */
  public Collection<Person> getEmployees() {
    List<Person> tempList = new LinkedList<Person>();
    for (Person employee : employees) {
      tempList.add(new Person(employee));
    }
    return tempList;
  }
}
